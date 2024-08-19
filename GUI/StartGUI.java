package game.GUI;
import game.data.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StartGUI extends JFrame implements ActionListener {
    // список кнопок, глобальные переменные по типу памяти, текущий игрок, попытки
    private final ArrayList<JButton> btns;
    private final GlobalData globalData;
    private byte currentPlayer;
    private byte counter;

    // переделать интерфейс
    public StartGUI() {
        globalData = new GlobalData();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        btns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            button.addActionListener(this);
            btns.add(button);
            panel.add(button);
        }

        setContentPane(panel);

        setTitle("Крестики-нолики");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        currentPlayer = 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // не трогать ломается(((
        JButton clickedButton = (JButton) e.getSource();
        int index = btns.indexOf(clickedButton);
        int line = index / 3;
        int column = index % 3;

        globalData.MemorySetGUI(line, column, currentPlayer);
        clickedButton.setText(currentPlayer == 1 ? "X" : "O");

        char Player = (currentPlayer == 1) ? 'X' : 'O';
        // проверка на победу
        if (GameWinner.checkWinner(globalData.GetMemory(), Player)) {

            String winner = currentPlayer == 1 ? "Крестик" : "Нолик";
            JOptionPane.showMessageDialog(this, winner + " победил!");
            int response = JOptionPane.showConfirmDialog(this, "Хотите сыграть еще раз?", "Перезапуск игры", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                resetGame();
            } else {
                System.exit(0);
            }
        } else {
            if (!GameWinner.checkDraw(globalData.GetMemory())) {
                currentPlayer = (byte) ((currentPlayer == 1) ? 2 : 1);
            } else {
                JOptionPane.showMessageDialog(this, "Ничья!");
                int response = JOptionPane.showConfirmDialog(this, "Хотите сыграть еще раз?", "Перезапуск игры", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    resetGame();
                } else {
                    System.exit(0);
                }
            }

        }
    }


    private void resetGame() {
        for (JButton button : btns) {
            button.setText("");
        }
        globalData.ResetMemory();
        currentPlayer = 1;
    }

}