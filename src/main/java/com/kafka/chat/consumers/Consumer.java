package com.kafka.chat.consumers;

import java.util.Arrays;
import java.util.Properties;

//Use of new org.apache.kafka.clients.consumer package 
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.chat.system.PersonalMessage;



public class Consumer {
	public static void main(String[] args) {
		final String topic = "KafkaKGCh";
		final Properties props = new Properties();
		//Basic properties values
		props.put("bootstrap.servers", "eagle5.di.uoa.gr:9092");
		props.put("enable.auto.commit", "false");
		props.put("group.id", "KafkaChatConsumer");
		props.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("schema.registry.url", "http://eagle5.di.uoa.gr:8081");

		final KafkaConsumer<String, PersonalMessage> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic));
		while (true) {
			final ConsumerRecords<String, PersonalMessage> r = consumer.poll(1000);
			for (ConsumerRecord<String, PersonalMessage> rr : r) {
				System.out.println(rr.value());
			}
		}

	}
}