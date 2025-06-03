package com.buchclubapp.buchclub_app.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


    public Book addBook(Book newBook){
        return bookRepository.save(newBook);
    }


    Book editBook(Book newBook,Long id) {

        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    book.setPublishYear(newBook.getPublishYear());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    return bookRepository.save(newBook);
                });
    }

    void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }



}
