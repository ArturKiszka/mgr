/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "storehouseofdocuments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StorehouseOfDocuments.findAll", query = "SELECT s FROM StorehouseOfDocuments s"),
    @NamedQuery(name = "StorehouseOfDocuments.findByIdstorehouseofdocuments", query = "SELECT s FROM StorehouseOfDocuments s WHERE s.idstorehouseofdocuments = :idstorehouseofdocuments"),
    @NamedQuery(name = "StorehouseOfDocuments.findByClassesIdclasses", query = "SELECT s FROM StorehouseOfDocuments s WHERE s.classesIdclasses = :classesIdclasses"),
    @NamedQuery(name = "StorehouseOfDocuments.findByStudentStudentcardnumber", query = "SELECT s FROM StorehouseOfDocuments s WHERE s.studentStudentcardnumber = :studentStudentcardnumber"),
    @NamedQuery(name = "StorehouseOfDocuments.findByGrade", query = "SELECT s FROM StorehouseOfDocuments s WHERE s.grade = :grade"),
    @NamedQuery(name = "StorehouseOfDocuments.findByComments", query = "SELECT s FROM StorehouseOfDocuments s WHERE s.comments = :comments")})
public class StorehouseOfDocuments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstorehouseofdocuments")
    private Integer idstorehouseofdocuments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classes_idclasses")
    private int classesIdclasses;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "student_studentcardnumber")
    private String studentStudentcardnumber;
    @Lob
    @Column(name = "document")
    private byte[] document;
    @Column(name = "grade")
    private BigInteger grade;
    @Size(max = 2147483647)
    @Column(name = "comments")
    private String comments;

    public StorehouseOfDocuments() {
    }

    public StorehouseOfDocuments(Integer idstorehouseofdocuments) {
        this.idstorehouseofdocuments = idstorehouseofdocuments;
    }

    public StorehouseOfDocuments(Integer idstorehouseofdocuments, int classesIdclasses, String studentStudentcardnumber) {
        this.idstorehouseofdocuments = idstorehouseofdocuments;
        this.classesIdclasses = classesIdclasses;
        this.studentStudentcardnumber = studentStudentcardnumber;
    }

    public Integer getIdstorehouseofdocuments() {
        return idstorehouseofdocuments;
    }

    public void setIdstorehouseofdocuments(Integer idstorehouseofdocuments) {
        this.idstorehouseofdocuments = idstorehouseofdocuments;
    }

    public int getClassesIdclasses() {
        return classesIdclasses;
    }

    public void setClassesIdclasses(int classesIdclasses) {
        this.classesIdclasses = classesIdclasses;
    }

    public String getStudentStudentcardnumber() {
        return studentStudentcardnumber;
    }

    public void setStudentStudentcardnumber(String studentStudentcardnumber) {
        this.studentStudentcardnumber = studentStudentcardnumber;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public BigInteger getGrade() {
        return grade;
    }

    public void setGrade(BigInteger grade) {
        this.grade = grade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstorehouseofdocuments != null ? idstorehouseofdocuments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StorehouseOfDocuments)) {
            return false;
        }
        StorehouseOfDocuments other = (StorehouseOfDocuments) object;
        if ((this.idstorehouseofdocuments == null && other.idstorehouseofdocuments != null) || (this.idstorehouseofdocuments != null && !this.idstorehouseofdocuments.equals(other.idstorehouseofdocuments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.StorehouseOfDocuments[ idstorehouseofdocuments=" + idstorehouseofdocuments + " ]";
    }
    
}
