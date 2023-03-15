package br.com.flavia.bookstore.repository;

import br.com.flavia.bookstore.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.lastName = ?1")
    Iterable<Client> findClientByLastName(String lastName);

}
