package at.nacs.fengshuiprofiler.Domain;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Data
public class Profile {
    private LocalDate birthday;
    private String sign;
}
