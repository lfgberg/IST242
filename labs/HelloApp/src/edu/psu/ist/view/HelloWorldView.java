/*
 * Liam Geyer
 * ist242 - Hello World w/MVC
 * lfg5289@psu.edu
 */

package edu.psu.ist.view;

import javax.swing.*;

public class HelloWorldView extends JFrame {
    private final HelloForm form;

    public HelloWorldView() {
        this.form = new HelloForm();
        JPanel content = form.getPanel();
        this.setContentPane(content);
        this.pack();
        this.setTitle("Hello World Gui");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public HelloForm form() { return form; }
}