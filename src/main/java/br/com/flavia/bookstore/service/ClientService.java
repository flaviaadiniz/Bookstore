package br.com.flavia.bookstore.service;

import br.com.flavia.bookstore.model.Client;
import br.com.flavia.bookstore.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        Optional<Client> targetClientOptional = clientRepository.findById(id);
        if (targetClientOptional.isEmpty()) {
            System.out.println("ID inexistente!");
            return Optional.empty(); //criar Exception para ID inexistente
        }
        Client targetClient = targetClientOptional.get();

        return clientRepository.findById(targetClient.getId());
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
            System.out.println("ID inexistente"); //criar exceção para ID inexistente
        }

        Client clientToDelete = clientToDeleteOptional.get();
        clientRepository.deleteById(clientToDelete.getId());
    }

    public Iterable<Client> findClientByName(String lastName, String firstName) {
        if (lastName != null && firstName == null) {
            return clientRepository.findClientByLastName(lastName);
        }
        if (firstName != null && lastName == null) {
            return clientRepository.findClientByFirstName(firstName);
        }
        if (lastName != null & firstName != null) {
            return clientRepository.findClientByLastNameAndFirstName(lastName, firstName);
        }
        return null;
    }

    public Optional<Client> findClientByCpf(String cpf) {

        Optional<Client> targetClientOptional = clientRepository.findClientByCpf(cpf);
        Client targetClient = new Client();

        if (cpf != null && targetClientOptional.isPresent()) {
            targetClient = targetClientOptional.get();
        }

        return clientRepository.findClientByCpf(targetClient.getCpf());

    }

    public Iterable<Client> findClientByAddress(String city, String state) {
        if (city != null && state == null) {
            return clientRepository.findClientByAddress_City(city);
        }
        if (state != null && city == null) {
            return clientRepository.findClientByAddress_State(state);
        }
        if (city != null & state != null) {
            return clientRepository.findClientByAddress_CityAndAddress_State(city, state);
        }
        return null;
    }
}
