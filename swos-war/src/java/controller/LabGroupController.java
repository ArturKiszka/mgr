/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.LabGroup;
import com.model.LabGroupFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author akis
 */
@ManagedBean
@RequestScoped
public class LabGroupController {

    @EJB
    private LabGroupFacade labGroupFacade;

    private LabGroup labGroup = new LabGroup();

    public LabGroup getLabGroup() {
        return labGroup;
    }

    public void setLabGroup(LabGroup labGroup) {
        this.labGroup = labGroup;
    }

    public LabGroupController() {
    }

    public List<LabGroup> findAll() {
        return this.labGroupFacade.findAll();
    }

    public String add() {
        this.labGroupFacade.create(labGroup);
        this.labGroup = new LabGroup();
        return "labGroupList";
    }

    public String delete(LabGroup labGroup) {
        this.labGroupFacade.remove(labGroup);
        return "labGroupList";
    }

   public String edit(LabGroup labGroup){
        this.labGroup = labGroup;
        return "labGroupEdit";
    }
      public String edit(){
        this.labGroupFacade.edit(labGroup);
        this.labGroup = new LabGroup();
        return "labGroupList";
    }
      


}
