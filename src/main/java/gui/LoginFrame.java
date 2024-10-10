package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

import service.User.User;
import service.User.UserService;

public class LoginFrame extends JFrame {
    User tempUser;
    JPanel  topPanel, centerPanel, bottomPanel;
    JLabel usernameLabel, passwordLabel, titleLabel, registrationLinkLabel, loginLinkLabel;
    JTextField usernameValue;
    JPasswordField passwordValue;
    JButton loginButton, exitButton;

    LoginFrame() {
       createComponents();
       createFrame();
       addComponents();
       addListeners();
    }

    public void createFrame(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(208, 202, 253));
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void createBackPanels(){

        topPanel =new JPanel();
        topPanel.setBackground(new Color(208, 202, 253));
        topPanel.setSize(600, 75);
        topPanel.setLocation(0, 0);
        topPanel.setLayout(null);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 10, 10));
        centerPanel.setBackground(new Color(208, 202, 253));
        centerPanel.setLocation(20, 75);
        centerPanel.setSize(540, 100);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2, 20, 20));
        bottomPanel.setBackground(new Color(208, 202, 253));
        bottomPanel.setSize(540, 75);
        bottomPanel.setLocation(20, 260);

    }

    public void addComponents(){
        topPanel.add(titleLabel);
        topPanel.add(loginLinkLabel);
        topPanel.add(registrationLinkLabel);

        centerPanel.add(usernameLabel);
        centerPanel.add(usernameValue);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordValue);

        bottomPanel.add(loginButton);
        bottomPanel.add(exitButton);

        add(topPanel);
        add(centerPanel);
        add(bottomPanel);
    }

    public void createComponents(){
        titleLabel = new JLabel("Login" , JLabel.CENTER);
        titleLabel.setSize(250, 75);
        titleLabel.setLocation(150, 0);

        loginLinkLabel = new JLabel("Login", JLabel.RIGHT);
        loginLinkLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        loginLinkLabel.setSize(250, 20);
        loginLinkLabel.setLocation(300, 10);

        registrationLinkLabel = new JLabel("Registration", JLabel.RIGHT);
        registrationLinkLabel.setSize(250, 20);
        registrationLinkLabel.setLocation(300, 35);

        usernameLabel = new JLabel("Username", JLabel.CENTER);
        passwordLabel = new JLabel("Password", JLabel.CENTER);
        usernameValue = new JTextField();

        passwordValue = new JPasswordField();
        loginButton = new JButton("Login");
        exitButton = new JButton("Exit");
        addFont();
        createBackPanels();
    }

    public void addFont(){
       JLabel[] labels={usernameLabel, passwordLabel};
        JLabel[] linkLabels= {registrationLinkLabel, loginLinkLabel};
       JTextField[] textFields={usernameValue, passwordValue};
       JButton[] buttons= {loginButton, exitButton};

        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBackground(new Color(208, 202, 253));
        for(JLabel label : labels){
            label.setFont(new Font("Times New Roman", Font.BOLD, 20));
            label.setForeground(Color.BLACK);
            label.setBackground(new Color(208, 202, 253));
        }
        for(JLabel label : linkLabels){
            label.setFont(new Font("Times New Roman", Font.ITALIC, 18));
            label.setForeground(Color.GRAY);
        }
        for(JTextField textField : textFields){
            textField.setFont(new Font("Serif", Font.BOLD, 24));
        }
        for(JButton button : buttons){
            button.setFont(new Font("Times New Roman", Font.BOLD, 24));
            button.setForeground(Color.BLACK);
            button.setBackground(new Color(160, 149, 255));
            button.setBorder(new LineBorder(Color.lightGray, 1, true));
        }
    }

MouseAdapter mouseClicked=new MouseAdapter(){
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== registrationLinkLabel) {
           onClickRegistrationLink();
        }
        if(e.getSource()== loginLinkLabel){
           onClickLoginLink();
        }
        if(e.getSource()== usernameValue){
           clearTextFieldsAndChangeBorderInMouseClicked();
        }
    }
};

public void onClickLoginLink(){
    loginLinkLabel.setText(">  Login");
    registrationLinkLabel.setText("Registration");
    loginButton.setText("Login");
    titleLabel.setText("Login");
}

