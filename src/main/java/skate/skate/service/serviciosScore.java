package skate.skate.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skate.skate.model.Score;
import skate.skate.repository.RepositorioScore;

@Service

public class serviciosScore {
    @Autowired
    private RepositorioScore metodosCrud;
    
    public List<Score> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Score> getScore(int idScore){
        return metodosCrud.getScore(idScore);
    }
    
    public Score save(Score score){
        if(score.getIdScore()==null){
            return metodosCrud.save(score);
        }else{
            Optional<Score>evt=metodosCrud.getScore(score.getIdScore());
            if(evt.isEmpty()){
                return metodosCrud.save(score);
            }else{
                return score;
            }
        }             
    }
}
