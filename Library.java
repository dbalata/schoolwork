public class Library { 
    /**
     * Dylan Balata
     * CS152L-001
     * 4-25-16
     */

    /** Books in the library. */
    private Book[] books;
    
    /** Number of copies for each book. */
    private int[] copies;

    /** Number of copies currently checked out for each book. */
    private int[] checkedOut;

    /** Number of unique books in the library. */
    private int numBooks;

    /** Construct a new empty Library. */
    public Library() {
        // We'll assume we never have more than 400 books.
        int librarySize = 400;
        books = new Book[librarySize];
        copies = new int[librarySize];
        checkedOut = new int[librarySize];
        numBooks = 0;
    }

    /**
     * Get the number of total copies of all books that exist in the
     * library.
     * @return Total number of copies in the library.
     */
    public int totalCopies() {
        int x = 0;
        for(int i=0;i<copies.length;i++){
            x = x + copies[i];
        }
        return x;
    }

    /**
     * Get the number of copies currently checked out.
     * @return Total number of copies checked out.
     */
    public int totalCheckedOut() {
        int x = 0;
        for(int i=0;i<checkedOut.length;i++){
            x = x+checkedOut[i];
        }
        return x;
    }

    /**
     * Get a String representing the status of the library.
     * @return Status string.
     */
    public String statusString() {
        return "Total unique books: "+numBooks+
                "\nTotal number of copies: "+this.totalCopies()+
                "\nTotal checked out: "+this.totalCheckedOut();
    }

    /**
     * Add all the books in the array to the library. Adds one copy of
     * each book.
     * @param newBooks Books to add.
     */
    public void addBooks( Book[] newBooks ) {
        for(int j=0; j<newBooks.length; j++){
            addBook(newBooks[j]);
                
        }
    }

    /**
     * Add a single book the library.
     *
     * If the book is already present, adds another copy.
     * If the book is new, add it after the existing books.
     * @param b Book to add.
     */
    public void addBook( Book b ) {
        boolean found=false;
        for(int i=0; i<numBooks; i++){
            if(books[i].equals(b)){
                copies[i]++;
                found=true;
                //System.out.println(b.toString()+" num copies ="+copies[i]);
            }
        }
        if(!found){
            books[numBooks]=b;
            copies[numBooks]++;
            numBooks++;
            //System.out.println(b.toString()+" num copies ="+copies[numBooks]);
        }            
    }
  
    /**
     * Checks out a book from the library if possible.
     * @param b Book to check out.
     * @return String denoting success or failure.
     */
    public String checkOutBook ( Book b ) {
        for(int i=0; i<numBooks; i++){
            if(books[i].equals(b)){
                if(copies[i]-checkedOut[i]==0){
                    return "All out of copies.";
                }
                if(copies[i] - checkedOut[i]>0){
                    checkedOut[i]++;
                    return "Checked out!";   
                }      
            }
        }
        return "Book not found.";
    }

    /**
     * Checks in a book to the library if possible.
     * @param b Book to check in.
     * @return String denoting success or failure.
     */
    public String checkInBook ( Book b ) {
        for(int i=0;i<numBooks;i++){
            if(books[i].equals(b)){
                if(checkedOut[i]==0){
                   
                    return "All of our copies are already checked in.";
                }
                if(checkedOut[i]>0){
           
                    checkedOut[i]--;
                    return "Checked in!";   
                }
            }
        }
        return "Book not found.";
    }
  
    /**
     * Get string representation of entire library collection and status.
     * @return String representation of library.
     */
    public String toString() {
        String s="";
        int x;
        for(int i=0; i<numBooks; i++){
            //System.out.println(copies[i]+" "+checkedOut[i]);
            x = copies[i]-checkedOut[i];
            s=s+i+". "+books[i].toString()+" : "+x
                    +"/"+copies[i]+"\n";
        }
        //System.out.println(s+"\n"+this.statusString());
        return s+"\n"+this.statusString();
    }
  
    /**
     * Get number of unique books that exist for a given author.
     * @param a The author to check.
     * @return Number of books by the author.
     */
    public int numBooksByAuthor( Author a ) { 
        int x=0;
        for(int i=0;i<numBooks;i++){
            Author b = books[i].getAuthor();
            if(a.isSame(b)){
                x++;
            }
        }
        return x;
    }

    /**
     * Returns a String that lists the unique books which exist for a
     * given author, in standard book format, with a newline after
     * each.  If no books are found for the author, returns string
     * that says so.
     * 
     * @param a The author in question.
     * @return String listing books by the author.
     */
    public String listBooksByAuthor( Author a ) { 
        String s = "";
        for(int i=0;i<numBooks;i++){
            if(a.isSame(books[i].getAuthor())){
                s = s+books[i].toString()+"\n";
            }
         }
        if(s.equals("")){
            //System.out.println("No books by "+a.toString());
            return "No books by "+a.toString()+".";
        }
        return s;
    }  
  
    /**
     * Returns string that lists the unique books with contain the
     * given string within their titles, without regard for case, with
     * a newline after each.  If no books are found containing the
     * string, returns string that says so.
     * @param s The string to look for in the titles.
     * @return String listing books that contain given string in titles.
     */
    public String listBooksByTitle( String s ) {
        String n = "";
        for(int i=0; i<numBooks; i++){
            if(books[i].getTitle().toLowerCase().indexOf(s)!=-1){
                n = n+books[i].toString()+"\n";
            }
        }
        if(!n.equals("")){
            //System.out.println(n);
            return n;
        }
        //System.out.println(n);
        return "No books with \""+s+"\" in the title.";
    }
    

    /**
     * Deletes book entirely from the library.
     * @param b Book to remove.
     * @return String denoting success or failure.
     */
    public String deleteBook( Book b ) {
        for(int i=0;i<numBooks;i++)
            if(books[i].equals(b)){
                for(int n=i;n<numBooks;n++){
                    books[n]=books[n+1];
                    checkedOut[n]=checkedOut[n+1];
                    copies[n]=copies[n+1];
                }
                books[numBooks-1]=null;
                numBooks--;
                return "Book removed.";
            }
        return "Book not found.";
    }
}