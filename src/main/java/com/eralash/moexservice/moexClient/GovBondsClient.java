package com.eralash.moexservice.moexClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "corporatebonds", url =  "${moex.bonds.government.url}", configuration = FeignConfig.class)
public interface GovBondsClient {
    @GetMapping
    String getBondsFromMoex();
}
