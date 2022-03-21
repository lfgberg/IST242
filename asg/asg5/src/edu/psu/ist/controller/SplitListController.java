/*
 * Liam Geyer
 * IST242 - Splittable List
 * lfg5289@psu.edu
 */

package edu.psu.ist.controller;

import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.view.SplitListForm;
import edu.psu.ist.view.SplitListView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SplitListController {
    public static final String OUTPUT_FILE_NAME = "contents.txt";

    private final ISplittableList<String> listModel;
    private final SplitListView view;
    private final SplitListForm form;

    public SplitListController(ISplittableList<String> listModel,
                               SplitListView view) {
        this.listModel = listModel;
        this.view = view;
        this.form = view.form();

        updateDisplay();

        // clear button
        form.getClearButton().addActionListener((ActionEvent e) -> {
            listModel.clear();
            updateDisplay();
        });

        //  Add right button
        form.getAddRightButton().addActionListener((ActionEvent e) ->{
            String input = getInput();

            //  defensive check
            if (input.isBlank()){
                JOptionPane.showMessageDialog(view, "Input field cannot be blank.");
                return;
            }

            listModel.addToRightAtFront(input);
            updateDisplay();
        });

        //  remove right button
        form.getRemoveRightButton().addActionListener((ActionEvent e) -> {
            //  defensive check
            if (listModel.rightLength() == 0){
                JOptionPane.showMessageDialog(view, "No entries to remove.");
                return;
            }

            //  update last removed + remove
            form.getRemovedDisplay().setText(listModel.removeFromRightAtFront());
            updateDisplay();
        });

        //  move forward
        form.getForwardButton().addActionListener((ActionEvent e) -> {
            //  defensive check
            if (listModel.rightLength() == 0){
                JOptionPane.showMessageDialog(view, "Cannot move forward; empty right list.");
                return;
            }

            listModel.moveForward();
            updateDisplay();
        });

        //  move to beginning
        form.getBeginningButton().addActionListener((ActionEvent e) -> {
            listModel.moveToVeryBeginning();
            updateDisplay();
        });

        //  save
        form.getSaveButton().addActionListener((ActionEvent e) -> {
            try {
                save();
            } catch (Exception exception){
                JOptionPane.showMessageDialog(view, exception.getMessage());
            }
        });

        //  load
        form.getClearLoadButton().addActionListener((ActionEvent e) -> {
            try {
                listModel.clear();
                load();
                updateDisplay();
            } catch (Exception exception){
                JOptionPane.showMessageDialog(view, exception.getMessage());
                listModel.clear();
                updateDisplay();
            }
        });
    }

    /**
     * Saves the contents of the current {@link ISplittableList} model to a
     * file. Note that this method mutates the model, but
     * <strong>restores</strong> it to its original (input) state upon
     * completion of the method.
     * <p>
     * If an exception is thrown during the course of the method, the list model
     * is just reinitialized (and an error msg is displayed).
     */
    private void save() throws Exception {
        //  instead of mutating the model, mutate the .toString() output
        String[] raw = listModel.toString().split("><");
        raw[0] = raw[0].replace("<", "");
        raw[1] = raw[1].replace(">", "");
        String[] a = raw[0].split(", ");  //  left side
        String[] b = raw[1].split(", ");  //  right side

        //  Put each element from the array into a string
        String left = "";
        String right = "";

        for (int i = (a.length - 1); i >= 0; i--){
            left = left.concat(a[i] + ",");
        }
        for (int i = (b.length - 1); i >= 0; i--){
            right = right.concat(b[i] + ",");
        }

        //  write to outfile
        try (PrintWriter out = new PrintWriter(OUTPUT_FILE_NAME)) {
            out.println(left);
            out.println(right);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Loads the contents of the current saved file to {@link ISplittableList} model
     */
    private void load() throws Exception {
        // it still feels like this would be easier in the utillist where I can mutate the model
        File inputFile = new File(OUTPUT_FILE_NAME);
        List<String> left;
        List<String> right;

        try {
            Scanner input = new Scanner(inputFile);

            //  read each line out of the file
            left = List.of(input.nextLine().split(","));
            right = List.of(input.nextLine().split(","));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

        //  read the input from the file back into the model, move forward the proper amount
        for (String x : right){
            listModel.addToRightAtFront(x);
        }
        for (String x : left){
            listModel.addToRightAtFront(x);
        }
        for (int i = 0; i < left.size(); i++){
            listModel.moveForward();
        }
    }

    /**
     * Updates the display fields
     */
    private void updateDisplay(){
        form.getDisplayLabel().setText(listModel.toString());
        form.getLeftLengthDisplay().setText(String.valueOf(listModel.leftLength()));
        form.getRightLengthDisplay().setText(String.valueOf(listModel.rightLength()));
    }

    /**
     * Fetches the user input from the text field
     * clears the input field
     * @return User input from text field
     */
    private String getInput(){
        JTextField entryField = form.getEntryField();

        String x = entryField.getText();
        entryField.setText("");

        return x;
    }
}
