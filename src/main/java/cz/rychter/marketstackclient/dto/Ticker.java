package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(builder = Ticker.TickerBuilder.class)
@Getter
@Setter
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticker)) return false;

        Ticker ticker = (Ticker) o;

        if (getName() != null ? !getName().equals(ticker.getName()) : ticker.getName() != null) return false;
        if (getSymbol() != null ? !getSymbol().equals(ticker.getSymbol()) : ticker.getSymbol() != null) return false;
        if (getCountry() != null ? !getCountry().equals(ticker.getCountry()) : ticker.getCountry() != null)
            return false;
        if (getHasIntraday() != null ? !getHasIntraday().equals(ticker.getHasIntraday()) : ticker.getHasIntraday() != null)
            return false;
        if (getHasEod() != null ? !getHasEod().equals(ticker.getHasEod()) : ticker.getHasEod() != null) return false;
        return getStockExchange() != null ? getStockExchange().equals(ticker.getStockExchange()) : ticker.getStockExchange() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSymbol() != null ? getSymbol().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getHasIntraday() != null ? getHasIntraday().hashCode() : 0);
        result = 31 * result + (getHasEod() != null ? getHasEod().hashCode() : 0);
        result = 31 * result + (getStockExchange() != null ? getStockExchange().hashCode() : 0);
        return result;
    }
}
