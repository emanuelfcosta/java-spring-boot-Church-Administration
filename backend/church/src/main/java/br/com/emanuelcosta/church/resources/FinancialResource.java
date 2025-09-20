package br.com.emanuelcosta.church.resources;

import br.com.emanuelcosta.church.entities.Financial;
import br.com.emanuelcosta.church.services.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/financial")
public class FinancialResource {

    @Autowired
    private FinancialService financialService;

    @GetMapping
    public ResponseEntity<List<Financial>> findAll(){
        List<Financial> list = financialService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Financial> findById(@PathVariable Long id){
        Financial obj = financialService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Financial> insert(@RequestBody Financial obj){
        obj = financialService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Financial> update(@PathVariable Long id, @RequestBody Financial obj ){
        obj = financialService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        financialService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
