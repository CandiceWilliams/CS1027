public class WordLL {
    private Word mysteryWord;
    private LinearNode<Word> history;

    public WordLL(Word mystery){
        history = new LinearNode<>();
        mysteryWord = mystery;
    }

    public boolean tryWord(Word guess){
        LinearNode<Word> userWord;
        userWord = new LinearNode<Word>(guess);  //creates a linear node to store the user's guess. 
        userWord.setNext(history);
        history = userWord;  //transfers all guesses to the history linear node
        if (guess.labelWord(mysteryWord)){    
            return true;
        }
        return false;
    }

    public String toString(){
        LinearNode<Word> curr = history;
        String s = "";
        Word l = curr.getElement();
        while(curr!=null){
            l = curr.getElement();
            if (l == null) break;  //if the l value is null then the while loop stops entirely
            s += l.toString() + "\n";
            curr = curr.getNext();
        }
        return s;
    }
}
