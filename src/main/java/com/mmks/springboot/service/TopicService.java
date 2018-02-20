package com.mmks.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mmks.springboot.model.Topic;

@Service
public class TopicService {
	/*private List<Topic> topics = Arrays.asList(  //Not mutable - use ArrayList if need to add
			new Topic("1", "topic 1", "Cameras"), 
			new Topic("2", "topic 2", "PCs"),
			new Topic("3", "topic 3", "Mobile"), 
			new Topic("4", "topic 4", "Games"),
			new Topic("5", "topic 5", "Apps"));*/
	
	private List<Topic> topics = new ArrayList<Topic>();
	
	public TopicService() {
		topics.add(new Topic("1", "topic 1", "Cameras"));
		topics.add(new Topic("2", "topic 2", "PCs"));
		topics.add(new Topic("3", "topic 3", "Mobile"));
		topics.add(new Topic("4", "topic 4", "Games"));
		topics.add(new Topic("5", "topic 5", "Apps"));
	}

	public List<Topic> getAllTopics() {
		return this.topics;
	}

	public Topic getTopic(String id) {
		return (Topic) this.topics.stream().filter(t -> {
			return t.getId().equals(id);
		}).findFirst().get();
	}

	public void addTopic(Topic topic) {
		this.topics.add(topic);
	}
}
