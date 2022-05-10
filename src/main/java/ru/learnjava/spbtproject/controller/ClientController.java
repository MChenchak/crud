package ru.learnjava.spbtproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.learnjava.spbtproject.model.Client;
import ru.learnjava.spbtproject.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getClientList(){
        return new ResponseEntity<>(clientService.getClientList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable ("id") Long id){
        return  new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
    }

    //метод должен возвращать дто. void - неправильно
    @PostMapping
    public void createClient(@RequestBody Client client){

        clientService.addNewClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable ("id") Long id){
        clientService.deleteClient(id);
    }

    //апдейтить нужно дто целиком, а не отдельные поля
//    @PutMapping(path = "{clientId}")
//    public void updateClient(
//            @PathVariable("clientId") Long id,
//            @RequestParam(required = false) String segment,
//            @RequestParam(required = false) Decimal portfolio) {
//        clientService.updateClient(id, segment, portfolio);
//    }



}
