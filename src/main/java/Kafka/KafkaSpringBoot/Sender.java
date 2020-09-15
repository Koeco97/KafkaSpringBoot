package Kafka.KafkaSpringBoot;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, MessageSample> kafkaTemplate;

    public void send(MessageSample data, String topic) {
        data.setHandledTimestamp(LocalDateTime.now().toString());
        ProducerRecord<String, MessageSample> record = new ProducerRecord<>(topic, data);
        kafkaTemplate.send(record);
    }
}
