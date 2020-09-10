package Kafka.KafkaSpringBoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
public class KafkaSpringBootApplication {
    private static final Logger LOG = LoggerFactory.getLogger(MessageSample.class);
    private static final String topicFrom = "topic1";
    private static final String topicTo = "topic2";

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringBootApplication.class, args);
    }

    @Autowired
    private Sender sender;

    @KafkaListener(topics = topicFrom)
    public void receive(@Payload MessageSample data) {
        LOG.info("received data from {} = '{}'", topicFrom, data);
        sender.send(data, topicTo);
    }
}
