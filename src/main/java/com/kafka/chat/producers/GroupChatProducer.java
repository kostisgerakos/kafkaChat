package com.kafka.chat.producers;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.chat.system.PersonalMessage;

public class GroupChatProducer {

	private final String brokers;
	private final String schema;
	private final String topic;
	private final KafkaProducer<String, PersonalMessage> producer;
	private final Properties props;

	PersonalMessage pm;
	ProducerRecord<String, PersonalMessage> record;

	public GroupChatProducer(String brokers, String schema, String topic) {
		this.brokers = brokers;
		this.schema = schema;
		this.topic = topic;
		this.props = new Properties();
		props.put("bootstrap.servers", brokers);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("schema.registry.url", schema);

		this.producer = new KafkaProducer<>(props);

	}

	public void sendGroupMessage(String from,String message) {
		this.pm = new PersonalMessage(from, "to", message);
		this.record = new ProducerRecord<>(topic, pm);
		this.producer.send(record);
	}

	public void closeGroupChatProducer() {
		producer.close();
	}

}