package at.nacs.drhouseaccountancy.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private Kind kind;

    private String symptoms;
    private String diagnosis;
    private String provided;

    private double cost;
    private boolean paid;
    private LocalDateTime timestamp;

}
