package nacs.at.homepage.comunication;

import lombok.RequiredArgsConstructor;
import nacs.at.homepage.view.model.Invoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InvoiceClient {
    private final RestTemplate restTemplate;

    @Value("${invoices.url}")
    private String invoicesUrl;

    @Value("${invoices.paid.url}")
    private String paidUrl;

    public List<Invoice> getAllInvoices() {
        Invoice[] invoicesArray = restTemplate.getForObject(invoicesUrl, Invoice[].class);
        return Arrays.asList(invoicesArray);
    }

    public void markAsPaid(Long id) {
        restTemplate.put(paidUrl, null, Map.of("id", id));
    }
}
