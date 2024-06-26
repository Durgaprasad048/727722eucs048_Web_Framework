package com.example.class_exercise_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.class_exercise_2.model.durgaprasadStudent;
import com.example.class_exercise_2.service.durgaprasadStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class durgaprasadStudentController {

     @Autowired
     public durgaprasadStudentService studentService;

     @GetMapping("/api/student")
     public ResponseEntity<List<durgaprasadStudent>> getDetails() {
          List<durgaprasadStudent> list = studentService.getAll();
          if (list.isEmpty()) {
               return new ResponseEntity<List<durgaprasadStudent>>(list, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<List<durgaprasadStudent>>(list, HttpStatus.OK);

     }

     @PostMapping("/api/student")
     public ResponseEntity<durgaprasadStudent> postMethodName(@RequestBody durgaprasadStudent student) {

          durgaprasadStudent postData = studentService.post(student);
          return new ResponseEntity<>(postData, HttpStatus.OK);
     }

     @GetMapping("/api/student/sort/{field}")
     public ResponseEntity<List<durgaprasadStudent>> sortedDetails(@PathVariable String field) {
          List<durgaprasadStudent> list = studentService.sortedDetails(field);
          if (list.isEmpty()) {
               return new ResponseEntity<List<durgaprasadStudent>>(list, HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<List<durgaprasadStudent>>(list, HttpStatus.OK);

     }
}
