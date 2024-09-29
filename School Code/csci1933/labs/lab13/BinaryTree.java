import java.util.Arrays;
import java.util.Collections;
public class BinaryTree {

    // TODO complete this method
    public static boolean isValid(int[] arr) {
      
      int size=arr.length;
      if((int)(Math.ceil((Math.log(size) / Math.log(2)))) == (int)(Math.floor(((Math.log(size) / Math.log(2)))))!=true)
        return false;
      int layers=(int) (Math.log(size)/Math.log(2));
      for(int i=0;i<layers-1;i++){
        // System.out.println(i);
        for (int j=(int)Math.pow(2,i);j<(int) Math.pow(2,i)*2;j++){
          
          // System.out.println(arr[j]);
          // System.out.println(arr[j*2]);
          // System.out.println(arr[j*2+1]);
          // System.out.println((arr[j]<=arr[j*2]||arr[j]>=arr[j*2+1]));
          if(arr[j]<=arr[j*2]||arr[j]>=arr[j*2+1])
            return false;
          
        }
        // System.out.println();
      }
      // System.out.println("testing");
      int start=(int)Math.pow(2,layers-1);
      int end=(int) (1.5*Math.pow(2,layers-1));
      for(int i=start ;i<end;i++){
        // System.out.println(arr[i]);
        if(arr[i]>arr[1])
          return false;
      }
      for(int i=end ;i<end*2-start;i++){
        // System.out.println(arr[i]);
        if(arr[i]<arr[1])
          return false;
      }
        
      return true;
    }

    // public static boolean isValidRec(int[] arr,int min, int max) {
    //   if(arr.length<=2)
    //     return true;
    //   if(arr[1]<=arr[2]||arr[1]>=arr[3])
    //     return false;
    //   if(arr[2]>=max||arr[2]<=min||arr[3]>=max||arr[3]<=max)
    //     return false;
    //   boolean valid=true;
    //   int[] newarr=new int[arr.length/2];
    //   int layers=(int) (Math.log(arr.length)/Math.log(2));
    //   for(int i=0;i<layers-1;i++){
    //     System.out.println(i);
    //     for (int j=(int)Math.pow(2,i);j<(int) Math.pow(2,i)*2;j++){
          
    //     }}
    //   valid&=isValidRec
    //   return valid;
    // }

    public static void main (String args[]) {
      // milestone 1
      int[] arr1 = new int[]{-1,7,4,10,3,6,8,15};
      int[] arr2 = new int[]{-1,20,12,32,5,18,25,38};
      int[] arr3 = new int[]{-1,11,3,33,2,8,10,44};
      int[] arr4 = new int[]{-1,55,44,77,33,48,54,95,22,34,45,57,53,70,85,98};

      System.out.println("arr1 valid: " + isValid(arr1));  // expected: true
      System.out.println("arr2 valid: " + isValid(arr2));  // expected: true
      System.out.println("arr3 valid: " + isValid(arr3));  // expected: false
      System.out.println("arr4 valid: " + isValid(arr4));  // expected: false
    }
}
