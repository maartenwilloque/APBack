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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BandService {
    private final BandRepository bandRepository;
    private final BandMemberRepository bandMemberRepository;

    @PostConstruct
    public void init(){
        if(bandRepository.count() <= 0) {
            Band nirvana = new Band();
            nirvana.setBandID("NIRVANA");
            nirvana.setName("Nirvana");
            nirvana.setNationality("American");
            nirvana.setBandMemberList(new ArrayList<>());

            // Create band members for Nirvana
            BandMember member1 = new BandMember();
            member1.setFirstName("Kurt");
            member1.setLastName("Cobain");
            member1.setNickName("Kurt");
            member1.setInstrument("Vocals, Guitar");

            BandMember member2 = new BandMember();
            member2.setFirstName("Krist");
            member2.setLastName("Novoselic");
            member2.setNickName("Krist");
            member2.setInstrument("Bass");

            BandMember member3 = new BandMember();
            member3.setFirstName("Dave");
            member3.setLastName("Grohl");
            member3.setNickName("Dave");
            member3.setInstrument("Drums");

            // Add band members to the Nirvana band
            nirvana.getBandMemberList().add(member1);
            nirvana.getBandMemberList().add(member2);
            nirvana.getBandMemberList().add(member3);

            // Save the band and its members to the database
            bandRepository.save(nirvana);
            bandMemberRepository.save(member1);
            bandMemberRepository.save(member2);
            bandMemberRepository.save(member3);

            Band live = new Band();
            live.setBandID("LIVE");
            live.setName("Live");
            live.setNationality("American");
            live.setBandMemberList(new ArrayList<>());

            BandMember member4 = new BandMember();
            member4.setFirstName("Ed");
            member4.setLastName("Kowalczyk");
            member4.setNickName("Ed");
            member4.setInstrument("Vocals");

            BandMember member5 = new BandMember();
            member5.setFirstName("Chad");
            member5.setLastName("Taylor");
            member5.setNickName("Chad");
            member5.setInstrument("Guitar");

            BandMember member6 = new BandMember();
            member6.setFirstName("Chad");
            member6.setLastName("Gracey");
            member6.setNickName("Chad");
            member6.setInstrument("Drums");

            BandMember member7 = new BandMember();
            member7.setFirstName("Patrick");
            member7.setLastName("Dahlheimer");
            member7.setNickName("Patrick");
            member7.setInstrument("Bass");

            live.getBandMemberList().add(member4);
            live.getBandMemberList().add(member5);
            live.getBandMemberList().add(member6);
            live.getBandMemberList().add(member7);

            bandRepository.save(live);
            bandMemberRepository.save(member4);
            bandMemberRepository.save(member5);
            bandMemberRepository.save(member6);
            bandMemberRepository.save(member7);

            Band metallica = new Band();
            metallica.setBandID("METALLICA");
            metallica.setName("Metallica");
            metallica.setNationality("American");
            metallica.setBandMemberList(new ArrayList<>());

            // Create band members for Nirvana
            BandMember member8 = new BandMember();
            member8.setFirstName("James");
            member8.setLastName("Hetfield");
            member8.setNickName("James");
            member8.setInstrument("Vocals, Guitar");

            BandMember member9 = new BandMember();
            member9.setFirstName("Lars");
            member9.setLastName("Ulrich");
            member9.setNickName("Lars");
            member9.setInstrument("Drums");

            BandMember member10 = new BandMember();
            member10.setFirstName("Kirk");
            member10.setLastName("Hammet");
            member10.setNickName("Kirk");
            member10.setInstrument("Guitar");

            BandMember member11 = new BandMember();
            member11.setFirstName("Robert");
            member11.setLastName("Truijllo");
            member11.setNickName("Robert");
            member11.setInstrument("Bass");

            // Add band members to the Nirvana band
            metallica.getBandMemberList().add(member8);
            metallica.getBandMemberList().add(member9);
            metallica.getBandMemberList().add(member10);
            metallica.getBandMemberList().add(member11);

            // Save the band and its members to the database
            bandRepository.save(metallica);
            bandMemberRepository.save(member8);
            bandMemberRepository.save(member9);
            bandMemberRepository.save(member10);
            bandMemberRepository.save(member11);

// Create a Band object and set its properties
            Band fooFighters = new Band();
            fooFighters.setBandID("FOOFIGHTERS");
            fooFighters.setName("Foo Fighters");
            fooFighters.setNationality("American");
            fooFighters.setBandMemberList(new ArrayList<>());

// Create BandMember objects for the band
            BandMember member12 = new BandMember();
            member1.setFirstName("Dave");
            member1.setLastName("Grohl");
            member1.setNickName("Dave");
            member1.setInstrument("Vocals, Guitar, Drums");

            BandMember member13 = new BandMember();
            member2.setFirstName("Nate");
            member2.setLastName("Mendel");
            member2.setNickName("Nate");
            member2.setInstrument("Bass");

            BandMember member14 = new BandMember();
            member3.setFirstName("Chris");
            member3.setLastName("Shiflett");
            member3.setNickName("Chris");
            member3.setInstrument("Guitar");

            BandMember member15 = new BandMember();
            member4.setFirstName("Rami");
            member4.setLastName("Jaffee");
            member4.setNickName("Rami");
            member4.setInstrument("Keyboards");

// Add BandMember objects to the Foo Fighters' member list
            fooFighters.getBandMemberList().add(member12);
            fooFighters.getBandMemberList().add(member13);
            fooFighters.getBandMemberList().add(member14);
            fooFighters.getBandMemberList().add(member15);

// Save the Foo Fighters' Band object to the bandRepository
            bandRepository.save(fooFighters);

// Save each BandMember object to the bandMemberRepository
            bandMemberRepository.save(member12);
            bandMemberRepository.save(member13);
            bandMemberRepository.save(member14);
            bandMemberRepository.save(member15);

            Band redHotChiliPeppers = new Band();
            redHotChiliPeppers.setBandID("REDHOTCHILIPEPPERS");
            redHotChiliPeppers.setName("Red Hot Chili Peppers");
            redHotChiliPeppers.setNationality("American");
            redHotChiliPeppers.setBandMemberList(new ArrayList<>());

// Create BandMember objects for the band
            BandMember member16 = new BandMember();
            member1.setFirstName("Anthony");
            member1.setLastName("Kiedis");
            member1.setNickName("Anthony");
            member1.setInstrument("Vocals");

            BandMember member17 = new BandMember();
            member2.setFirstName("Flea");
            member2.setLastName("Balzary");
            member2.setNickName("Flea");
            member2.setInstrument("Bass");

            BandMember member18 = new BandMember();
            member3.setFirstName("John");
            member3.setLastName("Frusciante");
            member3.setNickName("John");
            member3.setInstrument("Guitar");

            BandMember member19 = new BandMember();
            member4.setFirstName("Chad");
            member4.setLastName("Smith");
            member4.setNickName("Chad");
            member4.setInstrument("Drums");

// Add BandMember objects to the Red Hot Chili Peppers' member list
            redHotChiliPeppers.getBandMemberList().add(member16);
            redHotChiliPeppers.getBandMemberList().add(member17);
            redHotChiliPeppers.getBandMemberList().add(member18);
            redHotChiliPeppers.getBandMemberList().add(member19);

// Save the Red Hot Chili Peppers' Band object to the bandRepository
            bandRepository.save(redHotChiliPeppers);

// Save each BandMember object to the bandMemberRepository
            bandMemberRepository.save(member16);
            bandMemberRepository.save(member17);
            bandMemberRepository.save(member18);
            bandMemberRepository.save(member19);
        }
    }

    public List<BandResponse> getBands(){
        List<Band> bands = bandRepository.findAll();
        return bands.stream().map(band -> new BandResponse(band.getBandID(),band.getName(),band.getNationality(),mapToBandMemberDto(band.getBandMemberList()))).toList();
    }

    public BandResponse getBand(String Id){
        Band band = bandRepository.findBandByBandID(Id);
        BandResponse bandResponse = new BandResponse();
        bandResponse.setBandId(band.getBandID());
        bandResponse.setName(band.getName());
        bandResponse.setNationality(band.getNationality());
        bandResponse.setMembers(mapToBandMemberDto(band.getBandMemberList()));
        return bandResponse;
    }
    public List<BandMemberResponse> getBandMembers() {
        List<BandMember> bandMembers = bandMemberRepository.findAll();

        return bandMembers.stream().map(bandMember -> new BandMemberResponse(bandMember.getFirstName(),bandMember.getLastName(),bandMember.getNickName(),bandMember.getInstrument())).toList();
    }

    public BandMemberResponse getBandMember(String Id){
        BandMember bandMember = bandMemberRepository.findById(Id).get();
        BandMemberResponse bandMemberResponse = new BandMemberResponse();
        bandMemberResponse.setFirstName(bandMember.getFirstName());
        bandMemberResponse.setLastName(bandMember.getLastName());
        bandMemberResponse.setNickName(bandMember.getNickName());
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