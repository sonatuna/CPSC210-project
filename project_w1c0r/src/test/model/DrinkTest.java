package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {

    //constructor
    private Drink testDrink;

    @BeforeEach
    void runBefore() {

        testDrink = new Drink("Test Drink", 5.0, "");

    }

    @Test
    void testConstructor() {
        assertEquals("Test Drink", testDrink.getName());
        assertEquals(5.0, testDrink.getPrice());
        assertEquals("", testDrink.getToppings());
    }

    //upgrade size
    @Test
    void testUpgradeSizeToMedium() {
        assertEquals("Small", testDrink.getSize());

        testDrink.upgradeSize("Medium");
        assertEquals("Medium", testDrink.getSize());
        assertEquals(5.5, testDrink.getPrice());
    }

    @Test
    void testUpgradeSizeToLarge() {
        assertEquals("Small", testDrink.getSize());

        testDrink.upgradeSize("Large");
        assertEquals("Large", testDrink.getSize());
        assertEquals(5.5, testDrink.getPrice());

    }
    //adjust sugar level

    @Test
    void testAdjustSugar() {
        assertEquals("100%", testDrink.getSugarLevel());

        testDrink.changeSugarLevel("75%");
        assertEquals("75%", testDrink.getSugarLevel());

        testDrink.changeSugarLevel("50%");
        assertEquals("50%", testDrink.getSugarLevel());

        testDrink.changeSugarLevel("25%");
        assertEquals("25%", testDrink.getSugarLevel());

        testDrink.changeSugarLevel("0%");
        assertEquals("0%", testDrink.getSugarLevel());

        testDrink.changeSugarLevel("25%");
        assertEquals("25%", testDrink.getSugarLevel());
    }
    //adjust ice level

    @Test
    void adjustIceLevel() {
        assertEquals("Regular", testDrink.getIceLevel());

        testDrink.changeIceLevel("Medium");
        assertEquals("Medium", testDrink.getIceLevel());

        testDrink.changeIceLevel("Light");
        assertEquals("Light", testDrink.getIceLevel());

        testDrink.changeIceLevel("None");
        assertEquals("None", testDrink.getIceLevel());
    }

    //add topping
    @Test
    void testAddTopping() {
        assertEquals("", testDrink.getToppings());

        testDrink.addTopping("Pearls");
        assertEquals("Pearls", testDrink.getToppings());
    }

    @Test
    void testAddManyToppings() {
        testDrink.addTopping("Coconut Jelly");
        assertEquals("Coconut Jelly", testDrink.getToppings());

        testDrink.addTopping("Grass Jelly");
        assertEquals("Coconut Jelly,Grass Jelly", testDrink.getToppings());

        testDrink.addTopping("Sago");
        assertEquals("Coconut Jelly,Grass Jelly,Sago", testDrink.getToppings());

    }

    @Test
    void testNull() {
        assertNotEquals(testDrink, null);
    }

    @Test
    void testNotEqualsRandomObject() {
        assertNotEquals(testDrink, new Object());
    }

    @Test
    void testNotEquals() {
        Drink heheDrink = new Drink("Test Drink", 0, "");
        assertNotEquals(testDrink, heheDrink);
    }

    @Test
    void testDrinkNotEquals() {
        Drink anotherDrink = new Drink("1", 5, "");
        assertNotEquals(testDrink, anotherDrink);
    }

    @Test
    void testDrinkInnerDoesNotEqual() {
        Drink anotherDrink = new Drink("Test Drink", 5, "");
        anotherDrink.upgradeSize("Large");
        assertNotEquals(anotherDrink, testDrink);

        Drink anotherDrink2 = new Drink("Test Drink", 5, "");
        anotherDrink2.changeIceLevel("75%");
        assertNotEquals(anotherDrink2, testDrink);

        Drink anotherDrink3 = new Drink("Test Drink", 5, "");
        anotherDrink3.changeSugarLevel("75%");
        assertNotEquals(anotherDrink3, testDrink);
    }

    @Test
    void testDrinkEquals() {
        Drink sameDrink = new Drink("Test Drink", 5.0, "");
        assertEquals(testDrink, sameDrink);
    }
}

