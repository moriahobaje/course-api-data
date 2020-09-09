package org.course.demo.courses;


import org.course.demo.topic.Topic;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController 
public class CoursesController {
	
	@Autowired
	private CoursesService coursesService;

	@RequestMapping ("topics/{id}/courses")
	public List<Courses> getAllCourses (@PathVariable String id) {
		return coursesService.getAllCourses(id);
	}

	@RequestMapping ("/topics/{topicId}/courses/{id}")
	public Optional<Courses> getCourse(/* @PathVariable String topicId,*/ @PathVariable String id) {
		return coursesService.getCourse(id);

	}

	@RequestMapping(method=RequestMethod.POST, value = "/topics/{topicsId}/courses")
	public void addCourse(@RequestBody Courses course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "",""));
		coursesService.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicsId}/courses/{id}")
	public void updateCourse(@RequestBody Courses course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		coursesService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/topics/{topicsId}/courses/{id}")
	public void deleteCourse(@RequestBody Courses courses, @NotEmpty @PathVariable String id) {
		coursesService.deleteCourse(id);
	}
}
