package ru.learnjava.spbtproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.learnjava.spbtproject.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void addNewClient(Client client);

    Client getClientById(Long id);

    List<Client> getClientList();

    void deleteClient(Long id);

    Client updateClient(Long id, String json) throws JsonProcessingException;
}
