package skate.skate.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import skate.skate.model.Message;
import skate.skate.repository.crud.interfaceMessage;

@Repository
public class RepositorioMessage {
    @Autowired
    private interfaceMessage crud;
    
    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return crud.findById(id);
    }
    
    public Message save(Message message){
        return crud.save(message);
    }

    public void delete(Message message) {
        crud.delete(message);
    }
}
