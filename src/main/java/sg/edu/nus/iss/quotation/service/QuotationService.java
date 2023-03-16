package sg.edu.nus.iss.quotation.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.edu.nus.iss.quotation.model.Quotation;

@Service
public class QuotationService {

    public Optional<Quotation> getQuotation() throws IOException {
        String url = "https://quotation-production.up.railway.app/quotation";

        RequestEntity req = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .build();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> res = template.exchange(req, String.class);
        Quotation quotation = Quotation.createFromJSON(res.getBody());
        if (quotation != null) {
            return Optional.of(quotation);
        }
        return Optional.empty();
    }
}
