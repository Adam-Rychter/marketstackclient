package cz.rychter.marketstackclient.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class DataItem<T> {
    private Pagination pagination;
    private ArrayList<T> data;
}
