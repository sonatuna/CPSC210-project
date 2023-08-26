package model;

import org.json.JSONObject;
import persistence.Writable;

import java.lang.String;
import java.util.ArrayList;
import java.util.Objects;

public class Drink implements Writable {
    private final String name;
    private double price;
    private String size;
    private String toppings;
    private String sugarLevel;
    private String iceLevel;


    // MODIFIES: this
    // EFFECTS: instantiates a new drink with given name, given price ($), empty list of toppings, and
    //          default cup size, sugar and ice levels
    public Drink(String name, double price, String toppings) {
        this.name = name;
        this.price = price;
        this.size = "Small";
        this.toppings = toppings;
        this.sugarLevel = "100%";
        this.iceLevel = "Regular";
    }

    // EFFECTS: returns name of drink
    public String getName() {
        return this.name;
    }

    // EFFECTS: returns price of drink
    public double getPrice() {
        return this.price;
    }

    // EFFECTS: returns list of toppings of drink
    public String getToppings() {
        return this.toppings;
    }

    // EFFECTS: returns size of drink
    public String getSize() {
        return this.size;

    }

    // EFFEFCTS: returns sugar level of drink
    public String getSugarLevel() {
        return this.sugarLevel;
    }

    // EFFECTS: returns ice level of drink
    public String getIceLevel() {
        return this.iceLevel;
    }

    // REQUIRES: size is either the string "Medium" or "Large"
    // MODIFIES: this
    // EFFECTS: changes cup size to size. Also increases price by 50 cents
    public void upgradeSize(String size) {
        this.size = size;
        this.price += 0.5;
        EventLog.getInstance().logEvent(new Event("Cup size changed."));
    }

    // REQUIRES: sugar level is  either "100%", "75%", "50%", "25%", or "0%"
    // MODIFIES: this
    // EFFECTS: changes sugar level to sugarLevel
    public void changeSugarLevel(String sugarLevel) {
//        ArrayList<String> sugarLevels = new ArrayList<>();
//        sugarLevels.add("100%");
//        sugarLevels.add("75%");
//        sugarLevels.add("50%");
//        sugarLevels.add("25%");
//        sugarLevels.add("0%");

        this.sugarLevel = sugarLevel;
        EventLog.getInstance().logEvent(new Event("Sugar level changed."));
    }

    // REQUIRES: ice level must be either "Medium", "Light", or "None"
    // MODIFIES: this
    // EFFECTS: changes ice level to iceLevel
    public void changeIceLevel(String iceLevel) {
//        ArrayList<String> iceLevels = new ArrayList<>();
//        iceLevels.add("Medium");
//        iceLevels.add("Light");
//        iceLevels.add("None");

        this.iceLevel = iceLevel;
        EventLog.getInstance().logEvent(new Event("Ice level changed."));

    }

    // REQUIRES: topping must be either "Pearls", "Coconut Jelly", "Grass Jelly", or "Sago"
    // MODIFIES: this
    // EFFECTS: adds given topping to the drink. Also increases price by 25 cents
    public void addTopping(String topping) {
        if (this.toppings != "") {
            this.toppings += ",";
        }
        this.toppings += topping;
        this.price += 0.25;
        EventLog.getInstance().logEvent(new Event("Topping added."));
    }

    // EFFECTS: compares this and given object
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Drink drink = (Drink) o;
        return Double.compare(drink.price, price) == 0
                && Objects.equals(name, drink.name)
                && Objects.equals(size, drink.size)
                && Objects.equals(toppings, drink.toppings)
                && Objects.equals(sugarLevel, drink.sugarLevel)
                && Objects.equals(iceLevel, drink.iceLevel);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", this.name);
        json.put("price", this.price);
        json.put("size", this.size);
        json.put("toppings", this.toppings);
        json.put("sugarLevel", this.sugarLevel);
        json.put("iceLevel", this.iceLevel);
        return json;
    }

}





