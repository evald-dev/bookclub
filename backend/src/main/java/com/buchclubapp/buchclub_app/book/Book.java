package com.buchclubapp.buchclub_app.book;
import com.buchclubapp.buchclub_app.club.Club;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;


@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Component
@Builder
@Document(collection = "books")
public class Book {

    @Id
    private String id;

    private String coverId;

    private String title;

    private String author;

    private Integer publishYear;

    @DBRef
    private Club club;

}
