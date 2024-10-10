package gui;

import service.Category.Category;
import service.Category.CategoryService;
import service.Question.Question;
import service.Question.QuestionService;
import service.QuizItem.QuizItem;
import service.QuizItem.QuizItemService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

public class NewItemsFrame extends JFrame {
    private JPanel backPanel, topPanel, centerPanel, bottomPanel;
    private JLabel title, category;
    private JLabel question;
    private JLabel correctAnswer;
    private JLabel answer1, answer2, answer3, answer4;
    private JTextField questionValue, correctAnswerValue;
    private JTextField answer1Value, answer2Value, answer3Value, answer4Value;
    JButton saveButton, getButton, deleteButton,exitButton;
    JComboBox comboBox;
    String[] categories={"Animals", "Films", "Sports", "Science", "Music", "Food"};

    public NewItemsFrame() {
        createComponents();
        createFrame();
        addComponents();
        addListeners();
    }

    public void createFrame() {
        setTitle("New Items");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(217, 211, 253));
        setSize(900, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public void createBackPanels(){
         backPanel = new JPanel();
         backPanel.setSize(850, 660);
         backPanel.setLocation(40, 10);
         backPanel.setLayout(null);

         topPanel=new JPanel();
         topPanel.setSize(800, 200);
         topPanel.setLocation(0,0);
         topPanel.setLayout(null);

         centerPanel = new JPanel();
         centerPanel.setSize(800, 320);
         centerPanel.setLocation(-200,200);
         centerPanel.setLayout(new GridLayout(6,2,20,10));

         bottomPanel = new JPanel();
         bottomPanel.setSize(800, 50);
         bottomPanel.setLayout(new GridLayout(1,4,10,10));
         bottomPanel.setLocation(0,590);
         addBackPanelsBackground();
    }

    public void addBackPanelsBackground(){
        JPanel[] panels = { backPanel, topPanel, centerPanel, bottomPanel};
        for (JPanel panel : panels) {
            panel.setBackground(new Color(217, 211, 253));
        }
    }

    public void createComponents(){
        title=new JLabel("New Quiz Items", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(800, 60);
        title.setLocation(0, 0);

        category=new JLabel("Category:", JLabel.RIGHT);

        comboBox = new JComboBox(categories);
        comboBox.setSize(160, 30);


        question=new JLabel("Question:", JLabel.RIGHT);
        question.setSize(160, 50);
        question.setLocation(0, 100);

        questionValue=new JTextField("", JTextField.LEFT);
        questionValue.setSize(600, 40);
        questionValue.setLocation(180, 100);

        correctAnswer=new JLabel("Correct Answer:", JLabel.RIGHT);
        correctAnswerValue=new JTextField();

        answer1=new JLabel("A:",JLabel.RIGHT);
        answer2=new JLabel("B:", JLabel.RIGHT);
        answer3=new JLabel("C:",JLabel.RIGHT);
        answer4=new JLabel("D:", JLabel.RIGHT);

        answer1Value=new JTextField();
        answer2Value=new JTextField();
        answer3Value=new JTextField();
        answer4Value=new JTextField();

        saveButton=new JButton("Save");
        getButton= new JButton("Get Items");
        deleteButton= new JButton("Delete");
        exitButton=new JButton("Exit");

        addCenterPanelComponentsFont();
        addBottomPanelComponentsFont();
        createBackPanels();
    }

    public void addCenterPanelComponentsFont(){
        JLabel[] labels= { category,question,correctAnswer, answer1, answer2, answer3, answer4 };
        JComponent[] labelValues= {comboBox, questionValue,correctAnswerValue, answer1Value, answer2Value, answer3Value, answer4Value };

        for(JLabel label: labels){
            label.setFont(new Font("Arial", Font.PLAIN, 26));
        }
        for(JComponent labelValue: labelValues){
            labelValue.setFont(new Font("Arial", Font.ITALIC, 24));
        }
    }

    public void addBottomPanelComponentsFont(){
        JButton[] buttons = { saveButton, getButton, deleteButton, exitButton };
        for(JButton button: buttons){
            button.setFont(new Font("Arial", Font.BOLD, 26));
            button.setBackground(new Color(146, 132, 255));
        }
    }

    public void addComponents(){
        JPanel[] panels= { topPanel, centerPanel, bottomPanel };
        JComponent[] components= {category, comboBox, correctAnswer,correctAnswerValue, answer1,
                                    answer1Value, answer2, answer2Value, answer3, answer3Value, answer4, answer4Value };
        JButton[] buttons= { saveButton, getButton, deleteButton, exitButton };
        topPanel.add(title);
        topPanel.add(question);
        topPanel.add(questionValue);
       for(JComponent component: components){
           centerPanel.add(component);
       }

        for(JButton button: buttons){
            bottomPanel.add(button);
        }
        for(JPanel panel: panels){
            backPanel.add(panel);
        }
        add(backPanel);
    }

    public void addListeners(){
        JTextField[] values={questionValue, correctAnswerValue, answer1Value, answer2Value, answer3Value, answer4Value};
        saveButton.addActionListener(this::onClickSaveButton);
        getButton.addActionListener(this::onClickGetFirstFromListItem);
        deleteButton.addActionListener(this::onClickDeleteItem);
        exitButton.addActionListener(this::onClickExitButton);
        for(JTextField textField: values){
            textField.addMouseListener(mouseAdapter);
        }
    }

    public void onClickSaveButton(ActionEvent e){
        String question= questionValue.getText();
        String correctAnswer= correctAnswerValue.getText();
        String answer1= answer1Value.getText();
        String answer2= answer2Value.getText();
        String answer3= answer3Value.getText();
        String answer4= answer4Value.getText();

        String[] values={question,correctAnswer,answer1,answer2,answer3,answer4};
        if(!hasEmptyFields(values)){
            saveItem();
        }
        else{
            infoMessage("Please fill all fields");
        }
    }

    public boolean hasEmptyFields(String[] values){
        for(String value: values){
            if(value.isEmpty()){
                return true;
            }
        }
        return false;
    }

    public void saveItem(){
        QuestionService questionService= new QuestionService();
        Question question=new Question();
        question.setQuestionText(questionValue.getText());
        CategoryService categoryService=new CategoryService();
        String tempCat=(String) comboBox.getSelectedItem();
        assert tempCat != null;
        int catID=getCategoryId(tempCat);
        Category category=categoryService.find(catID);
        question.setCategory(category);
        questionService.create(question);

        QuizItemService quizItemService=new QuizItemService();
        QuizItem quizItem= new QuizItem();

        quizItem.setQuestion(question);
        quizItem.setIsCorrect(correctAnswerValue.getText());
        quizItem.setAnswerText1(answer1Value.getText());
        quizItem.setAnswerText2(answer2Value.getText());
        quizItem.setAnswerText3(answer3Value.getText());
        quizItem.setAnswerText4(answer4Value.getText());
        quizItemService.create(quizItem);
        if(validated(quizItem)){
            infoMessage("Quiz item saved, and validated");
        }
        else{
            infoMessage("Quiz item is not saved and validated");
        }
    }

    public int getCategoryId(String tempCat){
        switch(tempCat){
            case "Animals": return 1;
            case "Films": return 2;
            case "Sports": return 3;
            case "Science": return 4;
            case "Music": return 5;
            case "Food": return 6;
        }
        return 0;
    }

    public boolean validated(QuizItem quizItem){
        QuizItemService quizItemService=new QuizItemService();
        QuizItem item= quizItemService.find(quizItem.getId());
        return Objects.nonNull(item);
    }

    public void onClickExitButton(ActionEvent e){
        this.dispose();
    }

    public List<QuizItem> getQuizItems(){
        QuizItemService quizItemService=new QuizItemService();
        return quizItemService.findAll();
    }

    public void setQuizItemValues(){

    }

    public void onClickGetFirstFromListItem(ActionEvent e){

    }

    public void onClickDeleteItem(ActionEvent e){

    }

    public void getNext(){

    }

    public void getPrevious(){

    }

    MouseAdapter mouseAdapter= new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            JTextField[] values = {questionValue, correctAnswerValue, answer1Value, answer2Value, answer3Value, answer4Value};
                for (JTextField textField : values) {
                    if(e.getSource() == textField) {
                        textField.setText("");
                    }
                }
            }
    };

    public void infoMessage(String message){
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 24));
        JOptionPane.showMessageDialog(this, message+" !",
                "Service", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new NewItemsFrame();
    }
}