package nacs.at.homepage.view.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String symptoms;
}
