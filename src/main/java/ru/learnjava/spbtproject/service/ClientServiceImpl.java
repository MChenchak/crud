package ru.learnjava.spbtproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.learnjava.spbtproject.model.Client;
import ru.learnjava.spbtproject.repository.ClientRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final ObjectMapper objectMapper;

    @Override
    public void addNewClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Клиент не найден"));

    }

    @Override
    public List<Client> getClientList() {
        return clientRepository.findAll();
    }


    @Override
    public void deleteClient(Long id) {
        boolean exists = clientRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Клиент id " + id + " не найден");
        }
        clientRepository.deleteById(id);

    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Client updateClient(Long id, String json) throws JsonProcessingException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Клиент id " + id + " не найден"));

        ObjectReader objectReader = objectMapper.readerForUpdating(client);

        //на основе json инициализируем измененный объект
        Client newClient = objectReader.readValue(json);

        client.setSegment(newClient.getSegment());
        client.setName(newClient.getName());

        return client;
    }

}
