package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@JsonDeserialize(builder = TickersDataItem.TickersDataItemBuilder.class)
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class TickersDataItem {
    private Pagination pagination;
    private ArrayList<Ticker> data;
    @JsonPOJOBuilder(withPrefix = "")
    public static class TickersDataItemBuilder<T>{}
}
