package br.com.emanuelcosta.church.resources;

import br.com.emanuelcosta.church.entities.Occasion;
import br.com.emanuelcosta.church.services.OccasionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/occasions")
public class OccasionResource {
    @Autowired
    private OccasionService occasionService;

    @GetMapping
    public ResponseEntity<List<Occasion>> findAll() {
        List<Occasion> list = occasionService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Occasion> findById(@PathVariable Long id){
        Occasion obj = occasionService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Occasion> insert(@RequestBody Occasion obj){
        obj = occasionService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Occasion> update(@PathVariable Long id, @RequestBody Occasion obj){
        obj = occasionService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        occasionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
