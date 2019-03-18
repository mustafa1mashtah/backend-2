package at.nacs.dutchman.domain;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Chest {

    @Value("${hidden.treasure}")
    private String treasure;

    public DeadMansChest getDeadManChest(){
        return new DeadMansChest(treasure);
    }
}
