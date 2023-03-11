package br.com.flavia.bookstore.controller;

import br.com.flavia.bookstore.model.Client;
import br.com.flavia.bookstore.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }


}
