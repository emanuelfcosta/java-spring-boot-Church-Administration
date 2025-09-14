package br.com.emanuelcosta.church.repositories;

import br.com.emanuelcosta.church.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
