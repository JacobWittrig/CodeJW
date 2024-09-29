

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Postfix {
    public static void main(String Args[]){
        String[] test1 = {"5", "2", "+"};
        String[] test2 = {"1", "2", "-"};
        String[] test3 = {"4", "5", "*", "3", "+"};
        String[] test4 = {"1", "2", "+", "3", "4", "+", "/"};
        String[] test5 = {"1","2","3","4","5","6","7", "-"};
        String[] test6 = {"1","2","3","4","5","6","7", "8"};
        String[] test7 = {"1","2","+","4","5","-", "/", "/"};
        String[] test8 = {"1", "4", "-", "3", "4", "+", "/"};


        assertTrue(Postfix.evaluate((test1)) == 7.0);
        assertTrue(Postfix.evaluate((test2)) == -1.0);
        assertTrue(Postfix.evaluate((test3)) == 23.0);
        assertTrue(Postfix.evaluate((test4)) == 0.42857142857142855);
        assertTrue(Postfix.evaluate(test5) == 0.0);
        assertTrue(Postfix.evaluate(test6) == 0.0);
        assertTrue(Postfix.evaluate(test7) == 0.0);
        assertTrue(Postfix.evaluate(test8) == -0.42857142857142855);
    }
    static double evaluate (String[] input){

        Stack calculate = new Stack();
        double retVal=0.0;
        try{
        for (String token:input) {
            boolean numeric = true;
            Double num = 0.0;
            try {
                num = Double.parseDouble(token);
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if (numeric) {
                calculate.push(num);

            }
            else{
                double num1=(double)calculate.pop();
                double num2=(double)calculate.pop();
                switch (token){
                    case "+":
                        calculate.push(num2+num1);
                        break;
                    case "-":
                        calculate.push(num2-num1);
                        break;
                    case "/":
                        calculate.push(num2/num1);
                        break;
                    case "*":
                        calculate.push(num2*num1);
                        break;
                }
            }

        }
            retVal=(double)calculate.pop();
        }
        catch (StackException q) {
            System.out.println("Did not work, with size 5");
        }
        finally{
            System.out.println("Evaluation Complete");
        }
        return retVal;
    }

}
