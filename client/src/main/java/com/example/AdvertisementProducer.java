package com.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class AdvertisementProducer {
    private static final String TOPIC_NAME = "advertisement-topic";

    public static void main(String[] args) {
        // Set Kafka producer properties
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            // Create and send advertisement messages to the Kafka topic
            for (int i = 0; i < 10; i++) {
                String advertisementContent = "Advertisement " + i + " Content";
                String advertiserName = "Advertiser X";
                String publicationDate = "2024-04-25";

                ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, advertisementContent);
                producer.send(record);
                System.out.println("Sent advertisement: " + advertisementContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
