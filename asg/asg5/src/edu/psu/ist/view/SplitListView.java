/*
 * Liam Geyer
 * IST242 - Splittable List
 * lfg5289@psu.edu
 */

package edu.psu.ist.view;

import javax.swing.*;

public class SplitListView extends JFrame {
    private final SplitListForm form;

    public SplitListView() {
        this.form = new SplitListForm();
        JPanel content = form.getPanel();
        this.setContentPane(content);
        this.pack();

        this.setTitle("Splittable List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public SplitListForm form() {
        return form;
    }
}
