package nacs.at.themorseencoderui.view.controller;

import lombok.RequiredArgsConstructor;
import nacs.at.themorseencoderui.logic.EncoderClient;
import nacs.at.themorseencoderui.view.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MorseEncoderUIController {
    private final EncoderClient encoderClient;

    @ModelAttribute("message")
    Message message() {
        return new Message();
    }

    @GetMapping
    String page() {
        return "morse-encoder-ui";
    }

    @PostMapping
    String post(@Valid Message message, BindingResult result, RedirectAttributesModelMap redirect) {
        if (result.hasErrors()) {
            return page();
        }
        redirect.addFlashAttribute("encoded", encoderClient.sendToEncoder(message));
        return "redirect:/";
    }
}
