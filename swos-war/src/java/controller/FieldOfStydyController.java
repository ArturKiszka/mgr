/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.Faculty;
import com.entity.FieldOfStudy;
import com.model.FieldOfStudyFacade;
import java.lang.annotation.Annotation;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 *
 * @author akis
 */
@ManagedBean
@SessionScoped
public class FieldOfStydyController  {

    @EJB
    private FieldOfStudyFacade fieldOfstudyFacade;

    private FieldOfStudy filedOfStudy = new FieldOfStudy();

    public FieldOfStudy getFiledOfStudy() {
        return filedOfStudy;
    }

    public void setFiledOfStudy(FieldOfStudy filedOfStudy) {
        this.filedOfStudy = filedOfStudy;
    }

    public FieldOfStydyController() {
    }

    public List<FieldOfStudy> findAll() {
        return this.fieldOfstudyFacade.findAll();
    }

    public String add() {
        this.fieldOfstudyFacade.create(filedOfStudy);
        this.filedOfStudy = new FieldOfStudy();
        return "fieldOfStudyList";
    }

    public String delete(FieldOfStudy filedOfStudy) {
        this.fieldOfstudyFacade.remove(filedOfStudy);
        return "fieldOfStudyList";
    }

    public String edit(FieldOfStudy filedOfStudy) {
        this.filedOfStudy = filedOfStudy;
        return "fieldOfStudyEdit";
    }

    public String edit() {
        this.fieldOfstudyFacade.edit(filedOfStudy);
        this.filedOfStudy = new FieldOfStudy();
        return "fieldOfStudyList";
    }



}
