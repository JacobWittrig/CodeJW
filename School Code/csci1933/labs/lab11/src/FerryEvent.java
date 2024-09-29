/**
 * A class that represents a FerryEvent, which handles boarding, deboarding, and transport of Passengers
 */
public class FerryEvent implements IEvent{
  private int curIsland; 
  private Ferry ship;


  // What two attributes will we need to keep track of?
  
  public FerryEvent(int island,Ferry ship){
    this.curIsland=island;
    this.ship=ship;
  }
  // We should create a constructor that takes in those attributes and sets them.

  // TODO: implement this
  @Override
  public void run() {
    Passenger[] remove=ship.removePassengersAtIsland(curIsland);
    if(remove!=null && remove.length>=1){
      int time=remove.length*1;
      FerrySim.agenda.add(new FerryEvent(curIsland,ship),time*1000);
    }
    else{
      int numAdded=0;
      while(!ship.isFull()&&FerrySim.lines[curIsland].length()>0){
        ship.addPassenger(FerrySim.lines[curIsland].remove());
        numAdded++;
      }
      int time=numAdded*1;
      int nextIsland=(curIsland+1)%3;
      FerrySim.agenda.add(new FerryEvent(nextIsland,ship),time*1000);
    }
    
    
    // Check if there are passengers to deboard.
    // If there are, deboard them and create a new FerryEvent with the same 
    //   island and ferry. The time will be the amount of time it takes to
    //   deboard these passengers.
    
    // If there aren't any passengers to deboard, let's check if we can board 
    //   passengers. If there's passengers who want to board and space on the 
    //   ferry, then let's board. Keep track of the number of passengers that
    //   board, because we'll once again be adding another FerryEvent to allow
    //   for the time that passed, just like for deboarding.
    
    // If there is no deboarding and no boarding, then it's time for the ferry 
    //   to move on. We'll add a new FerryEvent to the agenda, this time with 
    //   the next island (remember that the ferry goes 0->1->2->0...), and the 
    //   time as the amount of time it takes to travel to the next island.
       
  }
}
