package model;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;


public class Menu {

    Map<Integer, Drink> menu = new HashMap<>();

    // MODIFIES: this
    // EFFECTS: creates the menu with a key and associated drink
    public Menu() {
        menu.put(1, new Drink("Brown Sugar Boba", 6.0, "Pearls"));
        menu.put(2, new Drink("Taro Boba", 6.5, "Pearls"));
        menu.put(3, new Drink("Matcha Boba", 6.0, "Pearls"));
        menu.put(4, new Drink("Grapefruit Green Tea", 5.5, ""));
        menu.put(5, new Drink("Lemon Black Tea", 5.5, ""));
        menu.put(6, new Drink("Strawberry Cream FLoat", 7, ""));
        menu.put(7, new Drink("Mango Coconut Sago", 7, "Sago"));

    }

    // EFFECTS: returns size of menu
    public int getMenuSize() {
        return this.menu.size();
    }


    //EFFECTS: returns corresponding item to given key
    public Drink getMenuItem(Integer itemNum) {
        return this.menu.get(itemNum);
    }


}
