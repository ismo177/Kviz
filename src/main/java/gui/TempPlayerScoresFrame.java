package gui;

import service.User.User;

import javax.swing.*;
import java.awt.*;

public class TempPlayerScoresFrame extends JFrame {
    private JLabel titleLabel,scoreLabel, playerLabel;

    private User tempUser;
    private int score;
    public TempPlayerScoresFrame(User tempUser, int score) {
        this.tempUser = tempUser;
        this.score = score;

      createComponents();
      createFrame();
      addComponents();
    }
     public void createFrame(){
         setTitle("Score");
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setSize(600, 400);
         getContentPane().setBackground(new Color(208, 202, 253));
         setLayout(null);
         setLocationRelativeTo(null);
         setVisible(true);
     }

     public void createComponents(){
         titleLabel = new JLabel("Score");
         titleLabel.setSize(200,40);
         titleLabel.setLocation(250,20);

         playerLabel = new JLabel("Player Name: "+ tempUser.getUsername());
         playerLabel.setSize(500,40);
         playerLabel.setLocation(100,120);

         scoreLabel = new JLabel("Player's score: "+ score);
         scoreLabel.setSize(300,40);
         scoreLabel.setLocation(100,170);
         addFont();
     }

     public void addFont(){
         JLabel[] labels= {scoreLabel, playerLabel };
         titleLabel.setFont(new Font("Arial",Font.BOLD,40));
         for(JLabel label:labels){
             label.setFont(new Font("Serif", Font.BOLD, 30));
             label.setForeground(Color.darkGray);
         }
     }

    public void addComponents(){
        add(titleLabel);
        add(playerLabel);
        add(scoreLabel);
        createFrame();
    }

}
