package accountEdit;

import entities.Account;

import javax.swing.*;

public class AccountEdit {
    public void startAccountEdit(Account account){
        AccountEditFrame registerFrame = new AccountEditFrame(account);
        registerFrame.setTitle("Edit Account");
        registerFrame.setVisible(true);
        registerFrame.setBounds(100, 50, 370, 600);
        registerFrame.setResizable(false);
    }
}
