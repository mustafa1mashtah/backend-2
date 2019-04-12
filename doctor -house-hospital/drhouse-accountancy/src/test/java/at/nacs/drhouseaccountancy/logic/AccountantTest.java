package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.Domain.Invoice;
import at.nacs.drhouseaccountancy.Domain.InvoiceRepository;
import at.nacs.drhouseaccountancy.Domain.Kind;
import at.nacs.drhouseaccountancy.Domain.PatientRepository;
import at.nacs.drhouseaccountancy.Domain.PatientDTO;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("info1")
class AccountantTest {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    Accountant accountant;

    @Setter
    PatientDTO patientDTO1;

    @Setter
    PatientDTO patientDTO2;

    @BeforeEach
    void before() {
        patientRepository.deleteAll();
        invoiceRepository.deleteAll();
    }

    @Test
    void getAll() {
        accountant.postOne(patientDTO1);
        accountant.postOne(patientDTO2);
        List<Invoice> invoices = accountant.getAll();
        System.out.println(invoices);
        Assertions.assertThat(invoices.get(0).getKind()).isEqualTo(Kind.TREATMENT);
        Assertions.assertThat(invoices.get(1).getKind()).isEqualTo(Kind.MEDICINE);
    }

    @Test
    void putPaid() {
        accountant.postOne(patientDTO1);
        List<Invoice> invoices = invoiceRepository.findAll();
        Invoice invoice = invoices.get(0);
        Long id = invoice.getId();
        
        accountant.putPaid(id);
        List<Invoice> invoices1 = invoiceRepository.findAll();
        Invoice invoice1 = invoices1.get(0);

        Assertions.assertThat(invoice1.isPaid()).isTrue();
    }
}