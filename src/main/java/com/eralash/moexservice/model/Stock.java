package com.eralash.moexservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class Stock {
    String name;
    String ticker;
    String figi;
    String type;
    Currency currency;
    String source;
}
