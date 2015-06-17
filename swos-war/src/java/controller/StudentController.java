/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.Student;
import com.model.StudentFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author akis
 */
@ManagedBean
@SessionScoped
public class StudentController {

    @EJB
    private StudentFacade studentFacade;

    private Student student = new Student();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentController() {
    }

    public List<Student> findAll(){
        return this.studentFacade.findAll();
    }
    public String add(){
        this.studentFacade.create(student);
        this.student = new Student();
        return "studentList";
    }
    
    public String delete(Student student){
        this.studentFacade.remove(student);
        return "studentList";
    }
    
    public String edit(Student student){
        this.student = student;
        return "studentEdit";
    }
      public String edit(){
        this.studentFacade.edit(student);
        this.student = new Student();
        return "studentList";
    }
}
