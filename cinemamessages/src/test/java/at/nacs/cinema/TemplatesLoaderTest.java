package at.nacs.cinema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplatesLoaderTest {
    @Autowired
    TemplatesLoader templatesLoader;

    @Test
    void getTemplates() {
        System.out.println(templatesLoader.getTemplates());
    }
}