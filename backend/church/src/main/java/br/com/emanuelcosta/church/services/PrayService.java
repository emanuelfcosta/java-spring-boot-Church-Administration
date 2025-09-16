package br.com.emanuelcosta.church.services;

import br.com.emanuelcosta.church.entities.Pray;
import br.com.emanuelcosta.church.repositories.PrayRepository;
import br.com.emanuelcosta.church.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrayService {

    @Autowired
    private PrayRepository prayRepository;

    public List<Pray> findAll() {
        return prayRepository.findAll();
    }

    public Pray findById(Long id){
        return prayRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));
    }

   @Transactional
    public Pray insert(Pray pray){ return prayRepository.save(pray);}

    @Transactional
    public Pray update(Long id, Pray pray){
        Pray existingPray = prayRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        existingPray.setReason(pray.getReason());
        existingPray.setDescription(pray.getDescription());
        existingPray.setPriority(pray.getPriority());
        existingPray.setStatus(pray.getStatus());

        return prayRepository.save(existingPray);
    }

    @Transactional
    public void delete(Long id){
        Pray pray = prayRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        prayRepository.delete(pray);
    }
}
