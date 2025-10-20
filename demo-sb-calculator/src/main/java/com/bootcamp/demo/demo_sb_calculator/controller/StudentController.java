package com.bootcamp.demo.demo_sb_calculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_calculator.model.Database;
import com.bootcamp.demo.demo_sb_calculator.model.Student;

@RestController
public class StudentController {
  @GetMapping(value = "/students")
  public List<Student> getAllStudents() {
    return Database.studentDatabase;
  }

  @PostMapping(value = "/student")
  public Student createStudent(@RequestBody Student student) {
    if (Database.studentDatabase.add(student)) {
      return student;
    }
    return null;
  }

  // ! Put -> assume 100% trust API User
  // @PutMapping(value = "/student/{id}")
  @PutMapping(value = "/student")
  public Student updateStudent(@RequestParam Long id,
      @RequestBody Student student) {
    if (!id.equals(student.getId()))
      return null;
    for (int i = 0; i < Database.studentDatabase.size(); i++) {
      if (id.equals(Database.studentDatabase.get(i).getId())) {
        return Database.studentDatabase.set(i, student);
      }
    }
    return null;
  }

  // ! Patch ->

  // URL with parameters -> Two Designs

  // 1. @PathVariable : http://localhost:8092/student/id/1/name/John
  // @PatchMapping(value = "/student/id/{id}/name/{name}")

  // 2. @RequestParam : http://localhost:8092/student?id=1&name=John
  // @PatchMapping(value = "/student")

  @PatchMapping(value = "/student")
  public Student patchStudentName(@RequestParam Long id,
      @RequestParam String name) {
    for (int i = 0; i < Database.studentDatabase.size(); i++) {
      if (id.equals(Database.studentDatabase.get(i).getId())) {
        Student student = Database.studentDatabase.get(i);
        student.setName(name);
        return Database.studentDatabase.set(i, student);
      }
    }
    return null;
  }

}
