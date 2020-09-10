# KafkaSpringBoot

Description:
Develop Spring Boot application which consumes JSON messages of the following format 
{"firstName": "Sergey", "lastName": "Prokofiev", "age": 29} 
from Kafka topic (topic1), modifies them appending handledTimestamp
with current timestamp and outputting into another Kafka topic (topic2). 
Both topics exist before application startup. 
Console producer is used to publish messages to the topic1. 
Console consumer is used to read messages from topic2.

Example: 
1. User creates topic1, topic2 in Kafka
2. Application starts
3. User connects with console consumer to topic2
4. User connects with console producer to topic1
5. User sent messages of appropriate form into topic1
6. User verifies that modified message arrived in topic2
