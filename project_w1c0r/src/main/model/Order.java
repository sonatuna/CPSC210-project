package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;


public class Order implements Writable {
    private final String customerName;
    private final ArrayList<Drink> drinks;
    private double totalPrice;

    // MODIFIES: this
    // EFFECTS: instantiates a new order with given string as name, empty drinks list, price ($0)
    public Order(String customerName) {
        this.customerName = customerName;
        this.drinks = new ArrayList<>();
        this.totalPrice = 0;
        EventLog.getInstance().logEvent(new Event("New order created."));
    }

    // EFFECTS: returns name of order customer
    public String getCustomerName() {
        return this.customerName;
    }

    // EFFECTS: returns list of drinks in order
    public ArrayList<Drink> getOrderDrinks() {
        return this.drinks;
    }

    // EFFECTS: returns total price of cart
    public double getTotalPrice() {
        return this.drinks.stream()
                .map((d) -> d.getPrice())
                .reduce(0.0, (acc, d) -> acc + d);
    }

    // MODIFIES: this
    // EFFECTS: adds drink to order
    public void addDrink(Drink drink) {
        this.drinks.add(drink);
        this.totalPrice = this.totalPrice + drink.getPrice();
        EventLog.getInstance().logEvent(new Event("Drink added to order."));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("customerName", this.customerName);
        json.put("drinks", drinksToJson());
        json.put("totalPrice", this.totalPrice);
        return json;
    }

    // EFFECTS: returns drinks in order as a JSON array
    private JSONArray drinksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Drink d : drinks) {
            jsonArray.put(d.toJson());
        }

        return jsonArray;
    }

    public void addPrice(double price) {
        this.totalPrice = price;
        EventLog.getInstance().logEvent(new Event("Price is added to total;"));
    }
}
