package nacsat.lectureexercise.view.controller;

import nacsat.lectureexercise.view.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message/model")
public class ModelMessageController {
    @ModelAttribute("message")
    Message message(){
        return Message.builder()
                .text("Message from the View Controller's Model")
                .build();

    }
    @GetMapping
    String page(){
        return "messages/model-message";
    }
}
