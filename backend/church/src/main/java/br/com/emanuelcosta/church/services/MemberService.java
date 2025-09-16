package br.com.emanuelcosta.church.services;

import br.com.emanuelcosta.church.entities.Church;
import br.com.emanuelcosta.church.entities.Member;
import br.com.emanuelcosta.church.repositories.ChurchRepository;
import br.com.emanuelcosta.church.repositories.MemberRepository;
import br.com.emanuelcosta.church.services.exceptions.DatabaseException;
import br.com.emanuelcosta.church.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ChurchRepository churchRepository;


    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id){
        Optional<Member> obj = memberRepository.findById(id);

        return obj.get();
    }

//    public List<Member> findByChurchId(Long churchId){
//
//        try{
//            Church churchEntity = churchRepository.findById(churchId).get();
//
//            List<Member> obj = churchEntity.getMembers();
//
//            return obj;
//
//
//        }catch(EntityNotFoundException e){
//            throw new ResourceNotFoundException(churchId);
//        }
//    }

    // to create the member you need the church
    public Member createMember(Long churchId, Member member){
        try{
            Church churchEntity = churchRepository.findById(churchId).get();

            member.setChurch(churchEntity);

            return memberRepository.save(member);

        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(churchId);
        }
    }

    //to update the member you need the church
    public Member updateMember(Long id, Long churchId, Member obj){

        try{
            Church churchEntity = churchRepository.findById(churchId).get();
            Member entity = memberRepository.getReferenceById(id);

            entity.setChurch(churchEntity);

            entity.setStatus(obj.getStatus());
            entity.setRole(obj.getRole());
            entity.setBaptismDate(obj.getBaptismDate());
            entity.setAdmission(obj.getAdmission());
            entity.setName(obj.getName());
            entity.setGender(obj.getGender());
            entity.setBirthdate(obj.getBirthdate());
            entity.setAddress(obj.getAddress());
            entity.setState(obj.getState());
            entity.setOccupation(obj.getOccupation());

            return memberRepository.save(entity);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void delete(Long id){
        try{
            memberRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
}
