package GeSim.Window.SettingsWindows;

import GeSim.Math.Function;
import GeSim.Render.Dot;
import GeSim.SimulationEngine;
import GeSim.Utils.WindowUtils;
import GeSim.Window.MainWindowEngine;
import GeSim.Window.SimulationWindowEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeFuncSettings extends JFrame {

    Container container;
    Function function = MainWindowEngine.function;

    public ChangeFuncSettings(int x, int y, int width, int height){
        setTitle("Function Settings");
        setSize(width, height+25);
        setLocation(x, y);
        setResizable(false);

        setVisible(true);

        this.container = this.getContentPane();

        ui(container);
    }

    JTextField x;
    JTextField a;
    JTextField b;
    JTextField c;
    JTextField k;

    JButton OKButton;
    JButton CancelButton;

    public void ui(Container container){
        if(function.getFunction().equals(Function.Parabola)){

            container.setLayout(new GridLayout(5, 5, 2, 2));

            JLabel labelX = new JLabel(" maxX: ");
            JLabel labelA = new JLabel(" A: ");
            JLabel labelB = new JLabel(" B: ");
            JLabel labelC = new JLabel(" C: ");

            this.x = new JTextField(5);
            this.a = new JTextField(5);
            this.b = new JTextField(5);
            this.c = new JTextField(5);

            container.add(labelX);
            container.add(x);

            container.add(labelA);
            container.add(a);

            container.add(labelB);
            container.add(b);

            container.add(labelC);
            container.add(c);

            this.OKButton = new JButton("Ok");
            OKButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    WindowUtils.getChangeFuncSettingsWindow().setVisible(false);
                    Function.clearFunc();
                    try {
                        double x = Double.parseDouble(getParameterX().getText());
                        double a = Double.parseDouble(getParameterA().getText());
                        double b = Double.parseDouble(getParameterB().getText());
                        double c = Double.parseDouble(getParameterC().getText());
                        if(a == 0)
                            a=1;
                        function.parabola(x, a, b, c);
                    } catch (NumberFormatException error){
                        function.parabola(10, 1, 0, 0);
                    }
                    SimulationWindowEngine.getSimulationEngine().repaint();
                }
            });
            this.CancelButton = new JButton("Cancel");
            CancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    WindowUtils.getChangeFuncSettingsWindow().setVisible(false);
                }
            });

            container.add(CancelButton);
            container.add(OKButton);
        }
        if(function.getFunction().equals(Function.Hyperbola)){

            container.setLayout(new GridLayout(4, 5, 2, 2));

            JLabel labelX = new JLabel(" maxX: ");
            JLabel labelK = new JLabel(" K: ");
            JLabel labelA = new JLabel(" A: ");

            this.x = new JTextField(5);
            this.a = new JTextField(5);
            this.k = new JTextField(5);

            container.add(labelX);
            container.add(x);
            container.add(labelK);
            container.add(k);
            container.add(labelA);
            container.add(a);

            this.OKButton = new JButton("Ok");

            OKButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    WindowUtils.getChangeFuncSettingsWindow().setVisible(false);
                    Function.clearFunc();
                    try {
                        double x = Double.parseDouble(getParameterX().getText());
                        double k = Double.parseDouble(getParameterA().getText());
                        double a = Double.parseDouble(getParameterB().getText());
                        if(a == 0)
                            a=1;
                        function.hyperbola(x, k, a);
                    } catch (NumberFormatException error){
                        function.hyperbola(10, 1, 1);
                    }
                    SimulationWindowEngine.getSimulationEngine().repaint();
                }
            });

            this.CancelButton = new JButton("Cancel");
            CancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    WindowUtils.getChangeFuncSettingsWindow().setVisible(false);
                }
            });

            container.add(CancelButton);
            container.add(OKButton);
        }
    }

    public JTextField getParameterX() {
        return x;
    }

    public JTextField getParameterA() {
        return a;
    }

    public JTextField getParameterB() {
        return b;
    }

    public JTextField getParameterC() {
        return c;
    }
}
