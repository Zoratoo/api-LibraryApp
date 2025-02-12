package guilherme.zorato.libraryappbackend.restcontrollers;

import guilherme.zorato.libraryappbackend.entities.Employee;
import guilherme.zorato.libraryappbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("apis/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository repo;

    @PostMapping("/add")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        Employee emp = repo.save(employee);
        if(emp==null)
            return ResponseEntity.badRequest().body("Error to add employee");
        else
            return ResponseEntity.ok("Employee added successfully");
    }

    @GetMapping("/find-all")
    public ResponseEntity<Object> findAllEmployees() {
        List<Employee> employees = repo.findAll();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteEmployee(Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Client deleted");
    }
}
