package org.sid.app.controllers;

import java.util.List;

import org.sid.app.dto.TopicDto;
import org.sid.app.services.TopicService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topics")
public class TopicController {

	private final TopicService topicService;

	public TopicController(TopicService topicService) {
		super();
		this.topicService = topicService;
	}

	@PostMapping("/addTopic")
	public TopicDto add(@RequestBody TopicDto topicDto) {
		return topicService.add(topicDto);
	}

	@DeleteMapping("/deleteTopic/{topicId}")
	public void deleteById(@PathVariable Long topicId) {
		topicService.deleteById(topicId);
	}

	@GetMapping("/getTopic/{topicId}")
	public TopicDto findById(@PathVariable Long topicId) {
		return topicService.findById(topicId);
	}

	@GetMapping("/getAllTopics")
	public List<TopicDto> findAll() {
		return topicService.findAll();
	}

}
