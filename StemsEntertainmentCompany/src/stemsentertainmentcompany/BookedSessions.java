/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stemsentertainmentcompany;

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
 * @author Lwandile
 */
@Entity
@Table(name = "booked_sessions", catalog = "stems", schema = "")
@NamedQueries({
    @NamedQuery(name = "BookedSessions.findAll", query = "SELECT b FROM BookedSessions b"),
    @NamedQuery(name = "BookedSessions.findById", query = "SELECT b FROM BookedSessions b WHERE b.id = :id"),
    @NamedQuery(name = "BookedSessions.findByTicketNumber", query = "SELECT b FROM BookedSessions b WHERE b.ticketNumber = :ticketNumber"),
    @NamedQuery(name = "BookedSessions.findByMovieName", query = "SELECT b FROM BookedSessions b WHERE b.movieName = :movieName"),
    @NamedQuery(name = "BookedSessions.findByTimeBooked", query = "SELECT b FROM BookedSessions b WHERE b.timeBooked = :timeBooked")})
public class BookedSessions implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Ticket_Number")
    private String ticketNumber;
    @Column(name = "Movie_Name")
    private String movieName;
    @Basic(optional = false)
    @Column(name = "Time_Booked")
    private String timeBooked;

    public BookedSessions() {
    }

    public BookedSessions(Integer id) {
        this.id = id;
    }

    public BookedSessions(Integer id, String ticketNumber, String timeBooked) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.timeBooked = timeBooked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        String oldTicketNumber = this.ticketNumber;
        this.ticketNumber = ticketNumber;
        changeSupport.firePropertyChange("ticketNumber", oldTicketNumber, ticketNumber);
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        String oldMovieName = this.movieName;
        this.movieName = movieName;
        changeSupport.firePropertyChange("movieName", oldMovieName, movieName);
    }

    public String getTimeBooked() {
        return timeBooked;
    }

    public void setTimeBooked(String timeBooked) {
        String oldTimeBooked = this.timeBooked;
        this.timeBooked = timeBooked;
        changeSupport.firePropertyChange("timeBooked", oldTimeBooked, timeBooked);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookedSessions)) {
            return false;
        }
        BookedSessions other = (BookedSessions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stemsentertainmentcompany.BookedSessions[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
