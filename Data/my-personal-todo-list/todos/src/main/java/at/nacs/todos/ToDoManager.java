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

    public void markAsDone(String id) {
        Optional<Todo> oTodo = findMatch(id);
        if (oTodo.isEmpty()) {
            return;
        }
        Todo todo = oTodo.get();
        todo.setDone(true);
        todoRepository.save(todo);
    }

    public void delete(String id) {
        todoRepository.deleteById(id);
    }
}
