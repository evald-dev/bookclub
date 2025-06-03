package com.buchclubapp.buchclub_app;

import com.buchclubapp.buchclub_app.book.Book;
import com.buchclubapp.buchclub_app.book.BookRepository;
import com.buchclubapp.buchclub_app.book.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;



    @Test
    public void testAddBook() {
        Book newBook = Book.builder()
                .title("Ein anderes Buch")
                .author("Anna Autorin")
                .publishYear(2025)
                .coverId(67890L)
                .build();

        when(bookRepository.save(Mockito.any(Book.class))).thenReturn(newBook);

        Book savedBook = bookService.addBook(newBook);

        Assertions.assertThat(savedBook).isNotNull();
        Assertions.assertThat(savedBook.getTitle()).isEqualTo("Ein anderes Buch");
    }
}
