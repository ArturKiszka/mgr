/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.StoreHouseOfDocuments;
import com.entity.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author akis
 */
@Stateless
public class StoreHouseOfDocumentsFacade extends AbstractFacade<StoreHouseOfDocuments> {
    @PersistenceContext(unitName = "swos-ejbPU")
    private EntityManager em;

    
    public StoreHouseOfDocumentsFacade() {
        super(StoreHouseOfDocuments.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}