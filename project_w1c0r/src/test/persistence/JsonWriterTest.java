package persistence;


import model.Drink;
import model.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

// this class contains code based on the JsonWriterTest class in the JsonSerializationProject
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/d31979d8a993d63c3a8c13c8add7f9d1753777b6/src/
// test/persistence/JsonWriterTest.java


import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Order testOrder = new Order("Talia");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyOrder() {
        try {
            Order order = new Order("Julia");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyOrder.json");
            writer.open();
            writer.write(order);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyOrder.json");
            order = reader.read();
            assertEquals("Julia", order.getCustomerName());
            assertEquals(0, order.getOrderDrinks().size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Order order = new Order("Barry");
            order.addDrink(new Drink("Brown Sugar Boba", 5.0, "Pearls"));
            order.addDrink(new Drink("Taro Boba", 6.5, "Sago"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralOrder.json");
            writer.open();
            writer.write(order);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralOrder.json");
            order = reader.read();
            assertEquals("Barry", order.getCustomerName());
            ArrayList<Drink> drinks = order.getOrderDrinks();
            assertEquals(2, drinks.size());
            checkDrink("Brown Sugar Boba", 5.0, "Pearls", drinks.get(0));
            checkDrink("Taro Boba", 6.5, "Sago", drinks.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
