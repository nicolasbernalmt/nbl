package skate.skate.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import skate.skate.model.Skate;
import skate.skate.repository.crud.interfaceSkate;

@Repository

public class RepositorioSkate {
     @Autowired
    private interfaceSkate crud;
    
    public List<skate.skate.model.Skate> getAll(){
        return (List<skate.skate.model.Skate>) crud.findAll();
    }
    
    public Optional<skate.skate.model.Skate> getSkate(int id){
        return crud.findById(id);
    }
    
    public skate.skate.model.Skate save(skate.skate.model.Skate skate){
        return crud.save(skate);
    }

    public void delete(Skate skate) {
        crud.delete(skate);
    }
}
