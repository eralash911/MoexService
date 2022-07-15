package com.eralash.moexservice.dto;

import com.eralash.moexservice.model.Stock;
import lombok.Value;
import java.util.List;

@Value
public class StocksDto {
    List<Stock> stocks;
}
