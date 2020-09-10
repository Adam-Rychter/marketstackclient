package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(builder = Ticker.TickerBuilder.class)
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Ticker {
    private String name, symbol, country;
    @JsonProperty("has_intraday")
    private Boolean hasIntraday;
    @JsonProperty("has_eod")
    private Boolean hasEod;
    @JsonProperty("stock_exchange")
    private StockExchange stockExchange;
    @JsonPOJOBuilder(withPrefix = "")
    public static class TickerBuilder{}
}
