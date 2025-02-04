package guilherme.zorato.libraryappbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cli_id")
    private Long id;
    @Column(name="cli_name")
    private String name;
    @Column(name="cli_cpf")
    private String cpf;
    @Column(name="cli_address")
    private String address;
    @Column(name="cli_cep")
    private String cep;
    @Column(name="cli_phone")
    private String phone;
    @Column(name="cli_email")
    private String email;

    public Client() {
        this(0L,"","","","","","");
    }

    public Client(Long id, String name, String cpf, String address, String cep, String phone, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.cep = cep;
        this.phone = phone;
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
