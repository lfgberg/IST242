package edu.psu.ist.view;

import javax.swing.*;

public class GarageForm {
    private JPanel panel;
    private JLabel manuName;
    private JTextField manuField;
    private JLabel countryName;
    private JTextField countryField;
    private JLabel modelName;
    private JTextField modelField;
    private JTextField mpgField;
    private JLabel mpgLabel;
    private JTextField prodYearsToField;
    private JTextField prodYearsFromField;
    private JLabel prodYearsFromLabel;
    private JLabel prodYearsToLabel;
    private JLabel vehicleTypeLabel;
    private JComboBox vehicleTypeBox;
    private JButton addToGarageButton;
    private JButton sortByReleaseButton;
    private JButton emptyGarageButton;
    private JTextArea displayArea;

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getManuName() {
        return manuName;
    }

    public JTextField getManuField() {
        return manuField;
    }

    public JLabel getCountryName() {
        return countryName;
    }

    public JTextField getCountryField() {
        return countryField;
    }

    public JLabel getModelName() {
        return modelName;
    }

    public JTextField getModelField() {
        return modelField;
    }

    public JTextField getMpgField() {
        return mpgField;
    }

    public JLabel getMpgLabel() {
        return mpgLabel;
    }

    public JTextField getProdYearsToField() {
        return prodYearsToField;
    }

    public JTextField getProdYearsFromField() {
        return prodYearsFromField;
    }

    public JLabel getProdYearsFromLabel() {
        return prodYearsFromLabel;
    }

    public JLabel getProdYearsToLabel() {
        return prodYearsToLabel;
    }

    public JLabel getVehicleTypeLabel() {
        return vehicleTypeLabel;
    }

    public JComboBox getVehicleTypeBox() {
        return vehicleTypeBox;
    }

    public JButton getAddToGarageButton() {
        return addToGarageButton;
    }

    public JButton getSortByReleaseButton() {
        return sortByReleaseButton;
    }

    public JButton getEmptyGarageButton() {
        return emptyGarageButton;
    }

    public JTextArea getDisplayArea() {
        return displayArea;
    }
}
