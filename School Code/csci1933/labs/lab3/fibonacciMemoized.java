import java.util.Scanner;
public class fibonacciMemoized {
    static int[] numbers;
    public fibonacciMemoized(){
        numbers = new int[90];
        for (int i=0;i<90;i++)
        numbers[i]=0;}
        
        public static void main(String args[]) {
            System.out.println("Enter an integer n to get the n'th Fibonacci number:");
            Scanner myScanner = new Scanner(System.in);
            int n = myScanner.nextInt(); // gets an integer from command line
            fibonacciMemoized myFib = new fibonacciMemoized();
            System.out.println("The " + n + "'th Fibonacci number using fibonacciMemoized is " + fibonacciMemo(n));
            }
        
        public static int fibonacciMemo(int n){
            if (numbers[n]!=0)
                return numbers[n];
            if (n<=2){
                numbers[n]=1;
                return 1;}
            numbers[n]=fibonacciMemo(n-2)+fibonacciMemo(n-1);
            return numbers[n];
        }

}
