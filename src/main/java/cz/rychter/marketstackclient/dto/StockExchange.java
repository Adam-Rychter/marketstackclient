package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(builder = StockExchange.StockExchangeBuilder.class)
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class StockExchange {
    private String name,acronym, mic,country, city,website;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonPOJOBuilder(withPrefix = "")
    public static class StockExchangeBuilder{}
}
