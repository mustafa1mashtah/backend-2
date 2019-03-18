package at.nacs.yaml;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaysOfWeek {

    @Getter
    @Value("${days.day-of-week}")

    private List<String> daysOfWeek;
}
