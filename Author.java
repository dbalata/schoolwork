/**
 * An Author is a writer of books. An author has a first and last name 
 * and birth/death dates.
 * @author Dylan Balata 4-14-16
 */
public class Author {
    
    private String firstName;
    private String lastName;
    private int death;
    private int birth;
    
    /**
     * Creates a new Author with a name, but birth and death dates not set.
     * @param lastName
     * @param firstName
     */ 
    public Author(String lastName, String firstName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = BookAuthorConstants.UNKNOWN_YEAR;
        this.death = BookAuthorConstants.UNKNOWN_YEAR;
    }
    
    /**
     * Creates a new Author with a name, but birth and death dates not set.
     * @param birth
     */
    public void setDates(int birth){
        if(birth>0){
            this.birth=birth;
        }
    }
    
    /**
     * Returns an int representing the author’s year of birth.
     * @return
     */
    public int getBirth(){
        return this.birth;
    }
    
    /**
     * Returns an int representing the author’s year of death.
     * @return
     */
    public int getDeath(){
        return this.death;
    }
    
    /**
     * Sets both the author’s year of birth and death. Both must be valid years
     * and the year of death must be after the year of birth.
     * @param birth
     * @param death
     */
    public void setDates(int birth, int death){
        if(birth>0 && death>birth){
            this.birth = birth;
            this.death = death;
        }
    }
    
    /**
     * If two authors have the same first and last names it should return true,
     * otherwise it should return false.
     * @param other
     * @return
     */
    public boolean isSame(Author other){
        if(this.firstName.equals(other.firstName) 
                && this.lastName.equals(other.lastName)){
            return true;
        }
        return false;
    }
    
    /**
     * Should return a string representation of the author, of the form:
     * Barnes, Julian
     */
    public String toString(){
        String first = this.firstName;
        String last = this.lastName;
        return last+", "+first;
    }
    
    /**
     * Should return (not print) a string for the author, of the form:
     * Heaney, Seamus
     * If the year of birth (but not death) is set it should return:
     * Heaney, Seamus (b. 1939)
     * If both the years of birth and death have been set, it should return:
     * Heaney, Seamus (1939-2013)
     * @return
     */
    public String infoString(){
        if(this.birth == BookAuthorConstants.UNKNOWN_YEAR
                && this.death == BookAuthorConstants.UNKNOWN_YEAR){
            return this.lastName+", "+this.firstName;
        }
        if(this.birth != BookAuthorConstants.UNKNOWN_YEAR
                && this.death == BookAuthorConstants.UNKNOWN_YEAR){
            return this.lastName + ", " + this.firstName 
                    + " (b. " + this.birth + ")";
        }
        if(this.birth != BookAuthorConstants.UNKNOWN_YEAR
                && this.death != BookAuthorConstants.UNKNOWN_YEAR){
            return this.lastName + ", " + this.firstName 
                    + " (" + this.birth + "-" + this.death + ")";
        }
        else{return "infoString error";}
    }

}
