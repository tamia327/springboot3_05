package com.example.springboot3_05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;
    @RequestMapping("/")
    public String index(Model model){
        // First let`s add a student
        Student student = new Student();
        student.Setname("Sandra Bullock");
        student.Setrealname("Sandra Mae Bullowski");

        // Now let`s add a course
        course course = new course();
        course.setTitle("Java");
        course.setYear(2018);
        course.setDescription("please give me a A");

        // Add the course to an empty list
        Set<course>courses = new HashSet<course>();
        courses.add(course);

        // Add the list of courses to the students course list
        student.Setcourses(courses);

        // Save the student to the database
        studentRepository.save(student);

        // send students to the template
        model.addAttribute("students", studentRepository.findAll());
        return "index";


    }
}
