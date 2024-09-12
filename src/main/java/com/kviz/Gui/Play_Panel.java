package com.kviz.Gui;

import com.kviz.Answer.Answer;
import com.kviz.Answer.AnswerService;
import com.kviz.Category.Category;
import com.kviz.Category.CategoryService;
import com.kviz.User.User;
import com.kviz.User.UserService;
import com.kviz.UserScore.UserScore;
import com.kviz.UserScore.UserScoreService;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.Timer;


public class Play_Panel extends JFrame  implements WindowListener {
    JButton answer1Button, answer2Button, answer3Button, answer4Button, endGameButton;
    JPanel mainPanel;
    JLabel titleLabel, questionLabel, scoreLabel, failCounterLabel, scoreLab,failLab;
    int score=0;
    int scorePerMatch=10;
    int failCounter =0;
    int cat;
   // List<Quiz_Item> list;
    List<Answer> list;
    //Quiz_Item quizItem;
    Answer answer;
    Timer timer;
    Random random;
    String player_Name;
    TimerTask task;


    public Play_Panel(int category, String playerName) {

        this.cat = category;
        this.player_Name = playerName;
        System.out.println("Category: " + this.cat);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        setTitle("PlayFrame: " + " Category= " + category);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenSize.width, screenSize.height);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        titleLabel = new JLabel("Quiz  Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setLayout(null);
        titleLabel.setLocation(0, 0);
        titleLabel.setSize(screenSize.width - 15, 100);


        questionLabel = new JLabel("----------Question------------", JLabel.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.black);
                g2d.drawRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 30,30);

            }
        };
        questionLabel.setSize(screenSize.width - 180, 150);
        questionLabel.setLocation(20, 100);
        questionLabel.setForeground(Color.BLACK);
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        questionLabel.setBorder(new LineBorder(new Color(208, 202, 253)));
        //questionLabel.setBackground(new Color(155, 147, 202));


        answer1Button = new JButton("------Answer1------");
        answer1Button.setSize(screenSize.width / 3 + 80, 120);
        answer1Button.setLocation(40, 350);
        answer1Button.setForeground(Color.DARK_GRAY);
        answer1Button.setFont(new Font("Times New Roman", Font.BOLD, 40));
        //answer1Button.setBorder(new LineBorder(new Color(141, 180, 225), 10, true));
        answer1Button.setBackground(new Color(185, 178, 250));
        //answer1Button.addActionListener(this::handleAnswer1Button);
        answer1Button.addActionListener(this::handleAnswer);


        answer2Button = new JButton("----Answer2----");
        answer2Button.setSize(screenSize.width / 3 + 80, 120);
        answer2Button.setLocation(screenSize.width / 3 + 200, 350);
        answer2Button.setForeground(Color.DARK_GRAY);
        answer2Button.setFont(new Font("Times New Roman", Font.BOLD, 40));
       //answer2Button.setBorder(new LineBorder(Color.black, 1, true));
        answer2Button.setBackground(new Color(185, 178, 250));
       // answer2Button.addActionListener(this::handleAnswer2Button);
        answer2Button.addActionListener(this::handleAnswer);


        answer3Button = new JButton("----Answer3----");
        answer3Button.setSize(screenSize.width / 3 + 80, 120);
        answer3Button.setLocation(40, 550);
        answer3Button.setForeground(Color.DARK_GRAY);
        answer3Button.setFont(new Font("Times New Roman", Font.BOLD, 40));
       // answer3Button.setBorder(new LineBorder(Color.black, 1, true));
        answer3Button.setBackground(new Color(185, 178, 250));
        //answer3Button.addActionListener(this::handleAnswer3Button);
        answer3Button.addActionListener(this::handleAnswer);


        answer4Button = new JButton("----Answer4----");
        answer4Button.setSize(screenSize.width / 3 + 80, 120);
        answer4Button.setLocation(screenSize.width / 3 + 200, 550);
        answer4Button.setForeground(Color.darkGray);
       // answer4Button.setBorder(new LineBorder(Color.black, 1, true));
        answer4Button.setFont(new Font("Times New Roman", Font.BOLD, 40));
        answer4Button.setBackground(new Color(185, 178, 250));
        //answer4Button.addActionListener(this::handleAnswer4Button);
        answer4Button.addActionListener(this::handleAnswer);



        endGameButton = new JButton("End Game");
        endGameButton.setSize(170, 75);
        endGameButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        endGameButton.setLocation(screenSize.width - 200, 592);
        endGameButton.setForeground(Color.BLACK);
        endGameButton.setBackground(new Color(171, 165, 241));
        //endGameButton.setBorder(new LineBorder(Color.black, 1, true));
        endGameButton.addActionListener(this::handleEndGameButton);


        scoreLabel= new JLabel("Score : " );
        scoreLabel.setSize(100,80);
        scoreLabel.setForeground(Color.darkGray);
        scoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        scoreLabel.setBackground(new Color(185, 178, 250));
        scoreLabel.setLocation(screenSize.width-210, 340);


        scoreLab=new JLabel(""+score);
        scoreLab.setSize(100,100);
        scoreLab.setForeground(new Color(5, 108, 5));
        scoreLab.setBackground(new Color(171, 165, 241));
        scoreLab.setFont(new Font("Times New Roman", Font.BOLD, 30));
        scoreLab.setLocation(screenSize.width-100, 330);


        failCounterLabel= new JLabel("Fail (x2): ");
        failCounterLabel.setSize(100,80);
        failCounterLabel.setForeground(Color.darkGray);
        failCounterLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
        failCounterLabel.setBackground(new Color(185, 178, 250));
        failCounterLabel.setLocation(screenSize.width-210, 410);

        failLab=new JLabel(""+score);
        failLab.setSize(100,100);
        failLab.setForeground(new Color(255, 0, 0));
        failLab.setBackground(new Color(171, 165, 241));
        failLab.setFont(new Font("Times New Roman", Font.BOLD, 30));
        failLab.setLocation(screenSize.width-100, 400);



        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(208, 202, 253));
        mainPanel.setLocation(0, 0);
        mainPanel.setSize(screenSize.width, screenSize.height);


        mainPanel.add(titleLabel);
        mainPanel.add(questionLabel);
        mainPanel.add(answer1Button);
        mainPanel.add(answer2Button);
        mainPanel.add(answer3Button);
        mainPanel.add(answer4Button);
        mainPanel.add(scoreLabel);
        mainPanel.add(scoreLab);
        mainPanel.add(failCounterLabel);
        mainPanel.add(failLab);
        mainPanel.add(endGameButton);
        add(mainPanel);
        addWindowListener(this);
        timer=new Timer();
        random =new Random();

    }




    @Override
    public void windowOpened(WindowEvent e) {
            //loadList();
            loadListDB();
        //setItemOnPanel();
        setItemOnPanelDB();

    }


    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

