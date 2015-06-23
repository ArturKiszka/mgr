/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.StoreHouseOfDocuments;
import com.model.StoreHouseOfDocumentsFacade;
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
public class StorehouseOfDocumentsController {

    @EJB
    private StoreHouseOfDocumentsFacade storeHouseOfDocumentsFacade;

    private StoreHouseOfDocuments document = new StoreHouseOfDocuments();

    public StoreHouseOfDocuments getDocument() {
        return document;
    }

    public void setDocument(StoreHouseOfDocuments document) {
        this.document = document;
    }

    public StorehouseOfDocumentsController() {
    }

    public StoreHouseOfDocuments findById(int id) {

        System.out.println(storeHouseOfDocumentsFacade);
        StoreHouseOfDocuments f = new StoreHouseOfDocuments();//facultyFacade.find(id);
        return f;
    }

    public String add() {
        this.storeHouseOfDocumentsFacade.create(document);
        this.document = new StoreHouseOfDocuments();
        return "documentList";
    }

    public String delete(StoreHouseOfDocuments document) {
        this.storeHouseOfDocumentsFacade.remove(document);
        return "documentList";
    }

    public String edit(StoreHouseOfDocuments document) {
        this.document = document;
        return "documentEdit";
    }

    public String edit() {
        this.storeHouseOfDocumentsFacade.edit(document);
        this.document = new StoreHouseOfDocuments();
        return "documentList";
    }

    public List<StoreHouseOfDocuments> findAll() {
        return this.storeHouseOfDocumentsFacade.findAll();
    }

}
