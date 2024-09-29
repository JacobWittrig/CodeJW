public class Car extends Vehicle{
    private boolean movingForward;
    private double mpg;
    public Car(){this.mpg=30.0;super.nVehicles+=1;}
    public Car(double mpg){this.mpg=mpg;super.nVehicles+=1;}
    public double getMPG(){return this.mpg;}
    public void movingForward(){
        this.movingForward=true;
        if(movingForward)
            System.out.println(this.getClass()+" Moving "+(movingForward?"Forwards":"Backwards"));
    };
    public  void movingBackward(){
        this.movingForward=false;
        System.out.println(this.getClass()+" Moving "+(movingForward?"Forwards":"Backwards"));

    };
    public String toString(){
        return ("Car: "+this.getMPG());
    }

    
    protected static int nVehicles = 0;

   

    
}
