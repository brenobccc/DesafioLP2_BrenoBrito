package br.edu.ifce.lp2.controller.response;

import br.edu.ifce.lp2.model.entities.Client;
import lombok.Getter;

@Getter
public class ClientResponse {
    private  String id;
    private String name;
    private String email;
    //private String password;
    private Boolean enabled;
    //private String name;
    public ClientResponse fromClient(Client publisher) {
        this.id = publisher.getId();
        this.name = publisher.getName();
        this.email = publisher.getEmail();
        //this.password = publisher.getPassword();
        this.enabled = publisher.getEnabled();
        //this.name = publisher.getName();
        return this;
    }

}
