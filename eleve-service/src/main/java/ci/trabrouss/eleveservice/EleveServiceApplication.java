package ci.trabrouss.eleveservice;

import ci.trabrouss.eleveservice.domain.entity.Eleve;
import ci.trabrouss.eleveservice.domain.repository.EleveRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EleveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EleveServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(EleveRepository eleveRepository) {
        return args -> {

            eleveRepository.save(Eleve.builder().nom("KONE").prenom("Mohamed").email("mohamed@gmail.com").telephone("123456789").adresse("123 Main St").build());
            eleveRepository.save(Eleve.builder().nom("KONE").prenom("Amara").email("amara@gmail.com").telephone("123456789").adresse("123 Main St").build());
            eleveRepository.save(Eleve.builder().nom("COULIBALY").prenom("Oumar").email("oumar@gmail.com").telephone("123456789").adresse("123 Main St").build());

            for(Eleve eleve : eleveRepository.findAll()) {
                System.out.println(eleve.getNom());
            }
        };
    }

}
