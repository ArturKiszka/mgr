/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.Classes;
import com.model.ClassesFacade;
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
public class ClassesController {
    @EJB
    private ClassesFacade classesFacade;

    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
    
    public List<Classes> findAll() {
        return this.classesFacade.findAll();
    }

    public String add() {
        this.classesFacade.create(classes);
        this.classes = new Classes();
        return "classesList";
    }

    public String delete(Classes classes) {
        this.classesFacade.remove(classes);
        return "classesList";
    }

   public String edit(Classes classes){
        this.classes = classes;
        return "classesEdit";
    }
      public String edit(){
        this.classesFacade.edit(classes);
        this.classes = new Classes();
        return "classesList";
    }
      
    public ClassesController() {
    }
    
}
