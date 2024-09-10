package com.kviz.Gui;

import com.kviz.UserScore.UserScore;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class All_Players_Score_panel extends JFrame {
    JLabel title ;
    JPanel scorePanel, mainPanel = new JPanel();
    JScrollPane scrollPane ;
    List<UserScore> userScoreList;

    public All_Players_Score_panel(List<UserScore> list) {
        this.userScoreList = list;
        title = new JLabel("Scores",JLabel.CENTER);
        title.setSize(600,40);
        title.setForeground(Color.darkGray);
        title.setFont(new Font("Arial",Font.BOLD,40));
        title.setLayout(null);
        setLocation(0,10);


        scorePanel = new JPanel();
        scorePanel.setSize(600,750);
        scorePanel.setLayout(new GridLayout(userScoreList.size(),1));
        scorePanel.setBackground(new Color(208, 202, 253));
        scorePanel.setBorder(new LineBorder(Color.darkGray));
        scorePanel.setLocation(0,50);

        createScoreLineLabels();

        mainPanel=new JPanel();
        mainPanel.setSize(600,750);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(208, 202, 253));
        mainPanel.setBorder(new LineBorder(Color.darkGray));
        mainPanel.setLocation(0,0);

        scrollPane = new JScrollPane(scorePanel);
        scrollPane.setSize(580,700);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setLocation(0,50);


        mainPanel.add(title);
        mainPanel.add(scrollPane);
        add(mainPanel);
        setTitle("Scores");
        getContentPane().setBackground(new Color(208, 202, 253));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public void createScoreLineLabels(){
        for(int i=0; i<userScoreList.size(); i++) {
            String score = userScoreList.get(i).getUser().getUsername()+" "+userScoreList.get(i).getDate()+" "+"score: "+userScoreList.get(i).getScore();

            JLabel label = new JLabel(i+1+". "+score);
            label.setSize(600, 30);
            label.setForeground(Color.darkGray);
            label.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            label.setLocation(0,i*30);
            scorePanel.add(label);
        }

    }

   /* public static void main(String[] args) {
        new All_Players_Score_panel();
    }

    */
}
