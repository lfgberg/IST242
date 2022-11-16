package ist.psu.edu;

import ist.psu.edu.controller.LockAppController;
import ist.psu.edu.model.IDialLock;
import ist.psu.edu.model.TrLockImpl;
import ist.psu.edu.view.LockAppView;

public class LockApp {
    public static void main(String[] args) {
        IDialLock model = new TrLockImpl(3, 1, 5, 7);
        LockAppView view = new LockAppView();
        LockAppController controller = new LockAppController(model, view);
        view.setVisible(true);
    }
}