package org.course.demo.courses;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepositories extends CrudRepository <Courses,String >{

    //getAllTopics()
    public List<Courses> findByTopicId(String topicId);
    //getTopic(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)
}
