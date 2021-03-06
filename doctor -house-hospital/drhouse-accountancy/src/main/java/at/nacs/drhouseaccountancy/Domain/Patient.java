package at.nacs.drhouseaccountancy.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    @Column(unique = true)
    private String name;
}
