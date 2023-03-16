package sg.edu.nus.iss.quotation.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Quotation {
    private String id;
    private List<Item> items = new LinkedList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static Quotation createFromJSON(String json) throws IOException {
        Quotation quotation = new Quotation();
        try (InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader jr = Json.createReader(is);
            JsonObject jsObj = jr.readObject();
            quotation.id = jsObj.getString("quotation_id");

            JsonArray jsArr = jsObj.getJsonArray("items");
            List<Item> list = new LinkedList<>();
            for (int i = 0; i < jsArr.size(); i++) {
                JsonObject js = jsArr.getJsonObject(i);
                Item listItem = Item.createFromJson(js);
                list.add(listItem);
            }
            quotation.setItems(list);
        }
        return quotation;
    }

}
