package dashboard;

import entities.User;

import javax.swing.*;

public class Dashboard {

    public void showDashboard(User user) {
        DashboardFrame frame = new DashboardFrame(user);
        frame.setTitle("Dashboard");
        frame.setVisible(true);
        frame.setBounds(100, 50, 750, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

}