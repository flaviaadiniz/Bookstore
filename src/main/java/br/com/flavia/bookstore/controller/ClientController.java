package br.com.flavia.bookstore.controller;

import br.com.flavia.bookstore.model.Client;
import br.com.flavia.bookstore.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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

    @GetMapping("/name")
    public Iterable<Client> findClientByName(
            @RequestParam (name ="lastName", required = false) String lastName,
            @RequestParam (name ="firstName", required = false) String firstName
            ) {
        return clientService.findClientByName(lastName, firstName);
    }

    @GetMapping("/cpf")
    public Optional<Client> findClientByCpf(@RequestParam (name = "cpf") String cpf) {
        return clientService.findClientByCpf(cpf);
    }

    @GetMapping("/address")
    public Iterable<Client> findClientByAddress(
            @RequestParam (name = "city", required = false) String city,
            @RequestParam (name = "state", required = false) String state
    ) {
        return clientService.findClientByAddress(city, state);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.editById(id, client);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

}