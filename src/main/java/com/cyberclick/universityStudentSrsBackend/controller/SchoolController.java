package com.cyberclick.universityStudentSrsBackend.controller;

import com.cyberclick.universityStudentSrsBackend.entity.Schools;
import com.cyberclick.universityStudentSrsBackend.response.ResponseHandler;
import com.cyberclick.universityStudentSrsBackend.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173/", maxAge = 3600)
@RestController
@RequestMapping("/schools")
public class SchoolController {
    SchoolService schoolService;
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("{schoolId}")
    public ResponseEntity<Object> getSchoolDetails(@PathVariable("schoolId") String schoolId){
        return ResponseHandler.responseBuilder("School details", HttpStatus.OK, schoolService.getSchool(schoolId));
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Object> getAllSchools(){
        return ResponseHandler.responseBuilder("Schools list", HttpStatus.OK, schoolService.getAllSchools());
    }

    @PostMapping
    public ResponseEntity<Object> createSchool(@RequestBody Schools school)
    {
        return ResponseHandler.responseBuilder("School created", HttpStatus.OK, schoolService.createSchool(school));
    }

    @PutMapping()
    public ResponseEntity<Object> updateSchool(@RequestBody Schools school)
    {
        return ResponseHandler.responseBuilder("School updated", HttpStatus.OK, schoolService.updateSchool(school));
    }

    @DeleteMapping("{schoolId}")
    public ResponseEntity<Object> deleteSchool(@PathVariable("schoolId") String schoolId)
    {
        return ResponseHandler.responseBuilder("School deleted", HttpStatus.OK, schoolService.deleteSchool(schoolId));
    }
}
