package br.com.emanuelcosta.church.resources;

import br.com.emanuelcosta.church.entities.Member;
import br.com.emanuelcosta.church.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/members")
public class MemberResource {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> findAll(){
        List<Member> list = memberService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Member> findById(@PathVariable Long id){
        Member obj = memberService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value ="/churches/{churchId}" )
    public ResponseEntity<Member> insert(@PathVariable Long churchId,
                                         @RequestBody Member obj){
       obj = memberService.createMember(churchId, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @PutMapping(value = "/{memberId}/churches/{churchId}")
    public ResponseEntity<Member> update(@PathVariable Long memberId,
                                         @PathVariable Long churchId,
                                         @RequestBody Member obj){

        obj = memberService.updateMember(memberId,churchId, obj);
        return ResponseEntity.ok().body(obj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
