package br.com.flavia.bookstore.repository;

import br.com.flavia.bookstore.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ClientRepository extends CrudRepository<Client, Long> {

    Iterable<Client> findClientByLastName(String lastName);

    Iterable<Client> findClientByFirstName(String firstName);

    Iterable<Client> findClientByLastNameAndFirstName(String lastName, String firstName);

    Optional<Client> findClientByCpf(String cpf);

    Iterable<Client> findClientByAddress_City(String city);

    Iterable<Client> findClientByAddress_State(String city);

    Iterable<Client> findClientByAddress_CityAndAddress_State(String city, String state);

}
