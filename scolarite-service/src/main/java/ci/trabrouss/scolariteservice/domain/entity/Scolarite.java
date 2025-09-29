package ci.trabrouss.scolariteservice.domain.entity;

import ci.trabrouss.scolariteservice.common.entities.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Scolarite extends BaseEntity {

    private Long classeId;
    private String anneeScolaire;
    private Double fraisInscription;
    private Double fraisScolarite;
    private Double fraisExamens;

}
