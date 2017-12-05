import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class score_main extends JFrame {

    private int scoreA = 0;
    private int scoreB = 0;

    private score_main() {
        super("Test frame");
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));

        JButton button1 = new JButton("0");
        button1.setFont(new Font("Arial", Font.PLAIN, 200));
        button1.setFocusPainted(false);
        panel.add(button1);

        JButton button2 = new JButton("0");
        button2.setFont(new Font("Arial", Font.PLAIN, 200));
        button2.setFocusPainted(false);
        panel.add(button2);
        button1.addActionListener(e -> {
            scoreA++;
            button1.setText(String.valueOf(scoreA));
        });

        KeyAdapter refresher = new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == 'r'){
                    scoreA = 0;
                    button1.setText(String.valueOf(scoreA));
                    scoreB = 0;
                    button2.setText(String.valueOf(scoreB));
                }

            }

        };

        button1.addKeyListener(refresher);
        button2.addKeyListener(refresher);






        button2.addActionListener(e -> {
            scoreB++;
            button2.setText(String.valueOf(scoreB));
        });

        getContentPane().add(panel);

    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            score_main frame = new score_main();
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}