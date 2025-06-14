package com.buchclubapp.buchclub_app.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/book")
    Book addBook(@RequestBody Book newBook){
        return bookService.addBook(newBook);
    }

    @GetMapping("/book/{id}")
    Book findBookById(@PathVariable Long id) {
        return  bookService.findBookById(id);
    }

    @GetMapping("/{clubId}/book")
    List<Book> findBooksByClubId(@PathVariable Long clubId){
        return bookService.findBooksByClubId(clubId);
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
