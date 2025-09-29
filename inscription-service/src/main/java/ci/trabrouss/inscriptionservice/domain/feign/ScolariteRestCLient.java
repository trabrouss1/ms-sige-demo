package ci.trabrouss.inscriptionservice.domain.feign;

import ci.trabrouss.inscriptionservice.common.contract.response.APIResponse;
import ci.trabrouss.inscriptionservice.domain.dto.Scolarite;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SCOLARITE-SERVICE")
public interface ScolariteRestCLient {

    @GetMapping("/api/v1/scolarites/{scolariteId}")
    APIResponse<Scolarite> getScolariteById(@PathVariable Long scolariteId);
}
