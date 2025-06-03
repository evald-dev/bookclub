package com.buchclubapp.buchclub_app.book;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;



    @GetMapping("/books")
    List<Book> all(){
        return bookService.getAllBooks();
    }

    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook){
        return bookService.addBook(newBook);
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
