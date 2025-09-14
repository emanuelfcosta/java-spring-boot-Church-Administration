package br.com.emanuelcosta.church.repositories;

import br.com.emanuelcosta.church.entities.Financial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRepository extends JpaRepository<Financial,Long> {
}
