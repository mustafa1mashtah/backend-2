package at.nacs.todos;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("dataset")
class TodoEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Setter
    Todo todo;

    @SpyBean
    ToDoManager toDoManager;

    @MockBean
    TodoRepository todoRepository;

    private String url = "/todos";

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, Todo[].class);

        verify(toDoManager).findAll();
    }

    @Test
    void getById() {
        testRestTemplate.getForObject(url + "/mustafa", Todo.class);

        verify(toDoManager).findMatch(anyString());
    }

    @Test
    void postOne() {
        testRestTemplate.postForObject(url + "", todo, Todo.class);

        verify(toDoManager).postOne(any());
    }

    @Test
    void putOne() {
        testRestTemplate.put(url + "/mustafa/done", Optional.class);

        verify(toDoManager).putOne(anyString());
    }

    @Test
    void deleteOne() {
        testRestTemplate.delete(url + "/mustafa", void.class);

        verify(toDoManager).delete(anyString());
    }
}