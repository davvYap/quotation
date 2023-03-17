package sg.edu.nus.iss.quotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.quotation.service.QuotationService;

@RestController
@RequestMapping(path = "/api")
public class QuotationRestController {
    @Autowired
    private QuotationService quoSvc;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getQuotation(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String price,
            @RequestParam(required = true) String username) {

        ResponseEntity<String> res = quoSvc.postQuotation(name, price, username);
        System.out.println("Response >>>>> " + res);
        return res;
    }
}
