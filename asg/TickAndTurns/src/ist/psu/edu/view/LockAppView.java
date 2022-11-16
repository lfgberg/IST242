package ist.psu.edu.view;

import javax.swing.*;
import java.awt.*;

public class LockAppView extends JFrame{
    private final LockAppForm form;

    public LockAppView() {
        this.form = new LockAppForm();

        JPanel content = form.getMyPanel();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(300, 300));
        this.pack();

        this.setTitle("Dial Lock App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LockAppForm form() {
        return form;
    }
}
