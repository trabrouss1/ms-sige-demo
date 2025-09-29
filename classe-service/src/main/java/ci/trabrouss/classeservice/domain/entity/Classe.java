package ci.trabrouss.classeservice.domain.entity;

import ci.trabrouss.classeservice.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Classe extends BaseEntity {

    private String libelle;
    private String niveau;
    private String anneeScolaire;

}
