package skate.skate.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skate.skate.repository.RepositorioSkate;

@Service
public class serviciosSkate {
     @Autowired
    private RepositorioSkate metodosCrud;
    
    public List<skate.skate.model.Skate> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<skate.skate.model.Skate> getSkate(int idSkate){
        return metodosCrud.getSkate(idSkate);
    }
    
    public skate.skate.model.Skate save(skate.skate.model.Skate skate){
        if(skate.getId()==null){
            return metodosCrud.save(skate);
        }else{
            Optional<skate.skate.model.Skate>evt=metodosCrud.getSkate(skate.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(skate);
            }else{
                return skate;
            }
        }             
    }
}
