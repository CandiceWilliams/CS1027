import java.util.Random;

public class Tile {

    private char value;
        
    //constructor
    public Tile() {
        value = ' ';
    }

    //constructor
    public Tile(char newValue){
        this.value = newValue;
    }

    public void pickup(){
        Random r = new Random();
        this.value = (char)(r.nextInt(26) + 'A');  //creates random values to be used in the scrabble game
    }

    public char getValue(){  //gets the scrabble letter values
        return value;
    }
    
}
