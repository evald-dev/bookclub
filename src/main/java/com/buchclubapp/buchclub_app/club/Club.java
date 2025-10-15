package com.buchclubapp.buchclub_app.club;


import com.buchclubapp.buchclub_app.user.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Table(name = "clubs")
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy ="club")
    private Set<Member> members;

    public void addMember(Member member) {
        // Falls das Member bereits einem anderen Club zugewiesen war, dort entfernen

            this.members.add(member);
            member.setClub(this);

        // Setze den Club auf der Member-Seite
    }
}
