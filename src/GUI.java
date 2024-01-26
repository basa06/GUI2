
import javax.swing.*;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;

import java.util.Timer;
import java.util.TimerTask;
public class GUI extends JFrame {
    // constructor will create all GUI components and set their properties


    public GUI() {

        super("A simple GUI demo");

        final Object stateLock = new Object();
        // frame properties
        setSize(400, 300);
        setLayout(new FlowLayout());
        setVisible(true);
        JMenuBar menuBar;

        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener((ActionEvent e) -> confirm_exit());

        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);


        setVisible(true);


        int state = 0;
        Timer timer = new Timer();
        TimerTask task = new stateincrament();

        timer.schedule(task, 0, 100);

        String value_state = state + "";
        JLabel stateLabel = new JLabel(value_state);
        add(stateLabel);


        public void confirm_exit () {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        }



        class stateincrament extends TimerTask {
            public int state = 0;

            public void run() {
                state++;
            }
        }
    }

