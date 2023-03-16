package sg.edu.nus.iss.quotation.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Item {
    private String name;
    private Double price;
    private String username;
    private String id;
    private String dt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public static Item createFromJson(JsonObject jsObj) {
        Item item = new Item();
        item.name = jsObj.getString("name");
        JsonNumber jsNum = jsObj.getJsonNumber("price");
        item.price = jsNum.doubleValue();
        item.username = jsObj.getString("username");
        item.id = jsObj.getString("id");
        item.dt = jsObj.getString("dt");
        return item;
    }
}
