package com.kafka.chat.graphics;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import org.apache.kafka.common.PartitionInfo;

public class TopicsList {

	public void start(Set<String> topics) {
		final JList list = new JList(topics.toArray());
		final JScrollPane pane = new JScrollPane(list);
		final JFrame frame = new JFrame("Chat Groups");

		// create a button and add action listener
		final JButton btnGet = new JButton("Get Selected");
		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedElem = "";
				int selectedIndices[] = list.getSelectedIndices();
				for (int j = 0; j < selectedIndices.length; j++) {
					String elem = (String) list.getModel().getElementAt(selectedIndices[j]);
					selectedElem += "\n" + elem;

				}
				JOptionPane.showMessageDialog(frame, "You've selected:" + selectedElem);
			}// end actionPerformed
		});

		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.getContentPane().add(btnGet, BorderLayout.SOUTH);
		frame.setSize(200, 500);
		frame.setVisible(true);
	}

	/*public static void main(String[] args) {
		final int MAX = 10;
		// initialize list elements
		// String[] listElems = new String[MAX];
		ArrayList topics = new ArrayList();
		for (int i = 0; i < MAX; i++) {
			// listElems[i] = "element " + i;
			topics.add("element " + i);
		}
		TopicsList topicList = new TopicsList();
		topicList.start(topics);

	}*/
}
