import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class HashTable<T>{
    private int collisionCount;
    private int collisionTotal;
    private int longChain;
    NGen<T>[] hashTable;


    public HashTable(int length){
         this.hashTable=new NGen[length];
         collisionCount=0;
         collisionTotal=0;
         longChain=0;

    }
    //TODO: Create a constructor that takes in a length and initializes the hash table array

    //TODO: Implement a simple hash function
    public int hash1(T item) {
        Random rand = new Random();
        int loc=0;
        boolean collided=false;
        int chain=0;
        while(hashTable[loc]!=null){
            chain++;
            collided=true;
            collisionTotal++;
            loc=rand.nextInt(hashTable.length);
            
            
        }
        if(collided)
            collisionCount++;
        if(chain>longChain)
            longChain=chain;
        return loc;
    }

    //TODO: Implement a second (different and improved) hash function
    public int hash2(T item) {
        return -1;
    }

    //TODO: Implement the add method which adds an item to the hash table using your best performing hash function
    // Does NOT add duplicate items
    public void add(T item) {
        int loc=hash1(item);
        hashTable[loc]=new NGen<>(item,null);
    }

    // ** Already implemented -- no need to change **
    // Adds all words from a given file to the hash table using the add(T item) method above
    @SuppressWarnings("unchecked")
    public void addWordsFromFile(String fileName) {
        Scanner fileScanner = null;
        String word;
        try {
            fileScanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " not found.");
            System.exit(1);
        }
        while (fileScanner.hasNext()) {
            word = fileScanner.next();
            word = word.replaceAll("\\p{Punct}", ""); // removes punctuation
            this.add((T) word);
        }
    }

    //TODO: Implement the display method which prints the indices of the hash table and the number of words "hashed"
    // to each index. Also prints:
    // - total number of unique words
    // - number of empty indices
    // - number of nonempty indices
    // - average collision length
    // - length of longest chain
    public void display() {
        int total=0;
        for(int i=0;i<this.hashTable.length;i++){
            if(this.hashTable[i]!=null){
                System.out.println(i);
                total++;
            }
        }
        System.out.println("unique words: "+total);
        System.out.println("empty indices: "+(this.hashTable.length-total));
        System.out.println("nonempty indices: "+total);
        System.out.println("average collision length: "+collisionTotal/collisionCount);
        System.out.println("length of longest chain: "+longChain);
        System.out.println("num collision"+collisionCount);

    }

    // TODO: Create a hash table, store all words from "canterbury.txt", and display the table
    //  Create another hash table, store all words from "keywords.txt", and display the table
    public static void main(String args[]) {
        System.out.println("running");
        HashTable cantTable=new HashTable<>(25);
        cantTable.addWordsFromFile("cant.txt.txt");
        cantTable.display();
        
    }
}
