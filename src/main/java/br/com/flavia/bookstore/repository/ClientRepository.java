package br.com.flavia.bookstore.repository;

import br.com.flavia.bookstore.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.lastName = ?1")
    Iterable<Client> findClientByLastName(String lastName);

    @Query("SELECT c FROM Client c WHERE c.firstName = ?1")
    Iterable<Client> findClientByFirstName(String firstName);

    @Query("SELECT c FROM Client c WHERE c.lastName = ?1 AND c.firstName = ?2")
    Iterable<Client> findClientByLastNameAndFirstName(String lastName, String firstName);

    @Query("SELECT c FROM Client c WHERE c.cpf = ?1")
    Optional<Client> findClientByCpf(String cpf);

    @Query("SELECT c FROM Client c WHERE c.address.city = ?1")
    Iterable<Client> findClientByAddress_City(String city);

    @Query("SELECT c FROM Client c WHERE c.address.state = ?1")
    Iterable<Client> findClientByAddress_State(String city);

    @Query("SELECT c FROM Client c WHERE c.address.city = ?1 AND c.address.state = ?2 ")
    Iterable<Client> findClientByAddress_CityAndAddress_State(String city, String state);

}
