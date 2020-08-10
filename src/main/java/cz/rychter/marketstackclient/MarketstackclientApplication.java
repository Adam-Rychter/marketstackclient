package cz.rychter.marketstackclient;

import cz.rychter.marketstackclient.services.MarketStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketstackclientApplication {

    public static void main(String[] args) {

        SpringApplication.run(MarketstackclientApplication.class, args);
    }

}
