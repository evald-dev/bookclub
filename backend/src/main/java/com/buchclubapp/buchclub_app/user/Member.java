package com.buchclubapp.buchclub_app.user;
import com.buchclubapp.buchclub_app.club.Club;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import lombok.NoArgsConstructor;

@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "members")
public class Member implements UserDetails {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String email;

    private String password;

    private String profilePicUrl;


    // Ein Getter für den Club, um im PreAuthorize Ausdruck darauf zugreifen zu können
    @DBRef
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

    public String getUserId() {
        return this.id;
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
