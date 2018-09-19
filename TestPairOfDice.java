//**********************************************************************************************************************
//  TestPairOfDice.java
//
//  Tests objects of class PairOfDice.
//**********************************************************************************************************************

public class TestPairOfDice
{
    public static void main(String[] args)
    {
        // Declaration of variables.
        int doubleSixCounter = 0;
        Die die_1 = new Die();
        Die die_2 = new Die();

        // Loop that rolls a pair of dice 1000 times, counting each box car (double six).
        for (int i = 0; i < 1000; i++)
        {
            die_1.roll();
            die_2.roll();
            if (die_1.getFaceValue() == 6 && die_2.getFaceValue() == 6)
                doubleSixCounter++;
        }

        // Prints the number of box cars rolled.
        System.out.println("Number of box cars (double sixes): " + doubleSixCounter);
    }
}