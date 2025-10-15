package com.buchclubapp.buchclub_app.book;

import com.buchclubapp.buchclub_app.user.Member;
import com.buchclubapp.buchclub_app.user.MemberRepository;
import com.buchclubapp.buchclub_app.user.MemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    MemberRepository memberRepository;

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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        Member member = memberRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with name " + currentUsername ));
        if(member.getClub().getId() != null && member.getClub().getId().equals(clubId)) {
            return bookRepository.findAllByClubId(clubId);

        }else {
            return Collections.emptyList() ;
        }
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
