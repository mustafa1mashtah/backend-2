package at.basketball.basketball;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Screen {
    private final BasketballTeams basketballTeams;
    private final BasketballTournament basketballTournament;


    public void display() {
        System.out.println("Welcome to the street basketball tournament!\n" +
                "These are the teams who signed up:\n");

        basketballTeams.getBasketballTeams().stream()
                .forEach(e -> System.out.println("Team: " + e.getName() + "| Players: " + e.getPlayerNames()));
        System.out.println("-------------------------------------");
        basketballTournament.start();
    }
}
