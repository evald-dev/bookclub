package com.buchclubapp.buchclub_app.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<Member> findByUsername(String username);
}
