import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/**
 * A class that handles the addition of Passengers to the line on an island
 */
public class PassengerArrivalEvent implements IEvent{
    private int island;
    public PassengerArrivalEvent(int island){
        this.island = island;
    }
    public int getIsland(){
        return island;
    }
    
    // TODO: implement this method
    @Override
    public void run() {
        Random rand = new Random();
        Passenger newPassenger = new Passenger(this.island);
        
        FerrySim.lines[this.island].add(newPassenger);
        int next = rand.nextInt(5,15);
        FerrySim.agenda.add(new PassengerArrivalEvent(this.island),next);
        System.out.println("Passenger Event Island: "+this.island+", Current Time is: "+FerrySim.agenda.getCurrentTime()+", Next Passenger in: "+next);
    }
}
