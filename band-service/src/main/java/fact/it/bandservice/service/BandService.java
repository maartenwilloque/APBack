package fact.it.bandservice.service;

import fact.it.bandservice.dto.BandDto;
import fact.it.bandservice.dto.BandMemberDto;
import fact.it.bandservice.dto.BandMemberResponse;
import fact.it.bandservice.dto.BandResponse;
import fact.it.bandservice.model.Band;
import fact.it.bandservice.model.BandMember;
import fact.it.bandservice.repository.BandMemberRepository;
import fact.it.bandservice.repository.BandRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BandService {
    private final BandRepository bandRepository;
    private final BandMemberRepository bandMemberRepository;

    /*@PostConstruct
    public void init(){
        BandMember member = BandMember.builder()
                .firstName("Kurt")
                .lastName("Cobain")
                .nickName("Kurt")
                .instrument("Vocals, Guitar")
                .build();

        BandMember member2 = BandMember.builder()
                .firstName("Krist")
                .lastName("Novoselic")
                .nickName("Krist")
                .instrument("Bass")
                .build();
        BandMember member3 = BandMember.builder()
                .firstName("Dave")
                .lastName("Grohl")
                .nickName("Dave")
                .instrument("Drums")
                .build();
        Band band = Band.builder()
                .bandID(UUID.randomUUID().toString())
                .name("Nirvana")
                .nationality("American")
                .build();
        band.getBandMembers().add(member);
        band.getBandMembers().add(member2);
        band.getBandMembers().add(member3);
        bandRepository.save(band);
        bandMemberRepository.save(member);
        bandMemberRepository.save(member2);
        bandMemberRepository.save(member3);

    }*/

    public List<BandResponse> getBands(){
        List<Band> bands = bandRepository.findAll();
        return bands.stream().map(band -> new BandResponse(band.getBandID(),band.getName(),band.getNationality(),mapToBandMemberDto(band.getBandMembers()))).toList();
    }

    public BandResponse getBand(String Id){
        Band band = bandRepository.findById(Id).get();
        BandResponse bandResponse = new BandResponse();
        bandResponse.setBandId(band.getBandID());
        bandResponse.setName(band.getName());
        bandResponse.setNationality(band.getNationality());
        bandResponse.setMembers(mapToBandMemberDto(band.getBandMembers()));
        return bandResponse;
    }
    public List<BandMemberResponse> getBandMembers() {
        List<BandMember> bandMembers = bandMemberRepository.findAll();

        return bandMembers.stream().map(bandMember -> new BandMemberResponse(bandMember.getFirstName(),bandMember.getLastName(),bandMember.getNickName(),bandMember.getInstrument(),mapToBandDto(bandMember.getBand()))).toList();
    }

    public BandMemberResponse getBandMember(String Id){
        BandMember bandMember = bandMemberRepository.findById(Id).get();
        BandMemberResponse bandMemberResponse = new BandMemberResponse();
        bandMemberResponse.setFirstName(bandMember.getFirstName());
        bandMemberResponse.setLastName(bandMember.getLastName());
        bandMemberResponse.setNickName(bandMember.getNickName());
        bandMemberResponse.setBand(mapToBandDto(bandMember.getBand()));
        return bandMemberResponse;
    }



    private List<BandMemberDto> mapToBandMemberDto(List<BandMember> bandMembers){
        return bandMembers.stream().map(bandMember -> new BandMemberDto(
                bandMember.getFirstName(),
                bandMember.getLastName(),
                bandMember.getNickName(),
                bandMember.getInstrument()
        )).collect(Collectors.toList());
    }

    private BandDto mapToBandDto(Band band){
        BandDto bandDto = new BandDto();
        bandDto.setBandId(band.getBandID());
        bandDto.setName(band.getName());
        bandDto.setNationality(band.getNationality());
        return bandDto;
    }


}