package br.com.flavia.bookstore.controller;

import br.com.flavia.bookstore.model.Client;
import br.com.flavia.bookstore.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    @GetMapping()
    public Iterable<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.editById(id, client);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

    @GetMapping("/name")
    public Iterable<Client> searchClient(
            @RequestParam  (name ="lastName", required = false) String lastName,
            @RequestParam (name ="firstName", required = false) String firstName
            ) {
        return clientService.searchClient(lastName, firstName);
    }

    @GetMapping("/cpf")
    public Optional<Client> findClientByCpf(@RequestParam (name = "cpf") String cpf) {
        return clientService.findClientByCpf(cpf);
    }

}
