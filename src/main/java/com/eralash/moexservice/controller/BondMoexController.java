package com.eralash.moexservice.controller;


import com.eralash.moexservice.dto.StocksDto;
import com.eralash.moexservice.dto.TickersDto;
import com.eralash.moexservice.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bonds")
@RequiredArgsConstructor
public class BondMoexController {
    private final BondService bondService;

    @PostMapping("/getBondsByTickers")
    public StocksDto getBondsFromMoex(@RequestBody TickersDto tickersDto) {
        return bondService.getBondsFromMoex(tickersDto);
    }


}
