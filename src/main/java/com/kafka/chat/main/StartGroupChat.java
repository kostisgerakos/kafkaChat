package com.kafka.chat.main;

import com.kafka.chat.consumers.ListTopicsConsumer;
import com.kafka.chat.graphics.TopicsList;

public class StartGroupChat {
	public static void main(String[] args) {
		ListTopicsConsumer group = new ListTopicsConsumer("localhost:9092","localhost:8081");
		TopicsList gui = new TopicsList();
		gui.start(group.getGroupTopics());
		

	}
}
