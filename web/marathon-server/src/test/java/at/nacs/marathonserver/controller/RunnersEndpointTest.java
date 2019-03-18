package at.nacs.marathonserver.controller;

import at.nacs.marathonserver.presistence.Runner;
import at.nacs.marathonserver.presistence.RunnerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.Duration;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class RunnersEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    RunnerRepository runnerRepository;

    @Autowired
    Runners runners;


    String url = "/runners";

    @Test
    void get() {

        Runner runner1 = new Runner("Mike", Duration.parse("PT1H10M"));
        Runner runner2 = new Runner("John", Duration.parse("PT1H15M"));

        runnerRepository.add(runner1);
        runnerRepository.add(runner2);


        Runner[] actual = testRestTemplate.getForObject(url, Runner[].class);
        Assertions.assertThat(actual).contains(runner1);
    }

    @Test
    void add() {
        Runner runner1 = new Runner("Mike", Duration.parse("PT1H10M"));
        Runner actual = testRestTemplate.postForObject(url, runner1, Runner.class);

        Assertions.assertThat(actual).isEqualTo(runner1);


    }
}