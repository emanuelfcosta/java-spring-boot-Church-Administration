package br.com.emanuelcosta.church.services;

import br.com.emanuelcosta.church.entities.Church;
import br.com.emanuelcosta.church.entities.Member;
import br.com.emanuelcosta.church.repositories.ChurchRepository;
import br.com.emanuelcosta.church.services.exceptions.ResourceNotFoutndException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ChurchService {
    @Autowired
    private ChurchRepository churchRepository;

    public List<Church> findAll() {
        return churchRepository.findAll();
    }

    public Church findById(Long id){
        return churchRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoutndException(id));
    }

    public List<Member> findAllMembersByChurchId(Long churchId){
        Church church = churchRepository.findById(churchId)
                .orElseThrow(()-> new ResourceNotFoutndException(churchId));
        return church.getMembers();
    }

    @Transactional
    public Church insert(Church church){
        return churchRepository.save(church);
    }

    @Transactional
    public void delete(Long id){
     Church church = churchRepository.findById(id)
             .orElseThrow(()-> new ResourceNotFoutndException(id));

        // Unlink members before deleting
     church.getMembers().forEach(member -> member.setChurch(null));

     churchRepository.delete(church);
    }

    @Transactional
    public Church update(Long id, Church church){
        Church existingChurch = churchRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoutndException(id));

        existingChurch.setName(church.getName());
        existingChurch.setResponsible(church.getResponsible());
        existingChurch.setWebsite(church.getWebsite());
        existingChurch.setType(church.getType());
        existingChurch.setAddress(church.getAddress());
        existingChurch.setCity(church.getCity());
        existingChurch.setState(church.getState());

        return churchRepository.save(existingChurch);

    }
}
