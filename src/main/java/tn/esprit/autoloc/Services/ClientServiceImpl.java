package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.ClientRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClient {

    private final ClientRepo clientRepo;

    @Override
    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Set<Client> retrieveClient() {
        return new HashSet<>(clientRepo.findAll());
    }

    @Override
    public Client retrieveById(Long id) {
        return clientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("client", id));
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }
}