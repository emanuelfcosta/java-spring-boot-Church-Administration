package br.com.emanuelcosta.church.repositories;

import br.com.emanuelcosta.church.entities.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study,Long> {
}
