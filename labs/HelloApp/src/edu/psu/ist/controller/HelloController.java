/*
 * Liam Geyer
 * ist242 - Hello World w/MVC
 * lfg5289@psu.edu
 */

package edu.psu.ist.controller;

import edu.psu.ist.model.StringWrapperModel;
import edu.psu.ist.view.HelloWorldView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HelloController {
    private StringWrapperModel model;
    private HelloWorldView view;

    public HelloController(StringWrapperModel model, HelloWorldView view) {
        this.model = model;
        this.view = view;

        //  set the label to the initial string
        JLabel blankLabel = view.form().getBlankLabel();
        blankLabel.setText(model.getWrappedString());

        //  reverse the string if the button is pushed
        view.form().getReverseButton().addActionListener((ActionEvent event) -> blankLabel.setText(model.reverseText()));

        //  behavior for submit num button
        view.form().getSubmitButton().addActionListener((ActionEvent event) -> {
            //  get the entered text
            JTextField entryField = view.form().getEntryField();
            String x = entryField.getText();

            //  determine if the input was valid
            if (x.isBlank()){
                //  give user feedback
                JOptionPane.showMessageDialog(view, "Please enter a valid positive and nonzero integer");
                view.form().getEntryField().setText("");
            } else if (Integer.parseInt(x) <= 0){
                JOptionPane.showMessageDialog(view, "Entered value must be greater than 0");
                view.form().getEntryField().setText("");
            } else {
                //  proceed w/ number submission
                model.setWrappedString(model.getWrappedString().concat(x));
                blankLabel.setText(model.getWrappedString());
                view.form().getEntryField().setText("");
            }
        });
    }
}
