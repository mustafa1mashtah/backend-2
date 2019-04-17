package nacs.at.mypersonaltodolistui.view.controller;

import lombok.RequiredArgsConstructor;
import nacs.at.mypersonaltodolistui.view.TodoClient;
import nacs.at.mypersonaltodolistui.view.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MyPersonalToDoListUIController {
    private final TodoClient client;

    @ModelAttribute("todos")
    List<Todo> todos() {
        return client.getAll();
    }

    @ModelAttribute("todo")
    Todo todo() {
        return new Todo();
    }

    @GetMapping
    String page() {
        return "my-personal-todo-list-ui";
    }

    @PostMapping
    String post(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return page();
        }
        client.save(todo);
        return "redirect:/";
    }

    @PostMapping("/done")
    String put(@RequestParam String id) {
        client.markAsDone(id);
        return "redirect:/";
    }
}
