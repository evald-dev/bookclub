package com.buchclubapp.buchclub_app.club;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClubRepository extends MongoRepository<Club,String> {


}
