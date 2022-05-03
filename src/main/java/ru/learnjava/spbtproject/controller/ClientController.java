package ru.learnjava.spbtproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.learnjava.spbtproject.model.Client;
import ru.learnjava.spbtproject.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/get-list")
    public List<Client> getClientList(){
        return clientService.getClientList();
    }

    @GetMapping("/get-by-id/{id}")
    public List<Client> getClientById(@PathVariable ("id") Long id){
        Optional<Client> client = clientService.getClientById(id);
        if (client.isPresent()){
            return List.of(client.get());
        }
        else{
            throw new IllegalStateException("Клиент не найден");
        }
    }

    @PostMapping
    public void createClient(@RequestBody Client client){

        clientService.addNewClient(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable ("id") Long id){
        clientService.deleteClient(id);
    }

    @PutMapping(path = "{clientId}")
    public void updateClient(
            @PathVariable("clientId") Long id,
            @RequestParam(required = false) String segment,
            @RequestParam(required = false) Double portfolio) {
        clientService.updateClient(id, segment, portfolio);
    }



}
