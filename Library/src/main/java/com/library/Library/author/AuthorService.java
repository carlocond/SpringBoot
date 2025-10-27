package com.library.Library.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepo authorRepo;

    @Autowired
    public AuthorService(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;
    }

    public Author findByAuthorId(Long id){
        return authorRepo.getAuthorById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato con id: " + id));
    }

    public Author findAuthorByBook(String bookTitle){
        return authorRepo.getAuthorByBook(bookTitle)
                .orElseThrow(() -> new RuntimeException("Nessun autore trovato del libro: " + bookTitle));
    }
}
