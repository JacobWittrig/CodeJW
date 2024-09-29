/**
 * A class representing a Ferry, which transports Passengers from island to island.
 * Can hold up to 60 Passengers at a time.
 */

public class Ferry {
    private Passenger[] passengers= new Passenger[60];

    // TODO: implement this
    public boolean addPassenger(Passenger p) {
    for (int i=0;i<60;i++){
        if(passengers[i]==null){
            passengers[i]=p;
            return true;
        }
    }
         return false; }

    // TODO: implement this
    public Passenger[] removePassengersAtIsland(int island){
        Passenger[] retPassengers=new Passenger[60];
        int numPassengers=0;
        for (int i=0;i<60;i++){
            if(passengers[i]!=null && passengers[i].getDropoffIsland()==island){
                retPassengers[numPassengers]=passengers[i];
                numPassengers++;
                passengers[i]=null;
            }
        }
        if(numPassengers==0)
            return null;
        Passenger[] retPassengers2=new Passenger[numPassengers];
        System.arraycopy(retPassengers2, 0, retPassengers, 0, numPassengers);
        return retPassengers;
         }
    
    // TODO: implement this
    public boolean isFull() {
        for(Passenger passenger:passengers)
            if(passenger==null)
                return false;
         return true; }
    
}
