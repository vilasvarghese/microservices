package com.example.FirstSpringBoot.topic;
import com.example.FirstSpringBoot.topic.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topicList = new ArrayList<Topic>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java","Core Java","Core Java Description"),
			new Topic("javascript","JavaScript", "Javascript Description")
			));
	
	public List<Topic> getAllTopics(){
		return topicList;
	}
	
	public Topic getTopic(String id) {
		return topicList.stream().filter(t ->t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicList.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i=0; i < topicList.size(); i++) {
			Topic t = topicList.get(i);
			if (t.getId().equals(id)) {
				topicList.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topicList.removeIf(t -> t.getId().equals(id));
	}
}
