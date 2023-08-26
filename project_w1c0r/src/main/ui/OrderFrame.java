package ui;

import model.Drink;
import model.Event;
import model.EventLog;
import model.Order;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import model.Menu;

// Frame for ordering
public class OrderFrame extends JFrame implements ActionListener, WindowListener {
    private JButton myDrinks;
    private JButton checkout;
    private JButton save;
    private JMenuBar menuBar;
    private Order order;
    private JPanel drinkPanel;
    private JPanel checkoutPanel;
    private CardLayout cardLayout;
    private JButton addDrinkButton;
    private JPanel drinkMenuDisplay;
    private JButton bsb;
    private JButton tb;
    private JButton mb;
    private JButton gfgt;
    private JButton lbt;
    private JButton scf;
    private JButton mcs;
    private JTextArea checkoutTextArea;
    private JPanel custom;
    private JButton sugar;
    private JButton ice;
    private JButton cup;
    private JButton toppings;
    private JButton done;
    private JPanel sugarPanel;
    private JPanel icePanel;
    private JPanel cupPanel;
    private JPanel toppingPanel;
    private JButton pearls;
    private JButton cocoJelly;
    private JButton grassJelly;
    private JButton sago;
    private JButton large;
    private JButton mediumCup;
    private JButton small;
    private JButton regular;
    private JButton mediumIce;
    private JButton light;
    private JButton noIce;
    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private Drink drinkInProgress;
    private JLabel image;

    // MODIFIES: this
    // EFFECTS: constructs an order frame
    public OrderFrame(Order order) {
        super();
        this.order = order;
        super.setSize(500, 350);
        super.setTitle("Order for " + order.getCustomerName());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(this);


        addMenuBar();
        addCardLayout();
        addDrinkPanel();
        addCheckoutPanel();

        super.setVisible(true);
    }

    // MODIFIES: custom, drinkPanel
    // EFFECTS: creates customization panel
    private void addCustom() {
        custom = new JPanel();
        custom.setBounds(250, 350, 300, 300);
        drinkPanel.add(custom);
        custom.setLayout(new GridLayout(5, 1));

        addCustomButtons();
        custom.setVisible(false);
    }

    // MODIFIES: custom, done, sugar, ice, toppings
    // EFFECTS: creates buttons and adds them to custom
    private void addCustomButtons() {
        sugar = new JButton("Adjust Sugar");
        sugar.addActionListener(this);
        ice = new JButton("Adjust Ice");
        ice.addActionListener(this);
        cup = new JButton("Adjust Cup Size");
        cup.addActionListener(this);
        toppings = new JButton("Add Toppings");
        toppings.addActionListener(this);
        done = new JButton("Done");
        done.addActionListener(this);
        custom.add(sugar);
        custom.add(ice);
        custom.add(cup);
        custom.add(toppings);
        custom.add(done);
    }

    // MODIFIES: this
    // EFFECTS: card layout that has multiple panels
    private void addCardLayout() {
        cardLayout = new CardLayout();
        super.setLayout(cardLayout);
        cardLayout.show(this.getContentPane(), "drink panel");
    }

    // MODIFIES: drink panel, this, image
    // EFFECTS: creates a drink panel
    private void addDrinkPanel() {
        drinkPanel = new JPanel();
        super.add(drinkPanel, "drink panel");
        ImageIcon imageIcon = new ImageIcon("src/main/ui/bsb.png");
        image = new JLabel(imageIcon);
        image.setBounds(250, 250, 50, 50);


        drinkPanel.add(image, BorderLayout.CENTER);
        drinkButton();
        displayDrinkMenu();
        addCustom();
        addSugarPanel();
        addIcePanel();
        addCupPanel();
        addToppingPanel();

    }

    // MODIFIES: drinkPanel, toppingPanel
    // EFFECTS: creates topping panel
    private void addToppingPanel() {
        toppingPanel = new JPanel();
        toppingPanel.setBounds(250, 350, 300, 300);
        drinkPanel.add(toppingPanel);
        toppingPanel.setLayout(new GridLayout(7, 1));
        addToppingButtons();
        toppingPanel.setVisible(false);
    }

    // MODIFIES: toppingPanel, pearls, cocoJelly, grassJelly, sago
    // EFFECTS: creates buttons and adds them to toppingPanel
    private void addToppingButtons() {
        pearls = new JButton("Pearls");
        pearls.addActionListener(this);
        cocoJelly = new JButton("Coconut Jelly");
        cocoJelly.addActionListener(this);
        grassJelly = new JButton("Grass Jelly");
        grassJelly.addActionListener(this);
        sago = new JButton("Sago");
        sago.addActionListener(this);
        toppingPanel.add(pearls);
        toppingPanel.add(cocoJelly);
        toppingPanel.add(grassJelly);
        toppingPanel.add(sago);
    }

