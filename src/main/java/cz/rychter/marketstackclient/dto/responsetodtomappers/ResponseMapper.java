package cz.rychter.marketstackclient.dto.responsetodtomappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.rychter.marketstackclient.dto.Pagination;

import java.util.ArrayList;

public class ResponseMapper {

    private ObjectMapper objectMapper;

    public ResponseMapper() {
        objectMapper = new ObjectMapper();
    }

    public Pagination extractPagination(String data) throws JsonProcessingException {
        return objectMapper.readValue(data, Pagination.class);
    }
//
//    public <T> ArrayList<T> extractData(String data, Class<T> type) throws JsonProcessingException {
//        return objectMapper.readValue(data, type);
//    }
}
