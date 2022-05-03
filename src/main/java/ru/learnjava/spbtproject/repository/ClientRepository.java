package ru.learnjava.spbtproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnjava.spbtproject.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


}
