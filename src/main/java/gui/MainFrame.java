package gui;

import service.User.User;
import service.User.UserService;
import service.UserScore.UserScore;
import service.UserScore.UserScoreService;

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


public class MainFrame extends JFrame implements ActionListener {

    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();

    JPanel menuBarPanel, mainPanel, categoriesPanel;
    JButton animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton;
    JLabel headerLabel, authorLabel;
    JButton startQuizButton, aboutButton, instructionsButton, pastScoresButton, exitButtom;

    int tempCategorie;
    JLabel playerLabel;
    User tempUser;
    MainFrame(User tempUser){
        this.tempUser = tempUser;
        /*
        headerLabel = new JLabel("Quiz  Game", JLabel.CENTER);
        headerLabel.setLayout(null);
        headerLabel.setLocation(0,0);
        headerLabel.setSize(screenSize.width-15,100);

        startQuizButton=new JButton("Start Quiz");
        aboutButton =new JButton("About");
        instructionsButton =new JButton("Instructions");
        pastScoresButton =new JButton("Past Scores");
        exitButtom =new JButton("Exit");

        authorLabel=new JLabel("<html><b>Ismet Omerović</b><br>It Akademija<br>2023/24</html>");
        authorLabel.setSize(250,100);
        authorLabel.setLocation(screenSize.width-150,20);

        playerLabel =new JLabel("Player: "+ tempUser.getUsername());
        playerLabel.setSize(280,50);
        playerLabel.setLocation(40,95);

        ImageIcon icon1=new ImageIcon(ClassLoader.getSystemResource("images/animals.png"));
        Image image1=icon1.getImage();
        Image newImage1=image1.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon11=new ImageIcon(newImage1);
        animalsButton =new JButton(icon11);



        ImageIcon icon2=new ImageIcon(ClassLoader.getSystemResource("images/films.jpg"));
        Image image2=icon2.getImage();
        Image newImage2=image2.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon22=new ImageIcon(newImage2);
        moviesButton =new JButton(icon22);
        moviesButton.setFont(new Font("Serif", Font.BOLD, 24));


        ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("images/sports.jpg"));
        Image image3=icon3.getImage();
        Image newImage3=image3.getScaledInstance(310,280,Image.SCALE_DEFAULT);
        ImageIcon icon33=new ImageIcon(newImage3);
        sportsButton =new JButton(icon33);
        sportsButton.setFont(new Font("Serif", Font.BOLD, 24));

        ImageIcon icon4=new ImageIcon(ClassLoader.getSystemResource("images/science.jpg"));
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

         */








        createComponents();
        createFrame();
        addComponents();
        addListeners();

    }

    public void createFrame(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        setTitle(tempUser.getUsername());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(screenSize.width,screenSize.height);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void createBackPanels(){
        menuBarPanel = new JPanel();
        menuBarPanel.setLayout(new GridLayout(1,5));
        menuBarPanel.setBackground(new Color(212, 207, 248));
        menuBarPanel.setLocation(0,160);
        menuBarPanel.setSize(screenSize.width-15,100);

        categoriesPanel = new JPanel();
        categoriesPanel.setLayout(new GridLayout(2,3,30,30));
        categoriesPanel.setBackground(new Color(208, 202, 253));
        categoriesPanel.setLocation(280,320);
        categoriesPanel.setSize(1000,400);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(208, 202, 253));
        mainPanel.setLocation(0,0);
        mainPanel.setSize(screenSize.width,screenSize.height);

    }

    public void createComponents(){
        JButton[] categoriePanelButtons= {animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton};
        String[] categorieNames= {"animals", "movies", "sports", "science", "music", "food"};
        headerLabel = new JLabel("Quiz  Game", JLabel.CENTER);
        headerLabel.setLayout(null);
        headerLabel.setLocation(0,0);
        headerLabel.setSize(screenSize.width-15,100);

        startQuizButton=new JButton("Start Quiz");
        aboutButton =new JButton("About");
        instructionsButton =new JButton("Instructions");
        pastScoresButton =new JButton("Past Scores");
        exitButtom =new JButton("Exit");

        authorLabel=new JLabel("<html><b>Ismet Omerović</b><br>It Akademija<br>2023/24</html>");
        authorLabel.setSize(250,100);
        authorLabel.setLocation(screenSize.width-150,20);

        playerLabel =new JLabel("Player: "+ tempUser.getUsername());
        playerLabel.setSize(280,50);
        playerLabel.setLocation(40,95);

        for(int i=0; i<categoriePanelButtons.length; i++) {
            ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("images/"+categorieNames[i]+".png"));
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(310, 280, Image.SCALE_DEFAULT);
            ImageIcon newImageIcon = new ImageIcon(newImage);
            categoriePanelButtons[i] = new JButton(newImageIcon);
        }

