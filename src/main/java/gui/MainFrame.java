package gui;

import service.User.User;
import service.UserScore.UserScore;
import service.UserScore.UserScoreService;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame  {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    JPanel  menuBarPanel, backPanel, categoriesPanel;
    JButton animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton;
    JLabel topPanel, authorLabel;
    JButton startQuizButton, newItems, instructionsButton, pastScoresButton, exitButtom;
    int tempCategory;
    JLabel playerLabel;
    User tempUser;
    MainFrame(User tempUser){
        this.tempUser = tempUser;
        createComponents();
        createFrame();
        addComponents();
        addListeners();

    }

    public void createFrame(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        setTitle(tempUser.getUsername());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(screenSize.width,screenSize.height);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void createBackPanels(){
        topPanel = new JLabel("Quiz  Game", JLabel.CENTER);
        topPanel.setLayout(null);
        topPanel.setLocation(0, 0);
        topPanel.setSize(screenSize.width - 15, 100);

        menuBarPanel = new JPanel();
        menuBarPanel.setLayout(new GridLayout(1,5,5,0));
        menuBarPanel.setBackground(new Color(208, 202, 253));
        menuBarPanel.setLocation(0,160);
        menuBarPanel.setSize(screenSize.width-15,100);

        categoriesPanel = new JPanel();
        categoriesPanel.setLayout(new GridLayout(2,3,30,30));
        categoriesPanel.setBackground(new Color(208, 202, 253));
        categoriesPanel.setLocation(280,320);
        categoriesPanel.setSize(1000,400);

        backPanel = new JPanel();
        backPanel.setLayout(null);
        backPanel.setBackground(new Color(208, 202, 253));
        backPanel.setLocation(0,0);
        backPanel.setSize(screenSize.width,screenSize.height);
    }

    public void createComponents() {
        startQuizButton = new JButton("Start Quiz");
        newItems = new JButton("Add New Items");
        instructionsButton = new JButton("Instructions");
        pastScoresButton = new JButton("Past Scores");
        exitButtom = new JButton("Exit");

        authorLabel = new JLabel("<html><b>Ismet Omerović</b><br>It Akademija<br>2023/24</html>");
        authorLabel.setSize(250, 100);
        authorLabel.setLocation(screenSize.width - 150, 20);

        playerLabel = new JLabel("Player: " + tempUser.getUsername());
        playerLabel.setSize(280, 50);
        playerLabel.setLocation(40, 95);


        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("images/animals.png"));
        Image image1=icon1.getImage();
        Image newImage1=image1.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon11=new ImageIcon(newImage1);
        animalsButton =new JButton(icon11);

        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("images/films.png"));
        Image image2=icon2.getImage();
        Image newImage2=image2.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon22=new ImageIcon(newImage2);
        moviesButton =new JButton(icon22);
        moviesButton.setFont(new Font("Serif", Font.BOLD, 24));


        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("images/sports.png"));
        Image image3=icon3.getImage();
        Image newImage3=image3.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon33=new ImageIcon(newImage3);
        sportsButton =new JButton(icon33);
        sportsButton.setFont(new Font("Serif", Font.BOLD, 24));

        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("images/science.png"));
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


        //addBackColorForMenuPanelButtons();
        createBackPanels();
        addFont();

    }

    public void addFont(){
        JButton[] menuBarPanelButtons= { startQuizButton, newItems, instructionsButton, pastScoresButton, exitButtom};
        JButton[] categoriesPanelButtons= { animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton};

        topPanel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        topPanel.setForeground(Color.darkGray);
        playerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

        playerLabel.setForeground(Color.darkGray);
        playerLabel.setBackground(new Color(240, 243, 248));
        playerLabel.setBorder(new LineBorder(Color.white,1,true));

        authorLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        authorLabel.setForeground(Color.darkGray);
        authorLabel.setBackground(new Color(160, 149, 255));

        for(JButton button: menuBarPanelButtons){
            button.setFont(new Font("Times New Roman", Font.BOLD, 40));
            button.setForeground(Color.darkGray);
            button.setBackground(new Color(166, 153, 255));
        }

        for(JButton button: categoriesPanelButtons){
            button.setFont(new Font("Serif", Font.BOLD, 24));
        }
    }


    public void addComponents(){
        JButton[] menuBarButtons= { startQuizButton, newItems, instructionsButton, pastScoresButton, exitButtom };
        JButton[] categoriesPanelButtons={ animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton };
        JComponent[] mainPanelComponents= {authorLabel, playerLabel, topPanel, menuBarPanel,categoriesPanel };

        for(JButton button:menuBarButtons){
            menuBarPanel.add(button);
        }
        for(JButton button:categoriesPanelButtons){
            categoriesPanel.add(button);
        }
        for(JComponent component:mainPanelComponents){
            backPanel.add(component);
        }
        add(backPanel);
    }

 public void addListeners(){
        JButton[] categoriesPanelButtons={animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton};
        //JButton[]  menuBarPanelButtons= { aboutButton, instructionsButton, pastScoresButton, exitButtom };
        for(JButton button: categoriesPanelButtons){
            button.addActionListener(this::chooseCategory);
        }
        startQuizButton.addActionListener(this::onClickStartQuiz);
        newItems.addActionListener(this::onClickNewItems);
        //instructionsButton.addActionListener(this::);
        pastScoresButton.addActionListener(this::onClickGetScoresButton);
        exitButtom.addActionListener(this::onClickExitButton);
 }


