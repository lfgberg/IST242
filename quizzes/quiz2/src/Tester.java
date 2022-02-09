/*
 * Liam Geyer
 * ist242 - quiz2
 * lfg5289@psu.edu
 */

public class Tester {
    public static void main(String[] args) {
        // creates a condo
        Property c = new Condo("streetname", "cityname", "statename", Property.PropertySize.LARGE, 498237498, 293874);
        c.playBall();

        //  creates a house
        Property h = new House("124 waring cmns", "university park", "pa", Property.PropertySize.SMALL, 198273, 192873);
        h.playBall();
    }
}
