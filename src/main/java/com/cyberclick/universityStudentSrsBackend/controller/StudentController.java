package com.cyberclick.universityStudentSrsBackend.controller;

import com.cyberclick.universityStudentSrsBackend.entity.Students;
import com.cyberclick.universityStudentSrsBackend.response.ResponseHandler;
import com.cyberclick.universityStudentSrsBackend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Object> getStudentDetails(@PathVariable("studentId") String studentId){
        return ResponseHandler.responseBuilder("Student details", HttpStatus.OK, studentService.getStudent(studentId));
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Object> getAllStudents(){
        return ResponseHandler.responseBuilder("Students list", HttpStatus.OK, studentService.getAllStudents());
    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody Students students)
    {
        return ResponseHandler.responseBuilder("Student created", HttpStatus.OK, studentService.createStudent(students));
    }

    @PutMapping()
    public ResponseEntity<Object> updateStudent(@RequestBody Students students)
    {
        return ResponseHandler.responseBuilder("Student updated", HttpStatus.OK, studentService.updateStudent(students));
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("studentId") String studentId)
    {
        return ResponseHandler.responseBuilder("Student deleted", HttpStatus.OK, studentService.deleteStudent(studentId));
    }
}
