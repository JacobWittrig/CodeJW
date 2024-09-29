import java.util.Scanner;
public class fibonacci{
    fibonacci(){}
        public static void main(String args[]) {
            System.out.println("Enter an integer n to get the n'th Fibonacci number:");
            Scanner myScanner = new Scanner(System.in);
            int n = myScanner.nextInt(); // gets an integer from command line
            
            System.out.println("The " + n + "'th Fibonacci number using fibonacciRecursive is " + fibonacciRecursive(n));
            System.out.println("The " + n + "'th Fibonacci number using fibonacciIterative is " + fibonacciIterative(n));
            }
        
        public static int fibonacciRecursive(int n){
            if(n==0)
            return 0;
            if (n<=2)

                return 1;
            return fibonacciRecursive(n-2)+fibonacciRecursive(n-1);
        }

        public static int fibonacciIterative(int n){
            if (n==0)
            return 0;
            int num1=1;
            int num2=1;
            for(int count=2;count<n;count++){
                int newnum=num1+num2;
                num1=num2;
                num2=newnum;
            }
            return num2;
        }

        
        }


