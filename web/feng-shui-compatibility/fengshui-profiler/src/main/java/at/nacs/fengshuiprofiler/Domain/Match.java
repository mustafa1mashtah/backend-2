package at.nacs.fengshuiprofiler.Domain;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Match {

    private Profile profile1;
    private Profile profile2;
    private String signCompatibility;
    private String loveCompatibility;
}
