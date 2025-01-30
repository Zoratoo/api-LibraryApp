package guilherme.zorato.libraryappbackend.repository;

import guilherme.zorato.libraryappbackend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value= "SELECT DISTINCT book_genre FROM book", nativeQuery = true)
    List<String> findAllGenres();
}
