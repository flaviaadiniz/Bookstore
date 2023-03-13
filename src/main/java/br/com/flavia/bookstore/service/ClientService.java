package br.com.flavia.bookstore.service;

import br.com.flavia.bookstore.model.Client;
import br.com.flavia.bookstore.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }
}
