/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author akis
 */
@Entity
@Table(name = "fieldofstudy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FieldOfStudy.findAll", query = "SELECT f FROM FieldOfStudy f"),
    @NamedQuery(name = "FieldOfStudy.findByIdfieldofstudy", query = "SELECT f FROM FieldOfStudy f WHERE f.idfieldofstudy = :idfieldofstudy"),
    @NamedQuery(name = "FieldOfStudy.findByFacultyIdfaculty", query = "SELECT f FROM FieldOfStudy f WHERE f.facultyIdfaculty = :facultyIdfaculty"),
    @NamedQuery(name = "FieldOfStudy.findByName", query = "SELECT f FROM FieldOfStudy f WHERE f.name = :name")})
public class FieldOfStudy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfieldofstudy")
    private Integer idfieldofstudy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "faculty_idfaculty")
    private int facultyIdfaculty;
    @Size(max = 20)
    @Column(name = "name")
    private String name;

    public FieldOfStudy() {
    }

    public FieldOfStudy(Integer idfieldofstudy) {
        this.idfieldofstudy = idfieldofstudy;
    }

    public FieldOfStudy(Integer idfieldofstudy, int facultyIdfaculty) {
        this.idfieldofstudy = idfieldofstudy;
        this.facultyIdfaculty = facultyIdfaculty;
    }

    public Integer getIdfieldofstudy() {
        return idfieldofstudy;
    }

    public void setIdfieldofstudy(Integer idfieldofstudy) {
        this.idfieldofstudy = idfieldofstudy;
    }

    public int getFacultyIdfaculty() {
        return facultyIdfaculty;
    }

    public void setFacultyIdfaculty(int facultyIdfaculty) {
        this.facultyIdfaculty = facultyIdfaculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "com.entity.FieldOfStudy[ idfieldofstudy=" + idfieldofstudy + " ]";
    }
    
}
