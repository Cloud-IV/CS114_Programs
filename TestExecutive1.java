//**********************************************************************************************************************
//  TestExecutive1.java
//
//  Tests exception throwing of BonusTooHighException in Executive class. Exception terminates program.
//**********************************************************************************************************************

import java.util.Scanner;

public class TestExecutive1
{
    public static void main(String[] args) throws BonusTooHighException
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
        //  Adds user-inputted bonuses to each executive. Throws exception and terminates program if bonus exceeds
        //  $10,000.
        //--------------------------------------------------------------------------------------------------------------
        BonusTooHighException bonusException = new BonusTooHighException("Bonus exceeds $10,000.");

        for (int i = 0; i < execList.length; i++)
            {
                System.out.println("Please enter a bonus for executive " + (i + 1) + " with two decimal places.");
                double execBonus = input.nextDouble();
                execList[i].awardBonus(execBonus);
                if (execBonus > 10000)
                    throw bonusException;
            }
    }
}