    // MODIFIES: drinkPanel, cupPanel
    // EFFECTS: creates cup panel
    private void addCupPanel() {
        cupPanel = new JPanel();
        cupPanel.setBounds(250, 350, 300, 300);
        drinkPanel.add(cupPanel);
        cupPanel.setLayout(new GridLayout(3, 1));
        addCupButtons();
        cupPanel.setVisible(false);
    }

    // MODIFIES: cupPanel, large, mediumCup, small
    // EFFECTS: creates buttons and adds them to cupPanel
    private void addCupButtons() {
        large = new JButton("Large (+0.5)");
        large.addActionListener(this);
        mediumCup = new JButton("Medium (+0.5)");
        mediumCup.addActionListener(this);
        small = new JButton("Small");
        small.addActionListener(this);
        cupPanel.add(large);
        cupPanel.add(mediumCup);
        cupPanel.add(small);
    }

    // MODIFIES: drinkPanel, icePanel
    // EFFECTS: creates ice panel
    private void addIcePanel() {
        icePanel = new JPanel();
        icePanel.setBounds(250, 350, 300, 300);
        drinkPanel.add(icePanel);
        icePanel.setLayout(new GridLayout(4, 1));
        addIceButtons();
        icePanel.setVisible(false);
    }

    // MODIFIES: icePanel, regular, mediumIce, light, noIce
    // EFFECTS: creates buttons and adds them to icePanel
    private void addIceButtons() {
        regular = new JButton("Regular");
        regular.addActionListener(this);
        mediumIce = new JButton("Medium");
        mediumIce.addActionListener(this);
        light = new JButton("Light");
        light.addActionListener(this);
        noIce = new JButton("None");
        noIce.addActionListener(this);
        icePanel.add(regular);
        icePanel.add(mediumIce);
        icePanel.add(light);
        icePanel.add(noIce);
    }

    // MODIFIES: drinkPanel, sugarPanel
    // EFFECTS: creates sugar panel
    private void addSugarPanel() {
        sugarPanel = new JPanel();
        sugarPanel.setBounds(250, 350, 300, 300);
        drinkPanel.add(sugarPanel);
        sugarPanel.setLayout(new GridLayout(5, 1));
        addSugarButtons();
        sugarPanel.setVisible(false);
    }

    // MODIFIES: sugarPanel, one, two, three, four
    // EFFECTS: creates buttons and adds them to sugarPanel
    private void addSugarButtons() {
        four = new JButton("100%");
        four.addActionListener(this);
        three = new JButton("75%");
        three.addActionListener(this);
        two = new JButton("50%");
        two.addActionListener(this);
        one = new JButton("25%");
        one.addActionListener(this);
        zero = new JButton("0%");
        zero.addActionListener(this);
        sugarPanel.add(four);
        sugarPanel.add(three);
        sugarPanel.add(two);
        sugarPanel.add(one);
        sugarPanel.add(zero);
    }

    // MODIFIES: drinkPanel. addDrinkButton
    // EFFECTS: creates drinkButton
    private void drinkButton() {
        addDrinkButton = new JButton("new drink");
        addDrinkButton.addActionListener(this);
        drinkPanel.add(addDrinkButton);
        addDrinkButton.addActionListener(this);
    }

    // MODIFIES: drinkMenuDisplay, drinkPanel
    // EFFECTS: create drink menu display
    private void displayDrinkMenu() {
        drinkMenuDisplay = new JPanel();
        drinkMenuDisplay.setBounds(250, 350, 300, 300);
        drinkPanel.add(drinkMenuDisplay);
        drinkMenuDisplay.setLayout(new GridLayout(7, 1));
        addButtons();
    }

    // MODIFIES: bsb, tb. mb, gfgt, lbt, scf, mcs, drinkMenuDisplay
    // EFFECTS: adds buttons for drink menu
    private void addButtons() {
        bsb = new JButton("Brown Sugar Boba");
        bsb.addActionListener(this);
        tb = new JButton("Taro Boba");
        tb.addActionListener(this);
        mb = new JButton("Matcha Boba");
        mb.addActionListener(this);
        gfgt = new JButton("Grapefruit Green Tea");
        gfgt.addActionListener(this);
        lbt = new JButton("Lemon Black Tea");
        lbt.addActionListener(this);
        scf = new JButton("Strawberry Cream Float");
        scf.addActionListener(this);
        mcs = new JButton("Mango Coconut Sago");
        mcs.addActionListener(this);
        drinkMenuDisplay.add(bsb);
        drinkMenuDisplay.add(tb);
        drinkMenuDisplay.add(mb);
        drinkMenuDisplay.add(gfgt);
        drinkMenuDisplay.add(lbt);
        drinkMenuDisplay.add(scf);
        drinkMenuDisplay.add(mcs);
        drinkMenuDisplay.setVisible(false);
    }

