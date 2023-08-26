package persistence;

import model.Drink;

// this class contains code based on the JsonTest class in the JsonSerializationDemo project
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/d31979d8a993d63c3a8c13c8add7f9d1753777b6/src/
// test/persistence/JsonTest.java


import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {

    protected void checkDrink(String name, Double price, String toppings, Drink drink) {
        assertEquals(name, drink.getName());
        assertEquals(price, drink.getPrice());
        assertEquals(toppings, drink.getToppings());
    }
}
