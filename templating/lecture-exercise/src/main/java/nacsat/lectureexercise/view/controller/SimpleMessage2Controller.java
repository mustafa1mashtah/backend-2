package nacsat.lectureexercise.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message/simple/2")
public class SimpleMessage2Controller {
    @GetMapping
    String page(Model model) {
        model.addAttribute("message", "message from the atribute of the controller");
        return "messages/simple-message2";
    }
}
