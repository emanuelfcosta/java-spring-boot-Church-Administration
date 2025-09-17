package br.com.emanuelcosta.church.resources;

import br.com.emanuelcosta.church.entities.Study;
import br.com.emanuelcosta.church.services.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/studies")
public class StudyResource {

    @Autowired
    private StudyService studyService;

    @GetMapping
    public ResponseEntity<List<Study>> findAll() {
        List<Study> list = studyService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Study> findById(@PathVariable Long id){
        Study obj = studyService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Study> insert(@RequestBody Study obj){
        obj = studyService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Study> update(@PathVariable Long id, @RequestBody Study obj){
        obj = studyService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        studyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
