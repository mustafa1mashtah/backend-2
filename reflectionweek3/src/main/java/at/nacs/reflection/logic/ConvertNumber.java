package at.nacs.reflection.logic;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ConvertNumber {

    public List<Integer> convert(Integer price) {
        return Arrays.asList(price.toString().split("")).stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}
