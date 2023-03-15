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

    public Client editById(Long id, Client client) {
        Optional<Client> clientToUpdateOptional = clientRepository.findById(id);
        if (clientToUpdateOptional.isEmpty()) {
            return null; //criar Exception para ID inexistente
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

        return clientRepository.save(clientToUpdate);
    }

    public void deleteById(Long id) {
        Optional<Client> clientToDeleteOptional = clientRepository.findById(id);
        if (clientToDeleteOptional.isEmpty()) {
            //criar exceção para ID inexistente
        }

        Client clientToDelete = clientToDeleteOptional.get();
        clientRepository.deleteById(clientToDelete.getId());

    }

    public Iterable<Client> findClientByLastName(String lastName) {
        return clientRepository.findClientByLastName(lastName);
    }

}
