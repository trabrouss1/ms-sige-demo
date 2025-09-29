package ci.trabrouss.classeservice.domain.repository;

import ci.trabrouss.classeservice.domain.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
