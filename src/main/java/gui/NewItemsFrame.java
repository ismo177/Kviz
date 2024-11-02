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
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewItemsFrame extends JFrame {
    private JPanel backPanel, topPanel, centerPanel, centerButtonsPanel, bottomPanel;
    private JLabel title, category;
    private JLabel question;
    private JLabel correctAnswer;
    private JLabel answer1, answer2, answer3, answer4;
    private JTextField questionValue, correctAnswerValue;
    private JTextField answer1Value, answer2Value, answer3Value, answer4Value;
    JButton saveButton, getButton, deleteButton,exitButton, previousButton , nextButton;
    JComboBox comboBox;
    String[] categories={"Animals", "Films", "Sports", "Science", "Music", "Food"};
    List<QuizItem> allItemsList;
    int index=0;
    public NewItemsFrame() {
        createComponents();
        createFrame();
        addComponents();
        addListeners();
        allItemsList=getAllItems();
    }

    public void createFrame() {
        setTitle("New Items");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(217, 211, 253));
        setSize(880, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public void createBackPanels(){
         backPanel = new JPanel();
         backPanel.setSize(850, 760);
         backPanel.setLocation(30, 10);
         backPanel.setLayout(null);

         topPanel=new JPanel();
         topPanel.setSize(800, 200);
         topPanel.setLocation(0,0);
         topPanel.setLayout(null);

         centerPanel = new JPanel();
         centerPanel.setSize(800, 320);
         centerPanel.setLocation(-200,200);
         centerPanel.setLayout(new GridLayout(6,2,20,10));

         centerButtonsPanel = new JPanel();
         centerButtonsPanel.setSize(400, 40);
         centerButtonsPanel.setLocation(200,580);
         centerButtonsPanel.setLayout(new GridLayout(1,2,20,20));
         centerButtonsPanel.setBackground(Color.RED);

         bottomPanel = new JPanel();
         bottomPanel.setSize(800, 50);
         bottomPanel.setLayout(new GridLayout(1,4,10,10));
         bottomPanel.setLocation(0,690);
         addBackPanelsBackground();
    }

    public void addBackPanelsBackground(){
        JPanel[] panels = { backPanel, topPanel, centerPanel,centerButtonsPanel, bottomPanel};
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

        previousButton=new JButton("< Previous");
        nextButton=new JButton("Next >");

        addCenterPanelComponentsFont();
        addButtonsFont();
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

    public void addButtonsFont(){
        JButton[] buttons = { previousButton, nextButton, saveButton, getButton, deleteButton, exitButton };
        for(JButton button: buttons){
            button.setFont(new Font("Arial", Font.BOLD, 26));
            button.setBackground(new Color(146, 132, 255));
        }
    }

    public void addComponents(){
        JPanel[] panels= { topPanel, centerPanel,centerButtonsPanel, bottomPanel };
        JComponent[] components= {category, comboBox, correctAnswer,correctAnswerValue, answer1,
                                    answer1Value, answer2, answer2Value, answer3, answer3Value, answer4, answer4Value };
        JButton[] bottomPanelButtons= { saveButton, getButton, deleteButton, exitButton };
        JButton[] centerButtons= {previousButton, nextButton};
        topPanel.add(title);
        topPanel.add(question);
        topPanel.add(questionValue);
       for(JComponent component: components){
           centerPanel.add(component);
       }
       for(JButton button: centerButtons){
           centerButtonsPanel.add(button);
       }

        for(JButton button: bottomPanelButtons){
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
        getButton.addActionListener(this::onClickGet);
        deleteButton.addActionListener(this::onClickDeleteItem);
        exitButton.addActionListener(this::onClickExitButton);
        previousButton.addActionListener(this::onClickSetPreviousOrNextItem);
        nextButton.addActionListener(this::onClickSetPreviousOrNextItem);
        comboBox.addItemListener(this::resetIndex);
        comboBox.addItemListener(this::onCategoryChangeClearTxFields);
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
        int tempCatID=getCategoryId(tempCat);
        Category category=categoryService.find(tempCatID);

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
            infoMessage("Quiz item is not  validated");
        }
        this.dispose();
        new NewItemsFrame();
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

    public void onClickGet(ActionEvent e){
        getAllItems();
        setInitItem();

    }

    public List<QuizItem> getAllItems(){
        QuizItemService quizItemService=new QuizItemService();
        return quizItemService.findAll();
    }

    public List<QuizItem> getCategoryList(){
        List<QuizItem> categoryList = allItemsList
                .stream()
                .filter(quizItem -> quizItem.getQuestion().getCategory().getId().equals(comboBox.getSelectedIndex()+1))
                .toList();
        return categoryList;
    }

    public void setInitItem(){
        List<QuizItem> categoryList = getCategoryList();
        if(!categoryList.isEmpty()) {
           setValues(categoryList.get(0));
        }else {
            infoMessage("Category list is empty");
        }
    }

    public void resetIndex(ItemEvent e){
        index=0;
        System.out.println(index);
    }

    public void onCategoryChangeClearTxFields(ItemEvent e){
        JTextField[] values={questionValue, correctAnswerValue, answer1Value, answer2Value, answer3Value, answer4Value};
        if(e.getSource()==comboBox){
            for(JTextField textField: values){
                textField.setText("");
            }
        }
    }


    public void onClickSetPreviousOrNextItem(ActionEvent e){
        List<QuizItem> categoryList = getCategoryList();
        if(e.getSource() == previousButton && index>0) {
            index--;
        }else if(e.getSource() == nextButton && index<categoryList.size()-1) {
            index++;
        }
               QuizItem item= categoryList.get(index);
               setValues(item);

    }

    public void setValues(QuizItem item){
        questionValue.setText(item.getQuestion().getQuestionText());
        correctAnswerValue.setText(item.getIsCorrect());
        answer1Value.setText(item.getAnswerText1());
        answer2Value.setText(item.getAnswerText2());
        answer3Value.setText(item.getAnswerText3());
        answer4Value.setText(item.getAnswerText4());
    }

    public void onClickDeleteItem(ActionEvent e){
        getAllItems();
        List<QuizItem> categoryList = getCategoryList();
        System.out.println(categoryList.size());
        QuizItemService quizItemService=new QuizItemService();
        QuestionService questionService=new QuestionService();
        QuizItem item=categoryList.get(index);
        Question question=item.getQuestion();
        quizItemService.delete(item);
        questionService.delete(question);
        this.dispose();
        new NewItemsFrame();
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