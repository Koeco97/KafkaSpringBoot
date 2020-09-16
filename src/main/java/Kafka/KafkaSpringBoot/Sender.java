package Kafka.KafkaSpringBoot;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Sender {
    private final KafkaTemplate<String, MessageSample> kafkaTemplate;

    @Autowired
    public Sender(KafkaTemplate<String, MessageSample> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(MessageSample data, String topic) {
        data.setHandledTimestamp(LocalDateTime.now().toString());
        ProducerRecord<String, MessageSample> record = new ProducerRecord<>(topic, data);
        kafkaTemplate.send(record);
    }


}
