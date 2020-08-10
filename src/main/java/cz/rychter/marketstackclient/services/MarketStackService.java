package cz.rychter.marketstackclient.services;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;

@Service
public class MarketStackService {

    private final RestTemplate restTemplate;

    private final String apiToken;

    public MarketStackService(RestTemplate restTemplate, String apiToken) {
        this.restTemplate = restTemplate;
        this.apiToken = apiToken;
    }

    private HttpHeaders getJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    //Spise pro debug a pro ziskani dat writeDataToFile(ticker, response.getBody());
    private void writeDataToFile(String tickerName, String tickerData) {
        String fileName = tickerName + ".json";
        try {
            Files.write(Paths.get(fileName), stripInfoData(tickerData).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ufikneme data o paginaci, ty nam jsou pri zapisu nanic!
    private String stripInfoData(String rawData) {
        JSONObject jsonObject = new JSONObject(rawData);
        return jsonObject.getJSONArray("data").toString();
    }

    public String getTickerDataEOD(HashMap<String, String> params) {
        // Tohle url musi do nejake konfigurace, nejsme v CoTraRepu abychom hardkodovali :D
        String url = "http://api.marketstack.com/v1/eod";
        UriComponentsBuilder requestParams = buildRequestParams(params, url);
        ResponseEntity<String> response = sendRequest(requestParams, getJsonHeader(), String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Melo by byt error page ale zadnou zatim nenmam
            return "Error";
        }
    }

    private UriComponentsBuilder buildRequestParams(HashMap<String, String> params, String url) {
        UriComponentsBuilder requestParams = UriComponentsBuilder.fromHttpUrl(url).queryParam("access_key", apiToken);
        params.forEach(requestParams::queryParam);
        return requestParams;
    }

    private <T> ResponseEntity<T> sendRequest(UriComponentsBuilder requestParams, HttpHeaders headers, Class<T> type) {
        return restTemplate.exchange(requestParams.toUriString(), HttpMethod.GET, new HttpEntity<T>(headers), type);
    }
}
