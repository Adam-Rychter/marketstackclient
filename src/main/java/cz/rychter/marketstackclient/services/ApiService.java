package cz.rychter.marketstackclient.services;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ApiService {

    private final MarketStackService marketStackService;

    public ApiService(MarketStackService marketStackService) {
        this.marketStackService = marketStackService;
    }

    @RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE,  method = RequestMethod.GET)
    public String home() {
        return "<a href=\"http://localhost:8080/tickerEod?ticker=AMD\">Jeste nemam FE ale zatim zkus tohle -> http://localhost:8080/tickerEod?ticker=AMD</a>";
    }

    @RequestMapping(value = "/tickerEod", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
    public String getTickerEod(@RequestParam String ticker){

        // Tahle mapa by se mela plnit z FE
        HashMap<String, String> paramMap = new HashMap();
        paramMap.put("symbols", ticker);
        return marketStackService.getTickerDataEOD(paramMap);
    }
}