//*************************************************************************************************************
/*
    public void setItemOnPanel(){

    if(!list.isEmpty()) {
        int i = random.nextInt(list.size());
       // quizItem = list.get(i);
        questionLabel.setText(quizItem.getQuestion());
        answer1Button.setText(quizItem.getAnswer1());
        answer2Button.setText(quizItem.getAnswer2());
        answer3Button.setText(quizItem.getAnswer3());
        answer4Button.setText(quizItem.getAnswer4());

        list.remove(i);

    }else{
        //savePlayerScore();
        savePlayerScoreDB();
        new Player_Score_Panel(player_Name, score);
        this.dispose();
    }
}

 */
//**************************************************************************************************************

    public void setItemOnPanelDB(){
        if(!list.isEmpty()) {
            int i = random.nextInt(list.size());
            answer = list.get(i);
            questionLabel.setText(answer.getQuestion().getQuestionText());
            answer1Button.setText(answer.getAnswerText1());
            answer2Button.setText(answer.getAnswerText2());
            answer3Button.setText(answer.getAnswerText3());
            answer4Button.setText(answer.getAnswerText4());

            list.remove(i);

        }else{
            //savePlayerScore();
            savePlayerScoreDB();
            new Player_Score_Panel(player_Name, score);
            this.dispose();
        }
    }
