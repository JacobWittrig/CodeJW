import java.util.Scanner;

public class max {
    public static void main(String args[]) {
        System.out.println("Enter an integer n to get the largest digit:");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt(); // gets an integer from command line
        System.out.println("The largest digit using maxRecursive is " + maxRecursive(n,0));
        System.out.println("The largest digit using maxIterative is " + maxIterative(n));
        }
    public static int maxIterative(int n){
        int maximum=0;
        while (n>0){
            if (n%10>maximum)
                maximum=n%10;
            n/=10;
        }
        return maximum;
    }

    public static int maxRecursive(int n, int maximum){
        if (n<10)
            return n;
        return Math.max(Math.max(maximum,n%10),maxRecursive(n/10,maximum));
    }
}
