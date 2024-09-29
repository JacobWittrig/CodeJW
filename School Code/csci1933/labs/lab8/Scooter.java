public class Scooter implements Drivable{
    private boolean movingForward;
    public void movingForward(){
        this.movingForward=true;
        if(movingForward)
            System.out.println(this.getClass()+" Moving "+(movingForward?"Forwards":"Backwards"));
    };
    public  void movingBackward(){
        this.movingForward=false;
        System.out.println(this.getClass()+" Moving "+(movingForward?"Forwards":"Backwards"));

    };
    

    // public void start(){System.out.println("Starting Vehicle Engine..");}
    // public void stop(){System.out.println("Stopping Vehicle Engine..");}
    protected static int nVehicles = 0;

   
    // public boolean equals(Object o) {
    //     if (o != null && this.getClass() == o.getClass()) {
    //         Vehicle v = (Vehicle)o;
    //         if (getMPG() == v.getMPG()) {
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     } else {
    //         return false;
    //     }
    // }

    public static final int getNumVehicles() {
        return nVehicles;
    }

    // This method is used for sorting vehicles by their MPG.
    // TODO: Implement this method for Milestone 3
    public int compareTo(Vehicle v) {
         return 0;
    }
}
