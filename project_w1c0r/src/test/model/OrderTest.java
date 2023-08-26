package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    private Order testOrder;

    @BeforeEach
    void runBefore() {
        testOrder = new Order("Melissa");
    }

    //constructor
    @Test
    void testConstructor() {
        assertEquals("Melissa", testOrder.getCustomerName());
        assertEquals(0, testOrder.getOrderDrinks().size());
        assertEquals(0, testOrder.getTotalPrice());
    }


    // add drink
    @Test
    void testAddDrink() {
        assertEquals(0, testOrder.getOrderDrinks().size());
        Drink testDrink = new Drink("drink", 6, "");
        Drink anotherTestDrink = new Drink("drink", 6, "");
        testOrder.addDrink(testDrink);

        assertEquals(1, testOrder.getOrderDrinks().size());
        assertEquals(testDrink, testOrder.getOrderDrinks().get(0));
        testOrder.addDrink(testDrink);
        testOrder.addDrink(testDrink);
        testOrder.addDrink(anotherTestDrink);


        assertEquals(4, testOrder.getOrderDrinks().size());
        assertEquals(testDrink, testOrder.getOrderDrinks().get(0));
        assertEquals(testDrink, testOrder.getOrderDrinks().get(1));
        assertEquals(testDrink, testOrder.getOrderDrinks().get(2));

    }

}