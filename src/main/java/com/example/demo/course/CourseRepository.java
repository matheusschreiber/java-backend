package com.example.demo.course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    //essa anotação transforma esse método debaixo no parametro da anotação
    @Query("SELECT s FROM Course s WHERE s.code = ?1")
    Optional<Course> buscarPorCode(Integer code);

}

