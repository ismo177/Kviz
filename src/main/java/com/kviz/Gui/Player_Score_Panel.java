package com.kviz.Gui;

import javax.swing.*;
import java.awt.*;

public class Player_Score_Panel extends JFrame {
    JLabel titleLabel,scoreLabel, playerLabel;

    public Player_Score_Panel(String playerName, int score) {

        titleLabel = new JLabel("Score");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setSize(200,40);
        titleLabel.setLocation(250,20);


        playerLabel = new JLabel("Player Name: "+ playerName);
        playerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        playerLabel.setForeground(Color.darkGray);
        playerLabel.setSize(500,40);
        playerLabel.setLocation(100,120);

        scoreLabel = new JLabel("Player's score: "+ score);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 30));
        scoreLabel.setForeground(Color.darkGray);
        scoreLabel.setSize(300,40);
        scoreLabel.setLocation(100,170);

        add(titleLabel);
        add(playerLabel);
        add(scoreLabel);
        setTitle("Score");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        getContentPane().setBackground(new Color(208, 202, 253));
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
