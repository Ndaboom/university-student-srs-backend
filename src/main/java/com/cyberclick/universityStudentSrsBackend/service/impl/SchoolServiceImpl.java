package com.cyberclick.universityStudentSrsBackend.service.impl;

import com.cyberclick.universityStudentSrsBackend.entity.Schools;
import com.cyberclick.universityStudentSrsBackend.exception.CustomNotFoundException;
import com.cyberclick.universityStudentSrsBackend.repository.SchoolRepository;
import com.cyberclick.universityStudentSrsBackend.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public String createSchool(Schools school) {
        schoolRepository.save(school);
        return "Created successfully";
    }

    @Override
    public String updateSchool(Schools school) {
        schoolRepository.save(school);
        return "Updated successfully";
    }

    @Override
    public String deleteSchool(String school) {
        if(schoolRepository.existsById(school)) {
            schoolRepository.deleteById(school);
            return "Record deleted successfully";
        } else{
            throw new CustomNotFoundException("Requested school does not exist");
        }
    }

    @Override
    public Schools getSchool(String schoolId) {
        if(schoolRepository.findById(schoolId).isEmpty())
            throw new CustomNotFoundException("Requested school does not exist");
        return schoolRepository.findById(schoolId).get();
    }

    @Override
    public List<Schools> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public List<Schools> getBySchoolName(String schoolName) {
        return schoolRepository.findBySchoolName(schoolName);
    }
}
