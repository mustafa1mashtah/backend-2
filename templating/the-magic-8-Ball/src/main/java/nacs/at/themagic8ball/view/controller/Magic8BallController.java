package nacs.at.themagic8ball.view.controller;

import lombok.RequiredArgsConstructor;
import nacs.at.themagic8ball.view.model.MessageGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class Magic8BallController {
    private final MessageGenerator messageGenerator;

    @ModelAttribute("message")
    String message() {
        return messageGenerator.getMessage();
    }

    @GetMapping("/")
    String page() {
        return "magic-8-ball";
    }
}
