package com.buchclubapp.buchclub_app.book;


import com.buchclubapp.buchclub_app.user.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/book")
    Book addBook(@RequestBody Book newBook,@PathVariable String clubId){
        return bookService.addBook(newBook, clubId);
    }

    @GetMapping("/book/{id}")
    Book findBookById(@PathVariable String id) {
        return  bookService.findBookById(id);
    }

    @GetMapping("/{clubId}/book")
    List<Book> findBooksByClubId(@PathVariable String clubId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return bookService.findBooksByClubId(clubId);
    }

    @PutMapping("/book/{id}")
    Book editBook(@RequestBody Book newBook, @PathVariable String id) {

        return bookService.editBook(newBook,id);
    }

    @DeleteMapping("/book/{id}")
    void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }










}
