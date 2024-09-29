import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
import java.util.Random.*;

public class Bookshelf{
    private Book[] books;
    
    public static void main(String[] args) throws FileNotFoundException {
        Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
        System.out.println(goodbooks);
        bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
        bs.add(new Book("Twilight", "Stephenie Meyer", 0.0));
        bs.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        bs.sort('r');
        //System.out.println(bs);
        // Bookshelf bookshelf= new Bookshelf();
        // bookshelf=readBooksFromFile("bookinput.txt");
        // writeShelfToFile(bookshelf, "output.txt");
        System.out.println(bs.removeBook());
        System.out.println();
        System.out.println(bs);
    }

    public Book removeBook(){
        
        Random rand = new Random();
        int bookCount=this.books.length;
        for (int i=0;i<this.books.length;i++){
            if (books[i] == null) {
                bookCount=i;}}
        int rand_int1 = rand.nextInt(bookCount);
        for (int i=rand_int1;i<this.books.length-1;i++){
            books[i]=books[i+1];
        }
        books[bookCount-1]=null;
        return books[rand_int1];
    }

    public Bookshelf(){
    books = new Book[20];
    }

    public Bookshelf(int size){
        books = new Book[size];
        }

    public boolean add(Book newBook){
        for (int i=0;i<this.books.length;i++){
            if (books[i] == null) {
                books[i]=newBook;
                return true;      
            }
        }
        return false;
    }

    public Bookshelf getBooksByAuthor(String author){
        Bookshelf retBooks=new Bookshelf(this.books.length);
        for (int i=0;i<this.books.length;i++){
            if (books[i] != null) {
                if (books[i].getAuthor() == author) {
                    retBooks.add(books[i]); 
                }
            }
        }
        return retBooks;
    }

    public String toString(){
        String out=new String();
        for (int i=0;i<this.books.length;i++){
            if (books[i] != null) {
                out+=books[i].getTitle()+", "+books[i].getAuthor()+", "+books[i].getRating()+"\n";

            }

        }
        return out;
    }

    public void sort(char sortBy){
        int bookCount=this.books.length;
        for (int i=0;i<this.books.length;i++){
            if (books[i] == null) {
                bookCount=i;}}
        Boolean sorted = false;
        while (sorted==false){
            int sortTimes=0;
            for (int i=0;i<bookCount-1;i++){
                
                if(books[i].compareTo(books[i+1],sortBy)>0){
                    Book tempBook= books[i+1];
                    books[i+1]=books[i];
                    books[i]=tempBook;
                    sortTimes+=1;
                }
                
            }
            if (sortTimes==0)
                sorted=true;
            }}


    public static Bookshelf readBooksFromFile(String fileName) throws FileNotFoundException{
        
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        Bookshelf data = new Bookshelf(numLines);   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);
        for (int i=0; i<numLines;i++){
            String s = scanner.nextLine();
            String[] bookInfo=s.split(",");
            data.books[i]=new Book(bookInfo[0],(bookInfo[1]),Double.parseDouble(bookInfo[2]));

        }
        scanner.close();
        return data;
    }
    public static void writeShelfToFile(Bookshelf b, String fileName){
        // assume our filename is stored in the string fileName
Scanner s = null; // declare s outside try-catch block
try {
s = new Scanner(new File(fileName));
} catch (Exception e) { // returns false if fails to find fileName
// return false;:
;
}
// Now use s in the same way we used Scanners previously for user input
// To write to an arbitrary textfile, do the following:
// assume our filename is stored in the string fileName
PrintWriter p = null; // declare p outside try-catch block
try {
p = new PrintWriter(new File(fileName));

p.println(b.toString()); // "hello" is added to the file, ending with a newline character (\n)
p.close();//if you do not close the file, the output file will remain blank
} catch (Exception e) {
// return false;
;
}
    }
}