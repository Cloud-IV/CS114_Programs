//----------------------------------------------------------------------------------------------------------------------
// GUIQueue.java
// Author: Abrar Rouf
// Implements Queue class to create GUI that takes user inputs and inserts them into a FIFO queue using a circular
// buffer.
//----------------------------------------------------------------------------------------------------------------------

import java.awt.*;
import javax.swing.*;


public class GUIQueue extends Queue
{
    /**
     * GUIQueue constructor; takes integer capacity as parameter for size of data[].
     */
    private GUIQueue(int capacity)
    {
        super(capacity);
        data = new String[capacity];
    }


    /**
     * Inserts user-inputted String into queue and displays confirmation text in text field when 'Insert' button is
     * pressed.
     */
    private void insert(String s, JTextField j)
    {
        if (size < capacity)
        {
            if (in >= capacity) in = 0;
            data[in] = s;
            j.setText("'" + s + "'" + " inserted.");
            in++;
            size++;
        }
        else
        {
            if (in >= capacity) in = 0;
            j.setText("Queue is full.");
        }
    }


    /**
     * Removes oldest entry in queue and displays confirmation of removal in text field when 'Remove' button is pressed.
     */
    private void remove(JTextField j)
    {
        if (size == 0)  j.setText("No entries to be removed.");
        else
        {
            if (out >= capacity) out = 0;
            j.setText("'" + data[out] + "'" + " removed.");
            data[out] = null;
            out++;
            size--;
        }
    }

    /**
     * Displays next entry to be removed without removing entry when 'Peek' button is pressed.
     */
    private void peek(JTextField j)
    {
        if (size == 0)  j.setText("No entries to be removed.");
        else
        {
            if (out >= capacity) out = 0;
            j.setText("'" + data[out] + "'" + " will be removed next.");
        }
    }

    /**
     * Clears text field when 'Clear' button is pressed.
     */
    private void clear(JTextField j) {
        j.setText("");
    }

    /**
     * Displays number of entries currently stored in queue when '# of Entries' button is pressed.
     */
    private void getSize(JTextField j) {
        j.setText(size + " entries stored.");
    }

    /**
     * Displays maximum capacity of queue object when 'View Capacity' button is pressed.
     */
    private void getCapacity(JTextField j) {
        j.setText("Can store a maximum of " + data.length + " entries.");
    }

    /**
     * Retrieves and returns user-inputted String from text field.
     */
    private static String getString(JTextField j) {
        return j.getText();
    }



    // GUI object and queue object creation.
    //--------------------------------------
    public static void main(String args[])
    {
        GUIQueue GUIqueue = new GUIQueue(3);

        JFrame modifiedGUI = new JFrame("Queue GUI");
        modifiedGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container GUIcontainer = modifiedGUI.getContentPane();

        GUIcontainer.setLayout(new GridLayout(4, 1));

        GUIcontainer.add(new JLabel("Entries to be inserted into queue:"));
        JTextField queueField = new JTextField();
        GUIcontainer.add(queueField);

        JButton insertButton = new JButton("Insert");
        GUIcontainer.add(insertButton);
        insertButton.addActionListener(e -> GUIqueue.insert(getString(queueField), queueField));

        JButton removeButton = new JButton("Remove");
        GUIcontainer.add(removeButton);
        removeButton.addActionListener(e -> GUIqueue.remove(queueField));

        JButton peekButton = new JButton("Peek");
        GUIcontainer.add(peekButton);
        peekButton.addActionListener(e -> GUIqueue.peek(queueField));

        JButton sizeButton = new JButton("# of Entries");
        GUIcontainer.add(sizeButton);
        sizeButton.addActionListener(e -> GUIqueue.getSize(queueField));

        JButton capacityButton = new JButton("Queue Capacity");
        GUIcontainer.add(capacityButton);
        capacityButton.addActionListener(e -> GUIqueue.getCapacity(queueField));

        JButton clearButton = new JButton("Clear");
        GUIcontainer.add(clearButton);
        clearButton.addActionListener(e -> GUIqueue.clear(queueField));

        modifiedGUI.pack();
        modifiedGUI.setVisible(true);
    }
}