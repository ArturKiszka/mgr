/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.entity.Classes;
import com.entity.Plik;
import com.model.ClassesFacade;
import com.model.PlikFacade;
import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
//import java.nio.charset;

/**
 *
 * @author akis
 */
@ManagedBean
@SessionScoped
public class PlikController {

    @EJB
    private PlikFacade plikFacade;

    private Plik plik = new Plik();

    private UploadedFile uploadedFile;

    private StreamedContent file;

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public PlikController() {

    }

    public Plik getPlik() {
        return plik;
    }

    public void setPlik(Plik plik) {
        this.plik = plik;
    }

    public Plik findById(int id) {

        System.out.println(plikFacade);
        Plik f = new Plik();//facultyFacade.find(id);
        return f;
    }

    public String add() throws IOException {
//        plik.setPlik(uploadedFile.getContents());
//        
//        InputStream s = uploadedFile.getInputstream();
//        System.out.println(s.toString());
//        
//        java.util.Scanner ss = new java.util.Scanner(s).useDelimiter("\\A");
//        System.out.println(ss.next());
//        
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//        
//        int nRead;
//        byte[] data = new byte[16384];
//        
//        while ((nRead = s.read(data, 0, data.length)) != -1) {
//            buffer.write(data, 0, nRead);
//        }
//        
//        buffer.flush();
//        
//        System.out.println(buffer.toByteArray());
//        plik.setPlik(buffer.toByteArray());
        this.plikFacade.create(plik);
        this.plik = new Plik();
        return "plikList";
    }

    public String delete(Plik plik) {
        this.plikFacade.remove(plik);
        return "plikList";
    }

    public String edit(Plik plik) {
        this.plik = plik;
        return "plikEdit";
    }

    public String edit() {
        this.plikFacade.edit(plik);
        this.plik = new Plik();
        return "plikList";
    }

    public List<Plik> findAll() {
        return this.plikFacade.findAll();
    }

    public void setUploadedFile(UploadedFile uploadedFile) throws IOException {
        this.uploadedFile = uploadedFile;

        InputStream inputstream = uploadedFile.getInputstream();
        FileOutputStream fos = new FileOutputStream(new File(uploadedFile.getFileName()));
        int read = 0;
        byte[] bytes = new byte[(int) uploadedFile.getSize()];

        while ((read = inputstream.read(bytes)) != -1) {
            fos.write(bytes, 0, read);
        }

        fos.close();
        plik.setFileName(uploadedFile.getFileName());
        plik.setPlik(bytes);

    }

    public void fileUploadListener(FileUploadEvent event) {
        uploadedFile = event.getFile();
    }

    public void insert() throws FileNotFoundException, IOException {
        System.out.println("");
//        File file = new File("java.pdf");

        plik.setPlik(uploadedFile.getContents());
        if (uploadedFile != null) {
            System.out.println(uploadedFile.getFileName());
        } else {
            System.out.println("The file object is null.");
        }

    }

    public void downloadFile(Integer id) throws FileNotFoundException, IOException {
        Plik p = plikFacade.findById(id);
        System.out.println("Jakie to id? " + id);
        System.out.println(p.getId());
//        File file = new File("plik");
        FileOutputStream fos = new FileOutputStream("\\\\msfs-krb1\\profiles\\akis\\Desktop\\testy\\" + p.getFileName());
        fos.write(p.getPlik());
        System.out.println(fos);
//        System.out.println(new String(fos.toByteArray(), CharSet.defaultCharSet());
        fos.close();
        
       
    }

}
