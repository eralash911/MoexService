package com.eralash.moexservice.moexClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "corporatebond", url = "${moex.bonds.corporate.url}", configuration = FeignConfig.class)
public interface CorporateBondsClient {
    @GetMapping
    String getBondsFromMoex();
}
