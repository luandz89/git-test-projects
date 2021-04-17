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
@Table(name = "movie_catalog", catalog = "stems", schema = "")
@NamedQueries({
    @NamedQuery(name = "MovieCatalog.findAll", query = "SELECT m FROM MovieCatalog m"),
    @NamedQuery(name = "MovieCatalog.findById", query = "SELECT m FROM MovieCatalog m WHERE m.id = :id"),
    @NamedQuery(name = "MovieCatalog.findByMovieName", query = "SELECT m FROM MovieCatalog m WHERE m.movieName = :movieName"),
    @NamedQuery(name = "MovieCatalog.findByGenre", query = "SELECT m FROM MovieCatalog m WHERE m.genre = :genre")})
public class MovieCatalog implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Movie_Name")
    private String movieName;
    @Column(name = "Genre")
    private String genre;

    public MovieCatalog() {
    }

    public MovieCatalog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        String oldMovieName = this.movieName;
        this.movieName = movieName;
        changeSupport.firePropertyChange("movieName", oldMovieName, movieName);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String oldGenre = this.genre;
        this.genre = genre;
        changeSupport.firePropertyChange("genre", oldGenre, genre);
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
        if (!(object instanceof MovieCatalog)) {
            return false;
        }
        MovieCatalog other = (MovieCatalog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stemsentertainmentcompany.MovieCatalog[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
