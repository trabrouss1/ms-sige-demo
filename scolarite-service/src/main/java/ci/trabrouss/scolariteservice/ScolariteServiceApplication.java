package ci.trabrouss.scolariteservice;

import ci.trabrouss.scolariteservice.common.contract.response.APIResponse;
import ci.trabrouss.scolariteservice.domain.dto.Classe;
import ci.trabrouss.scolariteservice.domain.entity.Scolarite;
import ci.trabrouss.scolariteservice.domain.feign.ClasseRestCLient;
import ci.trabrouss.scolariteservice.domain.repository.ScolariteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ScolariteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScolariteServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ScolariteRepository scolariteRepository, ClasseRestCLient classeRestCLient){
        return args -> {

            APIResponse<List<Classe>> response = classeRestCLient.getAllClass();

            if (response == null || response.getData() == null || response.getData().isEmpty()) {
                System.out.println("⚠️ Aucune classe trouvée depuis ClasseRestClient !");
                return;
            }

            response.getData().forEach(classe -> {
                scolariteRepository.save(Scolarite.builder().classeId(classe.getId()).fraisScolarite(1500000000.0).anneeScolaire(classe.getAnneeScolaire()).fraisExamens(400000.0).fraisInscription(150000.0).build());
                scolariteRepository.save(Scolarite.builder().classeId(classe.getId()).fraisScolarite(1500000000.0).anneeScolaire("2025-2026").fraisExamens(400000.0).fraisInscription(150000.0).build());
                scolariteRepository.save(Scolarite.builder().classeId(classe.getId()).fraisScolarite(300000.0).anneeScolaire("2026-2027").fraisExamens(105000.0).fraisInscription(100000.0).build());
                scolariteRepository.save(Scolarite.builder().classeId(classe.getId()).fraisScolarite(450000.0).anneeScolaire("2027-2028").fraisExamens(270000.0).fraisInscription(120000.0).build());
            });


        };
    }

}
