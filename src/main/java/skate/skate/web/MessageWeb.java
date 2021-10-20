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
import skate.skate.service.serviciosMessage;
import skate.skate.model.Message;

@RestController
@RequestMapping("/api/Message")
public class MessageWeb {
    @GetMapping("/holaMundo")
    public String saludar(){
        return "Hola, que hace?";
    }
    
    @Autowired
    private serviciosMessage servicios;
    @GetMapping("/all")
    public List<Message> getMessage(){
        return servicios.getAll();
    }
       
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int idMessage){
        return servicios.getMessage(idMessage);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return servicios.save(message);
    }
    
}
