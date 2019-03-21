package at.nacs.trickster;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@RequiredArgsConstructor
public class Urls {

    @Value("${urls}")
    private final List<String> urls;


}
