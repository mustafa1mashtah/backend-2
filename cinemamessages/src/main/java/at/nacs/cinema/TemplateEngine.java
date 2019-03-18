package at.nacs.cinema;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TemplateEngine {

    private final TemplatesLoader templatesLoader;

    public String chooesTemplate(String name) {
        return templatesLoader.getTemplates().stream()
                .filter(e -> name.contains(e.getType()))
                .map(e -> e.getText())
                .map(e -> e.replace("{name}", name))
                .findFirst()
                .orElse("Invalid");


    }


}
