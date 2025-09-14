package br.com.emanuelcosta.church.repositories;

import br.com.emanuelcosta.church.entities.Occasion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccasionRepository extends JpaRepository<Occasion,Long> {
}
