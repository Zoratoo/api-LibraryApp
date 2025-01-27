package guilherme.zorato.libraryappbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_cpf")
    private String cpf;
    @Column(name = "emp_position")
    private String position;
    @Column(name = "emp_phone")
    private String phone;
    @Column(name = "emp_address")
    private String address;
    @Column(name = "emp_cep")
    private String cep;

    public Employee() {
        this(0L,"","",",","","","");
    }

    public Employee(Long id, String name, String cpf, String position, String phone, String address, String cep) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.position = position;
        this.phone = phone;
        this.address = address;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
