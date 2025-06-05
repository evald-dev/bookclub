package com.buchclubapp.buchclub_app.book;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

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

    public Book findBookById(Long id){

        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id:" + id));
    }

    public List<Book> findBooksByClubId(Long clubId){
        return bookRepository.findAllByClubId(clubId);
    }

    private BookDto convertToBookDto(Book unconvertedBook){

        return BookDto.builder()
                .author(unconvertedBook.getAuthor())
                .tittle(unconvertedBook.getTitle())
                .publishYear(unconvertedBook.getPublishYear())
                .id(unconvertedBook.getId())
                .build();
    }

    void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }



}
