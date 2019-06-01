package register;

import entities.Account;
import entities.User;
import login.Login;
import service.AccountService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("Username");
    JLabel nameLabel = new JLabel("Name");
    JLabel surnameLabel = new JLabel("Surname");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmPasswordLabel = new JLabel("Confirm Password");
    JTextField userTextField = new JTextField();
    JTextField nameTextField = new JTextField();
    JTextField surnameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JLabel loginLabel = new JLabel("Already have an account?");
    JButton loginButton = new JButton("Login");
    AccountService accountService = AccountService.getInstance();


    RegisterFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 50, 100, 30);
        nameLabel.setBounds(50, 100, 100, 30);
        surnameLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 200, 100, 30);
        confirmPasswordLabel.setBounds(50, 250, 100, 30);
        userTextField.setBounds(150, 50, 150, 30);
        nameTextField.setBounds(150, 100, 150, 30);
        surnameTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 200, 150, 30);
        confirmPasswordField.setBounds(150, 250, 150, 30);
        showPassword.setBounds(150, 280, 150, 30);
        registerButton.setBounds(50, 320, 100, 30);
        resetButton.setBounds(200, 320, 100, 30);
        loginLabel.setBounds(100, 450, 250, 30);
        loginButton.setBounds(130, 480, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(nameLabel);
        container.add(surnameLabel);
        container.add(passwordLabel);
        container.add(confirmPasswordLabel);
        container.add(userTextField);
        container.add(nameTextField);
        container.add(surnameTextField);
        container.add(passwordField);
        container.add(confirmPasswordField);
        container.add(showPassword);
        container.add(registerButton);
        container.add(resetButton);
        container.add(loginLabel);
        container.add(loginButton);
    }

    public void addActionEvent() {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        loginButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == registerButton) {
            String userText = userTextField.getText();
            String pwdText = passwordField.getText();
            String nameText = nameTextField.getText();
            String confirmpwdText = confirmPasswordField.getText();
            String surnameText = surnameTextField.getText();
            if (pwdText.equals(confirmpwdText)) {
                Account account = new Account(userText, pwdText, new User(nameText,surnameText));
                register(account);
                JOptionPane.showMessageDialog(this, "Registration successfully! Go to the login page!");

            } else {
                JOptionPane.showMessageDialog(this, "Password does not match the confirm password.");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
        if(e.getSource() == loginButton){
            dispose();
            Login.main(new String[0]);
        }
    }
    public void register(Account account){accountService.addAccount(account);}

}
