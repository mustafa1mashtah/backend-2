package nacs.at.homepage.view;

import lombok.RequiredArgsConstructor;
import nacs.at.homepage.view.model.Invoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceClient {
    private final RestTemplate restTemplate;

    @Value("${invoices.url}")
    private String url;

    public List<Invoice> getAllInvoices() {
        Invoice[] invoicesArray = restTemplate.getForObject(url, Invoice[].class);
        return Arrays.asList(invoicesArray);
    }

    public void markAsPaid(Long id) {
        restTemplate.put(url +"/"+ id + "/paid", void.class);
    }
}
