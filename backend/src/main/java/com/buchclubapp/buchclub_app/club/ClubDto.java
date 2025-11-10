package com.buchclubapp.buchclub_app.club;

import com.buchclubapp.buchclub_app.user.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubDto {
    private String name;
    private List<Member> members;
}
