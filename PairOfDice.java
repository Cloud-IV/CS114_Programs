//**********************************************************************************************************************
//  PairOfDice.java
//
//  Creates objects of type Die of class PairOfDice with attributes of dice.
//**********************************************************************************************************************

public class PairOfDice
{
    // Dice attribute declaration.
    private Die die_1;
    private Die die_2;

    // Default constructor.
    public PairOfDice()
    {
        die_1 = new Die();
        die_2 = new Die();
    }

    // Constructor with parameters.
    public PairOfDice(int d1Val, String d1Color, int d2Val, String d2Color)
    {
        die_1 = new Die(d1Val, d1Color);
        die_2 = new Die(d2Val, d2Color);
    }


    // Setter methods for each die.
    public void setDie1(Die desDie1)
    {
        die_1 = desDie1;
    }

    public void setDie2(Die desDie2)
    {
        die_2 = desDie2;
    }

    // Getter methods for each die.
    public Die getDie1()
    {
        return die_1;
    }

    public Die getDie2()
    {
        return die_2;
    }

    // Method to roll both dice.
    public void rollDice()
    {
        die_1.roll();
        die_2.roll();
    }

    // toString method that returns colors of both dice.
    public String toString()
    {
        String rtn = "Color of Die 1: " + die_1.getColor() + "\tColor of Die 2: " + die_2.getColor();
        return rtn;
    }

    // pairSum method that returns the current sum of the face values of both dice.
    public int pairSum()
    {
        int die1Value = die_1.getFaceValue();
        int die2Value = die_2.getFaceValue();
        int sumValue = die1Value + die2Value;
        return sumValue;
    }
}