    // MODIFIES: this, checkoutPanel, checkoutTextArea
    // EFFECTS: creates checkout panel
    private void addCheckoutPanel() {
        checkoutPanel = new JPanel();
        checkoutTextArea = new JTextArea(10, 40);
        super.add(checkoutPanel, "checkout panel");
        checkoutTextArea.setEditable(false);
        checkoutTextArea.setLineWrap(true);
        checkoutTextArea.setWrapStyleWord(true);
        checkoutTextArea.setText("Order for " + order.getCustomerName() + "\n" + order.getOrderDrinks()
                + "\n" + order.getTotalPrice());
        checkoutPanel.add(checkoutTextArea);
    }

    // MODIFIES: menuBar, this, myDrinks, checkout, save
    // EFFECTS: creates menu bar

    private void addMenuBar() {
        myDrinks = new JButton("My Drinks");
        checkout = new JButton("Checkout");
        save = new JButton("Save");

        menuBar = new JMenuBar();
        menuBar.add(myDrinks);
        menuBar.add(checkout);
        menuBar.add(save);
        super.setJMenuBar(menuBar);

        myDrinks.addActionListener(this);
        checkout.addActionListener(this);
        save.addActionListener(this);
    }

    // MODIFIES: cardLayout, checkoutTextArea, drinkMenuDisplay, addDrinkButton, image
    // EFFECTS: action listener for buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myDrinks) {
            cardLayout.show(this.getContentPane(), "drink panel");
        }
        if (e.getSource() == checkout) {
            cardLayout.show(this.getContentPane(), "checkout panel");
            checkoutTextArea.setText("Order for " + order.getCustomerName() + "\n" + printDrinks() + "\n------------"
                    + "\n Total: "
                    + "\n" + order.getTotalPrice());
        }
        if (e.getSource() == save) {
            saveOrder(order.getCustomerName());
        }
        if (e.getSource() == addDrinkButton) {
            drinkMenuDisplay.setVisible(true);
            addDrinkButton.setEnabled(false);
            image.setVisible(false);
        }
        drinkActions(e);
        customActions(e);
        sugarActions(e);
        iceActions(e);
        cupActions(e);
        toppingActions(e);

    }

    // MODIFIES: toppingPanel, custom, drinkInProgress
    // EFFECTS: action listener for topping buttons
    private void toppingActions(ActionEvent e) {
        if (e.getSource() == pearls | e.getSource() == cocoJelly | e.getSource() == grassJelly
                | e.getSource() == sago) {
            toppingPanel.setVisible(false);
            custom.setVisible(true);
        }
        if (e.getSource() == pearls) {
            drinkInProgress.addTopping("Pearls");
        }
        if (e.getSource() == cocoJelly) {
            drinkInProgress.addTopping("Coconut Jelly");
        }
        if (e.getSource() == grassJelly) {
            drinkInProgress.changeIceLevel("Grass Jelly");
        }
        if (e.getSource() == sago) {
            drinkInProgress.changeIceLevel("Sago");
        }
    }

    // MODIFIES: cupPanel, custom, drinkInProgress
    // EFFECTS: action listener for cup menu buttons
    private void cupActions(ActionEvent e) {
        if (e.getSource() == large | e.getSource() == mediumCup | e.getSource() == small) {
            cupPanel.setVisible(false);
            custom.setVisible(true);
        }
        if (e.getSource() == large) {
            drinkInProgress.upgradeSize("large");
        }
        if (e.getSource() == mediumCup) {
            drinkInProgress.upgradeSize("medium");
        }
        if (e.getSource() == small) {
            drinkInProgress.upgradeSize("small");
        }
    }

    // MODIFIES: icePanel, drinkInProgress, custom
    // EFFECTS: action listener for ice menu buttons
    private void iceActions(ActionEvent e) {
        if (e.getSource() == regular | e.getSource() == mediumIce | e.getSource() == light | e.getSource() == noIce) {
            icePanel.setVisible(false);
            custom.setVisible(true);
        }
        if (e.getSource() == regular) {
            drinkInProgress.changeIceLevel("regular");
        }
        if (e.getSource() == mediumIce) {
            drinkInProgress.changeIceLevel("medium");
        }
        if (e.getSource() == light) {
            drinkInProgress.changeIceLevel("light");
        }
        if (e.getSource() == noIce) {
            drinkInProgress.changeIceLevel("none");
        }
    }

    // MODIFIES: sugarPanel, drinkInProgress, custom
    // EFFECTS: action listener for sugar menu buttons
    private void sugarActions(ActionEvent e) {
        if (e.getSource() == four | e.getSource() == three | e.getSource() == two | e.getSource() == one
                | e.getSource() == zero) {
            sugarPanel.setVisible(false);
            custom.setVisible(true);
        }
        if (e.getSource() == four) {
            drinkInProgress.changeSugarLevel("100%");
        }
        if (e.getSource() == three) {
            drinkInProgress.changeSugarLevel("75%");
        }
        if (e.getSource() == two) {
            drinkInProgress.changeSugarLevel("50%");
        }
        if (e.getSource() == one) {
            drinkInProgress.changeSugarLevel("25%");
        }
        if (e.getSource() == zero) {
            drinkInProgress.changeSugarLevel("0%");
        }
    }

    private String printDrinks() {
        String drinks = "";
        for (Drink d : order.getOrderDrinks()) {
            drinks = drinks + "\n----" + "\n" + d.getName() + "\n" + d.getToppings() + "\n"
                    +
                    d.getIceLevel() + "\n" + d.getSugarLevel() + "\n" + d.getPrice();
        }
        return drinks;
    }

    // MODIFIES: addDrinkButton, custom, image, sugarPanel, icePanel, cupPanel, toppingPanel
    // EFFECTS: action listener for custom menu buttons
    private void customActions(ActionEvent e) {
        if (e.getSource() == done) {
            addDrinkButton.setEnabled(true);
            custom.setVisible(false);
            image.setVisible(true);
        }
        if (e.getSource() == sugar) {
            sugarPanel.setVisible(true);
            custom.setVisible(false);
        }
        if (e.getSource() == ice) {
            icePanel.setVisible(true);
            custom.setVisible(false);
        }
        if (e.getSource() == cup) {
            cupPanel.setVisible(true);
            custom.setVisible(false);
        }
        if (e.getSource() == toppings) {
            toppingPanel.setVisible(true);
            custom.setVisible(false);
        }
    }

    // MODIFIES: order, drinkInProgress, custom, drinkMenuDisplay
    // EFFECTS: action listener for drink menu
    private void drinkActions(ActionEvent e) {
        Menu menu = new Menu();
        if (e.getSource() == bsb | e.getSource() == mb | e.getSource() == tb | e.getSource() == gfgt
                | e.getSource() == lbt | e.getSource() == scf | e.getSource() == mcs) {
            custom.setVisible(true);
            if (e.getSource() == bsb) {
                drinkInProgress = menu.getMenuItem(1);
            } else if (e.getSource() == tb) {
                drinkInProgress = menu.getMenuItem(2);
            } else if (e.getSource() == mb) {
                drinkInProgress = menu.getMenuItem(3);
            } else if (e.getSource() == gfgt) {
                drinkInProgress = menu.getMenuItem(4);
            } else if (e.getSource() == lbt) {
                drinkInProgress = menu.getMenuItem(5);
            } else if (e.getSource() == scf) {
                drinkInProgress = menu.getMenuItem(6);
            } else if (e.getSource() == mcs) {
                drinkInProgress = menu.getMenuItem(7);
            }
            order.addDrink(drinkInProgress);
            drinkMenuDisplay.setVisible(false);
        }
    }


//     REQUIRES: file username must exist
//     MODIFIES: this
//     EFFECTS: saves order to file
//     throws exception if file unable to be written

    private void saveOrder(String orderName) {
        String orderPath = String.format("./data/%s.json", orderName);
        try {
            JsonWriter jsonWriter = new JsonWriter(orderPath);
            jsonWriter.open();
            jsonWriter.write(order);
            jsonWriter.close();
            System.out.println("Saved order for " + order.getCustomerName() + " to " + orderPath);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + orderPath);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // not used
    }

    // EFFECTS: upon window closing, prints the event log
    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource() == this) {
            printLog(EventLog.getInstance());
        }
    }

    // EFFECTS: prints the event log
    public void printLog(EventLog el) {
        for (Event next : el) {
            System.out.println(next.toString());
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // not used
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // not used
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // not used
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // not used
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // not used
    }
}

