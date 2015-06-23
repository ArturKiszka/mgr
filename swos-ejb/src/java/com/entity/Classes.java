/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author akis
 */
@Entity
@Table(name = "classes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "SELECT c FROM Classes c"),
    @NamedQuery(name = "Classes.findByIdclasses", query = "SELECT c FROM Classes c WHERE c.idclasses = :idclasses"),
    @NamedQuery(name = "Classes.findByLecturerIdlecturer", query = "SELECT c FROM Classes c WHERE c.lecturerIdlecturer = :lecturerIdlecturer"),
    @NamedQuery(name = "Classes.findByClassesterm", query = "SELECT c FROM Classes c WHERE c.classesterm = :classesterm"),
    @NamedQuery(name = "Classes.findByBegininghour", query = "SELECT c FROM Classes c WHERE c.begininghour = :begininghour"),
    @NamedQuery(name = "Classes.findByLecturehall", query = "SELECT c FROM Classes c WHERE c.lecturehall = :lecturehall"),
    @NamedQuery(name = "Classes.findByDocumentnamemask", query = "SELECT c FROM Classes c WHERE c.documentnamemask = :documentnamemask")})
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclasses")
    private Integer idclasses;
    @Basic(optional = false)
    @Column(name = "lecturer_idlecturer")
    private int lecturerIdlecturer;
    @Size(max = 45)
    @Column(name = "classesterm")
    private String classesterm;
    @Column(name = "begininghour")
    @Temporal(TemporalType.TIME)
    private Date begininghour;
    @Size(max = 20)
    @Column(name = "lecturehall")
    private String lecturehall;
    @Size(max = 45)
    @Column(name = "documentnamemask")
    private String documentnamemask;
    @JoinColumn(name = "idlecturer", referencedColumnName = "idlecturer")
    @ManyToOne
    private Lecturer idlecturer;
    @OneToMany(mappedBy = "idclasses")
    private List<StoreHouseOfDocuments> storeHouseOfDocumentsList;

    public Classes() {
    }

    public Classes(Integer idclasses) {
        this.idclasses = idclasses;
    }

    public Classes(Integer idclasses, int lecturerIdlecturer) {
        this.idclasses = idclasses;
        this.lecturerIdlecturer = lecturerIdlecturer;
    }

    public Integer getIdclasses() {
        return idclasses;
    }

    public void setIdclasses(Integer idclasses) {
        this.idclasses = idclasses;
    }

    public int getLecturerIdlecturer() {
        return lecturerIdlecturer;
    }

    public void setLecturerIdlecturer(int lecturerIdlecturer) {
        this.lecturerIdlecturer = lecturerIdlecturer;
    }

    public String getClassesterm() {
        return classesterm;
    }

    public void setClassesterm(String classesterm) {
        this.classesterm = classesterm;
    }

    public Date getBegininghour() {
        return begininghour;
    }

    public void setBegininghour(Date begininghour) {
        this.begininghour = begininghour;
    }

    public String getLecturehall() {
        return lecturehall;
    }

    public void setLecturehall(String lecturehall) {
        this.lecturehall = lecturehall;
    }

    public String getDocumentnamemask() {
        return documentnamemask;
    }

    public void setDocumentnamemask(String documentnamemask) {
        this.documentnamemask = documentnamemask;
    }

    public Lecturer getIdlecturer() {
        return idlecturer;
    }

    public void setIdlecturer(Lecturer idlecturer) {
        this.idlecturer = idlecturer;
    }

    @XmlTransient
    public List<StoreHouseOfDocuments> getStoreHouseOfDocumentsList() {
        return storeHouseOfDocumentsList;
    }

    public void setStoreHouseOfDocumentsList(List<StoreHouseOfDocuments> storeHouseOfDocumentsList) {
        this.storeHouseOfDocumentsList = storeHouseOfDocumentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasses != null ? idclasses.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.idclasses == null && other.idclasses != null) || (this.idclasses != null && !this.idclasses.equals(other.idclasses))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Classes[ idclasses=" + idclasses + " ]";
    }

}
