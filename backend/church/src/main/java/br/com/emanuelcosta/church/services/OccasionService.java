package br.com.emanuelcosta.church.services;

import br.com.emanuelcosta.church.entities.Occasion;
import br.com.emanuelcosta.church.repositories.OccasionRepository;
import br.com.emanuelcosta.church.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccasionService {

    @Autowired
    private OccasionRepository occasionRepository;

    public List<Occasion> findAll() { return occasionRepository.findAll();}

    public Occasion findById(Long id){
        return occasionRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id));
    }

    @Transactional
    public Occasion insert(Occasion occasion){
        return occasionRepository.save(occasion);
    }

    @Transactional
    public Occasion update(Long id, Occasion occasion){
        Occasion existingOccasion = occasionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        existingOccasion.setName(occasion.getName());
        existingOccasion.setDescription(occasion.getDescription());
        existingOccasion.setStart(occasion.getStart());
        existingOccasion.setEnd(occasion.getEnd());

        return occasionRepository.save(existingOccasion);
    }

    @Transactional
    public void delete(Long id){
        Occasion occasion = occasionRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        occasionRepository.delete(occasion);
    }
}
