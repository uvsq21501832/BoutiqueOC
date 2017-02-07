/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.datascale.boutiqueoc.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yarbanga
 */
@Entity
@Table(name = "Promotion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findByIdPromotion", query = "SELECT p FROM Promotion p WHERE p.idPromotion = :idPromotion"),
    @NamedQuery(name = "Promotion.findByDateDebut", query = "SELECT p FROM Promotion p WHERE p.dateDebut = :dateDebut"),
    @NamedQuery(name = "Promotion.findByDateFin", query = "SELECT p FROM Promotion p WHERE p.dateFin = :dateFin"),
    @NamedQuery(name = "Promotion.findByRemise", query = "SELECT p FROM Promotion p WHERE p.remise = :remise")})
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdPromotion")
    private Integer idPromotion;
    @Column(name = "DateDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Column(name = "DateFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "Remise")
    private Integer remise;
    @OneToMany(mappedBy = "idPromotion")
    private Collection<Article> articleCollection;

    public Promotion() {
    }

    public Promotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Integer getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Integer idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getRemise() {
        return remise;
    }

    public void setRemise(Integer remise) {
        this.remise = remise;
    }

    @XmlTransient
    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromotion != null ? idPromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.idPromotion == null && other.idPromotion != null) || (this.idPromotion != null && !this.idPromotion.equals(other.idPromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Promotion[ idPromotion=" + idPromotion + " ]";
    }
    
}
