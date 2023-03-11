package br.com.flavia.bookstore.service;

import br.com.flavia.bookstore.model.Client;
import br.com.flavia.bookstore.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

}
