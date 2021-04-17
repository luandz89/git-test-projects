/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hprxs3b161;

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
 * @author lafmah1
 */
@Entity
@Table(name = "tasks", catalog = "abcsecurity", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tasks.findAll", query = "SELECT t FROM Tasks t")
    , @NamedQuery(name = "Tasks.findByAllocatedSecurity", query = "SELECT t FROM Tasks t WHERE t.allocatedSecurity = :allocatedSecurity")
    , @NamedQuery(name = "Tasks.findByStatus", query = "SELECT t FROM Tasks t WHERE t.status = :status")
    , @NamedQuery(name = "Tasks.findByClientName", query = "SELECT t FROM Tasks t WHERE t.clientName = :clientName")
    , @NamedQuery(name = "Tasks.findByComplaintType", query = "SELECT t FROM Tasks t WHERE t.complaintType = :complaintType")
    , @NamedQuery(name = "Tasks.findByLocation", query = "SELECT t FROM Tasks t WHERE t.location = :location")
    , @NamedQuery(name = "Tasks.findByNoOfPeople", query = "SELECT t FROM Tasks t WHERE t.noOfPeople = :noOfPeople")
    , @NamedQuery(name = "Tasks.findByCaseNumber", query = "SELECT t FROM Tasks t WHERE t.caseNumber = :caseNumber")})
public class Tasks implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "AllocatedSecurity")
    private String allocatedSecurity;
    @Column(name = "Status")
    private String status;
    @Column(name = "Client_Name")
    private String clientName;
    @Column(name = "ComplaintType")
    private String complaintType;
    @Column(name = "Location")
    private String location;
    @Column(name = "NoOfPeople")
    private Integer noOfPeople;
    @Id
    @Basic(optional = false)
    @Column(name = "Case_Number")
    private Integer caseNumber;

    public Tasks() {
    }

    public Tasks(Integer caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getAllocatedSecurity() {
        return allocatedSecurity;
    }

    public void setAllocatedSecurity(String allocatedSecurity) {
        String oldAllocatedSecurity = this.allocatedSecurity;
        this.allocatedSecurity = allocatedSecurity;
        changeSupport.firePropertyChange("allocatedSecurity", oldAllocatedSecurity, allocatedSecurity);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        String oldClientName = this.clientName;
        this.clientName = clientName;
        changeSupport.firePropertyChange("clientName", oldClientName, clientName);
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        String oldComplaintType = this.complaintType;
        this.complaintType = complaintType;
        changeSupport.firePropertyChange("complaintType", oldComplaintType, complaintType);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
    }

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        Integer oldNoOfPeople = this.noOfPeople;
        this.noOfPeople = noOfPeople;
        changeSupport.firePropertyChange("noOfPeople", oldNoOfPeople, noOfPeople);
    }

    public Integer getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Integer caseNumber) {
        Integer oldCaseNumber = this.caseNumber;
        this.caseNumber = caseNumber;
        changeSupport.firePropertyChange("caseNumber", oldCaseNumber, caseNumber);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caseNumber != null ? caseNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasks)) {
            return false;
        }
        Tasks other = (Tasks) object;
        if ((this.caseNumber == null && other.caseNumber != null) || (this.caseNumber != null && !this.caseNumber.equals(other.caseNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hprxs3b161.Tasks[ caseNumber=" + caseNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
