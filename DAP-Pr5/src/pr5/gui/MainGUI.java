package pr5.gui;

import pr5.state_pattern.context.TrafficLight;
import pr5.state_pattern.state.TrafficLightState;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class MainGUI extends JFrame {
    private TrafficLight trafficLight;
    private JLabel imageLabel;

    public MainGUI() {
        setTitle("DAP - Práctica 5: El patrón Estado");
        setSize(214, 575);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        trafficLight = new TrafficLight();
        imageLabel = new JLabel();

        add(imageLabel);

        Thread stateChangeThread = new Thread(new StateChangeTask());
        stateChangeThread.start();
    }

    private class StateChangeTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                trafficLight.changeState();
                updateGUI();

                try {
                    TimeUnit.SECONDS.sleep(trafficLight.getCurrentState().getDuration());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void updateGUI() {
        TrafficLightState currentState = trafficLight.getCurrentState();
        ImageIcon image = new ImageIcon(currentState.getImagePath());
        imageLabel.setIcon(image);
        currentState.playSound();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI semaforoGUI = new MainGUI();
            semaforoGUI.setVisible(true);
        });
    }
}

