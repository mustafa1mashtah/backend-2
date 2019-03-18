package at.nacs.marathonserver.controller;

import at.nacs.marathonserver.presistence.Runner;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("runners")
public class Runners {

        @Setter
        @Getter
        private List<Runner>runners;

}
