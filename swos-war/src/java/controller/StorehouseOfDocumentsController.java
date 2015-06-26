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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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
    
    private UploadedFile uploadedFile;

    public StoreHouseOfDocuments getDocument() {
        return document;
    }
    
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void fileUploadListener(FileUploadEvent event){
        uploadedFile=event.getFile();
    }

    public void insert(){
//        System.out.println(uploadedFile.toString());
        if(uploadedFile!=null){
            System.out.println(uploadedFile.getFileName());
        }
        else{
            System.out.println("The file object is null.");
        }
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
     public void upload() {
//        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful",  " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
    }
     

}
