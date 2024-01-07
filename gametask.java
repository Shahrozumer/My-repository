package com.mycompany.gametaskgui;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameTaskGUI extends JFrame {
    private static int count = 0;
    private static int sum = 0;
    private static int num;
    private static Thread th;
    private final JTextField inputField;

    public GameTaskGUI() {
        th = new Thread(new GameTask());

        JLabel label = new JLabel("Guess the number:");
        inputField = new JTextField(10);

        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener((ActionEvent e) -> {
            makeGuess();
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(guessButton);

        add(panel);

        th.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Guessing Game");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void makeGuess() {
        try {
            int guess = Integer.parseInt(inputField.getText());
            sum += guess;
            count++;
            inputField.setText("");

            if (count == 5) {
                th.interrupt();
                JOptionPane.showMessageDialog(this, "Your points: " + sum + "\n" + (sum > 300 ? "You win!!!" : "You lose!!!"));
                System.exit(0);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        new GameTaskGUI();
    }

    static class GameTask extends Thread {
        @Override
        public void run() {
            for (; ; ) {
                num = (int) (Math.random() * 100);
                System.out.println(num);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }

                if (count == 5)
                    break;
            }
        }
    }
}
