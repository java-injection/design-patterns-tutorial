package it.ji.patterns.observer.live;

import javax.swing.*;
import java.awt.*;

public class TerminalFrame extends JFrame implements GuiListener {
    private JTextArea textArea;

    public TerminalFrame() {
        // Set the title of the frame
        setTitle("Log Terminal");

        // Close the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel and set its background color to black
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());

        // Create a text area with light green text and black background
        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        textArea.setEditable(false);

        // Add the text area to the panel
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Add the panel to the frame
        add(panel);

        // Set the size of the frame
        setSize(600, 400);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);

        GuiEventManager.getInstance().addGuiListener(this);
    }

    // Method to append messages to the text area
    public void append(String message) {
        textArea.append(message + "\n");
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
                    TerminalFrame terminalFrame = new TerminalFrame();
                    terminalFrame.append("Hello, World!");
                    /*terminalFrame.append("This is a test message.");
                    terminalFrame.append("This is another test message.");*/

                }

        );
    }

    @Override
    public void clickedButton(int buttonNumber) {
        this.append("Ho cliccato il bottone " + buttonNumber);
    }

    @Override
    public void sendCommand(String command) {
        if ("Count Down a 0!".equals(command)) {
            this.append("SHUTDOWN!!");
            this.append("SHUTDOWN!!");
            this.append("SHUTDOWN!!");
        }
        else {
            this.append("Ho eseguito il comando " + command);
        }
    }
}
