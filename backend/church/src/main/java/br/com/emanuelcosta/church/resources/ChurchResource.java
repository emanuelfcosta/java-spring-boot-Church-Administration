package br.com.emanuelcosta.church.resources;

import br.com.emanuelcosta.church.entities.Church;
import br.com.emanuelcosta.church.services.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/churches")
public class ChurchResource {

    @Autowired
    private ChurchService churchService;

    @GetMapping
    public ResponseEntity<List<Church>> findAll(){
        List<Church> list = churchService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Church> findById(@PathVariable Long id){
        Church obj = churchService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

   @PostMapping
    public ResponseEntity<Church> insert(@RequestBody Church obj){
        obj = churchService.insert(obj);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(obj.getId()).toUri();
       return ResponseEntity.ok().body(obj);
   }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Church> update(@PathVariable Long id, @RequestBody Church obj){
        obj = churchService.update(id,obj);
        return ResponseEntity.ok().body(obj);
   }

   @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        churchService.delete(id);
        return ResponseEntity.noContent().build();
   }



}
