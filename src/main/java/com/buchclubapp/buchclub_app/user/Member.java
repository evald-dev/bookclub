package com.buchclubapp.buchclub_app.user;

import com.buchclubapp.buchclub_app.club.Club;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "members")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String email;

    private String password;


    // Ein Getter für den Club, um im PreAuthorize Ausdruck darauf zugreifen zu können
    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    // Für die anderen UserDetails Methoden:
    @Override
    public boolean isAccountNonExpired() {
        return true; // Annahme: Konten laufen nicht ab
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Annahme: Konten werden nicht gesperrt
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Annahme: Zugangsdaten laufen nicht ab
    }

    @Override
    public boolean isEnabled() {
        return true; // Annahme: Konten sind immer aktiviert
    }

}
