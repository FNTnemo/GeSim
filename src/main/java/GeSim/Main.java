package GeSim;

import GeSim.Utils.WindowUtils;
import GeSim.Window.MainWindowEngine;

public class Main {

    public static void main(String[] args) {
        WindowUtils.window = new MainWindowEngine();
        WindowUtils.window.setVisible(true);
    }

    //самоходный арт-корпус 4го поколения
}