package com.kviz.Gui;

import com.kviz.User.User;
import com.kviz.User.UserService;
import com.kviz.UserScore.UserScore;
import com.kviz.UserScore.UserScoreService;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Menu_panel extends JFrame implements ActionListener {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    JPanel menuBarPanel, mainPanel, centerPanel   = new JPanel();
    JButton animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton;
    JLabel headerLabel, authorLabel;
    JButton startQuizButton, aboutButton, instructionsButton, pastScores, exitButtom;
    ImageIcon icon11;
    int cat;
    JLabel player;
    String playerName;
    String userName;
    Menu_panel(String userName){
        this.userName = userName;
        headerLabel = new JLabel("Quiz  Game", JLabel.CENTER);
        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setLayout(null);
        headerLabel.setBackground(Color.BLACK);
        headerLabel.setLocation(0,0);
        headerLabel.setSize(screenSize.width-15,100);

        startQuizButton=new JButton("Start Quiz");
        startQuizButton.setFont(new Font("Times New Roman", Font.BOLD, 40));
        startQuizButton.addActionListener(this::onStartQuizClick);

        aboutButton =new JButton("About");
        aboutButton.setFont(new Font("Times New Roman", Font.BOLD, 40));

        instructionsButton =new JButton("Instructions");
        instructionsButton.setFont(new Font("Times New Roman", Font.BOLD, 40));

        pastScores =new JButton("Past Scores");
        pastScores.setFont(new Font("Times New Roman", Font.BOLD, 40));
        pastScores.addActionListener(this::getScoresDB);

        exitButtom =new JButton("Exit");
        exitButtom.setFont(new Font("Times New Roman", Font.BOLD, 40));
        exitButtom.addActionListener(this::onExitClick);

        setBackgronudColorButtons();

        menuBarPanel = new JPanel();
        menuBarPanel.setLayout(new GridLayout(1,5));
        menuBarPanel.setBackground(new Color(212, 207, 248));
        //questionPanel.setBorder(new LineBorder(new Color(130, 166, 232), 10, true));
        menuBarPanel.setLocation(0,160);
        menuBarPanel.setSize(screenSize.width-15,100);
        menuBarPanel.add(startQuizButton);
        menuBarPanel.add(aboutButton);
        menuBarPanel.add(instructionsButton);
        menuBarPanel.add(pastScores);
        menuBarPanel.add(exitButtom);

        authorLabel=new JLabel("<html><b>Alen Botic</b><br>It Akademija<br>2023/24</html>");
        authorLabel.setSize(250,100);
        authorLabel.setForeground(Color.darkGray);
        authorLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        authorLabel.setLocation(screenSize.width-150,20);


        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("images/animals.png"));
        Image image1=icon1.getImage();
        Image newImage1=image1.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        icon11=new ImageIcon(newImage1);
        animalsButton =new JButton(icon11);
        //l1.setBackground(new Color(145, 243, 235));
        animalsButton.setFont(new Font("Serif", Font.BOLD, 24));


        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("images/films.jpg"));
        Image image2=icon2.getImage();
        Image newImage2=image2.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon22=new ImageIcon(newImage2);
        moviesButton =new JButton(icon22);


        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("images/sports.jpg"));
        Image image3=icon3.getImage();
        Image newImage3=image3.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon33=new ImageIcon(newImage3);
        sportsButton =new JButton(icon33);
        sportsButton.setFont(new Font("Serif", Font.BOLD, 24));

        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("images/Science.jpg"));
        Image image4=icon4.getImage();
        Image newImage4=image4.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon44=new ImageIcon(newImage4);
        scienceButton =new JButton(icon44);
        scienceButton.setFont(new Font("Serif", Font.BOLD, 24));

        ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("images/music.png"));
        Image image5=icon5.getImage();
        Image newImage5=image5.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon55=new ImageIcon(newImage5);
        musicButton =new JButton(icon55);
        musicButton.setFont(new Font("Serif", Font.BOLD, 24));

        ImageIcon icon6=new ImageIcon(ClassLoader.getSystemResource("images/food.png"));
        Image image6=icon6.getImage();
        Image newImage6=image6.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon66=new ImageIcon(newImage6);
        foodButton =new JButton(icon66);
        foodButton.setFont(new Font("Serif", Font.BOLD, 24));
        setListeners();


        player=new JLabel("Player: "+ userName);
        player.setFont(new Font("Times New Roman", Font.BOLD, 24));
        player.setSize(280,50);
        player.setForeground(Color.darkGray);
        player.setBackground(new Color(240, 243, 248));
        player.setBorder(new LineBorder(Color.white,1,true));
        player.setLocation(40,95);


        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,3,30,30));
        centerPanel.setBackground(new Color(208, 202, 253));
        centerPanel.setLocation(280,320);
        centerPanel.setSize(1000,400);
        centerPanel.add(animalsButton);
        centerPanel.add(moviesButton);
        centerPanel.add(sportsButton);
        centerPanel.add(scienceButton);
        centerPanel.add(musicButton);
        centerPanel.add(foodButton);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(208, 202, 253));
        mainPanel.setLocation(0,0);
        mainPanel.setSize(screenSize.width,screenSize.height);

        mainPanel.add(authorLabel);
        mainPanel.add(player);
        mainPanel.add(headerLabel);
        mainPanel.add(menuBarPanel);
        mainPanel.add(centerPanel);

        add(mainPanel);
        setTitle(this.userName);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenSize.width,screenSize.height);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }
