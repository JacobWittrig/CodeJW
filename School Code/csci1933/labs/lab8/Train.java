public class Train extends Vehicle{
    private boolean movingForward;
    private double mpg;
    public Train(){this.mpg=470.0;}
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
    public void enteringStation(){System.out.println("Train Entering Station");}
    public void leavingStation(){System.out.println("Train Leaving Station");}

    
    protected static int nVehicles = 0;

    public String toString(){
        return ("Train: "+this.getMPG());
    }

    
}
