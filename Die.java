//**********************************************************************************************************************
//  Die.java
//
//  Creates objects of class Die with attributes of face value and color.
//**********************************************************************************************************************

import java.util.*;

public class Die
{
    //private data declaration
    private int faceValue;
    private String color;

    //default constructor
    public Die() {
        faceValue = 1;
        color = "white";
    }

    //constructor with parameters
    public Die(int initVal, String initColor)
    {
        faceValue = initVal;
        color = initColor;
    }


    //roll method declaration
    public void roll()
    {
        //change face value to a random number between 1-6, inclusive.
        Random roller = new Random();
        faceValue = roller.nextInt(6) + 1;
    }

    //getter method for faceValue
    public int getFaceValue()
    {
        return faceValue;
    }

    //getter method for color
    public String getColor()
    {
        return color;
    }

    //setter method for faceValue
    public void setFaceValue(int desVal)
    {
        faceValue = desVal;
    }

    //setter method for color
    public void setColor(String desColor)
    {
        color = desColor;
    }

    //toString method for the Die class
    public String toString() {
        String rtn = "Face value of die: " + faceValue + "\tColor of die: " + color;
        return rtn;
    }
}