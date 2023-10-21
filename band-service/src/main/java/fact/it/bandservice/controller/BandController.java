package fact.it.bandservice.controller;

import fact.it.bandservice.repository.BandMemberRepository;
import fact.it.bandservice.repository.BandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BandController {
    private final BandRepository bandRepository;
    private final BandMemberRepository bandMemberRepository;

    
}
