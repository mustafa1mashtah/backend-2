package at.basketball.basketball;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component

public class Court {


    public BasketballTeam play(BasketballTeam player1, BasketballTeam player2) {
        Random random = new Random();
        List<BasketballTeam> Teams = Arrays.asList(player1, player2);
        Integer position = random.nextInt(Teams.size());
        return Teams.get(position);

    }
}
