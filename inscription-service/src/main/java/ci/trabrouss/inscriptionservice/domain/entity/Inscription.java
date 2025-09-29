package ci.trabrouss.inscriptionservice.domain.entity;

import ci.trabrouss.inscriptionservice.common.entities.BaseEntity;
import ci.trabrouss.inscriptionservice.domain.dto.Classe;
import ci.trabrouss.inscriptionservice.domain.dto.Eleve;
import ci.trabrouss.inscriptionservice.domain.dto.Scolarite;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
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
public class Inscription extends BaseEntity {

    private String matricule;
    private Long eleveId;
    private Long classeId;
    private Long scolariteId;

    @Transient
    private Eleve eleve;
    @Transient
    private Classe classe;
    @Transient
    private Scolarite scolarite;

}

