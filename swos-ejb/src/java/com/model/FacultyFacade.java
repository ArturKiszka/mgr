/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Faculty;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author akis
 */
@Stateless
public class FacultyFacade extends AbstractFacade<Faculty> {

    @PersistenceContext(unitName = "swos-ejbPU")
    private EntityManager em;

    public FacultyFacade() {
        super(Faculty.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
