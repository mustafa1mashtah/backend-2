package at.nacs.reflection.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Transformer {
    private final Map<Integer, String> moves;
    private final ConvertNumber convertNumber;

    public List<String> transform(Integer price) {
        List<Integer> digits = convertNumber.convert(price);
        return digits.stream()
                .filter(moves::containsKey)
                .map(moves::get)
                .collect(Collectors.toList());
    }
}
