package guilherme.zorato.libraryappbackend.restcontrollers;

import guilherme.zorato.libraryappbackend.entities.Book;
import guilherme.zorato.libraryappbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apis/book")
public class BookController {
    @Autowired
    BookRepository repo;

    @GetMapping("/add")
    public ResponseEntity<Object> addBook(Book book) {
        Book b = repo.save(book);
        if(b==null)
            return ResponseEntity.badRequest().body("Erro ao inserir ou alterar");
        else
            return ResponseEntity.ok("Inserido ou alterado com sucesso");
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAllBooks() {
        List<Book> books = repo.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteBook(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Book deleted");
    }
}
