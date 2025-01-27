package guilherme.zorato.libraryappbackend.repository;

import guilherme.zorato.libraryappbackend.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
