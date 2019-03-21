package at.nacs.trickster;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class Trickster {
    private final RestTemplate restTemplate;
    private final Urls urls;
    private  Random random=new Random();

    public void play(){
        remove();
        putCoinInOneCup();
    }

    private void remove() {
        urls.getUrls().stream()
                .forEach(e -> restTemplate.delete(e));
    }

    private void putCoinInOneCup() {

        int position = random.nextInt(urls.getUrls().size());
        String url = urls.getUrls().get(position);
        restTemplate.put(url,Void.class);
    }

    public Boolean choose(Integer number) {
        String url = urls.getUrls().get(number);
        return restTemplate.getForObject(url, Boolean.class);
    }
}
