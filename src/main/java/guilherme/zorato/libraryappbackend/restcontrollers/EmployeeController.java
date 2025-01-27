package guilherme.zorato.libraryappbackend.restcontrollers;

import guilherme.zorato.libraryappbackend.entities.Employee;
import guilherme.zorato.libraryappbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apis/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository repo;

    @GetMapping("/add")
    public ResponseEntity<Object> addEmployee(Employee employee) {
        Employee emp = repo.save(employee);
        if(emp==null)
            return ResponseEntity.badRequest().body("Erro ao inserir ou alterar");
        else
            return ResponseEntity.ok("Inserido ou alterado com sucesso");
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAllEmployees() {
        List<Employee> employees = repo.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/delete")
    public ResponseEntity<Object> deleteEmployee(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Client deleted");
    }
}
