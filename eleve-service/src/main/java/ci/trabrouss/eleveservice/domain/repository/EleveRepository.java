package ci.trabrouss.eleveservice.domain.repository;

import ci.trabrouss.eleveservice.domain.entity.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
}
