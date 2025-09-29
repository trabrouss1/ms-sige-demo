package ci.trabrouss.scolariteservice.domain.repository;

import ci.trabrouss.scolariteservice.domain.entity.Scolarite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScolariteRepository extends JpaRepository<Scolarite, Long> {
}
