//**********************************************************************************************************************
//  Book.java
//
//  Creates objects of class Book.
//**********************************************************************************************************************

public class Book
{
    // Private data declaration.
    private int pages;
    private String title;

    // Default constructor.
    public Book()
    {
        pages = 1;
        title = "Filler";
    }

    // Constructor with pages and title parameters.
    public Book(int initPages, String initTitle)
    {
        pages = initPages;
        title = initTitle;
    }


    // Getter method for book title.
    public String getTitle()
    {
        return title;
    }

    // Getter method for book pages.
    public int getPages()
    {
        return pages;
    }

    // Setter method for book title.
    public void setTitle(String desTitle)
    {
        title = desTitle;
    }

    // Setter method for book pages.
    public void setPages(int desPages)
    {
        pages = desPages;
    }

    // toString method that returns book title and pages.
    public String toString()
    {
        String rtnString = "Book title: " + title + "\t# of pages: " + pages;
        return rtnString;
    }

    // Equals method that returns true if two books have same title and # of pages.
    public boolean equals(Book book)
    {
        return (this.getTitle().equals(book.getTitle()) && this.getPages() == book.getPages());
    }

    // compareTo method that compares two books' pages values and returns various values based on conditions.
    public int compareTo(Book book)
    {
        if (this.getPages() < book.getPages())
            return -1;
        else if (this.getPages() > book.getPages())
            return +1;
        else
            return 0;
    }
}