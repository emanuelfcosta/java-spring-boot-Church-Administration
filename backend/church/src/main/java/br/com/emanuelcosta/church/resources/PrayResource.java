package br.com.emanuelcosta.church.resources;

import br.com.emanuelcosta.church.entities.Pray;
import br.com.emanuelcosta.church.services.PrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/prayers")
public class PrayResource {

    @Autowired
    private PrayService prayService;

    @GetMapping
    public ResponseEntity<List<Pray>> findAll() {
        List<Pray> list = prayService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pray> findById(@PathVariable Long id){
        Pray obj = prayService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Pray> insert(@RequestBody Pray obj){
        obj = prayService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pray> update(@PathVariable Long id, @RequestBody Pray obj){
        obj = prayService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        prayService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
