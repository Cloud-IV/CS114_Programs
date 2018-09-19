//**********************************************************************************************************************
//  Average.java
//
//  Uses command line arguments to calculate average of integers.
//**********************************************************************************************************************

public class Average
{
    public static void main(String[] args)
    {
        int[] intArgs = new int[args.length];
        int sum = 0;
        double average;

        if (args.length != 0)
        {
            for (int i = 0; i < args.length; i++)
            {
                intArgs[i] = Integer.parseInt(args[i]);
                sum += intArgs[i];
            }

            average = (double) sum/intArgs.length;
            System.out.println(average);
        }

        else
            System.out.println("No arguments.");
    }
}