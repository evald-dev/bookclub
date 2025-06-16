package com.buchclubapp.buchclub_app.user;

import com.buchclubapp.buchclub_app.club.Club;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Table(name = "members")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String email;

    private String password;



    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

}
