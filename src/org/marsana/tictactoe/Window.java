/*@author Carmelo Marsana*/
package org.marsana.tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

public class Window{
    private JFrame frame;
    private JPanel gridPanel = new JPanel();
    private JPanel statusPanel = new JPanel();
    
    public JButton[][] gridButton = new JButton[3][3];
    public JLabel status = new JLabel();
    
    public void createWindow() throws MalformedURLException{
        frame = new JFrame("TicTacToe");
        
        ImageIcon icon = new ImageIcon(new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXoa5J_HZjBlLpZPfWJ0JJdGpDhlPP3bPxbrFW9TclQbHqlQbSjA&s"));
        
        addGridButton();
        addStatusLabel();
        resetButton();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(525, 525);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());
    }
    
    private void addGridButton(){
        GridLayout grids = new GridLayout(3, 3);
        gridPanel.setLayout(grids);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gridButton[i][j] = new JButton("-");
                gridButton[i][j].setFont(new Font("Courier New", Font.BOLD, 100));
                gridButton[i][j].setBackground(new Color(205,187,186));
                gridPanel.add(gridButton[i][j]);
            }
        }
        frame.getContentPane().add(BorderLayout.NORTH, gridPanel);
    }
    private void addStatusLabel(){
        status.setText("Player 'X' turn");
        status.setFont(new Font("Courier New", Font.BOLD, 55));
        statusPanel.add(BorderLayout.SOUTH, status);
        statusPanel.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(BorderLayout.CENTER, statusPanel);
    }
    private void resetButton(){
        JButton reset = new JButton("Reset Grid");
        reset.setBackground(new Color(100,200,200));
        statusPanel.add(BorderLayout.SOUTH, reset);
        reset.addActionListener((ActionEvent e) -> {
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++){
                    gridButton[i][j].setText("-");
                    gridButton[i][j].setEnabled(true);
                }
            status.setText("Player 'X' turn");
        });
    }
    
}
