import java.util.LinkedList;
import java.util.Queue;


public class ColorPath {

   

    
    public static int[][] colorPath(int[][] input,int r,int c,int newColor){
        
        if(input[r][c]!=newColor){colorPathBFS(input, r, c, newColor, input[r][c]);}
        
        return input;
    };
    public static void colorPathDFS(int[][] image, int r,int c,int newColor,int oldColor){
        if(r>=image.length || r<0 || c>=image[0].length||c<0 || image[r][c]!=oldColor){
            return;
                
            
        }
        image[r][c]=newColor;
                colorPathDFS(image,r+1,c,newColor,oldColor);
                colorPathDFS(image,r-1,c,newColor,oldColor);
                colorPathDFS(image,r,c+1,newColor,oldColor);
                colorPathDFS(image,r,c-1,newColor,oldColor);
       
    };

    public static void colorPathBFS(int[][] input, int r, int c, int newColor, int oldColor){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        // int[] location = new int[2];
        // location[1]=c;location[0]=r;
        
        //  int[] addPlace=new int[2];
        // queue.add(location);
        while(queue.size()>0){
            int[] location=queue.remove();
            int row = location[0];
            int col = location[1];
            input[row][col]=newColor;
            if(row-1>=0&&input[row-1][col]==oldColor){
                
                queue.add(new int[]{row-1,col});
            }
            if(col-1>=0&&input[row][col-1]==oldColor){
                queue.add(new int[]{row,col-1});
            }
            if(row+1<input.length&&input[row+1][col]==oldColor){
                queue.add(new int[]{row+1,col});
            }
            if(col+1<input[0].length&&input[row][col+1]==oldColor){
                queue.add(new int[]{row,col+1});
            }
                
        }
    }
}
