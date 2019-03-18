package at.basketball.basketball;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedList;


@Component
@ConfigurationProperties("teams")

public class BasketballTeams {

    @Setter
    @Getter
    private LinkedList<BasketballTeam> basketballTeams;
}
