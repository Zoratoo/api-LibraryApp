package guilherme.zorato.libraryappbackend.restcontrollers;

import guilherme.zorato.libraryappbackend.entities.Book;
import guilherme.zorato.libraryappbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("apis/book")
public class BookController {
    @Autowired
    BookRepository repo;

    @PostMapping("/add")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        book.setAvailable(book.getQuantity());
        Book b = repo.save(book);
        if(b==null)
            return ResponseEntity.badRequest().body("Error to add book");
        else
            return ResponseEntity.ok("Book added successfully");
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAllBooks() {
        List<Book> books = repo.findAll();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteBook(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Book deleted");
    }

    @GetMapping("/find-all-genres")
    public ResponseEntity<Object> findAllGenres() {
        List<String> genres = repo.findAllGenres();
        return ResponseEntity.ok(genres);
    }
}
