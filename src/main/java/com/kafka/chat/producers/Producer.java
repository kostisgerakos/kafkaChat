package com.kafka.chat.producers;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.chat.system.PersonalMessage;



public class Producer {
   


	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final String topic = "KafkaKGCh";
		final Properties props = new Properties();

		props.put("bootstrap.servers", "eagle5.di.uoa.gr:9092");
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer","io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("schema.registry.url", "http://eagle5.di.uoa.gr:8081");

		final PersonalMessage pm = new PersonalMessage("from","to","message");
		final ProducerRecord<String, PersonalMessage> record = new ProducerRecord<>(topic,pm);
		final KafkaProducer<String, PersonalMessage > producer = new KafkaProducer<>(props);


		producer.send(record);
	    producer.close();

	}
}