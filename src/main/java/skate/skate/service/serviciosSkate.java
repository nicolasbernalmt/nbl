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
    
     public skate.skate.model.Skate update(skate.skate.model.Skate skate){
        if(skate.getId()!=null){
            Optional<skate.skate.model.Skate> e=metodosCrud.getSkate(skate.getId());
            if(!e.isEmpty()){
                if(skate.getName()!=null){
                    e.get().setName(skate.getName());
                }
                if(skate.getBrand()!=null){
                    e.get().setBrand(skate.getBrand());
                }
                if(skate.getYear()!=null){
                    e.get().setYear(skate.getYear());
                }
                if(skate.getDescription()!=null){
                    e.get().setDescription(skate.getDescription());
                }
                if(skate.getCategory()!=null){
                    e.get().setCategory(skate.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return skate;
            }
        }else{
            return skate;
        }
    }


    public boolean deleteSkate(int skateId) {
        Boolean aBoolean = getSkate(skateId).map(skate -> {
            metodosCrud.delete(skate);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
