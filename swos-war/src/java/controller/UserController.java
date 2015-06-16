/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.User;
import com.model.UserFacade;
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
public class UserController {
    @EJB
    private UserFacade userFacade;

 
    public UserController() {
    }
    
    public List<User> findAll(){
        return this.userFacade.findAll();
    }
}
