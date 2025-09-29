package ci.trabrouss.inscriptionservice.domain.repository;

import ci.trabrouss.inscriptionservice.domain.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
