import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;


    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);

        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        scanner.close();

        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs
        scanner = new Scanner(f);
        for (int i=0; i<numLines;i++){
            String s = scanner.nextLine();
            String[] owlInfo=s.split(",");
            data[i]=new Owl(owlInfo[0],Integer.parseInt(owlInfo[1]),Double.parseDouble(owlInfo[2]));

        }
        scanner.close();
        return numLines;

        //TODO: Populate the data with owls constructed from the lines of the file given
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        //TODO: Populate the class variables in OwlPopulation
        this.fileName=fileName;
        populateData();
    }

    public double averageAge(){
        double sum=0;
        for (int i=0;i<data.length;i++){
            sum+=data[i].getAge();}

        return sum/data.length;
    }

    public Owl getYoungest(){
        //TODO: implement
        int min=0;
        for (int i=0;i<data.length;i++){
            if (data[i].getAge()<data[min].getAge())
                min=i;
        }
        return data[min];
    }

    public Owl getHeaviest(){
        //TODO: implement
        int max=0;
        for (int i=0;i<data.length;i++){
            if (data[i].getWeight()>data[max].getWeight())
                max=i;
        }
        return data[max];
        
    }

    public String toString(){
        //TODO: implement
        String retStr=new String();
        retStr+=("The youngest owl is " + this.getYoungest().getName()+ " which is "+ this.getYoungest().getAge() +" years old.\n");
        retStr+=("The heaviest owl is " + this.getHeaviest().getName()+ " which is "+ this.getHeaviest().getWeight() +" pounds.\n");
        retStr+=("The average age of the population is "+this.averageAge()+".\n");
        
        return retStr;
    }

    public boolean containsOwl(Owl other){
        //TODO: method you can implement as a helper function to your merge method
        return false;
    }
	
    public void merge(OwlPopulation other){
        
        Owl[] newArray = new Owl[this.data.length+other.data.length];
        for (int i = 0; i<this.data.length;i++){
            newArray[i]=this.data[i];}
        int numDistinct = 0;
        for (int x = 0; x<other.data.length;x++){
            for (int j = 0; j<this.data.length;j++){
                if(!other.data[x].equals(this.data[j])){
                    newArray[this.data.length+x]=other.data[x];
                    numDistinct++;
                }
            }
        }
        
        this.data=newArray;
        
        //TODO: a brief overview of what you can do to implement this method is given below:

        //1) determine (and store) the distinct owls in the other population.

        //2) make a new data array to hold the correct number of owls for the merged population

        //3) copy over the distinct owls from each population to the data array

        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)
    }

    public void merge(OwlPopulation other, String fileName)throws IOException{
        // OwlPopulation New=new OwlPopulation(fileName);
        this.merge(other);
        File f = new File(fileName);
        f.createNewFile();
        FileWriter fm = new FileWriter(f);
        for (int i =0; i<data.length;i++){
            fm.append(data[i].getName()+","+data[i].getAge()+","+data[i].getWeight()+"\n");
        }
        fm.flush();
        fm.close();


    }

    public int popSize(){
        return data.length;
    }
	
    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());

            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());

            pop1.merge(pop2, "merge.csv");
            
            System.out.println(pop1);
            System.out.println(pop1.popSize());
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }


}
