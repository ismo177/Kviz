package gui;

import service.QuizItem.QuizItem;
import service.QuizItem.QuizItemService;
import service.Category.Category;
import service.Category.CategoryService;
import service.User.User;
import service.User.UserService;
import service.UserScore.UserScore;
import service.UserScore.UserScoreService;

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


public class PlayFrame extends JFrame   {
    private JButton answer1Button, answer2Button, answer3Button, answer4Button, endGameButton;
    private JPanel backPanel, topPanel, questionPanel,  centerPanel, sideCenterPanel, sideBottomPanel;
    private JLabel titleLabel, questionLabel,backIconLabel, scoreLabel, failCounterLabel, scoreValueLabel, failCounterValueLabel;

    private List<QuizItem> quizItemList;
    private QuizItem quizItem;
    private Timer timer;
    private Random random;
    private User tempUser;
    private  TimerTask task;

    private int score=0;
    private final int correctAnswerPoints =10;
    private int failAnswerCounter =0;
    private int category;

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    public PlayFrame(int category, User tempUser) {
        this.category = category;
        this.tempUser = tempUser;
        createComponents();
        createFrame();
        addComponents();
        addListeners();
    }

    public void createFrame(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenSize.width, screenSize.height);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        timer=new Timer();
        random =new Random();
    }

    public void createComponents(){
        createBackPanels();
        createTopPanelComponents();
        createCenterPanelComponents();
        createSideCenterPanelComponents();
        createSideBottomPanelComponents();
    }

    public void createBackPanels(){
        backPanel = new JPanel();
        backPanel.setSize(screenSize.width, screenSize.height-60);
        backPanel.setLocation(0,0);
        backPanel.setLayout(null);


        topPanel = new JPanel();
        topPanel.setSize(screenSize.width-50, screenSize.height/2-60);
        topPanel.setLocation(10, 10);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));


        questionPanel=new JPanel();
        questionPanel.setSize(screenSize.width-200, 100);
        questionPanel.setLocation(50, screenSize.height/2-50);
        questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        questionPanel.setBorder(new LineBorder(Color.BLACK,10));

        centerPanel = new JPanel();
        centerPanel.setSize(screenSize.width*3/4, screenSize.height/4);
        centerPanel.setLocation(100, screenSize.height*2/3-40);
        centerPanel.setLayout(new GridLayout(2, 2, 40, 40 ));

        sideCenterPanel = new JPanel();
        sideCenterPanel.setSize(220, centerPanel.getHeight()/3+20);
        sideCenterPanel.setLocation(screenSize.width- 230, screenSize.height-330);
        sideCenterPanel.setLayout(new GridLayout(2, 2, 10, 10 ));


        sideBottomPanel = new JPanel();
        sideBottomPanel.setSize(200, 100);
        sideBottomPanel.setLocation(screenSize.width-240, screenSize.height*3/4+20);
        sideBottomPanel.setLayout(null);
        addBackPanelsBackground();

    }

    public void addBackPanelsBackground(){
        JPanel[] panels = {backPanel, questionPanel, centerPanel, sideCenterPanel, sideBottomPanel};
        topPanel.setBackground(new Color(208, 202, 253));
        for(JPanel panel : panels){
            panel.setBackground(new Color(208, 202, 253));
            //panel.setBorder(new LineBorder(new Color(129, 117, 228), 10, true));
        }
        questionPanel.setBorder(new LineBorder(new Color(129, 117, 228), 10, true));
        backPanel.setBorder(new LineBorder(new Color(129, 117, 228), 10, true));
    }

    public void createTopPanelComponents() {
        titleLabel=new JLabel();
        titleLabel = new JLabel("QUIZ  ", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 250));
        titleLabel.setForeground(Color.darkGray);
        titleLabel.setLocation(0, 0);
        titleLabel.setSize(screenSize.width * 3 / 4, screenSize.height/2-60);


        questionLabel = new JLabel("Question", JLabel.CENTER);
        questionLabel.setBackground(new Color(186, 177, 255));
        questionLabel.setForeground(Color.darkGray);
        questionLabel.setSize(screenSize.width - 80, 80);
        questionLabel.setFont(new Font("Serif", Font.BOLD, 45));

    }

    public void createCenterPanelComponents(){
        answer1Button = new JButton("Answer1");
        answer2Button = new JButton("Answer2");
        answer3Button = new JButton("Answer3");
        answer4Button = new JButton("Answer4");
        addFontForCenterPanelComponents();
    }

    public void addFontForCenterPanelComponents(){
        JButton[] buttons= {answer1Button, answer2Button, answer3Button, answer4Button, };

        for(JButton button:buttons){
            button.setFont(new Font("Serif", Font.BOLD, 40));
            button.setForeground(Color.darkGray);
            button.setBackground(new Color(208, 202, 253));
            //button.setBorder(new LineBorder(Color.RED, 5, true));
        }
    }

    public void createSideCenterPanelComponents(){
        scoreLabel= new JLabel("Score : " );
        scoreValueLabel =new JLabel(""+score);
        scoreValueLabel.setForeground(new Color(5, 108, 5));
        failCounterLabel= new JLabel("Fail (x2): ");
        failCounterValueLabel =new JLabel(""+score);
        failCounterValueLabel.setForeground(new Color(255, 0, 0));
        addFontForSideCenterPanelComponents();
    }

    public void addFontForSideCenterPanelComponents(){
        JLabel[] labels= {scoreLabel, failCounterLabel};
        scoreValueLabel.setFont(new Font("Serif", Font.BOLD, 25));
        failCounterValueLabel.setFont(new Font("Serif", Font.BOLD, 25));
        for(JLabel label:labels){
            label.setFont(new Font("Times New Roman", Font.BOLD, 25));
            label.setForeground(Color.BLACK);
            label.setBackground(new Color(208, 202, 253));
        }
    }

    public void createSideBottomPanelComponents(){
        endGameButton = new JButton("End Game");
        endGameButton.setSize(200, 80);
        endGameButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        endGameButton.setForeground(Color.BLACK);
        endGameButton.setBackground(new Color(163, 153, 251));
    }


    public void addComponents(){
        JPanel[] panels = {topPanel,questionPanel, centerPanel, sideCenterPanel, sideBottomPanel};
        JButton[] buttons= {answer1Button, answer2Button, answer3Button, answer4Button };
        JLabel[] labels= {scoreLabel, scoreValueLabel, failCounterLabel, failCounterValueLabel };
        topPanel.add(titleLabel);
        questionPanel.add(questionLabel);

        for(JButton button:buttons){
            centerPanel.add(button);
        }
        for(JLabel label:labels){
            sideCenterPanel.add(label);
        }
        sideBottomPanel.add(endGameButton);
        for(JPanel panel:panels){
            backPanel.add(panel);
        }
        add(backPanel);
    }

    public void addListeners(){
        JButton[] buttons= {answer1Button, answer2Button, answer3Button, answer4Button, };
        for(JButton button:buttons){
            button.addActionListener(this::handleAnswer);
        }
        endGameButton.addActionListener(this::handleEndGameButton);
        addWindowListener(windowAdapter);
    }

