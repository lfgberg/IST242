/*
* Liam Geyer
* ist242 - Hello World w/MVC
* lfg5289@psu.edu
 */

package edu.psu.ist;

import edu.psu.ist.controller.HelloController;
import edu.psu.ist.model.StringWrapperModel;
import edu.psu.ist.view.HelloWorldView;

public class App {
    public static void main(String[] args) {
        StringWrapperModel model = new StringWrapperModel();
        HelloWorldView view = new HelloWorldView();
        HelloController controller = new HelloController(model, view);
        view.setVisible(true);
    }
}
