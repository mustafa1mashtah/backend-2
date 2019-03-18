package at.nacs.morse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MorseServer {


    private final Translator translator;


    public String encodedLetter(String letter) {
        return translator.getMorseCode().getOrDefault(letter.toUpperCase(), "NOT SUPPORTED");
    }
}
