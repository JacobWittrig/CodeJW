public class Matrix {
    private int nrows;
    private int ncols;
    private int[][] matrix;

    public static void main(String[] args) {
        System.out.println("running");
        Matrix m1= new Matrix(2,3);
        m1.matrix[0][0]=1;
        m1.matrix[1][0]=3;
        m1.matrix[0][1]=5;
        m1.matrix[1][1]=7;
        m1.matrix[0][2]=9;
        m1.matrix[1][2]=11;

        Matrix m2=m1.transpose();
        System.out.println(m1);
        System.out.println(m2);
    }

    public Matrix(int nrows, int ncols){
        this.nrows=nrows;
        this.ncols=ncols;
        this.matrix=new int[nrows][ncols];
    }
    public Matrix(int[][] arr){
        this.matrix=arr;
        this.nrows=arr.length;
        this.ncols=arr[0].length;
    }
    public Matrix transpose(){
        Matrix newMatrix= new Matrix(this.ncols,this.nrows);
        for (int x=0;x<ncols;x++){
            for (int y=0;y<nrows;y++){
                newMatrix.matrix[x][y]=this.matrix[y][x];
            }
        }
        System.out.println(newMatrix);
        return newMatrix;
    }

    public String toString(){
        String txt = "";
        for (int x=0;x<nrows;x++){
            for (int y=0;y<ncols;y++){
                txt+=Integer.toString(this.matrix[x][y])+" ";
            }
            txt+="\n";
        }
        return txt;
    }

}
