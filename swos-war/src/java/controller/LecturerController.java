/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.Lecturer;
import com.model.LecturerFacade;
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
public class LecturerController {
    
    @EJB
    private LecturerFacade lecturerFacade;
    private Lecturer lecturer = new Lecturer();

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
    
    public LecturerController() {
    }
    public List<Lecturer> findAll(){
        return this.lecturerFacade.findAll();
    }
    public String add(){
        this.lecturerFacade.create(lecturer);
        this.lecturer = new Lecturer();
        return "lecturerList";
    }
    
    public String delete(Lecturer lecturer){
        this.lecturerFacade.remove(lecturer);
        return "lecturerList";
    }
    
    public String edit(Lecturer lecturer){
        this.lecturer = lecturer;
        return "lecturerEdit";
    }
      public String edit(){
        this.lecturerFacade.edit(lecturer);
        this.lecturer = new Lecturer();
        return "lecturerList";
    }
}
