/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.FieldOfstudy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author akis
 */
@Stateless
public class FieldOfstudyFacade extends AbstractFacade<FieldOfstudy> {
    @PersistenceContext(unitName = "swos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FieldOfstudyFacade() {
        super(FieldOfstudy.class);
    }
    
}
