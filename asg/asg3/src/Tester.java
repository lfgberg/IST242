/*
 * Liam Geyer
 * IST242 - Modeling Cars with inheritance
 * lfg5289@psu.edu
 */

import java.time.Year;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        //  create a garage
        Garage g = new Garage();

        //  Create and populate production years
        ArrayList<Year> productionYears = new ArrayList<>();
        for (int i = 2020; i < 2023; i++){
            productionYears.add(Year.of(i));
        }

        //  f150
        Manufacturer ford = new Manufacturer("Ford", "USA");
        AutoModel f150 = new AutoModel("F150", true, productionYears);
        Vehicle f150Truck = new Truck(ford, f150, 20);
        g.addVehicle(f150Truck);

        //  civic
        productionYears.clear();
        for (int i = 1996; i < 1999; i++){
            productionYears.add(Year.of(i));
        }

        Manufacturer honda = new Manufacturer("Honda", "Japan");
        AutoModel civic = new AutoModel("Civic", false, productionYears);
        Vehicle hondaCivic = new Sedan(honda, civic, 28);
        g.addVehicle(hondaCivic);

        //  m3
        productionYears.clear();
        for (int i = 2015; i < 2019; i++){
            productionYears.add(Year.of(i));
        }

        Manufacturer BMW = new Manufacturer("BMW", "Germany");
        AutoModel M3 = new AutoModel("M3 Limited", false, productionYears);
        Vehicle BMWM3 = new Sedan(BMW, M3, 30);
        g.addVehicle(BMWM3);

        //  tundra
        productionYears.clear();
        for (int i = 1987; i < 1989; i++){
            productionYears.add(Year.of(i));
        }

        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        AutoModel tundra = new AutoModel("Tundra", false, productionYears);
        Vehicle toyotaTundra = new Truck(toyota, tundra, 30, true);
        g.addVehicle(toyotaTundra);

        System.out.println("Before sorting: ");
        System.out.println(g);

        g.sortByReleaseYear(); // g is a garage object containing all 4 vehicles

        System.out.println("After sorting: ");
        System.out.println(g);
    }
}
