/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author akis
 */
@Entity
@Table(name = "plik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plik.findById", query = "SELECT f FROM Plik f WHERE f.id = :id")})
public class Plik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Lob
    @Column(name = "plik")
    private byte[] plik;

    @Column(name = "nazwaPliku")
    private String fileName;

//    @Column(name = "rozszerzenie")
//    private String fileExtension;

    public byte[] getPlik() {

        return plik;
    }
//    public String convertPlik() throws UnsupportedEncodingException{
//        return new String(plik, "UTF-8");
//    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

//    public String getFileExtension() {
//        return fileExtension;
//    }
//
//    public void setFileExtension(String fileExtension) {
//        this.fileExtension = fileExtension;
//    }

    
    
    public void setPlik(byte[] plik) {
        this.plik = plik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabGroup)) {
            return false;
        }
        Plik other = (Plik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return id.toString();
    }

}
