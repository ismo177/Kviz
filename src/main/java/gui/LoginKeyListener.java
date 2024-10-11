package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class LoginKeyListener {
    private LoginFrame loginFrame;
    public LoginKeyListener(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
        setFrameKeyListeners();

    }
    public void setFrameKeyListeners(){
        loginFrame.getLoginButton().addActionListener(loginButtonAction);
        loginFrame.getUsernameValue().requestFocusInWindow();
        loginFrame.getLoginButton().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter Pressed");
        loginFrame.getLoginButton().getActionMap().put("Enter Pressed", loginButtonAction);

        loginFrame.getExitButton().addActionListener(exitButtonAction);
        loginFrame.getExitButton().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Escape Pressed");
        loginFrame.getExitButton().getActionMap().put("Escape Pressed", exitButtonAction);
    }

    AbstractAction loginButtonAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginFrame.getLoginButton().setBackground(new Color(101, 84, 255));
            if(loginFrame.getUsernameValue().getText().isEmpty()&&loginFrame.getPasswordValue().getText().isEmpty()) {
                loginFrame.dispose();
                new LoginFrame();
            }
            loginFrame.login(loginFrame.getUsernameValue().getText(), loginFrame.getPasswordValue().getText());
        }
    };

    AbstractAction exitButtonAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginFrame.getExitButton().setBackground(new Color(101, 84, 255));
            loginFrame.dispose();
        }
    };
    public static void main(String[] args) {

        new LoginKeyListener(new LoginFrame());
    }

}