package nacs.at.deadmentellnotales.view.controller;

import lombok.RequiredArgsConstructor;
import nacs.at.deadmentellnotales.view.model.Dutchman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final Dutchman dutchman;

    @GetMapping
    String page() {
        return "diary";
    }

    @PostMapping
    String set() {
        dutchman.setCursed(false);
        return "redirect:/";

    }

}
