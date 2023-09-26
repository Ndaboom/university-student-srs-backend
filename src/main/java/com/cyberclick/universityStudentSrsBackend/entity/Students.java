package com.cyberclick.universityStudentSrsBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String studentId;
    private String userId;
    private String studentName;
    private String studentEmail;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "enrollmentDate")
    private Date enrollmentDate;

    public Students(String studentId, String userId, String studentName, String studentEmail, Date dateOfBirth, Date enrollmentDate) {
        this.studentId = studentId;
        this.userId = userId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
