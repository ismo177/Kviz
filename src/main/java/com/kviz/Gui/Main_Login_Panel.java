package com.kviz.Gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.kviz.User.User;
import com.kviz.User.UserService;

public class Main_Login_Panel extends JFrame implements MouseListener, ActionListener {

    String userName;
    JPanel headerPanel, centerPanel, buttonsPanel;
    JLabel titleLoginLabel, registrationLinkLabel, usernameLabel, passwordLabel, loginLinkLabel;
    JTextField usernameTextField;
    JPasswordField passwordTextField;
    JButton loginButton, exitButton;

    Main_Login_Panel() {


        titleLoginLabel = new JLabel("Login" , JLabel.CENTER);
        titleLoginLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        titleLoginLabel.setForeground(Color.DARK_GRAY);
        titleLoginLabel.setBackground(new Color(208, 202, 253));
        titleLoginLabel.setSize(250, 75);
        titleLoginLabel.setLocation(150, 0);
        titleLoginLabel.addMouseListener(this);

        loginLinkLabel = new JLabel("Login", JLabel.RIGHT);
        loginLinkLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        loginLinkLabel.setForeground(Color.blue);
        loginLinkLabel.setBackground(new Color(208, 202, 253));
        loginLinkLabel.setSize(250, 20);
        loginLinkLabel.setLocation(300, 10);
        loginLinkLabel.addMouseListener(this);

        registrationLinkLabel = new JLabel("Registration", JLabel.RIGHT);
        registrationLinkLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        registrationLinkLabel.setForeground(Color.BLUE);
        registrationLinkLabel.setBackground(new Color(208, 202, 253));
        registrationLinkLabel.setSize(250, 20);
        registrationLinkLabel.setLocation(300, 35);
        registrationLinkLabel.addMouseListener(this);


        headerPanel =new JPanel();
        headerPanel.setBackground(new Color(208, 202, 253));
        headerPanel.setSize(600, 75);
        headerPanel.setLocation(0, 0);
        headerPanel.setLayout(null);
        headerPanel.add(titleLoginLabel);
        headerPanel.add(loginLinkLabel);
        headerPanel.add(registrationLinkLabel);

        usernameLabel = new JLabel("Username", JLabel.CENTER);
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        usernameLabel.setForeground(Color.DARK_GRAY);
        usernameLabel.setBackground(new Color(208, 202, 253));

        passwordLabel = new JLabel("Password", JLabel.CENTER);
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        passwordLabel.setForeground(Color.DARK_GRAY);
        passwordLabel.setBackground(new Color(208, 202, 253));

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        usernameTextField.setForeground(Color.DARK_GRAY);
        usernameTextField.addMouseListener(this);

        passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        passwordTextField.setForeground(Color.DARK_GRAY);


        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 20, 10));
        centerPanel.setBackground(new Color(208, 202, 253));
        centerPanel.setLocation(20, 75);
        centerPanel.setSize(540, 100);
        // p1.setBorder(new LineBorder(Color.black));
        centerPanel.add(usernameLabel);
        centerPanel.add(usernameTextField);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordTextField);


        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        loginButton.setForeground(Color.DARK_GRAY);
        loginButton.setBackground(new Color(185, 178, 250));
        loginButton.setBorder(new LineBorder(Color.lightGray, 1, true));
        loginButton.addActionListener(this);
        loginButton.addMouseListener(this);


        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
        exitButton.setForeground(Color.DARK_GRAY);
        exitButton.setBackground(new Color(185, 178, 250));
        exitButton.setBorder(new LineBorder(Color.lightGray, 1, true));
        exitButton.addActionListener(this);
        exitButton.addMouseListener(this);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 20, 20));
        buttonsPanel.setBackground(new Color(208, 202, 253));
        buttonsPanel.setSize(540, 75);
        buttonsPanel.setLocation(20, 260);
        //p2.setBorder(new LineBorder(Color.black));
        buttonsPanel.add(loginButton);
        buttonsPanel.add(exitButton);

        add(headerPanel);
        add(centerPanel);
        add(buttonsPanel);

        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        getContentPane().setBackground(new Color(208, 202, 253));
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== registrationLinkLabel) {
            loginButton.setText("Register");
            titleLoginLabel.setText("Registration");
        }
            if(e.getSource()== loginLinkLabel){
                loginButton.setText("Login");
                titleLoginLabel.setText("Login");
            }
            if(e.getSource()== usernameTextField){
                usernameTextField.setText("");
                passwordTextField.setText("");
                usernameTextField.setBorder(new LineBorder(Color.GRAY));
                passwordTextField.setBorder(new LineBorder(Color.GRAY));
            }
        }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == loginButton) {
            loginButton.setBackground(new Color(152, 141, 253));
        } else if (e.getSource() == exitButton) {
            exitButton.setBackground(new Color(152, 141, 253));
        } else {
            loginButton.setBackground(new Color(185, 178, 250));
            exitButton.setBackground(new Color(185, 178, 250));
        }
        if(e.getSource() == registrationLinkLabel) {
            registrationLinkLabel.setForeground(Color.DARK_GRAY);
        }
        if(e.getSource() == loginLinkLabel) {
            loginLinkLabel.setForeground(Color.DARK_GRAY);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        loginButton.setBackground(new Color(185, 178, 250));
        exitButton.setBackground(new Color(185, 178, 250));
        loginLinkLabel.setForeground(Color.GRAY);
        registrationLinkLabel.setForeground(Color.gray);
        loginButton.repaint();
        exitButton.repaint();
        registrationLinkLabel.repaint();

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String msg=e.getActionCommand();
        if(msg.equals("Login")) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (!username.isEmpty() && !password.isEmpty()) {
            UserService userService=new UserService();
            User user = userService.login(username, password);
            if (user != null) {
                if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                    userName=user.getUsername();
                    new Menu_panel(username);
                    this.setVisible(false);
                }
            } else {
                usernameTextField.setText("User not found !");
                passwordTextField.setText("");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                this.dispose();

            }
        } else {
            usernameTextField.setText(" username or password is empty");
            usernameTextField.setBorder(new LineBorder(Color.red));
            usernameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
            passwordTextField.setText("");
            passwordTextField.setBorder(new LineBorder(Color.red));
        }


    }
        if(msg.equals("Register")) {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();


            if (!username.isEmpty() && !password.isEmpty()) {
                UserService userService=new UserService();
                User user=userService.register(username, password);
                if (user == null) {
                    usernameTextField.setText("User " +username+" created");
                    usernameTextField.setBorder(new LineBorder(Color.green,3));
                    passwordTextField.setText("");

                }else{
                    usernameTextField.setText("Already exists !");
                    usernameTextField.setBorder(new LineBorder(Color.red,3));
                }
            } else {
                usernameTextField.setText(" username or password is empty");
                usernameTextField.setBorder(new LineBorder(Color.red));
                usernameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                passwordTextField.setText("");
                passwordTextField.setBorder(new LineBorder(Color.red));
            }


        }

        else if(msg.equals("Exit")) {
        this.dispose();
        }
    }

    public static void main(String[] args) {
        new Main_Login_Panel();
    }


}
