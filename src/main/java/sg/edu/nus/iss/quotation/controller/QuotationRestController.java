package sg.edu.nus.iss.quotation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path = "/api")
public class QuotationRestController {
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getQuotation(@RequestParam(required = true) String name,
            @RequestParam(required = true) String price, @RequestParam(required = true) String username) {
        JsonObject jsObj = Json.createObjectBuilder()
                .add("name", name)
                .add("price", price)
                .add("username", username)
                .build();
        String url = "https://quotation-production.up.railway.app/quotation";
        RequestEntity req = RequestEntity.post(url).contentType(MediaType.APPLICATION_JSON).body(jsObj.toString(),
                String.class);

        RestTemplate template = new RestTemplate();

        ResponseEntity<String> res = template.exchange(req, String.class);

        return res;
    }
}
