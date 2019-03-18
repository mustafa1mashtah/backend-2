package at.nacs.marathonserver.controller;

import at.nacs.marathonserver.presistence.Runner;
import at.nacs.marathonserver.presistence.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/winner")
@RequiredArgsConstructor
public class WinnerEndpoint {

    private final RunnerRepository runnerRepository;

    @GetMapping
    Runner get() {
        return runnerRepository.findWinner()
                .orElse(null);

    }
}
