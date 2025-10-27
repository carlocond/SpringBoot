package com.library.Library.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    //Richiamo del servizio del libro
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    //Creazione del metodo che richiama quello del servizio
    @GetMapping("/by-title/{title}")
    public ResponseEntity<Book> getByTitle(@PathVariable String title){
        Book book = bookService.findBookByTitle(title);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        Book book = bookService.findBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("by-genre/{genre}")
    public ResponseEntity<Book> getByGenre(@PathVariable String genre){
        Book book = bookService.findBookByGenre(genre);
        return ResponseEntity.ok(book);
    }

    @GetMapping("by-author/{authorName}")
    public ResponseEntity<List<Book>> getByAuthor(@PathVariable String authorName){
        List<Book> books = bookService.findBooksByAuthorName(authorName);
        return ResponseEntity.ok(books);
    }

    @GetMapping("by-status/{status}")
    public ResponseEntity<List<Book>> getByStatus(@PathVariable BookStatus status){
        List<Book> books = bookService.findBooksByStatus(status);
        return ResponseEntity.ok(books);
    }
    //Create Update e Delete

    // Create
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.createBook(book);
        return ResponseEntity.ok(savedBook);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
