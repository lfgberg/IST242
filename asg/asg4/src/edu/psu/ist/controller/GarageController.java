/**
 * Liam Geyer
 * IST242 - GarageGUI
 * lfg5289@psu.edu
 */

package edu.psu.ist.controller;

import edu.psu.ist.model.*;
import edu.psu.ist.view.GarageForm;
import edu.psu.ist.view.GarageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.Year;
import java.util.List;

public class GarageController {
    private final Garage garageModel; // the controller can see both the view and model
    private final GarageView view;    // the view and model classes (by themselves) should be totally
    // oblivious to each other

    public GarageController(Garage garageModel, GarageView view) {
        this.garageModel = garageModel;
        this.view = view;

        //  get all the buttons
        GarageForm form = view.garageForm();
        JButton addButton = form.getAddToGarageButton();
        JButton sortButton = form.getSortByReleaseButton();
        JButton emptyButton = form.getEmptyGarageButton();

        //  sort button logic
        sortButton.addActionListener((ActionEvent event) -> {
            garageModel.sortByReleaseYear();

            //  Re-Render the display area
            form.getDisplayArea().setText(garageModel.toString());
        });

        //  empty button logic
        emptyButton.addActionListener((ActionEvent event) -> {
            garageModel.emptyGarage();

            //  Re-Render the display area
            form.getDisplayArea().setText(garageModel.toString());
        });

        //  add to garage button logic
        addButton.addActionListener((ActionEvent event) -> {
            //  fetch all the fields
            JTextField manuField = form.getManuField();
            JTextField modelField = form.getModelField();
            JTextField countryField = form.getCountryField();
            JTextField mpgField = form.getMpgField();
            JTextField prodStartField = form.getProdYearsFromField();
            JTextField prodEndField = form.getProdYearsToField();

            //  fetch info from fields
            String manuName = manuField.getText();
            String modelName = modelField.getText();
            String country = countryField.getText();
            double mpg = -1;
            int prodStart = -1;
            int prodEnd = -1;

            try {
                //  verify info is valid
                if (manuName.isBlank() || modelName.isBlank() || country.isBlank()
                        || form.getMpgField().getText().isBlank() || form.getProdYearsFromField().getText().isBlank()
                        || form.getProdYearsToField().getText().isBlank()){ //  <-- all fields must be filled
                    throw new IllegalArgumentException("Please fill all fields.");
                }

                //  try to parse the strings into valid nums
                prodStart = Integer.parseInt(prodStartField.getText());
                prodEnd = Integer.parseInt(prodEndField.getText());
                mpg = Double.parseDouble(mpgField.getText());

                if (mpg <= 0){ // <-- mpg needs to be a valid positive nonzero double
                    throw new IllegalArgumentException("MPG must be a positive nonzero double.");
                }

                if (prodStart <= 0 || prodEnd <= 0 || prodEnd < prodStart) { //  <-- prodStart/End need to be valid ints, End must => start
                    throw new IllegalArgumentException("Production years must be positive nonzero integers, the end year must be >= the start year.");
                }

                /*
                 Not checking the inProduction condition as specified in the rubric,
                 this will be inferred based on Year.now() when we create our vehicle object
                */
                List<Year> prodYears = view.retrieveProductionYears(prodStart, prodEnd); //  <-- get prod years, see if in production
                boolean inProd = prodYears.contains(Year.now());

                //  Create the Manufacturer and Model
                Manufacturer manu = new Manufacturer(manuName, country);
                AutoModel model = new AutoModel(modelName, inProd, prodYears);

                //  Create the appropriate vehicle type
                String vehicleType = String.valueOf(form.getVehicleTypeBox().getSelectedItem());
                switch (vehicleType) {
                    case "Truck" -> {
                        Vehicle t = new Truck(manu, model, mpg);
                        garageModel.addVehicle(t);
                        break;
                    }
                    case "Dually Truck" -> {
                        Vehicle t = new Truck(manu, model, mpg, true);
                        garageModel.addVehicle(t);
                        break;
                    }
                    case "Sedan" -> {
                        Vehicle s = new Sedan(manu, model, mpg);
                        garageModel.addVehicle(s);
                        break;
                    }
                }

                //  Re-Render the display area
                form.getDisplayArea().setText(garageModel.toString());
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(view, "Production years and MPG must be positive nonzero integers, the end year must be >= the start year.");
            } catch (Exception e){
                JOptionPane.showMessageDialog(view, e.getMessage());
            } finally {
                //  clear all text fields
                modelField.setText("");
                manuField.setText("");
                countryField.setText("");
                mpgField.setText("");
                prodEndField.setText("");
                prodStartField.setText("");
            }
        });
    }
}