public void onClickRegistrationLink(){
    registrationLinkLabel.setText(">  Registration");
    loginLinkLabel.setText("Login");
    loginButton.setText("Register");
    titleLabel.setText("Registration");
}
 public void clearTextFieldsAndChangeBorderInMouseClicked(){
     usernameValue.setText("");
     passwordValue.setText("");
     usernameValue.setBorder(new LineBorder(Color.GRAY));
     passwordValue.setBorder(new LineBorder(Color.GRAY));
 }

MouseAdapter mouseEntered = new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
       changeBackColorOfButtonsInMouseEntered(e);
        changeForegroundColorOfLabelsInMouseEntered(e);
    }
};

public void changeBackColorOfButtonsInMouseEntered(MouseEvent e){
    if (e.getSource() == loginButton) {
        loginButton.setBackground(new Color(152, 141, 253));
    } else if (e.getSource() == exitButton) {
        exitButton.setBackground(new Color(152, 141, 253));
    } else {
        loginButton.setBackground(new Color(185, 178, 250));
        exitButton.setBackground(new Color(185, 178, 250));
    }
}

public void changeForegroundColorOfLabelsInMouseEntered(MouseEvent e){
    if(e.getSource() == registrationLinkLabel) {
        registrationLinkLabel.setForeground(Color.BLACK);
    }
    if(e.getSource() == loginLinkLabel) {
        loginLinkLabel.setForeground(Color.BLACK);
    }
}

MouseAdapter mouseExited = new MouseAdapter() {
    @Override
    public void mouseExited(MouseEvent e) {
        setBackgroundColorOfButtonsInMouseExited();
        setForegroundColorOfLabelsInMouseExited();
    }
};

public void setBackgroundColorOfButtonsInMouseExited(){
    loginButton.setBackground(new Color(185, 178, 250));
    exitButton.setBackground(new Color(185, 178, 250));
}

public void setForegroundColorOfLabelsInMouseExited(){
    registrationLinkLabel.setForeground(Color.gray);
    loginLinkLabel.setForeground(Color.gray);
}



public void addListeners(){
    JComponent[] componentsForMouseClicked={loginButton, titleLabel, usernameValue, passwordValue, registrationLinkLabel, loginLinkLabel};
    JComponent[] componentsForMouseEntered={loginButton, exitButton, registrationLinkLabel, loginLinkLabel};
    JComponent[] componentsForMouseExited={loginButton, exitButton, registrationLinkLabel, loginLinkLabel};

    for(JComponent component : componentsForMouseClicked){
        component.addMouseListener(mouseClicked);
    }
    for(JComponent component : componentsForMouseEntered){
        component.addMouseListener(mouseEntered);
    }
    for(JComponent component : componentsForMouseExited){
        component.addMouseListener(mouseExited);
    }
    loginButton.addActionListener(this::onClickLoginButton);
    loginButton.addActionListener(this::onClickRegisterButton);
    exitButton.addActionListener(this::onClickExitButton);
}


public void onClickLoginButton(ActionEvent e){
    String username = usernameValue.getText();
    String password = passwordValue.getText();
    if(e.getSource()==loginButton&&loginButton.getText().equals("Login")) {
        login(username, password);
    }
}

public void onClickRegisterButton(ActionEvent e){
    String username = usernameValue.getText();
    String password = passwordValue.getText();
    if(e.getSource()==loginButton&&loginButton.getText().equals("Register")) {
        register(username, password);
    }
}

public void onClickExitButton(ActionEvent e){
    this.dispose();
}

    public void login(String username, String password){
        if (!username.isEmpty() && !password.isEmpty()) {
            UserService userService=new UserService();
            User user = userService.login(username, password);
            initMenuFrame(user, username, password);
        } else {
            infoMessage("Please enter username and password");
        }
    }

    public void initMenuFrame(User user,String username, String password){
        if (user != null) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                tempUser=user;
                new MainFrame(user);
                this.setVisible(false);
            }else{
            infoMessage("Can't initialize MenuFrame, User not found");}
        }
    }

    public void register(String username, String password){
        if (!username.isEmpty() && !password.isEmpty()) {
            UserService userService=new UserService();
            User user=userService.register(username, password);
            registerInfo(user, username);
        } else {
            infoMessage("Please enter username and password");
        }
    }

    public void registerInfo(User user, String username){
        if (user == null) {
            infoMessage("User " + username +" created");

        }else{
            infoMessage("Can't register user, user already exists");
        }
    }

    public void infoMessage(String message){
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 24));
        JOptionPane.showMessageDialog(this, message+" !",
                "Service", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }


}
