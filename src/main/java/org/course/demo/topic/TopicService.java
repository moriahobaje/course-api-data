package org.course.demo.topic;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private final TopicRepositories topicRepositories;

	public TopicService(TopicRepositories topicRepositories) {
		this.topicRepositories = topicRepositories;
	}

	public List<Topic> getAllTopics(){
		// return topics;
		List<Topic> topics = new ArrayList<>();
  		topicRepositories.findAll()
				.forEach(topics::add);
  		return topics;

	}
	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepositories.findById(id);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepositories.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		
		/*for(int i =0; i<topics.size(); i++) {
			Topic t = topics.get(i); 
			if(t.getId().equals(id)) {
				topics.set(i,topic);
				return; 
			}
		}*/
		topicRepositories.save(topic);
		
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepositories.deleteById(id);
		
	}
}
	
