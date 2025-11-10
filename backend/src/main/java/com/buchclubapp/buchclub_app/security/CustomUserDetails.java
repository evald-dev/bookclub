//package com.buchclubapp.buchclub_app.security;
//
//import com.buchclubapp.buchclub_app.user.Member;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Collections;
//@Getter
//@Setter
//@Builder
//public class CustomUserDetails extends User {
//
//    // Getters for your custom fields
//    private String id; // The member's actual database ID
//    private String clubId; // The member's club ID
//    private String username;
//    private String password;
//    // You can store a reference to the actual Member object if you need it later
//    // private Member member;
//
//    public CustomUserDetails(Member member) {
//        // Call the super constructor of Spring Security's User class
//        // It requires username, password, and authorities.
//        super(member.getUsername(),
//                member.getPassword(),
//                // Assuming a simple role mapping, e.g., all members are ROLE_USER
//                // If your Member entity has roles, map them here.
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
//        // Example if Member has a List<Role> getRoles() method:
//        // member.getRoles().stream()
//        //     .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
//        //     .collect(Collectors.toList()));
//        this.username = member.getUsername();
//        this.password = member.getPassword();
//        this.id = member.getId();
//        this.clubId = member.getClubId().getId(); // Assuming Club has an ID
//        // this.member = member; // If you need the full Member object accessible
//    }
//
//    // You don't need to override other UserDetails methods unless you customize them
//    // (e.g., isAccountNonExpired, isAccountNonLocked, etc. - default to true in User)
//}