package com.buchclubapp.buchclub_app.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    Long id;

    String tittle;

    private String author;

    private Integer publishYear;




}
