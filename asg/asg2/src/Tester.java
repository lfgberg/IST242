/*
 * Liam Geyer
 * IST242 - asg2
 * lfg5289@psu.edu
 */

import java.time.Year;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Vehicle> garage = new ArrayList<>();

        //  create F150
        ArrayList<Year> f150Years = new ArrayList<>();
        f150Years.add(Year.of(1975));

        Manufacturer f150Manu = new Manufacturer("Ford", "USA");
        Model f150Model = new Model("F150", true, f150Years);
        VehicleType f150Type = new VehicleType(VehicleType.Kind.TRUCK, 4);

        Vehicle f150 = new Vehicle(f150Model, f150Manu, f150Type, 17000, 22);

        //  add the f150 to the array
        garage.add(f150);

        //  create Civic
        ArrayList<Year> civicYears = new ArrayList<>();
        civicYears.add(Year.of(1996));

        Manufacturer civicManu = new Manufacturer("Honda", "Japan");
        Model civicModel = new Model("Civic", true, civicYears);
        VehicleType civicType = new VehicleType(VehicleType.Kind.SEDAN, 4);

        Vehicle civic = new Vehicle(civicModel, civicManu, civicType, 17000, 28);

        //  add the civic to the array
        garage.add(civic);

        //  create m3
        ArrayList<Year> m3Years = new ArrayList<>();
        m3Years.add(Year.of(2003));

        Manufacturer m3Manu = new Manufacturer("BMW", "Germany");
        Model m3Model = new Model("M3", true, m3Years);
        VehicleType m3Type = new VehicleType(VehicleType.Kind.COUPE, 4);

        Vehicle m3 = new Vehicle(m3Model, m3Manu, m3Type, 0, 30);

        //  add the m3 to the array
        garage.add(m3);

        //  display all the vehicle in the array
        for (Vehicle vehicle : garage){
            System.out.println(vehicle.toString());
            System.out.println("---------------------");
        }
    }
}
