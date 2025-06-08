package com.buchclubapp.buchclub_app.club;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Builder
@Table(name = "clubs")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy ="club")
    private Set<User> members;
}
