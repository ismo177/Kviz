package gui;

import service.UserScore.UserScore;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class ScoresFrame extends JFrame {
    private JLabel title ;
    private JPanel scorePanel, backPanel;
    private JScrollPane scrollPane ;
    private  List<UserScore> userScoreList;

    public ScoresFrame(List<UserScore> list) {
        this.userScoreList = list;

        createComponents();
        createScoreLineLabels();
        createFrame();
        addComponents();
    }

    public void createFrame(){
        setTitle("Scores");
        getContentPane().setBackground(new Color(208, 202, 253));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void createBackPanels(){
        backPanel =new JPanel();
        backPanel.setSize(600,750);
        backPanel.setLayout(null);
        backPanel.setBackground(new Color(208, 202, 253));
        backPanel.setBorder(new LineBorder(Color.darkGray));
        backPanel.setLocation(0,0);

        scorePanel = new JPanel();
        scorePanel.setSize(600,750);
        scorePanel.setLayout(new GridLayout(userScoreList.size(),1));
        scorePanel.setBackground(new Color(208, 202, 253));
        scorePanel.setBorder(new LineBorder(Color.darkGray));
        scorePanel.setLocation(0,50);
    }

    public void createComponents(){
        createBackPanels();
        title = new JLabel("Scores",JLabel.CENTER);
        title.setSize(600,40);
        title.setForeground(Color.darkGray);
        title.setFont(new Font("Arial",Font.BOLD,40));
        title.setLayout(null);

        scrollPane = new JScrollPane(scorePanel);
        scrollPane.setSize(580,700);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setLocation(0,50);

    }

    public void addComponents(){
        backPanel.add(title);
        backPanel.add(scrollPane);
        add(backPanel);
    }



    public void createScoreLineLabels(){
        for(int i=0; i<userScoreList.size(); i++) {
            String score = userScoreList.get(i).getUser().getUsername()+" "+userScoreList.get(i).getDate()+" "+"score: "+
                            userScoreList.get(i).getScore();

            JLabel label = new JLabel(i+1+". "+score);
            label.setSize(600, 30);
            label.setForeground(Color.darkGray);
            label.setFont(new Font("Times New Roman", Font.PLAIN, 24));
            label.setLocation(0,i*30);
            scorePanel.add(label);
        }

    }
}
