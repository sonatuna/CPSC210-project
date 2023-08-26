package model;

import model.Drink;
import model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTest {

    private Menu testMenu;

    @BeforeEach
    void runBefore() {
        testMenu = new Menu();
    }

    // constructor
    @Test
    void testConstructor() throws Exception {
        assertEquals(7, testMenu.getMenuSize());
        assertEquals(new Drink("Brown Sugar Boba", 6.0, "Pearls"),
                testMenu.getMenuItem(1));

        assertEquals(new Drink("Taro Boba", 6.5, "Pearls"), testMenu.getMenuItem(2));

        assertEquals(new Drink("Matcha Boba", 6.0, "Pearls"), testMenu.getMenuItem(3));

        assertEquals(new Drink("Grapefruit Green Tea", 5.5, ""),
                testMenu.getMenuItem(4));

        assertEquals(new Drink("Lemon Black Tea", 5.5, ""),
                testMenu.getMenuItem(5));

        assertEquals(new Drink("Strawberry Cream FLoat", 7, ""),
                testMenu.getMenuItem(6));

        assertEquals(new Drink("Mango Coconut Sago", 7, "Sago"), testMenu.getMenuItem(7));

        
    }
}
