package br.com.flavia.bookstore.repository;

import br.com.flavia.bookstore.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
