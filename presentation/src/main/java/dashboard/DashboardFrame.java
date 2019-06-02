package dashboard;

import entities.Event;
import entities.Ticket;
import entities.User;
import login.Login;
import service.AccountService;
import service.EventService;
import service.TicketService;
import service.repositories.EventRepositoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DashboardFrame extends JFrame implements ActionListener {

    private EventService eventService = EventService.getInstance();
    private EventRepositoryImpl eventRepository = new EventRepositoryImpl();
    private TicketService ticketDao = TicketService.getInstance();
    private AccountService accountService = AccountService.getInstance();
    private User user;
    Container container = getContentPane();
    JPanel header = new JPanel();
    JPanel content = new JPanel();
    JLabel titleLabel = new JLabel("Events Store", JLabel.LEFT);
    JLabel userLabel;
    JList eventList = new JList();
    JPanel rightContent = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JButton detailsButton = new JButton("Details");
    JButton buyTicketButton = new JButton("Buy Ticket");
    JPanel logoutPanel = new JPanel();
    JButton logout = new JButton("Logout");

    DashboardFrame(User user) {
        this.user = user;
        eventRepository.putAll(eventService.getEvents());
        userLabel = new JLabel("Welcome, " + user.getName() + " " + user.getSurname(), JLabel.CENTER);
        createEventList();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    private void createEventList() {
        List<Event> events = eventRepository.getAll();
        String[] eventsString = new String[events.size()];
        int k = 0;
        for (Event event : events) {
            eventsString[k] = event.getName();
            k++;
        }
        eventList.setListData(eventsString);
    }

    private void setLayoutManager() {
        GridLayout gridLayoutContent = new GridLayout(0, 2);
        content.setLayout(gridLayoutContent);
        GridLayout gridLayoutRight = new GridLayout(2, 0);
        rightContent.setLayout(gridLayoutRight);
    }

    private void setLocationAndSize() {
        titleLabel.setFont(new Font("Monaco", Font.BOLD, 40));
        userLabel.setFont(new Font("Monaco", Font.PLAIN, 25));
        header.setBackground(new Color(230, 255, 255));
        eventList.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        eventList.setBorder(BorderFactory.createLineBorder(new Color(203, 203, 179)));
        rightContent.setBorder(BorderFactory.createLineBorder(new Color(203, 203, 179)));
        rightContent.setBackground(new Color(245, 245, 240));
        eventList.setBackground(new Color(245, 245, 240));
        buttonsPanel.setBackground(new Color(245, 245, 240));
        logoutPanel.setBackground(new Color(230, 255, 255));

    }

    private void addComponentsToContainer() {

        header.add(titleLabel);
        container.add(BorderLayout.NORTH, header);
        logoutPanel.add(logout);
        container.add(BorderLayout.SOUTH, logoutPanel);
        content.add(eventList);
        container.add(BorderLayout.CENTER, content);
        content.add(rightContent);
        rightContent.add(userLabel);
        buttonsPanel.add(detailsButton);
        buttonsPanel.add(buyTicketButton);
        rightContent.add(buttonsPanel);

    }

    private void addActionEvent() {
        detailsButton.addActionListener(this);
        buyTicketButton.addActionListener(this);
        logout.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == detailsButton) {
            Event event = getEvent(eventList.getSelectedIndex());
            JOptionPane.showMessageDialog(this, event.toString());
        }
        if (e.getSource() == buyTicketButton) {
            ticketDao.addTicket(new Ticket(accountService.getAccountbyUser(user), getEvent(eventList.getSelectedIndex()), 200D));
            JOptionPane.showMessageDialog(this, "You have bought a ticket to: " + eventList.getSelectedValue());
        }
        if(e.getSource() == logout){
            dispose();
            Login.main(new String[0]);
        }

    }

    private Event getEvent(int index) {
        return eventRepository.getAll().get(index);
    }
}
