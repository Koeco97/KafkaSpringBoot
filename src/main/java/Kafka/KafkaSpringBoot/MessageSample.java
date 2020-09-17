package Kafka.KafkaSpringBoot;

import lombok.Data;

@Data
public class MessageSample {
    private String firstName;
    private String lastName;
    private int age;
    private String handledTimestamp;
}

