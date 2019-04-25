package nacs.at.deadmentellnotales.view.controller;

import lombok.RequiredArgsConstructor;
import nacs.at.deadmentellnotales.view.model.Dutchman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final Dutchman dutchman;

    @ModelAttribute("dutchman")
    Dutchman dutchman() {
        return dutchman;
    }

    @GetMapping
    String page() {
        return "home";
    }
}
