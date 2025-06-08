package com.buchclubapp.buchclub_app.user;

import com.buchclubapp.buchclub_app.club.Club;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Builder
@Table(name = "clubs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private String role;

    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;
}
