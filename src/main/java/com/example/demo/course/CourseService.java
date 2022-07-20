package com.example.demo.course;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("CourseService")
public class CourseService implements ICourseService {

	private final CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository){
		this.courseRepository = courseRepository;
	}

	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	public void addNewCourse(Course course) {
		Optional<Course> courseByCode = courseRepository.buscarPorCode(course.getCode());
		
		if (courseByCode.isPresent()) throw new IllegalStateException("code already registered");

		courseRepository.save(course);
	}

	public void deleteCourse(Long id){
		boolean exists = courseRepository.existsById(id);
				
		if (!exists) throw new IllegalStateException("course not found");

		courseRepository.deleteById(id);
	}

	@Transactional
	public void updateCourse(Long id, String name, Integer code){
		Course course = courseRepository.findById(id).orElseThrow(()->new IllegalStateException("course not found"));

		if (name != null) course.setName(name);
		if (code <= 9999) throw new IllegalStateException("code must be 5 digits");

		Optional<Course> courseByCode = courseRepository.buscarPorCode(code);
		if (courseByCode.isPresent()) throw new IllegalStateException("code already registered");

		course.setCode(code);
	}
}
