package com.buchclubapp.buchclub_app.book;

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
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long coverId;

    private String title;

    private String author;

    private Integer publishYear;

}
