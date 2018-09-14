//=====================================================================
// Program to illustrate a simple GUI.
// Computes Miles per gallon.
// This program is both an applet and an application.
// author: wallace s. rutkowski
//=====================================================================

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mileage
{
    private static JTextField gallonsField;
    private static JTextField milesField;
    private static JTextField mpgField;

    // Do the Computation
    //---------------------------
    private static void calculateMpg()
    {
        double gallons = getDouble(gallonsField);
        double miles = getDouble(milesField);
        setDouble(mpgField, miles/gallons);
    }
    // get the floating point value of a text field
    //---------------------------------------------
    private static double getDouble(JTextField t)
    {
        return Double.parseDouble(t.getText());
    }
    // set a text field to a floating point value
    //-------------------------------------------
    private static void setDouble(JTextField t, double p)
    {
        t.setText(Double.toString(p));
    }

    // Main method allows running as a Java application
    //-------------------------------------------------
    public static void main(String args[])
    {
        JFrame app = new JFrame("Mileage Calculator");
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Build the GUI
        //------------------------------------------------------------
        Container c = app.getContentPane();

        c.setLayout(new GridLayout(3, 2));

        c.add(new JLabel("Gallons"));
        gallonsField = new JTextField();
        c.add(gallonsField);

        c.add(new JLabel("Miles"));
        milesField = new JTextField();
        c.add(milesField);


        JButton calculateButton = new JButton("Calculate mpg");
        c.add(calculateButton);
        calculateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){calculateMpg();}
        });

        mpgField = new JTextField();
        mpgField.setEditable(false);
        c.add(mpgField);

        app.pack();
        app.setVisible(true); // do this after setting look and feel
    }
}