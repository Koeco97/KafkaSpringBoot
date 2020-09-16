package Kafka.KafkaSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class SenderConfig {

    private ProducerFactory producerFactory;

    @Autowired
    public void setProducerFactory(ProducerFactory producerFactory) {
        this.producerFactory = producerFactory;
    }

    @Bean
    public KafkaTemplate<String, MessageSample> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory);
    }


}
