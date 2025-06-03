package com.buchclubapp.buchclub_app.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;



    @GetMapping("/books")
    List<Book> all(){
        return bookService.all();
    }

    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook){
        return bookService.newBook(newBook);
    }

    @PutMapping("/book/{id}")
    Book editBook(@RequestBody Book newBook, @PathVariable Long id) {

        return bookService.editBook(newBook,id);
    }

    @DeleteMapping("/book/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }










}
