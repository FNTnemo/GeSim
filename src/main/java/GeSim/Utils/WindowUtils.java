package GeSim.Utils;

import GeSim.Window.MainWindowEngine;
import GeSim.Window.SettingsWindows.ChangeFuncSettings;
import GeSim.Window.SimulationWindowEngine;

import javax.swing.*;

public class WindowUtils {

    public static SimulationWindowEngine simulationWindow;
    public static SimulationWindowEngine getSimulationWindow() {
        return simulationWindow;
    }


    public static MainWindowEngine window;
    public static MainWindowEngine getMainWindow() {
        return window;
    }

    public static ChangeFuncSettings changeFuncSettingsWindow;
    public static ChangeFuncSettings getChangeFuncSettingsWindow(){return  changeFuncSettingsWindow;}

    public static void closeWindow(JFrame window){
        window.setVisible(false);
    }
    public static void openWindow(JFrame window){
        window.setVisible(true);
    }
}
