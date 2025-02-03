package guilherme.zorato.libraryappbackend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cli_id", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "rental_books",
            joinColumns = @JoinColumn(name = "rent_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;
    @Column(name = "rent_start_date")
    private LocalDate start_date;
    @Column(name = "rent_end_date")
    private LocalDate end_date;
    @Column(name = "rent_status")
    private char status;
    @Column(name = "rent_late_fee_per_day")
    private float late_fee_per_day;

    public Rental() {
        this(0L,null,null,null,LocalDate.now(),LocalDate.now(),'e',0);
    }

    public Rental(Long id, Client client, List<Book> books, Employee employee, LocalDate start_date, LocalDate end_date, char status, float late_fee_per_day) {
        this.id = id;
        this.client = client;
        this.books = books;
        this.employee = employee;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.late_fee_per_day = late_fee_per_day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> books) {
        this.books = books;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public float getLate_fee_per_day() {
        return late_fee_per_day;
    }

    public void setLate_fee_per_day(float late_fee_per_day) {
        this.late_fee_per_day = late_fee_per_day;
    }
}
