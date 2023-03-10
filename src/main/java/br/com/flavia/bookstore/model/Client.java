package br.com.flavia.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Clientes")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Address address;

}
