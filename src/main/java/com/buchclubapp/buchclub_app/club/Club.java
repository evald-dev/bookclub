package com.buchclubapp.buchclub_app.club;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Document(collection = "clubs")
public class Club {

    @Id
    private String id;

    private String name;
}
