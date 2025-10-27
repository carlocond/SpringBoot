package com.library.Library.book;

import com.library.Library.author.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired //Connessione automatica con la repository
    public BookService(BookRepo bookRepo, AuthorRepo authorRepo){
        this.bookRepo = bookRepo;
    }

    //Creazione del metodo che poi verrà richiamato nel controller
    public Book findBookByTitle(String title){
        return bookRepo.getBookByTitle(title)
                .orElseThrow(() -> new RuntimeException("Libro non trovato con titolo: " + title)); //Messaggio di errore
    }

    public Book findBookById(Long id){
        return bookRepo.getBookById(id)
                .orElseThrow(() -> new RuntimeException("Libro non trovato con id: " +id));
    }

    public Book findBookByGenre(String genre){
        return bookRepo.getBookByGenre(genre)
                .orElseThrow(() -> new RuntimeException("Libri non trovati con genere: " + genre));
    }

    public List<Book> findBooksByAuthorName(String authorName){
        List<Book> books = bookRepo.getBooksByAuthorName(authorName);
        if (books.isEmpty()){
            throw new RuntimeException("Nessun libro trovato appartenente all'autore: " + authorName);
        }
        return books;
    }

    public List<Book> findBooksByStatus(BookStatus status){
        return bookRepo.getBooksByStatus(status);
    }

    //Create Update Delete

    // Create
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    // Update
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro non trovato con id: " + id));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setStatus(bookDetails.getStatus());
        book.setDescription(bookDetails.getDescription());
        book.setGenre(bookDetails.getGenre());
        book.setLanguage(bookDetails.getLanguage());
        book.setPages(bookDetails.getPages());
        book.setPrice(bookDetails.getPrice());
        book.setPublicationDate(bookDetails.getPublicationDate());
        book.setPublisher(bookDetails.getPublisher());
        book.setIsbn(bookDetails.getIsbn());

        return bookRepo.save(book);
    }

    // Delete
    public void deleteBook(Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro non trovato con id: " + id));
        bookRepo.delete(book);
    }

    public Book updateBookStatus(Long bookId, BookStatus newStatus) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Libro da modificare non trovato"));
        book.setStatus(newStatus);
        return bookRepo.save(book);
    }

}
