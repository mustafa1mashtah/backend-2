package at.nacs.todos;

import lombok.Getter;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class ToDoManagerTest {
    @Autowired
    TodoRepository repository;

    @Autowired
    ToDoManager manager;

    @Setter
    List<Todo> todos;

    @Setter
    @Getter
    Todo todo;

    @BeforeEach
    void before() {
        repository.saveAll(todos);
    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }

    @Test
    void findAll() {
        List<Todo> actual = manager.findAll();

        Assertions.assertThat(actual.get(0).getId()).isNotBlank();

        Assertions.assertThat(actual.size()).isEqualTo(3);
    }

    @Test
    void findMatch() {
        Todo todo = todos.get(0);
        String id = todo.getId();
        Optional<Todo> match = manager.findMatch(id);

        Assertions.assertThat(match.get()).isEqualTo(todo);
    }

    @Test
    void postOne() {
        manager.postOne(todo);
        int size = manager.findAll().size();

        Assertions.assertThat(size).isEqualTo(4);
    }

    @Test
    void putOne() {
        Todo todo = manager.findAll().get(0);
        String id = todo.getId();
        manager.markAsDone(id);
        Optional<Todo> actual = repository.findById(id);

        Assertions.assertThat(actual.get().isDone()).isTrue();
    }

    @Test
    void delete() {
        String id = manager.findAll().get(0).getId();
        manager.delete(id);
        List<Todo> actual = manager.findAll();

        Assertions.assertThat(actual.size()).isEqualTo(2);
    }
}