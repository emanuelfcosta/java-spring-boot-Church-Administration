package br.com.emanuelcosta.church.repositories;

import br.com.emanuelcosta.church.entities.Pray;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrayRepository extends JpaRepository<Pray,Long> {
}
