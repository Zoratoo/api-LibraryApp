package guilherme.zorato.libraryappbackend.restcontrollers;

import guilherme.zorato.libraryappbackend.entities.Rental;
import guilherme.zorato.libraryappbackend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apis/rental")
public class RentalController {
    @Autowired
    RentalRepository repo;

    @PutMapping("/confirm-payment")
    public ResponseEntity<Object> confirmPayment(@RequestBody Long id) {
        Optional<Rental> rentalOptional = repo.findById(id);
        if (rentalOptional.isPresent()) {
            Rental rental = rentalOptional.get();
            rental.setStatus('f');
            repo.save(rental);
            return ResponseEntity.ok("Payment confirmed and rental status updated.");
        } else {
            return ResponseEntity.badRequest().body("Error to confirm payment");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addRental(@RequestBody Rental rental) {
        Rental rent = repo.save(rental);
        if(rent==null)
            return ResponseEntity.badRequest().body("Error to add rental");
        else
            return ResponseEntity.ok("Rental added successfully");
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAllRentals() {
        List<Rental> rentals = repo.findAll();
        return ResponseEntity.ok(rentals);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteRental(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Rental deleted");
    }
}
