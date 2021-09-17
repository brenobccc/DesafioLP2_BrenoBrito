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

        //NAME
        if(client.getName()==null){
            throw new RuntimeException("Nome é nulo");
        }else if(repository.existsByName(client.getName())){
            throw new RuntimeException("Nome já existe");
        }
        //EMAIL
        if(client.getEmail()!=null){
            if(repository.existsByEmail(client.getEmail()))
                throw new RuntimeException("Email já existe");
        }else{
            throw new RuntimeException("Dados inválidos! Verifique se seu Email e senha estão corretos");
        }


        //ENABLE.
        if(client.getEmail()==null || client.getPassword()==null){
            client.setEnabled(false);
        }else{
            client.setEnabled(true);
        }
        //System.out.println("EMAIL:"+repository.existsByName(client.getEmail()));
        return repository.save(client);

    }



    public Client update(String id, Client client){
        var clientDatabase = this.getById(id);


        //System.out.println("valor2"+!repository.existsByName(publisher.getName()));
        var p = repository.findByName(client.getName());
        System.out.println("EMAIL:"+client.getEmail());
        if(p != null && !p.getId().equals(id)){
            throw new RuntimeException("Nome já existe");
        }
        if(client.getName() != null){
            clientDatabase.setName(client.getName());
        }
        if(client.getEmail() != null){
            clientDatabase.setEmail(client.getEmail());
        }
        if(client.getPassword() != null){
            clientDatabase.setPassword(client.getPassword());
        }



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
