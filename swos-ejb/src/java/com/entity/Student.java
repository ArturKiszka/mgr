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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentcardnumber", query = "SELECT s FROM Student s WHERE s.studentcardnumber = :studentcardnumber"),
    @NamedQuery(name = "Student.findByFieldofstudyIdfieldofstudy", query = "SELECT s FROM Student s WHERE s.fieldofstudyIdfieldofstudy = :fieldofstudyIdfieldofstudy"),
    @NamedQuery(name = "Student.findByLabgroupIdlabgroup", query = "SELECT s FROM Student s WHERE s.labgroupIdlabgroup = :labgroupIdlabgroup"),
    @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email"),
    @NamedQuery(name = "Student.findByStudyyear", query = "SELECT s FROM Student s WHERE s.studyyear = :studyyear"),
    @NamedQuery(name = "Student.findByPhonenumber", query = "SELECT s FROM Student s WHERE s.phonenumber = :phonenumber")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "studentcardnumber")
    private String studentcardnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fieldofstudy_idfieldofstudy")
    private int fieldofstudyIdfieldofstudy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "labgroup_idlabgroup")
    private int labgroupIdlabgroup;
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 45)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "email")
    private String email;
    @Column(name = "studyyear")
    private Integer studyyear;
    @Size(max = 9)
    @Column(name = "phonenumber")
    private String phonenumber;

    public Student() {
    }

    public Student(String studentcardnumber) {
        this.studentcardnumber = studentcardnumber;
    }

    public Student(String studentcardnumber, int fieldofstudyIdfieldofstudy, int labgroupIdlabgroup) {
        this.studentcardnumber = studentcardnumber;
        this.fieldofstudyIdfieldofstudy = fieldofstudyIdfieldofstudy;
        this.labgroupIdlabgroup = labgroupIdlabgroup;
    }

    public String getStudentcardnumber() {
        return studentcardnumber;
    }

    public void setStudentcardnumber(String studentcardnumber) {
        this.studentcardnumber = studentcardnumber;
    }

    public int getFieldofstudyIdfieldofstudy() {
        return fieldofstudyIdfieldofstudy;
    }

    public void setFieldofstudyIdfieldofstudy(int fieldofstudyIdfieldofstudy) {
        this.fieldofstudyIdfieldofstudy = fieldofstudyIdfieldofstudy;
    }

    public int getLabgroupIdlabgroup() {
        return labgroupIdlabgroup;
    }

    public void setLabgroupIdlabgroup(int labgroupIdlabgroup) {
        this.labgroupIdlabgroup = labgroupIdlabgroup;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStudyyear() {
        return studyyear;
    }

    public void setStudyyear(Integer studyyear) {
        this.studyyear = studyyear;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentcardnumber != null ? studentcardnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentcardnumber == null && other.studentcardnumber != null) || (this.studentcardnumber != null && !this.studentcardnumber.equals(other.studentcardnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Student[ studentcardnumber=" + studentcardnumber + " ]";
    }
    
}
