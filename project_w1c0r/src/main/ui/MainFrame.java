package ui;

import model.Event;
import model.EventLog;
import model.Order;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

// default frame that creates an order and can open file
public class MainFrame extends JFrame implements ActionListener, WindowListener {

    private JMenuBar menuBar;
    private JButton fileMenu;
    private JButton orderMenu;
    private JButton createOrderButton;
    private JLabel enterNamePrompt;
    private JTextField nameInput;
    private JTextField fileNameInput;
    private JLabel enterFileNamePrompt;
    private JButton enterButton;
    private Order order;
    private JPanel main;
    private JPanel open;
    private CardLayout cardLayout;

    // MODIFIES: this
    // EFFECTS: creates main frame
    MainFrame() {
        this.setSize(500, 500);
        this.setTitle("Bubble Tea Order");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(this);

        addMenuBar();
        addCardLayout();
        addMainPanel();
        addOpenPanel();

        this.setVisible(true);
    }

    // MODIFIES: this, open
    // EFFECTS: adds panel to find file
    private void addOpenPanel() {
        open = new JPanel();
        this.add(open, "open");
        open.setLayout(null);
        addFileNameInput();
        addEnterButton();
    }

    // MODIFIES: enterButton, open
    // EFFECTS: creates enterButton
    private void addEnterButton() {
        enterButton = new JButton();
        enterButton.setBounds(200, 200, 100, 50);
        enterButton.setText("Enter");
        enterButton.setFocusable(false);
        enterButton.addActionListener(this);
        open.add(enterButton, BorderLayout.CENTER);

    }

    // MODIFIES: open, fileNameInput
    // EFFECTS: adds input field for file name for open
    private void addFileNameInput() {
        enterFileNamePrompt = new JLabel("Enter file name:");
        enterFileNamePrompt.setBounds(200, 130, 200, 50);
        open.add(enterFileNamePrompt);
        fileNameInput = new JTextField();
        fileNameInput.setBounds(200, 170, 100, 20);
        open.add(fileNameInput);
    }

    // MODIFIES: this, main
    // EFFECTS: adds a main panel
    private void addMainPanel() {
        main = new JPanel();
        main.setLayout(null);
        this.add(main, "main");
        addNameInput();
        addOrderButton();
    }

    // MODIFIES: cardLayout, this
    // EFFECTS: creates card layout and adds panels to card layout
    private void addCardLayout() {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        cardLayout.show(this.getContentPane(), "open");
    }

    // MODIFIES: createOrderButton, main
    // EFFECTS: makes a button that creates order
    private void addOrderButton() {
        createOrderButton = new JButton();
        createOrderButton.setBounds(200, 200, 100, 50);
        createOrderButton.setText("Create Order");
        createOrderButton.setFocusable(false);
        createOrderButton.addActionListener(this);
        main.add(createOrderButton, BorderLayout.CENTER);
    }

    // MODIFIES: enterNamePrompt, main, nameInput
    // EFFECTS: creates input field for entering customer name
    private void addNameInput() {
        enterNamePrompt = new JLabel("Enter your name:");
        enterNamePrompt.setBounds(200, 130, 200, 50);
        main.add(enterNamePrompt);
        nameInput = new JTextField();
        main.add(nameInput);
        nameInput.setBounds(200, 170, 100, 20);
    }

    // MODIFIES: menuBar, this
    // EFFECTS: creates menu bar for order and open menu items on main window
    private void addMenuBar() {
        menuBar = new JMenuBar();
        orderMenu = new JButton("Order");
        orderMenu.addActionListener(this);
        fileMenu = new JButton("Open");
        fileMenu.addActionListener(this);
        menuBar.add(orderMenu);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }

    // MODIFIES: order, cardLayout
    // EFFECTS: action listener for buttons

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createOrderButton) {
            String userName = nameInput.getText();
            order = new Order(userName);
            new OrderFrame(order);
        }
        if (e.getSource() == orderMenu) {
            cardLayout.show(this.getContentPane(), "main");

        }
        if (e.getSource() == fileMenu) {
            cardLayout.show(this.getContentPane(), "open");

        }
        if (e.getSource() == enterButton) {
            String fileName = fileNameInput.getText();
            order = loadOrder(fileName);
            new OrderFrame(order);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads order from file based on user input
    // throws exception if unable to read file
    private Order loadOrder(String fileName) {
        String orderPath = String.format("./data/%s.json", fileName);
        try {
            JsonReader jsonReader = new JsonReader(orderPath);
            order = jsonReader.read();
            System.out.println("Loaded order for " + order.getCustomerName() + " from " + orderPath);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + orderPath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource() == this) {

            printLog(EventLog.getInstance());
        }
    }

    public void printLog(EventLog el) {
        for (Event next : el) {
            System.out.println(next.toString());
        }
    }

    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
