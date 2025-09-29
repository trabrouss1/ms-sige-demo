package ci.trabrouss.scolariteservice.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Classe {
    private Long id;
    private String libelle;
    private String niveau;
    private String anneeScolaire;
}
