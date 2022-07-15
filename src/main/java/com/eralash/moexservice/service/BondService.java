package com.eralash.moexservice.service;

import com.eralash.moexservice.dto.BondDto;
import com.eralash.moexservice.dto.StocksDto;
import com.eralash.moexservice.dto.TickersDto;
import com.eralash.moexservice.exeption.LimitsRequestException;
import com.eralash.moexservice.model.Currency;
import com.eralash.moexservice.model.Stock;
import com.eralash.moexservice.moexClient.CorporateBondsClient;
import com.eralash.moexservice.moexClient.GovBondsClient;
import com.eralash.moexservice.parser.Parser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BondService {
    private final CorporateBondsClient corporateBondsClient;
    private final GovBondsClient govBondsClient;
    private final Parser parser;

    public StocksDto getBondsFromMoex(TickersDto tickersDto){
        List<BondDto>allBonds = new ArrayList<>();
        allBonds.addAll(getCorporateBonds());
        allBonds.addAll(getGovBonds());
         List<BondDto>resultBonds = allBonds.stream().filter(bondDto ->
                 tickersDto.getTickers().contains(bondDto.getTicker()))
                 .collect(Collectors.toList());
         List<Stock> stocks = resultBonds.stream().map(b ->
         {return Stock.builder()
                 .ticker(b.getTicker())
                 .name(b.getName())
                 .figi(b.getTicker())
                 .type("Bond")
                 .currency(Currency.RUB)
                 .source("MOEX")
                 .build();
         }).collect(Collectors.toList());
        return new StocksDto(stocks);

    }

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
