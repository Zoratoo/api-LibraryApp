package guilherme.zorato.libraryappbackend.repository;

import guilherme.zorato.libraryappbackend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
