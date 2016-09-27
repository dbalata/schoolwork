/**
 * A Book is our main object. Books in our system have a date (year) 
 * of being written, a title,
 * an ISBN, and a single Author (Author object) who wrote them.
 * @author Dylan Balata 4-4-16
 */
public class Book{
    
    private int date;
    private String title;
    private String ISBN;
    private Author author;
    
    /**
     * The default (no parameters) constructor, creates a new Book with
     * no title, year of publication, Author, or ISBN set.
     */
    public Book(){
        this.date = BookAuthorConstants.UNKNOWN_YEAR;
        this.title = BookAuthorConstants.UNKNOWN_TITLE;
        this.ISBN = BookAuthorConstants.UNKNOWN_ISBN;
        this.author = BookAuthorConstants.UNKNOWN_AUTHOR;
    }
    
    /**
     * Creates a new Book with a title, but no year of publication, 
     * Author, or ISBN set.
     */
    public Book(String title){
        this.date = BookAuthorConstants.UNKNOWN_YEAR;
        this.title = title;
        this.ISBN = BookAuthorConstants.UNKNOWN_ISBN;
        this.author = BookAuthorConstants.UNKNOWN_AUTHOR;
    }
    
    /**
     * Creates a new Book with a title and an Author (as an Author object) 
     * but no year of publication or ISBN set.
     */
    public Book(String title, Author author){
        this.date = BookAuthorConstants.UNKNOWN_YEAR;
        this.title = title;
        this.ISBN = BookAuthorConstants.UNKNOWN_ISBN;
        this.author = author;
    }
    
    /**
     * Sets the book’s title. Title must not be empty.
     */
    public void setTitle(String title){
        if(title.length()!=0){
            this.title = title;
        }
    }
    
    /**
     * Returns a String representing the book’s title.
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * Sets the Author object.
     */
    public void setAuthor(Author author){
        this.author = author;
    }
    
    /**
     * Returns the Author object for the author who wrote the book
     */
    public Author getAuthor(){
        return this.author;
    }
    
    /**
     * Sets the year the book was written/published. It must be a valid year.
     */
    public void setYear(int year){
        if(year>-2000 && year<2020){
            this.date = year;
        }
    }
    
    /**
     * Returns the year the book was written
     */
    public int getYear(){
        return this.date;
    }
    
    /**
     * Sets the ISBN for the book. This must be of length 13 or length 10.
     */
    public void setISBN (String isbn){
        if(isbn.length()==10 || isbn.length()==13){
            this.ISBN = isbn;
        }
    }
    
    /**
     * Returns a String representing the ISBN of the book.
     */
    public String getISBN(){
        return this.ISBN;
    }
    
    /**
     * Returns true if this book has the same Author as the book that was 
     * passed in in the arguments, otherwise return false.
     */
    public boolean sameAuthor(Book other){
        if(this.author.isSame(other.author)){
            return true;
        }
        return false;
    }
    
    /**
     * Returns true if this book is equal to the other book. 
     * We will say that two Book objects are equal if their ISBNs are equal.
     */
    public boolean equals(Book other){
        if(this.ISBN.equals(other.ISBN)){
            return true;
        }
        return false;
    }
    
    /**
     * Should return a String representation of this Book.
     * If only a title has been set, return a string of the form:
     * The Arcades Project.
     * If a title and author are set:
     * The Arcades Project. Benjamin, Walter.
     * If a title and author and year have been set:
     * The Arcades Project (2002). Benjamin, Walter.
     */
    public String toString(){
        if(!this.title.equals(BookAuthorConstants.UNKNOWN_TITLE)
                && this.author.equals(BookAuthorConstants.UNKNOWN_AUTHOR)
                && this.date == BookAuthorConstants.UNKNOWN_YEAR){
            return this.title + ".";
        }
        if(!this.title.equals(BookAuthorConstants.UNKNOWN_TITLE)
                && !this.author.equals(BookAuthorConstants.UNKNOWN_AUTHOR)
                && this.date == BookAuthorConstants.UNKNOWN_YEAR){
            return this.title + ". " + author.toString() + ".";
        }
        if(!this.title.equals(BookAuthorConstants.UNKNOWN_TITLE)
                && !this.author.equals(BookAuthorConstants.UNKNOWN_AUTHOR)
                && this.date != BookAuthorConstants.UNKNOWN_YEAR){
            return this.title + " (" + this.date + ")" + ". " + 
                author.toString() + ".";
        }
        else{return "toString error";}
    }



}





















