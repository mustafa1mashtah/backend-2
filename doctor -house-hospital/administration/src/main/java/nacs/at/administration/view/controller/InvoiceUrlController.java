package nacs.at.administration.view.controller;

import lombok.RequiredArgsConstructor;
import nacs.at.administration.comunication.InvoiceClient;
import nacs.at.administration.view.model.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceUrlController {
    private final InvoiceClient invoiceClient;

    @ModelAttribute("invoices")
    List<Invoice> invoices() {
        return invoiceClient.getAllInvoices();
    }

    @ModelAttribute("invoice")
    Invoice invoice() {
        return new Invoice();
    }

    @GetMapping
    String page() {
        return "invoice-url";
    }

    @PostMapping("/paid")
    String put(@RequestParam Long id) {
        invoiceClient.markAsPaid(id);
        return "redirect:/invoices";
    }
}
