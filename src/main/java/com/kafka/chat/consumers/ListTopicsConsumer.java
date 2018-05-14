package com.kafka.chat.consumers;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;



public class ListTopicsConsumer {
	
	
	public Set<String> getGroupTopics() {
		final Properties props = new Properties();
		//Basic properties values
		props.put("bootstrap.servers", "localhost:9092");
		props.put("enable.auto.commit", "false");
		props.put("group.id", "LocationConsumer2");
		props.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("schema.registry.url", "localhost:8081");
	
		//Map<String, List<PartitionInfo>> topics;
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		//topics = consumer.listTopics();
		Set<String> topics = consumer.listTopics().keySet()
                .stream()
                .filter(s -> s.startsWith("kafka"))
                .collect(Collectors.toSet());
	   /*   System.out.println("******************************************");
	      System.out.println("          L I S T    T O P I C S          ");
	      System.out.println("******************************************\n");

	      for (Map.Entry<String, List<PartitionInfo>> topic : topics.entrySet()) {
	         System.out.println("Topic: "+ topic.getKey());
	         //System.out.println("Value: " + topic.getValue() + "\n");
	      }
		*/
		consumer.close();
		return topics;
	}

}