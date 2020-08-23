package cz.rychter.marketstackclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.rychter.marketstackclient.dto.DataItem;
import cz.rychter.marketstackclient.dto.Pagination;
import cz.rychter.marketstackclient.dto.Ticker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URL;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class POJOExtractionTest {

    private ObjectMapper objectMapper;

    @BeforeAll
    public void init() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void jsonToPagination() throws IOException {
        Pagination pagination = objectMapper
                .readValue(new URL("file:src/test/resources/testPaginationExtraction.json"), Pagination.class);

        Assertions.assertEquals(Pagination
                .builder()
                .limit(1)
                .count(1)
                .offset(0)
                .total(132291)
                .build(), pagination);
    }

    @Test
    public void getTickersDataTest() throws IOException {

        DataItem<Ticker> tickers = objectMapper
                .readValue(new URL("file:src/test/resources/GetTickersData.json"), new TypeReference<>() { //this references the generic type
                });

        Assertions.assertEquals(10, tickers.getData().size());
    }

}
