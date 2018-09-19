//***********************************************************************************
// DiceArray.java
//
// Creates an array of 50 default dice and rolls each one, printing the smallest die.
//***********************************************************************************

public class DiceArray
{
    public static void main(String[] args)
    {
        // Creates dice array.
        Die[] diceArray = new Die[50];

        // Populates dice array.
        for (int i = 0; i < diceArray.length; i++)
        {
            diceArray[i] = new Die();
            diceArray[i].roll();
        }

        // Loops through dice array, declares smallest die variable and updates the smallest die.
        Die minDie = diceArray[0];

        /* for (Die d:diceArray)
            if (d.compareTo(minDie) < 0)
                minDie = d; */

        // Prints smallest die.
        System.out.println(minDie);
    }
}