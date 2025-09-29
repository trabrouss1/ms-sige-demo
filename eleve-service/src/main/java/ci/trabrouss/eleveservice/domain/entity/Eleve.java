package ci.trabrouss.eleveservice.domain.entity;

import ci.trabrouss.eleveservice.common.entity.BaseEntity;
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
public class Eleve extends BaseEntity {

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;

}
