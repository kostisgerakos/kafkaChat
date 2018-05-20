package com.kafka.chat.graphics;

import javax.swing.*;

import com.kafka.chat.consumers.GroupChatConsumer;
import com.kafka.chat.producers.GroupChatProducer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatMain {

	String username = "kostis";
	String topic;
	JTextField messageBox;
	JTextArea chatBox;
	JButton sendMessage;
	final GroupChatProducer producer;
	final GroupChatConsumer consumer;

	public ChatMain(String topic) {
		this.topic = topic;
		this.producer = new GroupChatProducer("eagle5.di.uoa.gr:9092", "http://eagle5.di.uoa.gr:8081", topic);
		this.display();
		this.consumer = new GroupChatConsumer("eagle5.di.uoa.gr:9092", "http://eagle5.di.uoa.gr:8081", topic,
				this.chatBox, username + "Consumer");
		Thread t = new Thread(consumer);
		t.start();
	}

	public void display() {

		JFrame frame = new JFrame("Group Chat for " + topic + " User : " + username);
		JPanel panel = new JPanel(); // the panel is not visible in output
		JLabel label = new JLabel("Enter Text");
		messageBox = new JTextField(10); // accepts upto 10 characters

		JButton sendMessage = new JButton("Send");
		sendMessage.addActionListener(new sendMessageButtonListener());

		JButton reset = new JButton("Reset");
		panel.add(label); // Components Added using Flow Layout
		panel.add(label); // Components Added using Flow Layout
		panel.add(messageBox);
		panel.add(sendMessage);
		panel.add(reset);

		chatBox = new JTextArea();

		frame.setLayout(new BorderLayout());
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, chatBox);
		frame.setVisible(true);
	}

	class sendMessageButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (messageBox.getText().length() < 1) {
				// do nothing
			} else if (messageBox.getText().equals(".clear")) {
				chatBox.setText("Cleared all messages\n");
				messageBox.setText("");
			} else {
				producer.sendGroupMessage(username, messageBox.getText());
				;
			}
			messageBox.requestFocusInWindow();
		}
	}
}
