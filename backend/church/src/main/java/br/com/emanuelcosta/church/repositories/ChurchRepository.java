package br.com.emanuelcosta.church.repositories;

import br.com.emanuelcosta.church.entities.Church;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<Church,Long> {
}
