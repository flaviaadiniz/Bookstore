package br.com.flavia.bookstore.service;

import br.com.flavia.bookstore.model.Client;
import br.com.flavia.bookstore.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public Client updateClient(Long id, Client client) {
        Optional<Client> clientToUpdateOptional = clientRepository.findById(id);
        if (!clientToUpdateOptional.isPresent()) {
            return null;
        }

        Client clientToUpdate = clientToUpdateOptional.get();

        if (client.getFirstName() != null) {
            clientToUpdate.setFirstName(client.getFirstName());
        }

        if (client.getLastName() != null) {
            clientToUpdate.setLastName(client.getLastName());
        }

        if (client.getCpf() != null) {
            clientToUpdate.setCpf(client.getCpf());
        }

        if (client.getBirthDate() != null) {
            clientToUpdate.setBirthDate(client.getBirthDate());
        }

        if (client.getPhoneNumber() != null) {
            clientToUpdate.setPhoneNumber(client.getPhoneNumber());
        }

        if (client.getEmail() != null) {
            clientToUpdate.setEmail(client.getEmail());
        }

        if (client.getAddress() != null) {
            clientToUpdate.setAddress(client.getAddress());
        }

        Client updatedClient = clientRepository.save(clientToUpdate);

        return updatedClient;
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
