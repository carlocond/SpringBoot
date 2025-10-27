package com.library.Library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    Optional<Book> getBookByTitle(String title);
    Optional<Book> getBookById(Long id);
    Optional<Book> getBookByGenre(String genre);

    @Query("SELECT b FROM Book b WHERE b.author.fName = :authorName OR b.author.lName = :authorName")
    List<Book> getBooksByAuthorName(@Param("authorName") String authorName);

    List<Book> getBooksByStatus(BookStatus status);
}
