package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class LoginKeyListener {
    LoginFrame loginFrame;
    public LoginKeyListener(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
        setFrameKeyListeners();

    }
    public void setFrameKeyListeners(){
        loginFrame.loginButton.addActionListener(loginButtonAction);
        loginFrame.usernameValue.requestFocusInWindow();
        loginFrame.loginButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter Pressed");
        loginFrame.loginButton.getActionMap().put("Enter Pressed", loginButtonAction);

        loginFrame.exitButton.addActionListener(exitButtonAction);
        loginFrame.exitButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape Pressed");
        loginFrame.exitButton.getActionMap().put("Escape Pressed", exitButtonAction);
    }

    AbstractAction loginButtonAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginFrame.loginButton.setBackground(new Color(101, 84, 255));
            if(loginFrame.usernameValue.getText().isEmpty()&&loginFrame.passwordValue.getText().isEmpty()) {
                loginFrame.dispose();
                new LoginFrame();
            }
            loginFrame.login(loginFrame.usernameValue.getText(), loginFrame.passwordValue.getText());
        }
    };

    AbstractAction exitButtonAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginFrame.exitButton.setBackground(new Color(101, 84, 255));
            loginFrame.dispose();
        }
    };
    public static void main(String[] args) {

        new LoginKeyListener(new LoginFrame());
    }

}