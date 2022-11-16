package ist.psu.edu.controller;

import ist.psu.edu.model.IDialLock;
import ist.psu.edu.view.LockAppForm;
import ist.psu.edu.view.LockAppView;

import javax.swing.*;
import java.awt.*;

public class LockAppController {
    private final IDialLock model;
    private final LockAppView view;

    public LockAppController(IDialLock model, LockAppView view) {
        this.model = model;
        this.view = view;

        //  get buttons and labels
        LockAppForm form = this.view.form();
        JLabel lockValueLabel = form.getLockValueLabel();
        JLabel tickValueLabel = form.getTickValueLabel();
        JButton leftButton = form.getLeftButton();
        JButton rightButton = form.getRightButton();
        JButton pullButton = form.getPullButton();
        JButton resetButton = form.getResetButton();

        //  Initialize starting text
        updateText(lockValueLabel, tickValueLabel);

        //  Right button logic
        rightButton.addActionListener(e -> {
            model.right(1);
            updateText(lockValueLabel, tickValueLabel);
        });

        //  Left button logic
        leftButton.addActionListener(e -> {
            model.left(1);
            updateText(lockValueLabel, tickValueLabel);
        });

        //  Reset button logic
        resetButton.addActionListener(e -> {
            model.reset();
            updateText(lockValueLabel, tickValueLabel);
        });

        //  Pull button logic
        pullButton.addActionListener(e -> {
            
        });
    }

    private void updateText(JLabel lockValueLabel, JLabel tickValueLabel){
        lockValueLabel.setText("Locked! " + model.toString());
        lockValueLabel.setForeground(Color.RED);
        tickValueLabel.setText(model.currentTick() + "");
    }
}
