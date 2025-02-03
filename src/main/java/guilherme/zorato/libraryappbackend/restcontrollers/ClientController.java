package guilherme.zorato.libraryappbackend.restcontrollers;

import guilherme.zorato.libraryappbackend.entities.Client;
import guilherme.zorato.libraryappbackend.entities.Rental;
import guilherme.zorato.libraryappbackend.repository.ClientRepository;
import guilherme.zorato.libraryappbackend.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("apis/client")
public class ClientController {
    @Autowired
    ClientRepository repo;
    @Autowired
    RentalRepository rent_repo;

    @GetMapping("/add")
    public ResponseEntity<Object> addClient(Client client) {
        Client cli = repo.save(client);
        if(cli==null)
            return ResponseEntity.badRequest().body("Erro ao inserir ou alterar");
        else
            return ResponseEntity.ok("Inserido ou alterado com sucesso");
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAllClients() {
        List<Client> clients = repo.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteClient(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Client deleted");
    }

    @GetMapping("find-cpf")
    public  ResponseEntity<Object> findCpf(@RequestParam String cpf) {
        Client client = repo.findCpf(cpf);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("find-rentals-cpf")
    public  ResponseEntity<Object> findRentalCpf(@RequestParam String cpf) {
        Client client = repo.findCpf(cpf);
        if (client != null) {
            List<Rental> rentals = rent_repo.findRentalsByClientId(client.getId());
            if (rentals != null) {
                return ResponseEntity.ok(rentals);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
