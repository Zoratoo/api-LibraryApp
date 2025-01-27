package guilherme.zorato.libraryappbackend.restcontrollers;

import guilherme.zorato.libraryappbackend.entities.Rental;
import guilherme.zorato.libraryappbackend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apis/rental")
public class RentalController {
    @Autowired
    RentalRepository repo;

    @GetMapping("/add")
    public ResponseEntity<Object> addRental(Rental rental) {
        Rental rent = repo.save(rental);
        if(rent==null)
            return ResponseEntity.badRequest().body("Erro ao inserir ou alterar");
        else
            return ResponseEntity.ok("Inserido ou alterado com sucesso");
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAllRentals() {
        List<Rental> rentals = repo.findAll();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteRental(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Rental deleted");
    }
}
