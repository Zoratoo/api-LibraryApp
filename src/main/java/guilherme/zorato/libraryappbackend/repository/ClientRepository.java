package guilherme.zorato.libraryappbackend.repository;

import guilherme.zorato.libraryappbackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
