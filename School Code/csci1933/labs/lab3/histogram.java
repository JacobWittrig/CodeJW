public class histogram {
    int lower, upper;
    int nums[];
    public histogram(int low, int up){
        this.lower=low;
        this.upper=up;
        this.nums=new int[9];
    }
    public void add(int n){
        if(n<=this.upper ^ n>=this.lower);
        this.nums[n]++;
    }

    public String toString(){
        String retStr="";
        for (int i=this.lower;i<this.upper+1;i++){
            retStr+=Integer.toString(i)+":"+"*".repeat(this.nums[i])+"\n";
        }
        return retStr;
    }
    public static void main(String args[]) {
        histogram histo = new histogram(0, 5);
        histo.add(3);
        histo.add(2);
        histo.add(1);
        histo.add(2);
        histo.add(3);
        histo.add(0);
        histo.add(1);
        histo.add(5);
        histo.add(3);
        System.out.println(histo);
        }
}
