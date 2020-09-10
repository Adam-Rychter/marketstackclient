package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

@JsonDeserialize(builder = Pagination.PaginationBuilder.class)
@Data
@Builder
@EqualsAndHashCode
public class Pagination {
    private Integer limit, offset, count, total;
    @JsonPOJOBuilder(withPrefix = "")
    public static class PaginationBuilder{}
}
