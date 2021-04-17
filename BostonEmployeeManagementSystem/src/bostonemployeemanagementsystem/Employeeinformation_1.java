/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bostonemployeemanagementsystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Lwandile
 */
@Entity
@Table(name = "employeeinformation", catalog = "employee", schema = "")
@NamedQueries({
    @NamedQuery(name = "Employeeinformation_1.findAll", query = "SELECT e FROM Employeeinformation_1 e")
    , @NamedQuery(name = "Employeeinformation_1.findByUsername", query = "SELECT e FROM Employeeinformation_1 e WHERE e.username = :username")
    , @NamedQuery(name = "Employeeinformation_1.findByFirstName", query = "SELECT e FROM Employeeinformation_1 e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employeeinformation_1.findByLastName", query = "SELECT e FROM Employeeinformation_1 e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employeeinformation_1.findByJobTitle", query = "SELECT e FROM Employeeinformation_1 e WHERE e.jobTitle = :jobTitle")
    , @NamedQuery(name = "Employeeinformation_1.findByDepartment", query = "SELECT e FROM Employeeinformation_1 e WHERE e.department = :department")
    , @NamedQuery(name = "Employeeinformation_1.findByDateofBirth", query = "SELECT e FROM Employeeinformation_1 e WHERE e.dateofBirth = :dateofBirth")
    , @NamedQuery(name = "Employeeinformation_1.findByPhoneNumber", query = "SELECT e FROM Employeeinformation_1 e WHERE e.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Employeeinformation_1.findByPassword", query = "SELECT e FROM Employeeinformation_1 e WHERE e.password = :password")})
public class Employeeinformation_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "JobTitle")
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "Department")
    private String department;
    @Basic(optional = false)
    @Column(name = "DateofBirth")
    private String dateofBirth;
    @Basic(optional = false)
    @Column(name = "PhoneNumber")
    private int phoneNumber;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;

    public Employeeinformation_1() {
    }

    public Employeeinformation_1(String username) {
        this.username = username;
    }

    public Employeeinformation_1(String username, String firstName, String lastName, String jobTitle, String department, String dateofBirth, int phoneNumber, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.department = department;
        this.dateofBirth = dateofBirth;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        String oldJobTitle = this.jobTitle;
        this.jobTitle = jobTitle;
        changeSupport.firePropertyChange("jobTitle", oldJobTitle, jobTitle);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        String oldDepartment = this.department;
        this.department = department;
        changeSupport.firePropertyChange("department", oldDepartment, department);
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        String oldDateofBirth = this.dateofBirth;
        this.dateofBirth = dateofBirth;
        changeSupport.firePropertyChange("dateofBirth", oldDateofBirth, dateofBirth);
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        int oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        changeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, phoneNumber);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeeinformation_1)) {
            return false;
        }
        Employeeinformation_1 other = (Employeeinformation_1) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bostonemployeemanagementsystem.Employeeinformation_1[ username=" + username + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
