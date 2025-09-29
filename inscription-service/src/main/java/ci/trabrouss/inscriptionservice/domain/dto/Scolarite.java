package ci.trabrouss.inscriptionservice.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scolarite {

    private Long classeId;
    private String anneeScolaire;
    private Double fraisInscription;
    private Double fraisScolarite;
    private Double fraisExamens;

}
