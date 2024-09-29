public class VehicleTester {
    public static void main(String Args[]){
        //milestone 1
        Scooter scooter=new Scooter();
        scooter.movingBackward();
        scooter.movingForward();
        Bike bike=new Bike();
        bike.movingBackward();
        bike.movingForward();
        //milestone 2
        Car car = new Car(30.0);
        System.out.println(car);
        car.movingForward();
        car.movingBackward();
        Helicopter helicopter = new Helicopter();
        Train train = new Train();
        System.out.println("Total Number of Vehicles: " + Vehicle.getNumVehicles());


    }
}
