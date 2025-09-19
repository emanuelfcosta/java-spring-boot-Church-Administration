package br.com.emanuelcosta.church.services;

import br.com.emanuelcosta.church.entities.Financial;
import br.com.emanuelcosta.church.repositories.FinancialRepository;
import br.com.emanuelcosta.church.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {

    @Autowired
    private FinancialRepository financialRepository;

    public List<Financial> findAll() {return financialRepository.findAll();}

    public Financial findById(Long id){
        return financialRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));
    }

    @Transactional
    public Financial insert(Financial financial){ return financialRepository.save(financial);}

    @Transactional
    public Financial update(Long id, Financial financial){
        Financial existingFinancial = financialRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        existingFinancial.setType(financial.getType());
        existingFinancial.setAmount(financial.getAmount());
        existingFinancial.setTheDate(financial.getTheDate());
        existingFinancial.setPaymentMethod(financial.getPaymentMethod());
        existingFinancial.setDescription(financial.getDescription());

        return financialRepository.save(existingFinancial);
    }

    @Transactional
    public void delete(Long id){
        Financial financial = financialRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id));

        financialRepository.delete(financial);
    }


}
