package com.example.demo.course;

import java.util.List;

public interface ICourseService {
	public List<Course> getCourses();

	public void deleteCourse(Long id);

	public void addNewCourse(Course course);

	public void updateCourse(Long id, String name, Integer code);
}
