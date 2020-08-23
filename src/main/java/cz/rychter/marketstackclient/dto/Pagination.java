package cz.rychter.marketstackclient.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(builder = Pagination.PaginationBuilder.class)
@Getter
@Setter
@Builder
public class Pagination {
    private Integer limit, offset, count, total;

    @JsonPOJOBuilder(withPrefix = "")
    public static class PaginationBuilder{}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagination)) return false;

        Pagination that = (Pagination) o;

        if (!getLimit().equals(that.getLimit())) return false;
        if (!getOffset().equals(that.getOffset())) return false;
        if (!getCount().equals(that.getCount())) return false;
        return getTotal().equals(that.getTotal());
    }

    @Override
    public int hashCode() {
        int result = getLimit().hashCode();
        result = 31 * result + getOffset().hashCode();
        result = 31 * result + getCount().hashCode();
        result = 31 * result + getTotal().hashCode();
        return result;
    }
}
