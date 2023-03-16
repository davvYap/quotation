package sg.edu.nus.iss.quotation.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.quotation.model.Quotation;
import sg.edu.nus.iss.quotation.service.QuotationService;

@Controller
@RequestMapping("/quotations")
public class QuotationController {

    @Autowired
    private QuotationService quoSvc;

    @GetMapping
    public String postQuotation(Model model) throws IOException {
        Quotation quotation = quoSvc.getQuotation().get();
        model.addAttribute("quotation", quotation);
        model.addAttribute("items", quotation.getItems());
        return "quotation";
    }
}
