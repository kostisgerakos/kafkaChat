package com.kafka.chat.consumers;

import java.util.Arrays;
import java.util.Properties;

import javax.swing.JTextArea;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


import com.chat.system.PersonalMessage;

import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

public class GroupChatConsumer implements Runnable {

	private final String brokers;
	private final String schema;
	private final String topic;
	private final KafkaConsumer<String, PersonalMessage> consumer;
	private final Properties props;
	private final JTextArea chatBox;

	public GroupChatConsumer(String brokers, String schema, String topic,  JTextArea chatBox, String group) {
		this.brokers = brokers;
		this.schema = schema;
		this.topic = topic;
		this.props = new Properties();
		this.chatBox = chatBox;
	
		props.put("bootstrap.servers", brokers);
		props.put("enable.auto.commit", "true");
		props.put("group.id", group);
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("schema.registry.url", schema);
	    props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true); 

	    consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic));	

	}
	
	public void run(){
		while (true) {
			final ConsumerRecords<String, PersonalMessage> r = consumer.poll(1000);
			for (ConsumerRecord<String, PersonalMessage> rr : r) {
				//System.out.println(rr.value());
				chatBox.append(rr.value().from + ": " + rr.value().message + "\n");
			}
		}
	}

}