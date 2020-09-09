package org.course.demo.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
	@Autowired
	private final CoursesRepositories coursesRepositories;

	public CoursesService(CoursesRepositories coursesRepositories) {
		this.coursesRepositories = coursesRepositories;
	}

	public List<Courses> getAllCourses(String topicId){
		// return topics;
		List<Courses> courses = new ArrayList<>();
  		coursesRepositories.findByTopicId(topicId)
				.forEach(courses::add);
  		return courses;
	}

	public Optional<Courses> getCourse(String id) {
		//return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return coursesRepositories.findById(id);
	}

	public void addCourse(Courses course) {
		//topics.add(topic);
		coursesRepositories.save(course);
	}
	
	public void updateCourse(Courses courses) {
		
		/*for(int i =0; i<topics.size(); i++) {
			Topic t = topics.get(i); 
			if(t.getId().equals(id)) {
				courses.set(i,topic);
				return; 
			}
		}*/
		coursesRepositories.save(courses);
		
	}

	public void deleteCourse(String id) {
		//courses.removeIf(t -> t.getId().equals(id));
		coursesRepositories.deleteById(id);
		
	}
}
	
