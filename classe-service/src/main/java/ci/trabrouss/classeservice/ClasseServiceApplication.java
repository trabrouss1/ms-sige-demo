package ci.trabrouss.classeservice;

import ci.trabrouss.classeservice.domain.entity.Classe;
import ci.trabrouss.classeservice.domain.repository.ClasseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClasseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClasseServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ClasseRepository classeRepository) {
        return args -> {
            classeRepository.save(Classe.builder().libelle("Niveau 1 - A").niveau("Niveau 1").anneeScolaire("2025-2026").build());
            classeRepository.save(Classe.builder().libelle("Niveau 1 - B").niveau("Niveau 2").anneeScolaire("2025-2026").build());
            classeRepository.save(Classe.builder().libelle("Niveau 1 - C").niveau("Niveau 3").anneeScolaire("2025-2026").build());
            classeRepository.save(Classe.builder().libelle("Niveau 1 - D").niveau("Niveau 4").anneeScolaire("2025-2026").build());
        };
    }

}
