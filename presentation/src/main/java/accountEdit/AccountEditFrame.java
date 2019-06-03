package accountEdit;

import entities.Account;
import entities.User;
import login.Login;
import service.AccountService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountEditFrame  extends JFrame implements ActionListener {

    Account account;
    Container container = getContentPane();
    JLabel userLabel = new JLabel("Username");
    JLabel nameLabel = new JLabel("Name");
    JLabel surnameLabel = new JLabel("Surname");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField; //= new JTextField();
    JTextField nameTextField ;//= new JTextField();
    JTextField surnameTextField;// = new JTextField();
    JTextField passwordField;// = new JPasswordField();
    JButton saveButton = new JButton("Save");
    JButton resetButton = new JButton("Reset");
    AccountService accountService = AccountService.getInstance();


    AccountEditFrame(Account account) {
        this.account = account;
        userTextField = new JTextField(account.getUsername());
        nameTextField = new JTextField(account.getUser().getName());
        surnameTextField = new JTextField(account.getUser().getSurname());
        passwordField = new JTextField(account.getPassword());
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
        userTextField.setBounds(150, 50, 150, 30);
        nameTextField.setBounds(150, 100, 150, 30);
        surnameTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 200, 150, 30);
        saveButton.setBounds(50, 320, 100, 30);
        resetButton.setBounds(200, 320, 100, 30);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(nameLabel);
        container.add(surnameLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(nameTextField);
        container.add(surnameTextField);
        container.add(passwordField);
        container.add(saveButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        saveButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == saveButton) {
            String userText = userTextField.getText();
            String pwdText = passwordField.getText();
            String nameText = nameTextField.getText();
            String surnameTxt = surnameTextField.getText();
            account.setPassword(pwdText);
            account.setUsername(userText);
            account.getUser().setName(nameText);
            account.getUser().setSurname(surnameTxt);
            accountService.updateAccount(account);
            JOptionPane.showMessageDialog(this, "Updated successfully");

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
    }
    public void register(Account account){accountService.addAccount(account);}

}
