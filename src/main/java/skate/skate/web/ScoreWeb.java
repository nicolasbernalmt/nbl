package skate.skate.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import skate.skate.service.serviciosScore;
import skate.skate.model.Score;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ScoreWeb {
    @GetMapping("/holaMundo")
    public String saludar(){
        return "Hola, que hace?";
    }
    
    @Autowired
    private serviciosScore servicios;
    @GetMapping("/all")
    public List<Score> getScore(){
        return servicios.getAll();
    }
       
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int idScore){
        return servicios.getScore(idScore);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return servicios.save(score);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return servicios.update(score);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id")int scoreId){
        return servicios.deleteScore(scoreId);
    }
}
