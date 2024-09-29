public class Helicopter extends Vehicle{
    private boolean movingForward;
    private double mpg;
    private boolean movingUp;
    public Helicopter(){this.mpg=0.3;}
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
    public void movingUp(){
        this.movingUp=false;
        System.out.println("Helicopter Moving Up");
    }
    public void movingDown(){
        this.movingUp=false;
        System.out.println("Helicopter Moving Down");
    }
    public String toString(){
        return ("Helicopter: "+this.getMPG());
    }

    
    protected static int nVehicles = 0;

   

    
}
