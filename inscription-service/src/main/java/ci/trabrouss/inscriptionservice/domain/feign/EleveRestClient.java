package ci.trabrouss.inscriptionservice.domain.feign;

import ci.trabrouss.inscriptionservice.common.contract.response.APIResponse;
import ci.trabrouss.inscriptionservice.domain.dto.Eleve;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ELEVE-SERVICE")
public interface EleveRestClient {
    @GetMapping("/api/v1/eleves/{eleveId}")
    APIResponse<Eleve> getEleveById(@PathVariable Long eleveId);
}
