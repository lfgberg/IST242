/**
 * Liam Geyer
 * IST242 - GarageGUI
 * lfg5289@psu.edu
 */

package edu.psu.ist;

import edu.psu.ist.controller.GarageController;
import edu.psu.ist.model.Garage;
import edu.psu.ist.view.GarageView;

public class App {
    public static void main(String[] args) {
        GarageView view = new GarageView();
        Garage garageModel = new Garage();
        GarageController controller = new GarageController(garageModel, view);
        view.setVisible(true);
    }
}
