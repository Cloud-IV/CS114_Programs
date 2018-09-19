//**********************************************************************************************************************
//  TestBooks.java
//
// Tests objects of the class Book.
//**********************************************************************************************************************

import java.util.Scanner;

public class TestBooks
{
    public static void main(String[] args)
    {
        // Variable declaration.
        Scanner scan = new Scanner(System.in);
        int userBooks;
        Book iterBook;

        // Asks user for number of books read during summer and creates an array of that length.
        System.out.println("Please enter an integer number for how many books you read over summer.");
        userBooks = scan.nextInt();
        scan.nextLine();
        Book[] bookArray = new Book[userBooks];

        // Creates as many book objects as user-input value and populates array with inputted books.
        for (int i = 0; i < bookArray.length; i++)
        {
            System.out.println("Please enter the title of a book.");
            String title = scan.nextLine();
            System.out.println("Please enter the number of pages in that book.");
            int pages = scan.nextInt();
            scan.nextLine();

            bookArray[i] = new Book(pages, title);
        }

        // Loops through array and finds the book with the smallest number of pages.
        Book minBook = bookArray[0];

        for (Book b : bookArray)
            if (b.compareTo(minBook) < 0)
                minBook = b;

        System.out.println("Smallest book is " + minBook.getTitle() + " with " + minBook.getPages() + " pages.");

        // Finds the average number of pages per book read.
        int pageTotal = 0;

        for (Book b: bookArray)
            pageTotal += b.getPages();

        System.out.println("Average number of pages per book read: " + pageTotal/bookArray.length);
    }
}