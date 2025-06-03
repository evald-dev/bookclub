package com.buchclubapp.buchclub_app.book;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class BookService {

   private final WebClient webClient;

   public BookService(WebClient.Builder webClientBuilder){
       this.webClient = webClientBuilder.baseUrl("https://openlibrary.org").build();
   }

    public String searchBook(String title){
        return this.webClient.get().uri("/search.json?q={title}",title).retrieve().bodyToMono(String.class).block();
    }
}
