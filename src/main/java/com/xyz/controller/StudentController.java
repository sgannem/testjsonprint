package com.xyz.controller;

import com.xyz.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private List<Student> studentList = new ArrayList<>();

    @GetMapping("/ping")
    public String ping() {
        return new String("pong");
    }

    @GetMapping("/ids/{id}")
    public Student fetch(@PathVariable("id") String id) {
        LOGGER.info("#fetch is called with id:"+id);
        return studentList.stream().filter(id1 -> id1.getRollNo().equals(id)).findFirst().orElse(null);
    }

    @GetMapping("/ids")
    public List<Student> fetchAll() {
        LOGGER.info("#fetchAll is called");
        return studentList.stream().collect(Collectors.toCollection(()->new ArrayList<Student>()));
    }

    @PostMapping
    public String save(Student student) {
        LOGGER.info("#save student is called:"+student);
        Comparator<Student> comparator = Comparator.comparing( Student::getRollNo );
        Student maxObject = studentList.stream().max(comparator).get();
        int id = Integer.valueOf(maxObject.getRollNo())+1;
        studentList.add(new Student(""+id, student.getName(), student.getCourse()));
        return "Successfully stored. Id:"+id;
    }

    @DeleteMapping("/ids/{id}")
    public String delete(@PathVariable("id") String id) {
        LOGGER.info("#delete student is called with id:"+id);
        studentList = studentList.stream()
                .filter(x -> !x.getRollNo().equalsIgnoreCase(id))
                .collect(Collectors.toList());
        return "successfully deleted id:"+id;
    }

    @Bean
    public void init() {
        LOGGER.info("#initializing student list is started");
        for(int i = 100;i<120;i++) {
            studentList.add( new Student(String.valueOf(i), "name:"+i, "b.tech"));
        }
        LOGGER.info("#student list size is :"+studentList.size());
    }


}
