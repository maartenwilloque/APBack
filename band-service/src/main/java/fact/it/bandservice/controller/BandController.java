package fact.it.bandservice.controller;

import fact.it.bandservice.dto.BandMemberResponse;
import fact.it.bandservice.dto.BandResponse;
import fact.it.bandservice.service.BandService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BandController {
    private final BandService bandService;
    @GetMapping("/bands")
    @ResponseStatus(HttpStatus.OK)
    public List<BandResponse> getBands(){
        return bandService.getBands();
    }

    @GetMapping("/band/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public BandResponse getBand(@PathVariable("Id") String bandId) {
        return  bandService.getBand(bandId);
    }

    @GetMapping("/bandmembers")
    @ResponseStatus(HttpStatus.OK)
    public List<BandMemberResponse> getBandMembers(){
        return bandService.getBandMembers();
    }

    @GetMapping("/bandmember/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public BandMemberResponse getBandMember(@PathVariable("Id") String bandMemberId){
        return  bandService.getBandMember(bandMemberId);
    }


    }

