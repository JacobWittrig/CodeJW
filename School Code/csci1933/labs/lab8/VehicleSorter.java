import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VehicleSorter {
	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		//TODO: add vehicle objects of different types to your list
		//	e.g. vehicles.add(new Vehicle());
		vehicles.add(new Car(20));
		vehicles.add(new Car(21));
		vehicles.add(new Car(22));
		vehicles.add(new Car(23));
		vehicles.add(new Car(24));
		vehicles.add(new Helicopter());
		vehicles.add(new Train());


		Collections.sort(vehicles);
		for (Vehicle v : vehicles) {
			System.out.println(v);
		}
	}
}
