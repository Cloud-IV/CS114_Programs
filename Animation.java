//==============================================================================
// Framework for a Space Invaders type game.
// Left/Right arrow keys move the base.
// Spacebar shoots missile.
// Up arrow speeds up game, down arrow slows down.
// This framework can have only one missile at a time on the screen.
// ==============================================================================

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *===================================================================================
 *
 * The main frame of the application.  Content pane of JFrame is replaced by an
 * instance of AnimationPane.
 *
 *===================================================================================
 */
public class Animation
{
    // MAIN
    //-------------------------------------
    public static void main(String args[]){
        JFrame mainWind = new JFrame("Animation Test");
        Container c = mainWind.getContentPane();
        AnimationPane animatePanel = new AnimationPane();
        c.add(animatePanel);
        animatePanel.setOpaque(false);
        ((JPanel)c).setOpaque(false); // speeds up the animation!
        animatePanel.requestFocus();
        animatePanel.startGame(8);

        // set the look and feel to Windows style
        //---------------------------------------
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(mainWind);
            mainWind.pack();
        }
        catch (Exception exc) {
            System.err.println("Could not load LookAndFeel: ");
        }

        //app.setSize(800, 570);
        mainWind.setVisible(true); // do this after setting look and feel

        // handle window closing
        //----------------------
        mainWind.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainWind.addWindowListener(
                new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        System.exit(0);
                    }
                }
        );
    }
}


/**
 *==============================================================================
 * Sprite class: keeps track of the position and velocity and the image of the
 * sprite.
 *==============================================================================
 */
class Sprite{
    public Image image;
    public int x, y;
    public int vx, vy;
    public int width, height;

    // Constructor
    //-------------------------------------------------------
    public Sprite(Image i, int ix, int iy, int ivx, int ivy){
        image = i;
        x = ix; y = iy;
        vx = ivx; vy = ivy;
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    // Move the Sprite
    //-------------------------------------------------------
    public void update(){
        x += vx;
        y += vy;
    }
    // Draw the Sprite centered at x, y
    //-------------------------------------------------------
    public void display(Graphics g){
        g.drawImage(image, x - width/2, y - height/2, null);
    }
}


/**
 * =============================================================================
 * SpriteQueue class that creates a Queue object specifically for Sprite objects
 * so Sprite methods can be used.
 * =============================================================================
 */
class SpriteQueue extends Queue
{
    private Sprite storage[];

    SpriteQueue(int capacity)
    {
        super(capacity);
        storage = new Sprite[capacity];
    }


    void insert(Sprite s)
    {
        if (size < capacity)
        {
            if (in >= capacity) in = 0;
            storage[in] = s;
            in++;
            size++;
        }
        else
        {
            if (in >= capacity) in = 0;
            storage[in] = s;
            in++;
        }
    }

    void remove()
    {
        if (out >= capacity) out = 0;
        storage[out] = null;
        size--;
    }

    Sprite getSprite(int i)
    {
        return storage[i];
    }

    int getCapacity()
    {
        return capacity;
    }
}

/**
 *==============================================================================
 * AnimationPane relies on Swing double buffering, implements Runnable Interface
 * so can run in it's own Thread.
 *==============================================================================
 */
class AnimationPane extends JPanel implements Runnable{

    private Thread theThread = null;
    int height, width;       // size of the animation
    int xScroll, yScroll;      // scroll position of background
    int delay;         // time interval between frames
    Sprite base, missile;
    SpriteQueue missileQueue = new SpriteQueue(10);
    Image baseImage, missileImage, spaceImage;
    Toolkit t = Toolkit.getDefaultToolkit();

    /**
     *===========================
     * AnimationPane constructor.
     *===========================
     */
    AnimationPane(){
        setOpaque(false);
        loadImages();
        base = new Sprite(baseImage, 300, 460, 0, 0);
        width = spaceImage.getWidth(null);
        height = spaceImage.getHeight(null);
        setPreferredSize(new Dimension(width, height));

        // Set initial background position
        //----------------------------------------------------
        yScroll = 0;
        xScroll = 0;

        // Set up keyboard controls
        //---------------------------------------------------
        registerKeyboardAction(e -> {
                    {
                        if(base.vx > -2) base.vx = base.vx - 2;
                    }
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        //---------------------------------------------------
        registerKeyboardAction(e -> {
                    {
                        if(base.vx < 2) base.vx = base.vx + 2;
                    }
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        //---------------------------------------------------
        registerKeyboardAction(e -> {
            missile = new Sprite(missileImage, base.x, base.y - base.height/2, 0, -5);
            missileQueue.insert(missile);
            },
                KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        //---------------------------------------------------
        registerKeyboardAction(e ->
                {
                    {
                        if(delay > 0)delay--;
                    }
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        //---------------------------------------------------
        registerKeyboardAction(e -> delay++,
                KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );
    }// end AnimationPane constructor

    /**
     *=========================================
     * Get the sprite and background images.
     *=========================================
     */
    public void loadImages(){
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(baseImage = t.getImage("Base.gif"), 0);
        mt.addImage(missileImage = t.getImage("Missle.gif"), 0);
        mt.addImage(spaceImage = t.getImage("BackGround.jpg"), 0);
        try { mt.waitForAll(); } catch (InterruptedException e) {}
    }

    /**
     *====================================================
     * Paints the background and then the sprites into the
     * offscreen buffer.
     *====================================================
     */
    public void paintComponent(Graphics g){
        g.drawImage(spaceImage, xScroll, yScroll, null);
        // g.drawImage(spaceImage, xScroll-width, yScroll-height, null);
        g.drawImage(spaceImage, xScroll, yScroll-height, null);
        // g.drawImage(spaceImage, xScroll-width, yScroll, null);

        base.display(g);
        for (int i = 0; i < missileQueue.getCapacity(); i++)
        {
        missile = missileQueue.getSprite(i);
            if (missile != null) missile.display(g);
        }
    }

    /**
     *=========================================
     * Update the state of the animation panel.
     * Scroll the screen and move the sprites.
     *=========================================
     */
    public void updateAnimation()
    {
        if(++yScroll >= height)yScroll = 0;
        base.update();
        if(base.x - base.width/2 < 0 || base.x + base.width/2 >= width)
            base.vx = -base.vx;
        //replace w/ "for" loop: remove missile, update missile, if still on screen --> reinsert into queue
        for (int i = 0; i < missileQueue.getCapacity(); i++)
        {
            missile = missileQueue.getSprite(i);
            if (missile != null)
            {
                missile.update();
                if (missile.y <= 0) missile = null;
            }
        }
    }//end function


    /**
     *=========================
     * Run function for
     * the animation thread.
     *=========================
     */
    public void run()
    {
        while(true){
            updateAnimation();
            paintImmediately(0, 0, width, height);
            try {
                theThread.sleep(delay);
            } catch (InterruptedException e) { ; }
        }
    }
    //--------------------------
    public void startGame(int d)
    {
        delay = d;
        theThread = new Thread(this);
        theThread.start();
    }

    /**
     *=================================
     * Override paint to avoid calling
     * the UI delegate to clear out
     * the background, which I am only
     * going to overwrite with the
     * background image anyway.
     * May not need this with Swing.
     *=================================
     */
    public void paint(Graphics g){
        paintComponent(g);
        paintBorder(g);
    }
}