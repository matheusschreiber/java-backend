package com.example.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller() //pode retornar html e outras coisas alem de json

@RestController //ja retorna json
@RequestMapping(path="/course")
public class CourseController {

    @Autowired
    @Qualifier("CourseService2")
    private ICourseService courseService;

    /*
    * 
     private final CourseService courseService;
     public CourseController(CourseService courseService) {
         this.courseService = courseService;
     }
     */

    @GetMapping
	public List<Course> getCourses() {
        return courseService.getCourses();
	}

    @PostMapping
    public void registerNewCourse(@RequestBody Course course){
        courseService.addNewCourse(course);
    }

    @DeleteMapping(path="{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long id){
        courseService.deleteCourse(id);
    }

    @PutMapping(path="{courseID}")
    public void updateCourse(@PathVariable("courseID") Long id, @RequestBody Course course){
        courseService.updateCourse(id, course.getName(), course.getCode());
    }
}
