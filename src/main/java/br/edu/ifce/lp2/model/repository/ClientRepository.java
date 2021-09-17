package br.edu.ifce.lp2.model.repository;

import br.edu.ifce.lp2.model.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String>{
    boolean existsByName(String name);
    boolean existsByEmail(String email);
    Client findByName(String name);
}
