import java.util.Scanner;

public class Application {
  // public static void main(String[] args) {
    
  //   System.out.println("CSCI 1933\n----\nCSCI 2011H\n----\nCHEM 1061\n----\nCSCL 1001W\n----\nSTAT 3021");
  //   System.out.println("Enter a phrase");
  //   Scanner myObj = new Scanner(System.in);
  //   System.out.println(commonChar(myObj.nextLine()));
  //   System.out.println(isPal("folklore"));
  //   System.out.println(isPal("radar"));
    
  // }
  public static String commonChar(String inputString){
    char character=inputString.charAt(0);
    int count=1;
    char curchar;
    int curcount=0;
    for (int i=0; i<inputString.length();i++){
      curchar=inputString.charAt(i);
      curcount=0;
      for (int j=0; j<inputString.length();j++){
        if (inputString.charAt(j)==curchar)
          curcount++;
      }
      if (curcount>count){
        count=curcount;
        character=inputString.charAt(i);
      }
    }
    return character + " : " + Integer.toString(count);
  }
  public static String isPal(String word){
    if (word.length()<=1)
      return "True";
    if (word.charAt(0)!=word.charAt(word.length()-1))
      return "False";
    return isPal(word.substring(1,word.length()-1));
  }
}

