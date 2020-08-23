package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(builder = StockExchange.StockExchangeBuilder.class)
@Getter
@Setter
@Builder
public class StockExchange {
    private String name,acronym, mic,country, city,website;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonPOJOBuilder(withPrefix = "")
    public static class StockExchangeBuilder{}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockExchange)) return false;

        StockExchange that = (StockExchange) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getAcronym() != null ? !getAcronym().equals(that.getAcronym()) : that.getAcronym() != null) return false;
        if (getMic() != null ? !getMic().equals(that.getMic()) : that.getMic() != null) return false;
        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null) return false;
        if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null) return false;
        if (getWebsite() != null ? !getWebsite().equals(that.getWebsite()) : that.getWebsite() != null) return false;
        return getCountryCode() != null ? getCountryCode().equals(that.getCountryCode()) : that.getCountryCode() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAcronym() != null ? getAcronym().hashCode() : 0);
        result = 31 * result + (getMic() != null ? getMic().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getWebsite() != null ? getWebsite().hashCode() : 0);
        result = 31 * result + (getCountryCode() != null ? getCountryCode().hashCode() : 0);
        return result;
    }
}