//***************************************************************************************************************
public void loadList() throws IOException {
    FileReader fileReader = new FileReader("src/main/resources/Quiz/Quiz_Items.txt");
   try {
       BufferedReader br = new BufferedReader(fileReader);
       String line;

       //list = new ArrayList<>();
       while ((line = br.readLine()) != null) {
           String[] parts = line.split(",");
           String question = parts[0];
           String answer1 = parts[1];
           String answer2 = parts[2];
           String answer3 = parts[3];
           String answer4 = parts[4];
           String isCorrect = parts[5];
           Quiz_Item quizItem=new Quiz_Item(question, answer1, answer2, answer3, answer4, isCorrect);
           //list.add(quizItem);
       }
   }catch(IOException e){
       System.out.println("Error :"+e.getMessage());
       }
}
//*******************************************************************************************************
public void loadListDB() {
    CategoryService categoryService = new CategoryService();
    Category category=categoryService.find(cat);

    AnswerService answerService = new AnswerService();
    list= answerService.findByCategory(category);

}

//******************************************************************************************************

 //**************************************************************************************************
    public void handleAnswer(ActionEvent e) {
        JButton answerButton = (JButton) e.getSource();
        String correctAnswer = answer.getIsCorrect();
        if (answerButton.getText().equals(correctAnswer)) {

                answerButton.setBackground(new Color(182, 237, 182));
                repaintOfferedAnswerLabels(answerButton);
                score += scorePerMatch;
                scoreLab.setText("" + score);
        }
        else {
                answerButton.setBackground(new Color(241, 109, 109));
                repaintOfferedAnswerLabels(answerButton);
                failCounter++;
                failLab.setText("" + failCounter);
                if (failCounter == 2) {
                    //savePlayerScore();
                    savePlayerScoreDB();
                    new Player_Score_Panel(player_Name, score);
                    this.dispose();
                }

        }
    }

public void repaintOfferedAnswerLabels(JButton button){
    try {
            task = new TimerTask() {
                public void run() {
                    button.setBackground(new Color(185, 178, 250));
                    setItemOnPanelDB();
                }
            };
        }
    catch (IllegalStateException ex) {
        System.out.println("Error in 'handleAnswer' :" + ex.getMessage());
        }
        timer.schedule(task, 1000);

}


//****************************************************************************************************
    public void savePlayerScore(){
        try{
        FileWriter fileWriter = new FileWriter("src/main/resources/Quiz/PastScores.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            LocalDateTime timeDate=LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss ");
            String timeDateFormatted = timeDate.format(myFormatObj);

            String line=player_Name+"; "+ timeDateFormatted +"; "+"Score: "+ score;
            System.out.println(line);
            bufferedWriter.newLine();
            bufferedWriter.write(line, 0, line.length());
            bufferedWriter.close();

    }catch(IOException e){
            System.out.println("Error writting scores :"+e.getMessage());
        }
    }
 //*******************************************************************************************************

    public void savePlayerScoreDB(){
        LocalDateTime timeDate=LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss ");
        String timeDateFormatted = timeDate.format(myFormatObj);

        UserService userService = new UserService();
        User user=userService.findByUsername(player_Name);

        UserScoreService userScoreService = new UserScoreService();
        UserScore userScore = new UserScore();

        userScore.setUser(user);
        userScore.setDate(timeDateFormatted);
        userScore.setScore(score);
        userScoreService.create(userScore);
    }
    //*************************************************************************************************

    public void handleEndGameButton(ActionEvent e) {
        this.dispose();
}

}
