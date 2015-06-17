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
@Table(name = "labgroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LabGroup.findAll", query = "SELECT l FROM LabGroup l"),
    @NamedQuery(name = "LabGroup.findByIdlabgroup", query = "SELECT l FROM LabGroup l WHERE l.idlabgroup = :idlabgroup"),
    @NamedQuery(name = "LabGroup.findByStudentStudentcardnumber", query = "SELECT l FROM LabGroup l WHERE l.studentStudentcardnumber = :studentStudentcardnumber"),
    @NamedQuery(name = "LabGroup.findByName", query = "SELECT l FROM LabGroup l WHERE l.name = :name")})
public class LabGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlabgroup")
    private Integer idlabgroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "student_studentcardnumber")
    private String studentStudentcardnumber;
    @Size(max = 45)
    @Column(name = "name")
    private String name;

    public LabGroup() {
    }

    public LabGroup(Integer idlabgroup) {
        this.idlabgroup = idlabgroup;
    }

    public LabGroup(Integer idlabgroup, String studentStudentcardnumber) {
        this.idlabgroup = idlabgroup;
        this.studentStudentcardnumber = studentStudentcardnumber;
    }

    public Integer getIdlabgroup() {
        return idlabgroup;
    }

    public void setIdlabgroup(Integer idlabgroup) {
        this.idlabgroup = idlabgroup;
    }

    public String getStudentStudentcardnumber() {
        return studentStudentcardnumber;
    }

    public void setStudentStudentcardnumber(String studentStudentcardnumber) {
        this.studentStudentcardnumber = studentStudentcardnumber;
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
        return "com.entity.LabGroup[ idlabgroup=" + idlabgroup + " ]";
    }
    
}
