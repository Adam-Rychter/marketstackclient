package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@JsonDeserialize(builder = StockExchange.StockExchangeBuilder.class)
@Data
@Builder
@EqualsAndHashCode
public class StockExchange {
    private String name,acronym, mic,country, city,website;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonPOJOBuilder(withPrefix = "")
    public static class StockExchangeBuilder{}
}
