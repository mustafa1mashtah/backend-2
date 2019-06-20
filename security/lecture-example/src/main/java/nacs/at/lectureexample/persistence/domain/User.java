package nacs.at.lectureexample.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name;

    @Column(unique = true)
    private String username;

    private String password;

    @ElementCollection(fetch = EAGER)
    private Set<String> authorities = new HashSet<>();
}
