/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "faculty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
    @NamedQuery(name = "Faculty.findByIdfaculty", query = "SELECT f FROM Faculty f WHERE f.idfaculty = :idfaculty"),
    @NamedQuery(name = "Faculty.findByFacultyname", query = "SELECT f FROM Faculty f WHERE f.facultyname = :facultyname"),
    @NamedQuery(name = "Faculty.findByFacultyadress", query = "SELECT f FROM Faculty f WHERE f.facultyadress = :facultyadress"),
    @NamedQuery(name = "Faculty.findByFacultyphonenumer", query = "SELECT f FROM Faculty f WHERE f.facultyphonenumer = :facultyphonenumer")})
public class Faculty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfaculty")
    private Integer idfaculty;
    @Size(max = 20)
    @Column(name = "facultyname")
    private String facultyname;
    @Size(max = 255)
    @Column(name = "facultyadress")
    private String facultyadress;
    @Column(name = "facultyphonenumer")
    private Integer facultyphonenumer;
    @OneToMany(mappedBy = "idfaculty")
    private List<FieldOfStudy> fieldOfstudyList;

    public Faculty() {
    }

    public Faculty(Integer idfaculty) {
        this.idfaculty = idfaculty;
    }

    public Integer getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(Integer idfaculty) {
        this.idfaculty = idfaculty;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    public String getFacultyadress() {
        return facultyadress;
    }

    public void setFacultyadress(String facultyadress) {
        this.facultyadress = facultyadress;
    }

    public Integer getFacultyphonenumer() {
        return facultyphonenumer;
    }

    public void setFacultyphonenumer(Integer facultyphonenumer) {
        this.facultyphonenumer = facultyphonenumer;
    }

    @XmlTransient
    public List<FieldOfStudy> getFieldOfstudyList() {
        return fieldOfstudyList;
    }

    public void setFieldOfstudyList(List<FieldOfStudy> fieldOfStudyList) {
        this.fieldOfstudyList = fieldOfStudyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfaculty != null ? idfaculty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.idfaculty == null && other.idfaculty != null) || (this.idfaculty != null && !this.idfaculty.equals(other.idfaculty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return facultyname.toString();
    }
    
}
