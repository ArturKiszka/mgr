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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "StoreHouseOfDocuments.findAll", query = "SELECT s FROM StoreHouseOfDocuments s"),
    @NamedQuery(name = "StoreHouseOfDocuments.findByIdstorehouseofdocuments", query = "SELECT s FROM StoreHouseOfDocuments s WHERE s.idstorehouseofdocuments = :idstorehouseofdocuments"),
    @NamedQuery(name = "StoreHouseOfDocuments.findByClassesIdclasses", query = "SELECT s FROM StoreHouseOfDocuments s WHERE s.classesIdclasses = :classesIdclasses"),
    @NamedQuery(name = "StoreHouseOfDocuments.findByStudentStudentcardnumber", query = "SELECT s FROM StoreHouseOfDocuments s WHERE s.studentStudentcardnumber = :studentStudentcardnumber"),
    @NamedQuery(name = "StoreHouseOfDocuments.findByGrade", query = "SELECT s FROM StoreHouseOfDocuments s WHERE s.grade = :grade"),
    @NamedQuery(name = "StoreHouseOfDocuments.findByComments", query = "SELECT s FROM StoreHouseOfDocuments s WHERE s.comments = :comments")})
public class StoreHouseOfDocuments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstorehouseofdocuments")
    private Integer idstorehouseofdocuments;
    @Basic(optional = false)
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
    @JoinColumn(name = "idclasses", referencedColumnName = "idclasses")
    @ManyToOne
    private Classes idclasses;
    @JoinColumn(name = "studentcardnumber", referencedColumnName = "studentcardnumber")
    @ManyToOne
    private Student studentcardnumber;

    public StoreHouseOfDocuments() {
    }

    public StoreHouseOfDocuments(Integer idstorehouseofdocuments) {
        this.idstorehouseofdocuments = idstorehouseofdocuments;
    }

    public StoreHouseOfDocuments(Integer idstorehouseofdocuments, int classesIdclasses, String studentStudentcardnumber) {
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

    public Classes getIdclasses() {
        return idclasses;
    }

    public void setIdclasses(Classes idclasses) {
        this.idclasses = idclasses;
    }

    public Student getStudentcardnumber() {
        return studentcardnumber;
    }

    public void setStudentcardnumber(Student studentcardnumber) {
        this.studentcardnumber = studentcardnumber;
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
        if (!(object instanceof StoreHouseOfDocuments)) {
            return false;
        }
        StoreHouseOfDocuments other = (StoreHouseOfDocuments) object;
        if ((this.idstorehouseofdocuments == null && other.idstorehouseofdocuments != null) || (this.idstorehouseofdocuments != null && !this.idstorehouseofdocuments.equals(other.idstorehouseofdocuments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.StoreHouseOfDocuments[ idstorehouseofdocuments=" + idstorehouseofdocuments + " ]";
    }
    
}
