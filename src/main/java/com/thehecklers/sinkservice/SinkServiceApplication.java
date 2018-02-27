package com.thehecklers.sinkservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;

@EnableBinding(Sink.class)
@SpringBootApplication
public class SinkServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkServiceApplication.class, args);
    }
}

@Log
@MessageEndpoint
class SinkLogger {
    @StreamListener(Sink.INPUT)
    public void logPing(Ping pingMessage) {
        log.info(pingMessage.toString());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Ping {
    private String id;
    private String payload;
}