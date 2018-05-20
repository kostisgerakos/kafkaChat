package com.kafka.chat.graphics;

import java.awt.*;
import java.awt.event.*;
import java.util.Set;

import javax.swing.*;

import com.kafka.chat.consumers.ListTopicsConsumer;

public class TopicsList {
	final ListTopicsConsumer group;

	public TopicsList() {
		this.group = new ListTopicsConsumer("eagle5.di.uoa.gr:9092", "http://eagle5.di.uoa.gr:8081");
		display(group.getGroupTopics());
	}

	public void display(Set<String> topics) {
		final JList list = new JList(topics.toArray());
		final JScrollPane pane = new JScrollPane(list);
		final JFrame frame = new JFrame("Chat Groups");
		final JButton btnGet = new JButton("Get Selected");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndices[] = list.getSelectedIndices();
				for (int j = 0; j < selectedIndices.length; j++) {
					String elem = (String) list.getModel().getElementAt(selectedIndices[j]);
					// frame.setVisible(false);
					ChatMain chat = new ChatMain(elem);
				}
			}
		});

		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.getContentPane().add(btnGet, BorderLayout.SOUTH);
		frame.setSize(200, 500);
		frame.setVisible(true);
	}

}
