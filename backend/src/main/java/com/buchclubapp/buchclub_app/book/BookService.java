package com.buchclubapp.buchclub_app.book;

import com.buchclubapp.buchclub_app.club.Club;
import com.buchclubapp.buchclub_app.club.ClubRepository;
import com.buchclubapp.buchclub_app.user.Member;
import com.buchclubapp.buchclub_app.user.MemberRepository;
import com.buchclubapp.buchclub_app.user.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    MemberRepository memberRepository;

    public Book addBook(Book newBook,String clubId){

        Club bookClub = clubRepository.findById(clubId).orElseThrow(()-> new NoSuchElementException("Club not found with id"+clubId));

        newBook.setClub(bookClub);

        return bookRepository.save(newBook);
    }


    Book editBook(Book newBook,String id) {

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

    public Book findBookById(String id){

        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found with id:"+id));
    }

    public List<Book> findBooksByClubId(String clubId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        Member member = memberRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new NoSuchElementException("Member not found with name " + currentUsername ));
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

    void deleteBook(String id) {
        bookRepository.deleteById(id);
    }



}