        addFont();
        createBackPanels();
        addBackColorForMenuPanelButtons();
    }

    public void addFont(){
        JButton[] menuBarPanelButtons= { startQuizButton, aboutButton, instructionsButton, pastScoresButton, exitButtom};
        JButton[] categoriesPanelButtons= { animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton};

        headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setBackground(Color.BLACK);
        playerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

        playerLabel.setForeground(Color.darkGray);
        playerLabel.setBackground(new Color(240, 243, 248));
        playerLabel.setBorder(new LineBorder(Color.white,1,true));

        authorLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        authorLabel.setForeground(Color.darkGray);
        authorLabel.setBackground(new Color(208, 202, 253));

        for(JButton button: menuBarPanelButtons){
            button.setFont(new Font("Times New Roman", Font.BOLD, 40));
            button.setForeground(Color.darkGray);
            button.setBackground(new Color(208, 202, 253));
        }

        for(JButton button: categoriesPanelButtons){
            button.setFont(new Font("Serif", Font.BOLD, 24));
        }
    }




    public void addComponents(){
        JButton[] menuBarButtons= { startQuizButton, aboutButton, instructionsButton, pastScoresButton, exitButtom };
        JButton[] categoriesPanelButtons={ animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton };
        JComponent[] mainPanelComponents= {authorLabel, playerLabel, headerLabel, menuBarPanel,categoriesPanel };

        for(JButton button:menuBarButtons){
            menuBarPanel.add(button);
        }
        for(JButton button:categoriesPanelButtons){
            categoriesPanel.add(button);
        }
        for(JComponent component:mainPanelComponents){
            mainPanel.add(component);
        }
        add(mainPanel);
    }

 public void addListeners(){
        JButton[] categoriesPanelButtons={animalsButton, moviesButton, sportsButton, scienceButton, musicButton, foodButton};
        //JButton[]  menuBarPanelButtons= { aboutButton, instructionsButton, pastScoresButton, exitButtom };
        for(JButton button: categoriesPanelButtons){
            button.addActionListener(this);
        }
        startQuizButton.addActionListener(this::onStartQuizClick);
        //aboutButton.addActionListener(this::);
        //instructionsButton.addActionListener(this::);
        pastScoresButton.addActionListener(this::onClickScoresButton);
        startQuizButton.addActionListener(this::onClickExitButton);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == animalsButton) {
            tempCategorie = 1;
            System.out.println("Category= " + tempCategorie);
        } else if (e.getSource() == moviesButton) {
            tempCategorie = 2;
            System.out.println("Category= " + tempCategorie);
        } else if (e.getSource() == sportsButton) {
            tempCategorie = 3;
            System.out.println("Category= " + tempCategorie);
        } else if (e.getSource() == scienceButton) {
            tempCategorie = 4;
            System.out.println("Category= " + tempCategorie);
        } else if (e.getSource() == musicButton) {
            tempCategorie = 5;
            System.out.println("Category= " + tempCategorie);
        } else if (e.getSource() == foodButton) {
            tempCategorie = 6;
            System.out.println("Category= " + tempCategorie);
        }

        }



    public void addBackColorForMenuPanelButtons(){
        JButton[] buttons={startQuizButton, aboutButton, instructionsButton, pastScoresButton, exitButtom};
        for(JButton button:buttons){
            button.setBackground(new Color(185, 178, 250));
        }
    }


    public void onStartQuizClick(ActionEvent actionEvent){
        if(tempUser==null || tempCategorie ==0){
            infoMessage("Please select categorie");
        }else {
            PlayFrame playFrame = new PlayFrame(tempCategorie, tempUser.getUsername());
        }

    }

    //use this method if working with files
    public void getScores(ActionEvent actionEvent) {
        try {
            FileReader fr = new FileReader("src/main/resources/Quiz/PastScores.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            ArrayList<String> playerScoresList=new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                if(name.equals(tempUser.getUsername())) {
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
                new ScoresFrame(list);


            for(String string: playerScoresList){
                System.out.println(string);
            }

        }catch(IOException e){
            System.out.println("Error reading scores: "+e.getMessage());
        }
    }

    public void onClickScoresButton(ActionEvent actionEvent) {
        //playerName= tempUser.getUsername();
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














