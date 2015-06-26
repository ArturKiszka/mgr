/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entity.Lecturer;
import com.entity.Plik;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author akis
 */
@Stateless
public class PlikFacade extends AbstractFacade<Plik> {
    @PersistenceContext(unitName = "swos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlikFacade() {
        super(Plik.class);
    }
    
    public Plik findById(int id){
        Query q = em.createNamedQuery("Plik.findById").setParameter("id", id);
        Plik p = (Plik)q.getSingleResult();
        return p;
    }
    
}
