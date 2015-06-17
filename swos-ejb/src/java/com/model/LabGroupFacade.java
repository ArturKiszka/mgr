/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.LabGroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author akis
 */
@Stateless
public class LabGroupFacade extends AbstractFacade<LabGroup> {
    @PersistenceContext(unitName = "swos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LabGroupFacade() {
        super(LabGroup.class);
    }
    
}
