package com.example.demo.course;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data //abstrai getters, setters, construtor, etc muito bom <3
@RequiredArgsConstructor
public class Course {
    @Id 
    @SequenceGenerator(
        name= "course_sequence",
        sequenceName = "course_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_sequence"
    )
    
    @NonNull
    private Long id;
    // @NonNull
    private String name;
    // @NonNull
    private int code;
    
    
    public Course(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    /*
    public Course() {}

    public Course(Long id, String name, Integer code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + id +
            ", name='" + name +'\'' +
            ", code=" + code +
            '}';
    }

    */

}
