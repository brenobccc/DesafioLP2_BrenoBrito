package br.edu.ifce.lp2.controller.response;

import br.edu.ifce.lp2.model.entities.Client;
import lombok.Getter;

@Getter
public class ClientResponse {
    private  String id;
    private String name;
    private String phone;
    //private String name;
    public ClientResponse fromClient(Client publisher) {
        this.id = publisher.getId();
        this.name = publisher.getName();
        this.phone = publisher.getPhone();
        //this.name = publisher.getName();
        return this;
    }

}
