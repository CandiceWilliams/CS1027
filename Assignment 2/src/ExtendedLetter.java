public class ExtendedLetter extends Letter{
    private String content;
    private int family;
    private boolean related;
    private int SINGLETON = -1;

    public ExtendedLetter(String s){
        super('c');
        content = s;
        related = false;
        family = SINGLETON;
        
    }

    public ExtendedLetter(String s, int fam){
        super('c');
        content = s;
        related = false;
        family = fam;
    }

    public boolean equals(Object other){
        if (other instanceof ExtendedLetter){
            if (((ExtendedLetter) other).getFamily() == this.getFamily())  //calls private getFamily method within the class to determine and compare the two values
                this.related = true;
            if (((ExtendedLetter) other).getContent() == this.getContent()) return true; //calls private getContent() method within the class to determine and compare the two values
        }
        return false;
    }

    private int getFamily(){  //returns the family variable
        return family;
    }

    private String getContent(){  //returns the content variable
        return content;
    }

    public String toString(){   
        if (this.isUnused() && related == true){  //if the extended letter object is unused and related is true then it decorates content with periods (.)
            return "." +this.content.toString()+".";  
        }
        else{
            return decorator() + this.content + decorator();
        }
    }

    public static Letter[] fromStrings(String[] content, int[] codes){
        Letter[] letters = new Letter[content.length];
        for (int i = 0; i < content.length; i ++){ 
            if(codes == null) letters[i] = new ExtendedLetter(content[i]); 
            else letters[i] = new ExtendedLetter(content[i], codes[i]);
        }
        return letters; //array of letters
    }

}
