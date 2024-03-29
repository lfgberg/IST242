/**
 * Liam Geyer
 * IST242 - GarageGUI
 * lfg5289@psu.edu
 */

package edu.psu.ist.view;

import javax.swing.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * A basic view class that serves as the outer frame for the garage application. 
 * <p>
 * It also serves as a sort of "helper layer" between the {@link JComponent}s that 
 * make up the actual {@link GarageForm} class while also providing some utility/helper 
 * methods.
 */
public class GarageView extends JFrame {

    private final GarageForm form;

    public GarageView() {
        this.form = new GarageForm();

        // you'll need to add getters for all JComponents in 
        // the form class that is generated by the IDE's formbuilder.
        // I suggest having the IDE generate getter methods for you once 
        // you are happy with the visual appearance of your form.
        JPanel content = form.getPanel();

        // Can set min/max dimensions of the window by calling:
        // this.setMaximumSize(new Dimension(/*desired width*/, /*desired height*/));
        // this.setMinimumSize(..);

        // TODO:
        // can include custom setup code for some JComponents involved in your form
        // (e.g.: do you want a box always checked when the app boots? Do it here)

        // boilerplate/standard code -- include this..
        this.setContentPane(content);
        this.pack();

        this.setTitle("Garage GUI"); // change if you want :-)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Some ideas for potential helper methods your view class might offer:

    /**
     * Returns a reference to the {@link GarageForm} instance stored in this 
     * class.
     */
    public GarageForm garageForm() { return form; }

    /**
     * Returns an inclusive list of well-formed {@link Year} objects from 
     * production start and stop year text fields.
     * <p>
     * For example, if the start year field holds 2000 and the stop year 
     * field holds 2004 then the returned list should include the following 
     * {@link Year} objects: 2000, 2001, 2002, 2003, 2004.
     * <p>
     * <b>Note:</b> This method assumes that the start year is <= to the
     * stop year and that the text in both the start and stop textfields 
     * are valid integers (note: this should be validated in the controller logic)
     */
    public List<Year> retrieveProductionYears(int start, int end) {
        List<Year> result = new ArrayList<>();

        //  add all appropriate years to results, and return populated list
        for (int i = start; i <= end; i++){
            result.add(Year.of(i));
        }

        return result;
    }
}