package com.eralash.moexservice.service;

import com.eralash.moexservice.dto.BondDto;
import com.eralash.moexservice.exeption.LimitsRequestException;
import com.eralash.moexservice.moexClient.CorporateBondsClient;
import com.eralash.moexservice.moexClient.GovBondsClient;
import com.eralash.moexservice.parser.Parser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
public class BondRepository {
    private final CorporateBondsClient corporateBondsClient;
    private final GovBondsClient govBondsClient;
    private final CacheManager cacheManager;
    private final Parser parser;

    @Cacheable(value = "corps")//кэширование
    public List<BondDto> getCorporateBonds() {
        log.info("Getting corp bonds from moex");
        String xmlFromMoex = corporateBondsClient.getBondsFromMoex();
        List<BondDto> bondDtos = parser.parser(xmlFromMoex);
        if(bondDtos.isEmpty()){
            log.error("Moex isn't answering for getting corporate bonds");
            throw  new LimitsRequestException("Moex isn't answering for getting corporate bonds");
        }
        return bondDtos;
    }
    @Cacheable(value = "govs")
    public List<BondDto> getGovBonds() {
        log.info("Getting gov bonds from moex");
        String xmlFromMoex = corporateBondsClient.getBondsFromMoex();
        List<BondDto> bonds = parser.parser(xmlFromMoex);
        if(bonds.isEmpty()){
            log.error("Moex isn't answering for getting corporate bonds");
            throw  new LimitsRequestException("Moex isn't answering for getting corporate bonds");
        }
        return bonds;
    }




}
