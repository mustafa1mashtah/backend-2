package nacs.at.mypersonaltodolistui.view;

import lombok.RequiredArgsConstructor;
import nacs.at.mypersonaltodolistui.view.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoClient {
    private final RestTemplate restTemplate;
    private final String url = "http://localhost:9000/todos";

    public List<Todo> getAll() {
        return Arrays.asList(restTemplate.getForObject(url, Todo[].class));
    }

    public Todo save(Todo todo) {
        return restTemplate.postForObject(url, todo, Todo.class);

    }

    public void markAsDone(String id) {
        restTemplate.put(url+"/" + id + "/done", Todo.class);
    }


}
