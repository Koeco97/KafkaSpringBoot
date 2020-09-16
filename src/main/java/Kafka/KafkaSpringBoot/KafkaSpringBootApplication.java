package Kafka.KafkaSpringBoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaSpringBootApplication {
    private static final Logger LOG = LoggerFactory.getLogger(MessageSample.class);
    private static final String TOPIC_FROM = "topic1";
    private static final String TOPIC_TO = "topic2";

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringBootApplication.class, args);
    }

    @Autowired
    private Sender sender;

    @KafkaListener(topics = TOPIC_FROM)
    public void receive(MessageSample data) {
        LOG.info("received data from {} = '{}'", TOPIC_FROM, data);
        sender.send(data, TOPIC_TO);
    }
}
