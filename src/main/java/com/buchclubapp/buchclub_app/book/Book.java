package com.buchclubapp.buchclub_app.book;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Component
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;


    private Long coverId;

    private String title;

    private String author;

    private Integer publishYear;

}
