package com.cyberclick.universityStudentSrsBackend.service.impl;

import com.cyberclick.universityStudentSrsBackend.entity.Students;
import com.cyberclick.universityStudentSrsBackend.exception.CustomNotFoundException;
import com.cyberclick.universityStudentSrsBackend.repository.StudentRepository;
import com.cyberclick.universityStudentSrsBackend.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public String createStudent(Students student) {
        studentRepository.save(student);
        return "Registered successfully";
    }

    @Override
    public String updateStudent(Students student) {
        studentRepository.save(student);
        return "Updated successfully";
    }

    @Override
    public String deleteStudent(String student) {
        if(studentRepository.existsById(student)) {
            studentRepository.deleteById(student);
            return "Record deleted successfully";
        } else{
            throw new CustomNotFoundException("Requested student does not exist");
        }
    }

    @Override
    public Students getStudent(String studentId) {
        if(studentRepository.findById(studentId).isEmpty())
            throw new CustomNotFoundException("Requested student does not exist");
        return studentRepository.findById(studentId).get();
    }

    @Override
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Students> getByStudentFirstName(String studentFirstName) {
        return studentRepository.findByStudentFirstName(studentFirstName);
    }
}
