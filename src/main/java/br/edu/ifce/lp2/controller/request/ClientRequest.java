package br.edu.ifce.lp2.controller.request;

import br.edu.ifce.lp2.model.entities.Client;
import lombok.Setter;

@Setter
public class ClientRequest {
    private String name;
    private String phone;

    public Client toClient(){
        var client = new Client();
        client.setName(name);
        client.setPhone(phone);
        return client;
    }
}
