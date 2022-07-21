public class Letter {
    private char letter;
    private int label;
    private int UNSET=1, UNUSED=2, USED=3, CORRECT=4;

    public Letter(char c){
        label = UNSET;
        letter = c;
    }


    
    /** Checks if two object values are equals. Does this by using the valueOf method that returns the value 
     * of the object so it may be compared to the instance variables
     * @param otherObject other object the user must compare with 
     * @return boolean true if they equal, otherwise false;
     */
    public boolean equals (Object otherObject){
        
        if(otherObject instanceof Letter) {
			String s = ((String.valueOf(otherObject)));
			char otherLetter = s.charAt(1);
			if (otherLetter == (this.letter)) return true;
        }
        return false;
    }

    
    /** Determines which decoration to add the the user guessed letters
     * @return String decoration
     */
    public String decorator(){
        if (this.label == 3){
            return "+";
        }
        else if (this.label == 2){
            return "-";
        }
        else if (this.label == 4){
            return "!";
        }
        return " ";
    }

    
    /** Decorates the string so the user knows if the guessed word is correct, used, or unused
     * @return String decorated string 
     */
    public String toString(){
        return decorator() +this.letter+ decorator();
    }

    public void setUnused(){
        this.label = 2;
    }
    public void setUsed(){
        this.label = 3;
    }
    public void setCorrect(){
        this.label = 4;
    }
    
    /**returns true if the current label of a word is unused, otherwise false
     * @return boolean
     */
    public boolean isUnused(){
        if (this.label == 2){
            return true;
        }
        else return false;
    }
    
    /** Creates an array of objects and stores within it the values of the s parameter
     * @param s string representation of the letters 
     * @return Letter[] array of Letter objects
     */
    public static Letter[] fromString(String s){
        Letter[] arr = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++){
            Letter charVal = new Letter(s.charAt(i));
            arr[i] = charVal; 
        }
       return arr; 
    }
}
