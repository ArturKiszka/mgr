/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import com.model.FacultyFacade;
import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author akis
 */
@Entity
@Table(name = "fieldofstudy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FieldOfstudy.findAll", query = "SELECT f FROM FieldOfStudy f"),
    @NamedQuery(name = "FieldOfstudy.findByIdfieldofstudy", query = "SELECT f FROM FieldOfStudy f WHERE f.idfieldofstudy = :idfieldofstudy"),
    @NamedQuery(name = "FieldOfstudy.findByName", query = "SELECT f FROM FieldOfStudy f WHERE f.name = :name")})
public class FieldOfStudy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfieldofstudy")
    private Integer idfieldofstudy;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idfieldofstudy")
    private List<Student> studentList;
    @JoinColumn(name = "idfaculty", referencedColumnName = "idfaculty")
    @ManyToOne
    private Faculty idfaculty;

    public FieldOfStudy() {
    }

    public FieldOfStudy(Integer idfieldofstudy) {
        this.idfieldofstudy = idfieldofstudy;
    }

   

    public Integer getIdfieldofstudy() {
        return idfieldofstudy;
    }

    public void setIdfieldofstudy(Integer idfieldofstudy) {
        this.idfieldofstudy = idfieldofstudy;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Faculty getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(Faculty idfaculty) {
        this.idfaculty = idfaculty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfieldofstudy != null ? idfieldofstudy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FieldOfStudy)) {
            return false;
        }
        FieldOfStudy other = (FieldOfStudy) object;
        if ((this.idfieldofstudy == null && other.idfieldofstudy != null) || (this.idfieldofstudy != null && !this.idfieldofstudy.equals(other.idfieldofstudy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name.toString();
    }
    
}
