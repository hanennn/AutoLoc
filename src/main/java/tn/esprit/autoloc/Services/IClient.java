package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Client;
import java.util.Set;

public interface IClient {
    Client addClient(Client client);
    void deleteClient(Long id);
    Set<Client> retrieveClient();
    Client retrieveById(Long id);
    Client updateClient(Client client);
}