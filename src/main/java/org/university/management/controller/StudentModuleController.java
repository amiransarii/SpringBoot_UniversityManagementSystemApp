package org.university.management.controller;

import org.university.management.dto.CreateModule;
import org.university.management.dto.CreateStudent;
import org.university.management.dto.CreateEnrolment;
import org.university.management.entity.Enrolment;
import org.university.management.entity.Module;
import org.university.management.entity.Student;
import org.university.management.service.StudentModuleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Log4j2
@RequestMapping(path = "/v1")
public class StudentModuleController {
    private final StudentModuleService studentModuleService;

    @Autowired
    public StudentModuleController(StudentModuleService studentModuleService) {
        this.studentModuleService = studentModuleService;
    }
    //get list of students who enroll to particular module
    @GetMapping(path = "/modules/{moduleId}/students")
    public List<Student> findAllStudentByModuleId(@PathVariable String moduleId) {
        return studentModuleService.getListOfStudentByModuleId(moduleId);
    }
    //get list of modules enrolled by particular student
    @GetMapping(path = "/students/{studentId}/modules")
    public List<Module> findAllModulesByStudentId(@PathVariable String studentId){
        return studentModuleService.getListOfModuleByStudentId(studentId);
    }
    //update students enrolment
    @PutMapping(path ="/enrolments")
    @ResponseStatus(code = HttpStatus.OK)
    public Enrolment createEnrolment(@ModelAttribute CreateEnrolment createEnrolment){
        return studentModuleService.addEnrolment(createEnrolment);
    }

    /***********************************************************
     *******************    Students Only    *******************
     ***********************************************************/
    @GetMapping(path = "/students")
    public List<Student> getAllStudents() {
        return studentModuleService.getAllStudents();
    }

    @GetMapping(path = "/students/studentID/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentModuleService.getStudentById(id);
    }

    @GetMapping(path = "/students/{name}")
    public List<Student> getStudentByLastName(@PathVariable String name) {
        return studentModuleService.getStudentByName(name);
    }

    @PostMapping(path = "/students")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student createStudent(@ModelAttribute CreateStudent student){
        return studentModuleService.addNewStudent(student);
    }

    //todo: [{"id":"1","firstName":"Abu","lastName":"Bakar}]"

    /***********************************************************
     *******************    Modules Only    ********************
     ***********************************************************/

    @GetMapping(path = "/module/all")
    public List<Module> getAllModule() {
        return studentModuleService.getAllModules();
    }

    @GetMapping(path = "/module/id/{id}")
    public Module getModuleById(@PathVariable String id) {
        return studentModuleService.getModuleById(id);
    }

    @GetMapping(path = "/module/name/{name}")
    public List<Module> getModuleByName(@PathVariable String name){
        return studentModuleService.getModuleByName(name);
    }
    @PostMapping(path = "/modules")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Module createModule(@ModelAttribute CreateModule module){
        return studentModuleService.addNewModule(module);
    }
}
