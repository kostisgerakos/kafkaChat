package com.kafka.chat.consumers;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;

public class ListTopicsConsumer {

	private final String brokers;
	private final String schema;
	private final Properties props = new Properties();
	private final KafkaConsumer<String, String> consumer;

	public ListTopicsConsumer(String brokers, String schema) {
		this.brokers = brokers;
		this.schema = schema;
		props.put("bootstrap.servers", brokers);
		props.put("group.id", "GroupTopicConsumer");
		props.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("schema.registry.url", schema);
		consumer = new KafkaConsumer<String, String>(props);

	}

	public Set<String> getGroupTopics() {

		Set<String> topics = consumer.listTopics().keySet().stream().filter(s -> s.startsWith("kafka"))
				.collect(Collectors.toSet());
		consumer.close();
		return topics;
	}
	
}