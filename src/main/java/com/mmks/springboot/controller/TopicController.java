package com.mmks.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mmks.springboot.model.Topic;
import com.mmks.springboot.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService; // DI

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {

		return this.topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable(name="id") String topicId) {
		return this.topicService.getTopic(topicId);
	}
	
	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {  //Convert JSON representation of Topic into Topic object
		this.topicService.addTopic(topic);
	}
}
