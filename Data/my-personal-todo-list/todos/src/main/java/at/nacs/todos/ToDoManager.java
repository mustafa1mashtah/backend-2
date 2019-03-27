package at.nacs.todos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoManager {
    private final TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findMatch(String id) {
        return todoRepository.findById(id);
    }

    public Todo postOne(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> putOne(String id) {
        Optional<Todo> optionalTodo = findMatch(id);
        if (optionalTodo.isEmpty()) {
            return Optional.empty();
        }
        optionalTodo.get().setDone(true);
        return optionalTodo;
    }

    public void delete(String id) {
        todoRepository.deleteById(id);
    }
}
