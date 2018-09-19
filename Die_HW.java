//**********************************************************************************************************************
//  Die.java
//
//  Simulates the rolling of a pair of dice.
//**********************************************************************************************************************

import java.util.Random;

public class Die_HW
{
    public static void main(String[] args)
    {
        // Creates two dice and a roller.
        int die_1, die_2;
        Random roller = new Random();

        // Rolls each die and calculates sum of dice values.
        die_1 = roller.nextInt(6) + 1;
        die_2 = roller.nextInt(6) + 1;
        int sum = die_1 + die_2;

        // Prints the resulting value of each die and sum of the values of the dice.
        System.out.println("Die 1 value: " + die_1);
        System.out.println("Die 2 value: " + die_2);
        System.out.println("Sum of dice values: " + sum);
    }
}