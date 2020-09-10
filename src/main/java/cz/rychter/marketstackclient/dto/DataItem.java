package cz.rychter.marketstackclient.dto;

import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@EqualsAndHashCode
public class DataItem<T> {
    private Pagination pagination;
    private ArrayList<T> data;
}
