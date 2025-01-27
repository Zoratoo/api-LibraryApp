package guilherme.zorato.libraryappbackend.restcontrollers;

import guilherme.zorato.libraryappbackend.entities.Client;
import guilherme.zorato.libraryappbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apis/client")
public class ClientController {
    @Autowired
    ClientRepository repo;

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
}
