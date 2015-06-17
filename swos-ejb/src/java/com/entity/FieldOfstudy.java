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
    @NamedQuery(name = "FieldOfstudy.findAll", query = "SELECT f FROM FieldOfstudy f"),
    @NamedQuery(name = "FieldOfstudy.findByIdfieldofstudy", query = "SELECT f FROM FieldOfstudy f WHERE f.idfieldofstudy = :idfieldofstudy"),
    @NamedQuery(name = "FieldOfstudy.findByStudentStudentcardnumber", query = "SELECT f FROM FieldOfstudy f WHERE f.studentStudentcardnumber = :studentStudentcardnumber"),
    @NamedQuery(name = "FieldOfstudy.findByFacultyIdfaculty", query = "SELECT f FROM FieldOfstudy f WHERE f.facultyIdfaculty = :facultyIdfaculty"),
    @NamedQuery(name = "FieldOfstudy.findByName", query = "SELECT f FROM FieldOfstudy f WHERE f.name = :name")})
public class FieldOfstudy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfieldofstudy")
    private Integer idfieldofstudy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "student_studentcardnumber")
    private String studentStudentcardnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "faculty_idfaculty")
    private int facultyIdfaculty;
    @Size(max = 20)
    @Column(name = "name")
    private String name;

    public FieldOfstudy() {
    }

    public FieldOfstudy(Integer idfieldofstudy) {
        this.idfieldofstudy = idfieldofstudy;
    }

    public FieldOfstudy(Integer idfieldofstudy, String studentStudentcardnumber, int facultyIdfaculty) {
        this.idfieldofstudy = idfieldofstudy;
        this.studentStudentcardnumber = studentStudentcardnumber;
        this.facultyIdfaculty = facultyIdfaculty;
    }

    public Integer getIdfieldofstudy() {
        return idfieldofstudy;
    }

    public void setIdfieldofstudy(Integer idfieldofstudy) {
        this.idfieldofstudy = idfieldofstudy;
    }

    public String getStudentStudentcardnumber() {
        return studentStudentcardnumber;
    }

    public void setStudentStudentcardnumber(String studentStudentcardnumber) {
        this.studentStudentcardnumber = studentStudentcardnumber;
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
        if (!(object instanceof FieldOfstudy)) {
            return false;
        }
        FieldOfstudy other = (FieldOfstudy) object;
        if ((this.idfieldofstudy == null && other.idfieldofstudy != null) || (this.idfieldofstudy != null && !this.idfieldofstudy.equals(other.idfieldofstudy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.FieldOfstudy[ idfieldofstudy=" + idfieldofstudy + " ]";
    }
    
}