WindowAdapter windowAdapter= new WindowAdapter() {
    @Override
    public void windowOpened(WindowEvent e) {
        loadQuizItemListDB();
        loadQuizItem();
    }
};



/* use this method if working with files
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
public void loadQuizItemListDB() {
    CategoryService categoryService = new CategoryService();
    Category category=categoryService.find(this.category);

    QuizItemService quizItemService = new QuizItemService();
    quizItemList = quizItemService.findByCategory(category);

}

    public void loadQuizItem(){
        if(!quizItemList.isEmpty()) {
            int i = random.nextInt(quizItemList.size());
            quizItem =quizItemList.get(i);
            setQuizItemOnPlayPanel();
            quizItemList.remove(i);

        }else{
            //savePlayerScore();
            savePlayerScoreDB();
            new TempPlayerScoresFrame(tempUser, score);
            this.dispose();
        }
    }


    public void setQuizItemOnPlayPanel(){
        questionLabel.setText(quizItem.getQuestion().getQuestionText());
        answer1Button.setText(quizItem.getAnswerText1());
        answer2Button.setText(quizItem.getAnswerText2());
        answer3Button.setText(quizItem.getAnswerText3());
        answer4Button.setText(quizItem.getAnswerText4());
        repaintButtons();
    }

    public void repaintButtons(){
        JButton[] buttons = {answer1Button, answer2Button, answer3Button, answer4Button};

        for(JButton button:buttons){
            button.setBackground(new Color(185, 178, 250));
        }
    }


    // use this method if working with files
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


    public void handleAnswer(ActionEvent e) {
        JButton answerButton = (JButton) e.getSource();
        String correctAnswer = quizItem.getIsCorrect();
        if (answerButton.getText().equals(correctAnswer)) {
                answerButton.setBackground(Color.GREEN);
                repaintPanelAndReloadQuizItem(answerButton);
                score += correctAnswerPoints;
                scoreValueLabel.setText("" + score);
        }
        else {
                answerButton.setBackground(Color.RED);
                repaintPanelAndReloadQuizItem(answerButton);
                failAnswerCounter++;
                failCounterValueLabel.setText("" + failAnswerCounter);
                if (failAnswerCounter == 2) {
                    savePlayerScoreDB();
                    new TempPlayerScoresFrame(tempUser, score);
                    this.dispose();
                }
        }
    }

public void repaintPanelAndReloadQuizItem(JButton button){
    try {
            task = new TimerTask() {
                public void run() {
                    loadQuizItem();
                }
            };
        }
    catch (IllegalStateException ex) {
        System.out.println("Error in 'handleAnswer' :" + ex.getMessage());
        }
        timer.schedule(task, 1000);
}

//use this method if working with files
    public void savePlayerScore(){
        try{
        FileWriter fileWriter = new FileWriter("src/main/resources/Quiz/PastScores.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            LocalDateTime timeDate=LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss ");
            String timeDateFormatted = timeDate.format(myFormatObj);

            String line= tempUser.getUsername()+"; "+ timeDateFormatted +"; "+"Score: "+ score;
            System.out.println(line);
            bufferedWriter.newLine();
            bufferedWriter.write(line, 0, line.length());
            bufferedWriter.close();

    }catch(IOException e){
            System.out.println("Error writting scores :"+e.getMessage());
        }
    }


    public void savePlayerScoreDB(){
        LocalDateTime timeDate=LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss ");
        String timeDateFormatted = timeDate.format(myFormatObj);

        UserService userService = new UserService();
        User user=userService.findByUsername(tempUser.getUsername());

        UserScoreService userScoreService = new UserScoreService();
        UserScore userScore = new UserScore();

        userScore.setUser(user);
        userScore.setDate(timeDateFormatted);
        userScore.setScore(score);
        userScoreService.create(userScore);
    }


    public void handleEndGameButton(ActionEvent e) {
        this.dispose();
}


}
