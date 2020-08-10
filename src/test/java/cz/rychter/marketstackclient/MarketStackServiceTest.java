package cz.rychter.marketstackclient;

import cz.rychter.marketstackclient.services.MarketStackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@SpringBootTest
public class MarketStackServiceTest {


    @Autowired //Melo by byt Mockovano
    private MarketStackService marketStackService;

    @Test
    public void buildRequestParamsTest() {
        try {
            Method buildRequestParams = MarketStackService.class.getDeclaredMethod("buildRequestParams", HashMap.class, String.class);
            HashMap<String, String> params = new HashMap<>();
            params.put("symbol", "AMD");
            buildRequestParams.setAccessible(true);
            UriComponentsBuilder builder = (UriComponentsBuilder)buildRequestParams.invoke(marketStackService, params, "http://testurl");
            Assertions.assertEquals("http://testurl?access_key=5b54788ea1c4f310a76f97f906a8704d&symbol=AMD", builder.toUriString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
