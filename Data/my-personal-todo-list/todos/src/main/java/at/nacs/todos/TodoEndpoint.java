package at.nacs.todos;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoEndpoint {
    private final ToDoManager toDoManager;

    @GetMapping
    List<Todo> getAll() {
        return toDoManager.findAll();
    }

    @GetMapping("/{id}")
    Optional<Todo> getById(@PathVariable String id) {
        return toDoManager.findMatch(id);
    }

    @PostMapping
    Todo postOne(@RequestBody Todo todo) {
        return toDoManager.postOne(todo);
    }

    @PutMapping("/{id}/done")
    Optional<Todo> putOne(@PathVariable String id) {
        return toDoManager.putOne(id);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        toDoManager.delete(id);
    }


}
