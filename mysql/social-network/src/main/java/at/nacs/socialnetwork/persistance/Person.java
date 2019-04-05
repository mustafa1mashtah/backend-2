package at.nacs.socialnetwork.persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@EqualsAndHashCode(exclude = "friends")
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;


    @ManyToMany(fetch = EAGER)
    @JsonIgnore
    private List<Person> friends = new ArrayList<>();

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name +
                '}';
    }
}
