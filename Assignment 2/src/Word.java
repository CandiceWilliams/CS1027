
public class Word {
    private LinearNode<Letter> firstLetter;

    public Word(Letter[] letters){

        LinearNode<Letter> temp;
        for (int i = letters.length-1; i >= 0; i--) { 
             temp = new LinearNode<Letter>(letters[i]); 
             temp.setNext(firstLetter);
             firstLetter = temp;
        }
    }
    
    /** This method returns a string version of the mystery word the user has to guess 
     * @return String Word the user must guess
     */
    public String toString(){
        LinearNode<Letter> curr = firstLetter;
        Letter l;
        String s="";
        while(curr != null){
            l = curr.getElement();
            s += l.toString() + " ";
            curr = curr.getNext();
        }
        return "Word: " +  s;
    }

    
    /**This method labels the individual letters that the user guess as correct, used or unused  
     * 
     * @param mystery the mystery word 
     * @return boolean true if the user guess the right word, otherwise false;
     */
    public boolean labelWord(Word mystery){
        LinearNode<Letter> curr = this.firstLetter;
        LinearNode<Letter> mys = mystery.firstLetter;
        int posMys = 0, posCurr=0, correctCount = 0;

        while (curr != null){
            boolean check = false; //checks if the the current letter, the current position, the mystery position and the mystery letter are the same 
            mys = mystery.firstLetter;
            posMys = 0; //keeps track of what position the program is at for the mystery word
            while (!check && mys != null){
                if (curr.getElement().toString().charAt(1) == mys.getElement().toString().charAt(1)){ //converts elements to char
                    if (posMys == posCurr) { 
                        curr.getElement().setCorrect(); correctCount++;
                        check = true;
                        break;
                    }
                    else{ curr.getElement().setUsed();
                        check = true;
                    }
               
                }
                else curr.getElement().setUnused();
                posMys++;  //counter increases so program knows to move to seperate letter position 
                mys = mys.getNext();
            }
        curr = curr.getNext();
        posCurr++; //counter increases so program knows to move to seperate letter position
        }

        if (correctCount-1 == posMys) return true;
       
        
        return false;
    }
}
