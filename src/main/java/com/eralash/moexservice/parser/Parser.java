package com.eralash.moexservice.parser;

import com.eralash.moexservice.dto.BondDto;

import java.util.List;

public interface Parser {
    List<BondDto> parser(String ratesAsString);
}
