package com.library.Library.author;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id){
        Author author = authorService.findByAuthorId(id);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/by-book/{bookTitle}")
    public ResponseEntity<Author> getAuthorByBook(@PathVariable String bookTitle){
        Author author = authorService.findAuthorByBook(bookTitle);
        return ResponseEntity.ok(author);
    }
}
