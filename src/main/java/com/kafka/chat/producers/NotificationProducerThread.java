package com.kafka.chat.producers;

import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.chat.system.PersonalMessage;


public class NotificationProducerThread implements Runnable {

  private final KafkaProducer<String, GenericRecord> producer;
  private final String topic;

  public NotificationProducerThread(String brokers, String topic) {
    Properties prop = createProducerConfig(brokers);
    this.producer = new KafkaProducer<String, GenericRecord>(prop);
    this.topic = topic;
  }

  private static Properties createProducerConfig(String brokers) {
    Properties props = new Properties();
    props.put("bootstrap.servers", brokers);
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
	props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	props.put("schema.registry.url", "http://localhost:8081");
    return props;
  }

  @Override
  public void run() {
    System.out.println("Produces 3 messages");
    for (int i = 0; i < 5; i++) {
    	PersonalMessage pm = new PersonalMessage("from","to","message");
		ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>(topic,"key", pm);
      //String msg = "Message " + i;
      producer.send(record, new Callback() {
        public void onCompletion(RecordMetadata metadata, Exception e) {
          if (e != null) {
            e.printStackTrace();
          }
          //System.out.println("Sent:" + msg + ", Partition: " + metadata.partition() + ", Offset: "
           //   + metadata.offset());
        }
      });

    }
    producer.close();

  }
}
