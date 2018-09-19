//**********************************************************************************************************************
//  StringManips.java
//
//  Test several methods for manipulating String objects.
//**********************************************************************************************************************

import java.util.Scanner;

public class StringManips
{
    public static void main(String[] args)
        {
            String phrase = new String("This is a string test.");
            String city;            // user's hometown city
            String state;           // user's hometown state
            int phraseLength;       // number of characters in the phrase String
            int middleIndex;        // index of the middle character in the String
            String firstHalf;       // first half of the phrase String
            String secondHalf;      // second half of the phrase String
            String middle3;         // the middle three characters of the phrase String
            String switchedPhrase;  // a new phrase with original halves switched

            // retrieves user's hometown city and state
            Scanner scan = new Scanner(System.in);

            System.out.println("Please enter the name of your hometown city.");
            city = scan.nextLine();
            System.out.println("Please enter the name of your hometown state.");
            state = scan.nextLine();

            // Capitalizes state name and converts city name to lowercase
            String upperState = state.toUpperCase();
            String lowerCity = city.toLowerCase();

            // compute the length and middle index of the phrase
            phraseLength = phrase.length();
            middleIndex = phraseLength / 2;

            // get the substring for each half of the phrase
            firstHalf = phrase.substring(0, middleIndex);
            secondHalf = phrase.substring(middleIndex, phraseLength);

            // get the substring for the middle characters
            middle3 = phrase.substring(middleIndex - 1, middleIndex + 1);

            // concatenate the firstHalf at the end of the secondHalf
            switchedPhrase = secondHalf.concat(firstHalf);

            // replace blank characters with asterisks in switchedPhrase
            switchedPhrase = switchedPhrase.replace(" ", "*");

            // print information about the phrase
            System.out.println();
            System.out.println("Original phrase: " + phrase);
            System.out.println("Length of the phrase: " + phraseLength + " characters.");
            System.out.println("Index of the middle: " + middleIndex);
            System.out.println("Character at the middle index: " + phrase.charAt(middleIndex));
            System.out.println("Middle three characters: " + middle3);
            System.out.println("Switched phrase: " + switchedPhrase);
            System.out.println("Concatenated hometown: " + upperState + lowerCity + upperState);
            System.out.println();
        }
}