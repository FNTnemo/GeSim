package GeSim.Window;

import GeSim.SimulationEngine;
import GeSim.Utils.WindowUtils;
import GeSim.Window.SettingsWindows.ChangeFuncSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationWindowEngine extends JFrame {
    Container container;
    static SimulationEngine simulationEngine;

    public SimulationWindowEngine(String title, int width, int height, int x, int y, boolean resizeable){
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height + 25);
        setResizable(resizeable);
        setVisible(true);

        menuBar(this);

        this.container = this.getContentPane();

        add(simulationEngine = new SimulationEngine());
    }

    public static SimulationEngine getSimulationEngine(){
        return simulationEngine;
    }

    public static void menuBar(JFrame frame){
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        menuBar.add(file);
        menuBar.add(edit);

        file.add(new JMenuItem("Reload")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowUtils.getSimulationWindow().revalidate();
            }
        });
        file.addSeparator();
        file.add(new JMenuItem("Close")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowUtils.openWindow(WindowUtils.getMainWindow());
                WindowUtils.closeWindow(WindowUtils.getSimulationWindow());
                WindowUtils.getMainWindow().revalidate();
            }
        });
        file.add(new JMenuItem("Exit")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        edit.add(new JMenuItem("Change variables")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(WindowUtils.getChangeFuncSettingsWindow() != null){WindowUtils.getChangeFuncSettingsWindow().setVisible(true);}
                else WindowUtils.changeFuncSettingsWindow = new ChangeFuncSettings(WindowUtils.getSimulationWindow().getLocation().x/2, WindowUtils.getSimulationWindow().getLocation().y/2,
                        250, 100);


            }
        });

        frame.setJMenuBar(menuBar);
    }

    public static void drawZone(Graphics g){
        int x0 = 800/2;
        int y0 = 600/2;

        g.setColor(Color.gray);
        g.drawLine(0, y0, 800, y0);
        g.drawLine(x0, 0, x0, 600);

        for (int x = 800; x > 0; x -= 10) {
            g.drawLine(x, y0+5, x, y0-5);
        }
        for (int y = 600; y > 0; y -= 10) {
            g.drawLine(x0+5, y, x0-5, y);
        }
    }
}
