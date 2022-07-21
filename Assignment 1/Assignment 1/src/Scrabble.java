/**
 * This program plays a game of scrabble with the user
 * Author: Candice Williams
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Scrabble {

    private Tile[] Tile;

    //constructor
    public Scrabble(){   //initailises Tile with random values
        Tile = new Tile[7];  
        for (int i = 0; i<7; i++){
            Tile[i] = new Tile();
            Tile[i].pickup();
        }
    }

    //constructor
    public Scrabble(Tile[] newTile){ //initilaises Tile with given values
        Tile = new Tile[7];
        for (int i = 0; i<newTile.length; i++){
            Tile [i] = newTile[i]; 
        }
    }

    
    /** 
     * This method puts the Tile array values into a string 
     * 
     * @return the string value of the scrabble letters
     */
    public String getLetters(){
        String tileVal = "";
        for (int i = 0; i < 7; i++){
            tileVal += (Tile[i].getValue());
        } 
        return tileVal;
    }

    
    /** 
     * Reads words from a text file and compares it with the given scarbble letters.
     * If the word from the file can be formed with the given letters, they are placed into an arraylist.
     * 
     * @return ArrayList<String> returns an arraylist of all possible words that can be made with given scrabble letters
     */
    public ArrayList<String> getWords(){ //what about reaccuring words? 
        ArrayList<String> words = new ArrayList<String>();
        String letters = getLetters();
        String[] allWords = new String[279496];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("doc\\CollinsScrabbleWords2019.txt"));  //read txt file into string array woth value of 279426

            for (int i=0; i<allWords.length; i++){
                allWords[i] = reader.readLine();
            }

        reader.close();
        } 
        catch(FileNotFoundException e){
             e.printStackTrace();
             System.out.println("where da file at?");
        }
        catch (IOException e ) {
                    e.printStackTrace();
                    System.out.println("we don't know");
                }

       
        for (int i=0; i<allWords.length;i++){  //uses a counter to count how many times the same letter appears in both the scrabble letters and the current word
            int wordCounter = 0;
            String w = allWords[i];
            for(int j = 0; j<w.length(); j++){  //
                if (letters.indexOf(w.charAt(j)) != -1){
                    wordCounter++;
                }
            }
            if (wordCounter == w.length() && frequencyCounter(w)){   // true if the word counter is equal to the word length and if frequencyCounter is true
                words.add(w);
            }
        }
        return words;
    }

    
    /** 
     * Finds the frequency of reaccuring letters from the scrabble letters and the current word. Compares them.
     * If the frequency of the given letter(word) is greater than the frequency of the scrabble letters, returns false
     * @param word this is the current word being tested 
     * @return boolean
     */
    private boolean frequencyCounter(String word){   
        int[] letterFreq = new int[26];
        int[] wordFreq = new int[26];
        int i;
        Arrays.fill(letterFreq, 0);
        Arrays.fill(wordFreq, 0);
        String letters = getLetters();

        for(i = 0; i<letters.length(); i++ ){
            letterFreq[letters.charAt(i) - 'A']++;
        }

        for(i = 0; i<word.length(); i++){
            wordFreq[word.charAt(i) -'A']++;
        }

        for (i = 0; i<26; i++){
            if (wordFreq[i] > letterFreq[i]){
                return false;
            }
        }
        return true;
    }

    
    /** 
     * Tallys up the total score of each word in ascending order and stores in an int array
     * @return the total score of each individual letter 
     */
    public int[] getScores(){
        int[] scores = new int[getWords().size()]; 
        ArrayList<String> words = new ArrayList<String>();
        words = getWords();
        for (int i=0; i<getWords().size(); i++){
            int tally=0;
            if (words.get(i).contains("A")) tally+=1;
            if (words.get(i).contains("S")) tally+=1;
            if (words.get(i).contains("E")) tally+=1;
            if (words.get(i).contains("I")) tally+=1;
            if (words.get(i).contains("O")) tally+=1;
            if (words.get(i).contains("U")) tally+=1;
            if (words.get(i).contains("N")) tally+=1;
            if (words.get(i).contains("L")) tally+=1;
            if (words.get(i).contains("R")) tally+=1;
            if (words.get(i).contains("T")) tally+=1;
            if (words.get(i).contains("D")) tally+=2;
            if (words.get(i).contains("G")) tally+=2;
            if (words.get(i).contains("B")) tally+=3;
            if (words.get(i).contains("M")) tally+=3;
            if (words.get(i).contains("P")) tally+=3;
            if (words.get(i).contains("C")) tally+=3;
            if (words.get(i).contains("F")) tally+=4;
            if (words.get(i).contains("H")) tally+=4;
            if (words.get(i).contains("V")) tally+=4;
            if (words.get(i).contains("W")) tally+=4;
            if (words.get(i).contains("Y")) tally+=4;
            if (words.get(i).contains("K")) tally+=5;
            if (words.get(i).contains("J")) tally+=8;
            if (words.get(i).contains("X")) tally+=8;
            if (words.get(i).contains("Z")) tally+=10;
            if (words.get(i).contains("Q")) tally+=10;
            scores[i] = tally;
        }
        Arrays.sort(scores);
        return scores;

    }

    
    /** Compares two objects in the Scrabble class with each other.
     * Puts each Scrabble object into string arrays to compare them
     * 
     * @param otherValue this is the object value to be compared 
     * @return true if they are equal; false if they are not equal
     */
    public boolean equals(Scrabble otherValue){
        if (this == otherValue){
            return true;
        }
        if (otherValue == null) return false;
        
        String tileLetters = getLetters();
        String otherLetters = otherValue.getLetters();
        String[] tileArray = new String[7];
        String[] otherArray = new String[7];

        for (int i=0; i<7; i++){
            tileArray[i] = String.valueOf(tileLetters.charAt(i));
            otherArray[i] = String.valueOf(otherLetters.charAt(i));
        }

        Arrays.sort(tileArray);
        Arrays.sort(otherArray);
        
        if(Arrays.equals(tileArray, otherArray)) return true;
     
        else return false;
        
    
        
    }
}