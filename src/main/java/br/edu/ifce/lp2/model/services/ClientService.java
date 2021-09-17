package br.edu.ifce.lp2.model.services;


import br.edu.ifce.lp2.model.entities.Client;
import br.edu.ifce.lp2.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;




    public Client create(Client client){

        //var allPublishers = repository.getAll();
        if(repository.existsByName(client.getName())){
            throw new RuntimeException("Nome já existe");
        }

        return repository.save(client);
    }



    public Client update(String id, Client client){
        var clientDatabase = this.getById(id);


        //System.out.println("valor2"+!repository.existsByName(publisher.getName()));
        var p = repository.findByName(client.getName());
        if(p != null && !p.getId().equals(id)){
            throw new RuntimeException("Nome já existe");
        }
        clientDatabase.setName(client.getName());
        clientDatabase.setPhone(client.getPhone());

        return repository.save(clientDatabase);
    }

    public Page<Client> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Client getById(String id) {

        return repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não existe"));
    }

    public void delete(String id) {
        repository.delete(getById(id));
    }
}
