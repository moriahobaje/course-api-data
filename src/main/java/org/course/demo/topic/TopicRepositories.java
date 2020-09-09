package org.course.demo.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepositories extends CrudRepository <Topic,String >{


    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)
}
