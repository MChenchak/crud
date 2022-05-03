package ru.learnjava.spbtproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnjava.spbtproject.model.Client;
import ru.learnjava.spbtproject.repository.ClientRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void addNewClient(Client client){
        clientRepository.save(client);
    }

    @Override
    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getClientList(){
        return clientRepository.findAll();
    }


    @Override
    public void deleteClient(Long id){
        boolean exists = clientRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "Клиент id " + id + " не найден" );
        }
        clientRepository.deleteById(id);

    }


    @Override
    @Transactional
    public void updateClient(Long id, String segment, Double portfolio) {
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Клиент id " + id + " не найден"));
        if (segment != null &&
                segment.length() > 0 && !Objects.equals(client.getSegment(), segment)){
            client.setSegment(segment);
        }
    }

}
