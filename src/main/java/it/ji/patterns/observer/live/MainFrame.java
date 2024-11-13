package it.ji.patterns.observer.live;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        // Imposta il titolo della finestra
        setTitle("Pannello con 3 Bottoni");

        // Chiudi l'applicazione quando la finestra viene chiusa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Imposta il layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        // Crea i tre bottoni
        JButton button1 = new JButton("Bottone 1");
        JButton button2 = new JButton("Bottone 2");
        JButton button3 = new JButton("Bottone 3");

        // Aggiungi ActionListener a ciascun bottone
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hai cliccato Bottone 1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hai cliccato Bottone 2");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hai cliccato Bottone 3");
            }
        });

        // Aggiungi i bottoni al layout
        add(button1, gbc);
        add(button2, gbc);
        add(button3, gbc);

        // Imposta la dimensione del JFrame
        setSize(400, 200);

        // Centra la finestra sullo schermo
        setLocationRelativeTo(null);

        // Rendi la finestra visibile
        setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // Imposta il Look and Feel del sistema
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName());
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }

        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Avvia l'interfaccia grafica usando il thread di Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}