//***********************************************************************************************************

 public void setListeners(){
        JButton[] buttons={animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton, aboutButton, instructionsButton, pastScores, exitButtom};
        for(JButton button:buttons){
            button.addActionListener(this);

        }
 }
//*************************************************************************************************************

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == animalsButton) {
            cat = 1;
            System.out.println("Category= " + cat);
        } else if (e.getSource() == moviesButton) {
            cat = 2;
            System.out.println("Category= " + cat);
        } else if (e.getSource() == sportsButton) {
            cat = 3;
            System.out.println("Category= " + cat);
        } else if (e.getSource() == scienceButton) {
            cat = 4;
            System.out.println("Category= " + cat);
        } else if (e.getSource() == musicButton) {
            cat = 5;
            System.out.println("Category= " + cat);
        } else if (e.getSource() == foodButton) {
            cat = 6;
            System.out.println("Category= " + cat);
        }

        }

//***************************************************************************************************************

    public void setBackgronudColorButtons(){
        JButton[] buttons={startQuizButton, aboutButton, instructionsButton, pastScores, exitButtom};
        for(JButton button:buttons){
            button.setBackground(new Color(185, 178, 250));
        }
    }
//****************************************************************************************************************

    public void onStartQuizClick(ActionEvent actionEvent){
        if(userName==null || cat==0){
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 24));
            JOptionPane.showMessageDialog(null, "Please choose Category!", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            Play_Panel playFrame = new Play_Panel(cat, userName);
        }

    }
    //*************************************************************************************************************

    public void getScores(ActionEvent actionEvent) {
            playerName=userName;
        try {
            FileReader fr = new FileReader("src/main/resources/Quiz/PastScores.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            ArrayList<String> playerScoresList=new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                if(name.equals(playerName)) {
                    playerScoresList.add(line);
                }
            }
            List<UserScore> list=new ArrayList<>();
            UserService userService=new UserService();


            for(String string : playerScoresList){
                String[] parts = string.split(";");
                String name = parts[0];
                String date = parts[1];
                String score = parts[2];

                User user=new User();
                user.setId(null);
                user.setUsername(name);
                user.setPassword(null);

                UserScore userScore=new UserScore();
                userScore.setId(null);
                userScore.setUser(user);
                userScore.setDate(date);
                userScore.setScore(Integer.parseInt(score.substring(score.length()-3)));

                list.add(userScore);
            }
                new All_Players_Score_panel(list);


            for(String string: playerScoresList){
                System.out.println(string);
            }

        }catch(IOException e){
            System.out.println("Error reading scores: "+e.getMessage());
        }
    }
//****************************************************************************************************************

    public void getScoresDB(ActionEvent actionEvent) {
        playerName=userName;
        UserScoreService userScoreService=new UserScoreService();
        List<UserScore> scoresList=userScoreService.findAll();
        new All_Players_Score_panel(scoresList);

    }

    //****************************************************************************************************************

    public void onExitClick(ActionEvent actionEvent){
        System.exit(0);
    }
//*****************************************************************************************************************

}














