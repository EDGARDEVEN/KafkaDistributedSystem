package com.example;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class PublishingCenterConsumer {
    private static final String TOPIC_NAME = "advertisement-topic";

    public static void main(String[] args) {
        // Set Kafka consumer properties
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "publishing-center-group");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            // Subscribe to the Kafka topic
            consumer.subscribe(Collections.singletonList(TOPIC_NAME));

            // Poll for new advertisement messages
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                records.forEach(record -> {
                    System.out.println("Received advertisement: " + record.value());
                    // Process the received advertisement message
                    // Further processing logic can be added here
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
