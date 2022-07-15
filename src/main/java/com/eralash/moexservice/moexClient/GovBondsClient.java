package com.eralash.moexservice.moexClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
//, configuration = FeignConfig.class
@FeignClient(name = "corporatebonds", url =  "${moex.bonds.government.url}")
public interface GovBondsClient {
    @GetMapping
    String getBondsFromMoex();
}
