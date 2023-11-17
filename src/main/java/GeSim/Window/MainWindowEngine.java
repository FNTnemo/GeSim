package GeSim.Window;

import GeSim.Math.Function;
import GeSim.Utils.WindowUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowEngine extends JFrame {
    public final static int width = 250;
    public final static int height = 100;

    private static boolean commandMode = false;
    private static String command;
    public static Function function = Function.None;

    private static JTextField textField = new JTextField("");
    private static JLabel label = new JLabel("Enter command");

    private JButton comButton = new JButton("Command mode.");
    private JButton buttButton = new JButton("Button mode.");

    private Container container;

    public MainWindowEngine() {
        setTitle("Geometry Simulation");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height + 25);
        setResizable(false);

        this.container = this.getContentPane();
        container.setLayout(new GridLayout(1, 2, 5, 0));

        comButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandMode = true;

                removeButton(comButton, buttButton, container);

                container.setLayout(new GridLayout(2, 0, 0, 0));

                MainWindowEngine.getTextField().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                container.add(MainWindowEngine.getLabel());
                container.add(MainWindowEngine.getTextField());

                WindowUtils.getMainWindow().setSize(width, height + 25);
                WindowUtils.getMainWindow().revalidate();

                System.out.println("Command mode");
            }
        });

        buttButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commandMode = false;

                removeButton(comButton, buttButton, container);

                container.setLayout(new GridLayout(10, 0, 5, 5));

                JButton parabola = new JButton("Parabola");
                parabola.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        WindowUtils.simulationWindow = new SimulationWindowEngine("Simulation", 800, 600, 100, 100, false);
                        function.setFunction(Function.Parabola);
                        function.parabola(10, 1, 0, 0);
                        WindowUtils.closeWindow(WindowUtils.getMainWindow());

                    }
                });

                JButton hyperbola = new JButton("Hyperbola");
                hyperbola.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        WindowUtils.simulationWindow = new SimulationWindowEngine("Simulation", 800, 600, 100, 100, false);
                        function.setFunction(Function.Hyperbola);
                        function.hyperbola(10, 1, 1);
                        WindowUtils.closeWindow(WindowUtils.getMainWindow());

                    }
                });

                container.add(parabola);
                container.add(hyperbola);

                WindowUtils.getMainWindow().setSize(400, 400);
                WindowUtils.getMainWindow().revalidate();

            }
        });

        container.add(comButton);
        container.add(buttButton);
    }

    public static void removeButton(JButton button, JButton button2, Container container) {
        container.remove(button);
        container.remove(button2);
    }


    public static JTextField getTextField() {
        return textField;
    }

    public static JLabel getLabel() {
        return label;
    }

    public Container getContainer() {
        return container;
    }

    public static boolean isCommandMode() {
        return commandMode;
    }

    public static String getCommand() {return textField.getText();}

}
