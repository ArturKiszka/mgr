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
@Table(name = "labgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabGroup.findAll", query = "SELECT l FROM LabGroup l"),
    @NamedQuery(name = "LabGroup.findByIdlabgroup", query = "SELECT l FROM LabGroup l WHERE l.idlabgroup = :idlabgroup"),
    @NamedQuery(name = "LabGroup.findByName", query = "SELECT l FROM LabGroup l WHERE l.name = :name")})
public class LabGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlabgroup")
    private Integer idlabgroup;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idlabgroup")
    private List<Student> studentList;

    public LabGroup() {
    }

    public LabGroup(Integer idlabgroup) {
        this.idlabgroup = idlabgroup;
    }

    public Integer getIdlabgroup() {
        return idlabgroup;
    }

    public void setIdlabgroup(Integer idlabgroup) {
        this.idlabgroup = idlabgroup;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlabgroup != null ? idlabgroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabGroup)) {
            return false;
        }
        LabGroup other = (LabGroup) object;
        if ((this.idlabgroup == null && other.idlabgroup != null) || (this.idlabgroup != null && !this.idlabgroup.equals(other.idlabgroup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
