package at.basketball.basketball;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BasketballTournament {

    private final BasketballTeams basketballTeams;
    private final Court court;

    public void start() {
        while (basketballTeams.getBasketballTeams().size() > 1) {
            BasketballTeam firstTeam = basketballTeams.getBasketballTeams().poll();
            BasketballTeam secondTeam = basketballTeams.getBasketballTeams().poll();
            System.out.println(firstTeam.getName() + " vs " + secondTeam.getName());
            BasketballTeam winner = court.play(firstTeam, secondTeam);
            System.out.println("And " + winner.getName() + " wins this match!");
            basketballTeams.getBasketballTeams().add(winner);


        }
        BasketballTeam champion = basketballTeams.getBasketballTeams().get(0);
        System.out.println("The tournament's winning team is " + champion.getName() + " !!");


    }


}
