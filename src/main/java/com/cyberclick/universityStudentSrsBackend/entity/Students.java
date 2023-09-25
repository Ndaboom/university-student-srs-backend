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
    private String student_id;
    private String user_id;
    private String student_name;
    private String student_email;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "enrollment_date")
    private Date enrollment_date;

    public Students(String student_id, String user_id, String student_name, String student_email, Date date_of_birth, Date enrollment_date) {
        this.student_id = student_id;
        this.user_id = user_id;
        this.student_name = student_name;
        this.student_email = student_email;
        this.date_of_birth = date_of_birth;
        this.enrollment_date = enrollment_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date) {
        this.enrollment_date = enrollment_date;
    }
}
