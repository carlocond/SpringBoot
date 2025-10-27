package com.library.Library.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

    Optional<Author> getAuthorById(Long id);
    @Query("SELECT a FROM Author a JOIN a.books b WHERE b.title = :title")
    Optional<Author> getAuthorByBook(@Param("title") String title);
}
