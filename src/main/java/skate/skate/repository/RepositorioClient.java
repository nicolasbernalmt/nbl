package skate.skate.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import skate.skate.model.Client;
import skate.skate.repository.crud.interfaceClient;

@Repository
public class RepositorioClient {
    @Autowired
    private interfaceClient crud;
    
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return crud.findById(id);
    }
    
    public Client save(Client client){
        return crud.save(client);
    }

    public void delete(Client client) {
        crud.delete(client);
    }
}
