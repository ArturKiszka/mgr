/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.Faculty;
import com.model.FacultyFacade;
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
public class FacultyController {
    @EJB
    private FacultyFacade facultyFacade;

    private Faculty faculty = new Faculty();

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
 
    public FacultyController() {
    }
    public List<Faculty> findAll(){
        return this.facultyFacade.findAll();
    }
    public String add(){
        this.facultyFacade.create(faculty);
        this.faculty = new Faculty();
        return "facultyList";
    }
    
    public String delete(Faculty faculty){
        this.facultyFacade.remove(faculty);
        return "facultyList";
    }
    
    public String edit(Faculty faculty){
        this.faculty = faculty;
        return "facultyEdit";
    }
      public String edit(){
        this.facultyFacade.edit(faculty);
        this.faculty = new Faculty();
        return "facultyList";
    }
    
}