public void chooseCategory(ActionEvent e){
    if (e.getSource() == animalsButton) {
        tempCategory = 1;
        System.out.println("Category= " + tempCategory);
    } else if (e.getSource() == moviesButton) {
        tempCategory = 2;
        System.out.println("Category= " + tempCategory);
    } else if (e.getSource() == sportsButton) {
        tempCategory = 3;
        System.out.println("Category= " + tempCategory);
    } else if (e.getSource() == scienceButton) {
        tempCategory = 4;
        System.out.println("Category= " + tempCategory);
    } else if (e.getSource() == musicButton) {
        tempCategory = 5;
        System.out.println("Category= " + tempCategory);
    } else if (e.getSource() == foodButton) {
        tempCategory = 6;
        System.out.println("Category= " + tempCategory);
    }
}


    public void addBackColorForMenuPanelButtons(){
        JButton[] buttons={startQuizButton, newItems, instructionsButton, pastScoresButton, exitButtom};
        for(JButton button:buttons){
            button.setBackground(new Color(103, 89, 255));
        }
    }

    public void onClickStartQuiz(ActionEvent actionEvent){
        if(tempUser==null || tempCategory ==0){
            infoMessage("Please select category");
        }else {
            PlayFrame playFrame = new PlayFrame(tempCategory, tempUser);
        }

    }

    //use this method if working with files
    public void getScores(ActionEvent actionEvent) {
            List<String> scoresList = getPlayerScoresList();
            List<UserScore> userScoresList= createUserScoreList(scoresList);
            new ScoresFrame(userScoresList);
    }

    public ArrayList<String> getPlayerScoresList() {
        try {
            FileReader fr = new FileReader("src/main/resources/Quiz/PastScores.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            ArrayList<String> playerScoresList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                if (name.equals(tempUser.getUsername())) {
                    playerScoresList.add(line);
                }
            }
            return playerScoresList;
        }catch(IOException e) {
            System.out.println("Error reading scores: " + e.getMessage());
            ArrayList<String> specialObject= new ArrayList<>();
            specialObject.add("Scores not found");
            return specialObject;
        }
    }

    public List<UserScore> createUserScoreList(List<String> list){
        List<UserScore> userScoreList=new ArrayList<>();
        for(String string : list){
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

            userScoreList.add(userScore);
        }return userScoreList;
    }

    public void onClickNewItems(ActionEvent actionEvent) {
        new NewItemsFrame();
    }

    public void onClickGetScoresButton(ActionEvent actionEvent) {
        UserScoreService userScoreService=new UserScoreService();
        List<UserScore> scoresList=userScoreService.findAll();
        new ScoresFrame(scoresList);

    }
    public void onClickExitButton(ActionEvent actionEvent){
        System.exit(0);
    }

    public void infoMessage(String message){
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 24));
        JOptionPane.showMessageDialog(this, message+" !",
                "Service", JOptionPane.WARNING_MESSAGE);
    }

}














