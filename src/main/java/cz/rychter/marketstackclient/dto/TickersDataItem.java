package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import java.util.ArrayList;

@JsonDeserialize(builder = TickersDataItem.TickersDataItemBuilder.class)
@Data
@Builder
@EqualsAndHashCode
public class TickersDataItem {
    private Pagination pagination;
    private ArrayList<Ticker> data;
    @JsonPOJOBuilder(withPrefix = "")
    public static class TickersDataItemBuilder<T>{}
}
