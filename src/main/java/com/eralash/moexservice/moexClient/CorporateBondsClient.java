package com.eralash.moexservice.moexClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
//, configuration = FeignConfig.class
@FeignClient(name = "corporatebond", url = "${moex.bonds.corporate.url}")
public interface CorporateBondsClient {
    @GetMapping
    String getBondsFromMoex();
}
