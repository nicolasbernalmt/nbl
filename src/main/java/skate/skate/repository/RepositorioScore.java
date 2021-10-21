package skate.skate.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import skate.skate.model.Score;
import skate.skate.repository.crud.interfaceScore;

@Repository
public class RepositorioScore {
    @Autowired
    private interfaceScore crud;
    
    public List<Score> getAll(){
        return (List<Score>) crud.findAll();
    }
    
    public Optional<Score> getScore(int id){
        return crud.findById(id);
    }
    
    public Score save(Score score){
        return crud.save(score);
    }

    public void delete(Score score) {
        crud.delete(score);
    }
    
}
