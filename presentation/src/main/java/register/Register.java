package register;

import javax.swing.*;

public class Register {
    public  void startRegisterFrame() {
        RegisterFrame registerFrame = new RegisterFrame();
        registerFrame.setTitle("Login");
        registerFrame.setVisible(true);
        registerFrame.setBounds(100, 50, 370, 600);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setResizable(false);
    }
}
