package com.buchclubapp.buchclub_app.club;


import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    ModelMapper modelMapper;

    public Club convertToEntity(ClubDto clubDto){
        return modelMapper.map(clubDto, Club.class);
    }

    public Club findClubById(Long id){
        return clubRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Club not found with id:" + id));
    }

    public Club addClub(Club newClub){
       return clubRepository.save(newClub);
    }

//    public Club addClubMember(@PathVariable Long clubId, @PathVariable Long memberId){
//        Club club = clubRepository.findById(clubId).orElseThrow(() -> new EntityNotFoundException("Club not found with id" + clubId));
//
//        return clubRepository.
//    }

    public Club editClub(ClubDto newClubDto, Long id) {


        return clubRepository.findById(id)
                .map(club -> {
                            club.setName(newClubDto.getName());
                            return clubRepository.save(club);
                        })
                .orElseGet(() -> {
                    return clubRepository.save(convertToEntity(newClubDto));
                });
}

    public void deleteClub(Long id){
        clubRepository.deleteById(id);
    }
}
