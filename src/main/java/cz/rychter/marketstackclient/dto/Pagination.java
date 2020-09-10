package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(builder = Pagination.PaginationBuilder.class)
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Pagination {
    private Integer limit, offset, count, total;
    @JsonPOJOBuilder(withPrefix = "")
    public static class PaginationBuilder{}
}
