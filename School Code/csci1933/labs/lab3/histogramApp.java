import java.util.Scanner;

public class histogramApp {
    int lower, upper;
    int nums[];
    public histogramApp(int low, int up){
        this.lower=low;
        this.upper=up;
        this.nums=new int[9];
    }
    public void add(int n){
        if(n<=this.upper && n>=this.lower)
        this.nums[n]++;
        else
        System.out.println(Integer.toString(n)+" is not in the range");
    }

    public String toString(){
        String retStr="";
        for (int i=this.lower;i<this.upper+1;i++){
            retStr+=Integer.toString(i)+":"+"*".repeat(this.nums[i])+"\n";
        }
        return retStr;
    }
    public static void main(String args[]) {
        System.out.println("---Histogram Console---\n");
        System.out.println("Options\n");
        System.out.println("add - used to add numbers to the histogram\n");
        System.out.println("print - prints the histogram to the screen\n");
        System.out.println("quit - leaves the program\n");
        System.out.println("Enter an lower bound:");
        Scanner myScanner = new Scanner(System.in);
        int lower = myScanner.nextInt();
        // myScanner.close();
        System.out.println("Enter an upper bound:");
       
        int upper = myScanner.nextInt();
        // myScanner.close();
        // Scanner scanner = new Scanner(System.in);
        
        
        
        histogramApp histo = new histogramApp(lower, upper);
        int num=0;
        while (1>0){
            myScanner.nextLine();
            if(myScanner.nextLine().equals("add"))
                {
                System.out.println("Enter a number:");
                num = myScanner.nextInt();
                histo.add(num);
                }
            else if(myScanner.nextLine().equals("print")){
                System.out.println(histo);}
            else{
                System.out.println("Bye!");
                break;
            }
            }
        }
        // histo.add(3);
        // histo.add(2);
        // histo.add(1);
        // histo.add(2);
        // histo.add(3);
        // histo.add(0);
        // histo.add(1);
        // histo.add(5);
        // histo.add(3);
        // System.out.println(histo);
        }

