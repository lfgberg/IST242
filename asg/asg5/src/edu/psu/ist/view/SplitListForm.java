/*
 * Liam Geyer
 * IST242 - Splittable List
 * lfg5289@psu.edu
 */

package edu.psu.ist.view;

import javax.swing.*;

public class SplitListForm {
    private JLabel displayLabel;
    private JTextField entryField;
    private JButton addRightButton;
    private JButton removeRightButton;
    private JButton forwardButton;
    private JButton beginningButton;
    private JButton clearButton;
    private JLabel removedLabel;
    private JLabel removedDisplay;
    private JLabel leftLengthLabel;
    private JLabel leftLengthDisplay;
    private JLabel rightLengthLabel;

    public JLabel getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(JLabel displayLabel) {
        this.displayLabel = displayLabel;
    }

    public JTextField getEntryField() {
        return entryField;
    }

    public void setEntryField(JTextField entryField) {
        this.entryField = entryField;
    }

    public JButton getAddRightButton() {
        return addRightButton;
    }

    public void setAddRightButton(JButton addRightButton) {
        this.addRightButton = addRightButton;
    }

    public JButton getRemoveRightButton() {
        return removeRightButton;
    }

    public void setRemoveRightButton(JButton removeRightButton) {
        this.removeRightButton = removeRightButton;
    }

    public JButton getForwardButton() {
        return forwardButton;
    }

    public void setForwardButton(JButton forwardButton) {
        this.forwardButton = forwardButton;
    }

    public JButton getBeginningButton() {
        return beginningButton;
    }

    public void setBeginningButton(JButton beginningButton) {
        this.beginningButton = beginningButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JLabel getRemovedLabel() {
        return removedLabel;
    }

    public void setRemovedLabel(JLabel removedLabel) {
        this.removedLabel = removedLabel;
    }

    public JLabel getRemovedDisplay() {
        return removedDisplay;
    }

    public void setRemovedDisplay(JLabel removedDisplay) {
        this.removedDisplay = removedDisplay;
    }

    public JLabel getLeftLengthLabel() {
        return leftLengthLabel;
    }

    public void setLeftLengthLabel(JLabel leftLengthLabel) {
        this.leftLengthLabel = leftLengthLabel;
    }

    public JLabel getLeftLengthDisplay() {
        return leftLengthDisplay;
    }

    public void setLeftLengthDisplay(JLabel leftLengthDisplay) {
        this.leftLengthDisplay = leftLengthDisplay;
    }

    public JLabel getRightLengthLabel() {
        return rightLengthLabel;
    }

    public void setRightLengthLabel(JLabel rightLengthLabel) {
        this.rightLengthLabel = rightLengthLabel;
    }

    public JLabel getRightLengthDisplay() {
        return rightLengthDisplay;
    }

    public void setRightLengthDisplay(JLabel rightLengthDisplay) {
        this.rightLengthDisplay = rightLengthDisplay;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getClearLoadButton() {
        return clearLoadButton;
    }

    public void setClearLoadButton(JButton clearLoadButton) {
        this.clearLoadButton = clearLoadButton;
    }

    private JLabel rightLengthDisplay;
    private JButton saveButton;
    private JButton clearLoadButton;

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    private JPanel panel;
}
