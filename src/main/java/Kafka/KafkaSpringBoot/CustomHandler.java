package Kafka.KafkaSpringBoot;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomHandler implements ErrorHandler {

    @Bean
    public CustomHandler getCustomHandler() {
        return new CustomHandler();
    }

    @Override
    public void handle(Exception e, ConsumerRecord<?, ?> consumerRecord) {

    }

    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> data, Consumer<?, ?> consumer) {
        readNextOffset(thrownException, consumer);
    }

    @Override
    public void clearThreadState() {
    }

    @Override
    public boolean isAckAfterHandle() {
        return false;
    }

    @Override
    public void handle(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container) {
        readNextOffset(thrownException, consumer);
    }

    private void readNextOffset(Exception thrownException, Consumer<?, ?> consumer) {
        String s = thrownException.getMessage();
        String topic = s.replaceAll(".*partition (.*)-.*", "$1");
        int partition = Integer.valueOf(s.replaceAll(".*(\\d+) at.*", "$1"));
        int offset = Integer.valueOf(s.replaceAll(".*offset (\\d+).*", "$1"));
        TopicPartition topicPartition = new TopicPartition(topic, partition);
        consumer.seek(topicPartition, offset + 1);
    }
}
