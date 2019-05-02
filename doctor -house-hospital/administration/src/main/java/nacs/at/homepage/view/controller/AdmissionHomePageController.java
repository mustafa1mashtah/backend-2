package nacs.at.homepage.view.controller;

import lombok.RequiredArgsConstructor;
import nacs.at.homepage.comunication.AdmissionClient;
import nacs.at.homepage.view.model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AdmissionHomePageController {
    private final AdmissionClient admissionClient;

    @ModelAttribute("patient")
    Patient patient() {
        return new Patient();
    }

    @GetMapping
    String page() {
        return "admission-home-page";
    }

    @PostMapping
    String post(@Valid Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return page();
        }
        admissionClient.sent(patient);
        return "redirect:/";
    }
}
