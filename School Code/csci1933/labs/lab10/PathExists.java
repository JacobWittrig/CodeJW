import java.util.LinkedList;
import java.util.Queue;

public class PathExists {
    public static void DFS(char[][]image,int r,int c){
        if(r>=image.length || r<0 || c>=image[0].length||c<0 || (image[r][c]!='p'&&image[r][c]!='v'&&!(r==0&&c==0))){
            return;
                
            
        }
        image[r][c]='z';
                DFS(image,r+1,c);
                DFS(image,r-1,c);
                DFS(image,r,c+1);
                DFS(image,r,c-1);
    }

    public static void BFS(char[][]image,int r,int c){
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
            image[row][col]='z';
            if(row-1>=0&&image[row-1][col]=='p'||(row-1>=0&&image[row-1][col]=='v')){
                
                queue.add(new int[]{row-1,col});
            }
            if(col-1>=0&&image[row][col-1]=='p'||(col-1>=0&&image[row][col-1]=='v')){
                queue.add(new int[]{row,col-1});
            }
            if(row+1<image.length&&image[row+1][col]=='p'||(row+1<image.length&&image[row+1][col]=='v')){
                queue.add(new int[]{row+1,col});
            }
            if(col+1<image[0].length&&image[row][col+1]=='p'||(col+1<image[0].length&&image[row][col+1]=='v')){
                queue.add(new int[]{row,col+1});
            }
                
        }
    }
    public static boolean doesPathExist(char[][] image, int row, int col){
        BFS(image,0,0);
        boolean path=false;
        
        if(image[0][0]=='z'&&image[row][col]=='z')
            path=true;
        return path;

    };
}
