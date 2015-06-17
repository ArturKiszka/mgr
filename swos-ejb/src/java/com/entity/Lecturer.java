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
@Table(name = "lecturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecturer.findAll", query = "SELECT l FROM Lecturer l"),
    @NamedQuery(name = "Lecturer.findByIdlecturer", query = "SELECT l FROM Lecturer l WHERE l.idlecturer = :idlecturer"),
    @NamedQuery(name = "Lecturer.findByFirstname", query = "SELECT l FROM Lecturer l WHERE l.firstname = :firstname"),
    @NamedQuery(name = "Lecturer.findByLastname", query = "SELECT l FROM Lecturer l WHERE l.lastname = :lastname"),
    @NamedQuery(name = "Lecturer.findByAcademictitle", query = "SELECT l FROM Lecturer l WHERE l.academictitle = :academictitle"),
    @NamedQuery(name = "Lecturer.findByEmail", query = "SELECT l FROM Lecturer l WHERE l.email = :email"),
    @NamedQuery(name = "Lecturer.findByPhonenumber", query = "SELECT l FROM Lecturer l WHERE l.phonenumber = :phonenumber"),
    @NamedQuery(name = "Lecturer.findByOffice", query = "SELECT l FROM Lecturer l WHERE l.office = :office")})
public class Lecturer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlecturer")
    private Integer idlecturer;
    @Size(max = 20)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 45)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 20)
    @Column(name = "academictitle")
    private String academictitle;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 9)
    @Column(name = "phonenumber")
    private String phonenumber;
    @Size(max = 45)
    @Column(name = "office")
    private String office;

    public Lecturer() {
    }

    public Lecturer(Integer idlecturer) {
        this.idlecturer = idlecturer;
    }

    public Integer getIdlecturer() {
        return idlecturer;
    }

    public void setIdlecturer(Integer idlecturer) {
        this.idlecturer = idlecturer;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAcademictitle() {
        return academictitle;
    }

    public void setAcademictitle(String academictitle) {
        this.academictitle = academictitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlecturer != null ? idlecturer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.idlecturer == null && other.idlecturer != null) || (this.idlecturer != null && !this.idlecturer.equals(other.idlecturer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Lecturer[ idlecturer=" + idlecturer + " ]";
    }
    
}
