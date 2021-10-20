package skate.skate.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import skate.skate.service.serviciosSkate;

@RestController
@RequestMapping("/api/Skate")
public class SkateWeb {
    @GetMapping("/holaMundo")
    public String saludar(){
        return "Hola, que hace?";
    }
    
    @Autowired
    private serviciosSkate servicios;
    @GetMapping("/all")
    public List<skate.skate.model.Skate> getSkate(){
        return servicios.getAll();
    }
       
    @GetMapping("/{id}")
    public Optional<skate.skate.model.Skate> getSkate(@PathVariable("id") int idSkate){
        return servicios.getSkate(idSkate);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public skate.skate.model.Skate save(@RequestBody skate.skate.model.Skate skate){
        return servicios.save(skate);
    }
    
}
