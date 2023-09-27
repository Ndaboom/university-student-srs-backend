package com.cyberclick.universityStudentSrsBackend.service;

import com.cyberclick.universityStudentSrsBackend.entity.Students;

import java.util.List;

public interface StudentService {
    public String createStudent(Students student);

    public String updateStudent(Students student);

    public String deleteStudent(String student);

    Students getStudent(String studentId);

    public List<Students> getAllStudents();

    List<Students> getByStudentName(String studentName);
}
