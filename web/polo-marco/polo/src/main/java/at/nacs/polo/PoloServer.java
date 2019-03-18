package at.nacs.polo;
import org.springframework.stereotype.Service;



@Service
public class PoloServer {

    public String getResponse(String message) {
        if (message.equals("Marco")) {
            return "Polo";
        }
        return "What?";
    }
}
