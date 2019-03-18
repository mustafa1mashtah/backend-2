package at.nacs.cinema;

import org.springframework.stereotype.Component;

@Component
public class InsertName {

    public String insert(Template template, String name) {

        return template.getText().replace("{name}", name);
    }
}
