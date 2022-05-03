package ru.learnjava.spbtproject.service;

import ru.learnjava.spbtproject.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    void addNewClient(Client client);

    Optional<Client> getClientById(Long id);

    List<Client> getClientList();

    void deleteClient(Long id);

    void updateClient(Long id, String segment, Double portfolio);
}
