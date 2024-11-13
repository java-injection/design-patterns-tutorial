package it.ji.patterns.observer.live;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScreenFrame extends JFrame {
    private JLabel messageLabel;
    private JPanel panel;
    private ScheduledExecutorService scheduler;

    public ScreenFrame() {
        // Set the title of the frame
        setTitle("Warning Screen");

        // Close the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel and set its background color to blue
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setLayout(new GridBagLayout());

        // Create a label with white text and set the initial message to "no signal"
        messageLabel = new JLabel("no signal");
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Add the label to the panel
        panel.add(messageLabel);

        // Add the panel to the frame
        add(panel);

        // Set the size of the frame
        setSize(600, 400);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }

    // Method to change the background to yellow and the text to red with "WARNING"
    public void warning() {
        panel.setBackground(Color.YELLOW);
        messageLabel.setForeground(Color.RED);
        messageLabel.setText("WARNING");
    }

    public void startCountdown() {
        scheduler = Executors.newScheduledThreadPool(1);
        final int[] countdown = {5};

        Runnable task = new Runnable() {
            @Override
            public void run() {
                if (countdown[0] > 0) {
                    messageLabel.setText("Self destruction in " + countdown[0] + "s");
                    countdown[0]--;
                } else {
                    scheduler.shutdown();
                    panel.setBackground(Color.BLACK);
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Segmentation fault");
                }
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            ScreenFrame warningFrame = new ScreenFrame();
            // Simulate a warning after 3 seconds
            Timer warningTimer = new Timer(3000, e -> {
                warningFrame.warning();
                ((Timer) e.getSource()).stop();
            });
            warningTimer.setRepeats(false);
            warningTimer.start();

            // Start the countdown after 5 seconds
            Timer countdownTimer = new Timer(5000, e -> {
                warningFrame.startCountdown();
                ((Timer) e.getSource()).stop();
            });
            countdownTimer.setRepeats(false);
            countdownTimer.start();
        });
    }
}