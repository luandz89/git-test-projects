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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "complains", catalog = "abcsecurity", schema = "")
@NamedQueries({
    @NamedQuery(name = "Complains.findAll", query = "SELECT c FROM Complains c")
    , @NamedQuery(name = "Complains.findByComplainsID", query = "SELECT c FROM Complains c WHERE c.complainsID = :complainsID")
    , @NamedQuery(name = "Complains.findByClientName", query = "SELECT c FROM Complains c WHERE c.clientName = :clientName")
    , @NamedQuery(name = "Complains.findByComplaintType", query = "SELECT c FROM Complains c WHERE c.complaintType = :complaintType")
    , @NamedQuery(name = "Complains.findByTime", query = "SELECT c FROM Complains c WHERE c.time = :time")
    , @NamedQuery(name = "Complains.findByNoOfPeople", query = "SELECT c FROM Complains c WHERE c.noOfPeople = :noOfPeople")
    , @NamedQuery(name = "Complains.findByLocation", query = "SELECT c FROM Complains c WHERE c.location = :location")})
public class Complains implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "complainsID")
    private Integer complainsID;
    @Column(name = "Client_Name")
    private String clientName;
    @Column(name = "ComplaintType")
    private String complaintType;
    @Column(name = "Time")
    private String time;
    @Column(name = "NoOfPeople")
    private Integer noOfPeople;
    @Column(name = "Location")
    private String location;

    public Complains() {
    }

    public Complains(Integer complainsID) {
        this.complainsID = complainsID;
    }

    public Integer getComplainsID() {
        return complainsID;
    }

    public void setComplainsID(Integer complainsID) {
        Integer oldComplainsID = this.complainsID;
        this.complainsID = complainsID;
        changeSupport.firePropertyChange("complainsID", oldComplainsID, complainsID);
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        String oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public Integer getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        Integer oldNoOfPeople = this.noOfPeople;
        this.noOfPeople = noOfPeople;
        changeSupport.firePropertyChange("noOfPeople", oldNoOfPeople, noOfPeople);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complainsID != null ? complainsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complains)) {
            return false;
        }
        Complains other = (Complains) object;
        if ((this.complainsID == null && other.complainsID != null) || (this.complainsID != null && !this.complainsID.equals(other.complainsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hprxs3b161.Complains[ complainsID=" + complainsID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
