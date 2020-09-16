package Kafka.KafkaSpringBoot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class MessageSample {
    private String firstName;
    private String lastName;
    private int age;
    private String handledTimestamp;
}

