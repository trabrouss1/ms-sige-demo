package ci.trabrouss.scolariteservice.domain.feign;

import ci.trabrouss.scolariteservice.common.contract.response.APIResponse;
import ci.trabrouss.scolariteservice.common.contract.response.PageResponse;
import ci.trabrouss.scolariteservice.domain.dto.Classe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CLASSE-SERVICE")
public interface ClasseRestCLient {

    @GetMapping("/api/v1/classes/{classeId}")
    APIResponse<Classe> getClasseById(@PathVariable Long classeId);

    @GetMapping("/api/v1/classes")
    APIResponse<List<Classe>> getAllClass();
}
