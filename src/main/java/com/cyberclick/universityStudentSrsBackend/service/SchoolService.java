package com.cyberclick.universityStudentSrsBackend.service;

import com.cyberclick.universityStudentSrsBackend.entity.Schools;

import java.util.List;

public interface SchoolService {
    public String createSchool(Schools school);

    public String updateSchool(Schools school);

    public String deleteSchool(String school);

    Schools getSchool(String schoolId);

    public List<Schools> getAllSchools();

    List<Schools> getBySchoolName(String schoolName);
}
