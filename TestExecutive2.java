//**********************************************************************************************************************
//  TestExecutive2.java
//
//  Tests exception throwing of BonusTooHighException in Executive class. Handles BonusTooHighException.
//**********************************************************************************************************************

import java.util.Scanner;
import java.text.NumberFormat;

public class TestExecutive2
{
    public static void main(String[] args)
    {
        Executive[] execList;
        Scanner input = new Scanner(System.in);

        //--------------------------------------------------------------------------------------------------------------
        //  Populates list of executives.
        //--------------------------------------------------------------------------------------------------------------
        System.out.println("Please enter how many executives are in the list.");
        int listSize = input.nextInt();
        input.nextLine();
        execList = new Executive[listSize];

        for (int i = 0; i < execList.length; i++)
        {
            System.out.println("Please enter executive " + (i + 1) + "'s name.");
            String execName = input.nextLine();
            System.out.println("Please enter executive " + (i + 1) + "'s email address.");
            String execEmail = input.nextLine();
            System.out.println("Please enter executive " + (i + 1) + "'s phone number (include dashes).");
            String execPhone = input.nextLine();
            System.out.println("Please enter executive " + (i + 1) + "'s Social Security Number (include dashes).");
            String execSSN = input.nextLine();
            System.out.println("Please enter executive " + (i + 1) + "'s pay rate with two decimal places.");
            double execRate = input.nextDouble();
            input.nextLine();
            System.out.println("Executive " + execName + " added to list.");

            execList[i] = new Executive(execName, execEmail, execPhone, execSSN, execRate);
        }

        //--------------------------------------------------------------------------------------------------------------
        //  Adds user-inputted bonuses to each executive. Catches exception and keeps bonus at $0.
        //--------------------------------------------------------------------------------------------------------------
        BonusTooHighException bonusException = new BonusTooHighException("Bonus exceeds $10,000.");
        int validCounter = 0;
        double bonusSum = 0;

        for (int i = 0; i < execList.length; i++)
        {
            try
            {
                System.out.println("Please enter a bonus for executive " + (i + 1) + " with two decimal places.");
                double execBonus = input.nextDouble();
                if (execBonus > 0 && execBonus <= 10000)
                {
                    execList[i].awardBonus(execBonus);
                    validCounter++;
                    bonusSum += execBonus;
                }
                else if (execBonus > 10000)
                    throw bonusException;
            }
            catch (BonusTooHighException execException)
            {
                System.out.println(bonusException.getMessage() + " Bonus for this executive has been kept at $0.");
            }
        }

        //--------------------------------------------------------------------------------------------------------------
        //  Prints out number of executives with valid bonuses and prints average of valid bonuses.
        //--------------------------------------------------------------------------------------------------------------
        NumberFormat bonusFmt = NumberFormat.getCurrencyInstance();

        System.out.println("Total number of executives with valid bonuses: " + validCounter);
        double bonusAvg = bonusSum / validCounter;
        System.out.println("Average of valid bonuses: " + bonusFmt.format(bonusAvg));
    }
}
