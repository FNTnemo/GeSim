package GeSim;

import GeSim.Render.Render;
import GeSim.Window.MainWindowEngine;
import GeSim.Window.SimulationWindowEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationEngine extends JPanel implements ActionListener {

    int frameDelay = 5;

    public SimulationEngine(){
        init();
    }

    Timer timer;
    private void init() {
        timer = new Timer(frameDelay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        SimulationWindowEngine.drawZone(g);
        Render.dotsRender(g);

    }

    public void repaintFunc(){
        repaint();
    }
}
