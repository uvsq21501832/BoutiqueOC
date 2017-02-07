/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.datascale.boutiqueoc.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Livraison")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livraison.findAll", query = "SELECT l FROM Livraison l"),
    @NamedQuery(name = "Livraison.findByIdLivraison", query = "SELECT l FROM Livraison l WHERE l.idLivraison = :idLivraison"),
    @NamedQuery(name = "Livraison.findByDatePrevu", query = "SELECT l FROM Livraison l WHERE l.datePrevu = :datePrevu"),
    @NamedQuery(name = "Livraison.findByEtatLivraison", query = "SELECT l FROM Livraison l WHERE l.etatLivraison = :etatLivraison")})
public class Livraison implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdLivraison")
    private Integer idLivraison;
    @Column(name = "DatePrevu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePrevu;
    @Column(name = "EtatLivraison")
    private String etatLivraison;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLivraison")
    private Collection<Commande> commandeCollection;
    @JoinColumn(name = "IdAdresse", referencedColumnName = "IdAdresse")
    @ManyToOne(optional = false)
    private Adresse idAdresse;
    @JoinColumn(name = "IdType", referencedColumnName = "IdType")
    @ManyToOne(optional = false)
    private TypeLivraison idType;

    public Livraison() {
    }

    public Livraison(Integer idLivraison) {
        this.idLivraison = idLivraison;
    }

    public Integer getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(Integer idLivraison) {
        this.idLivraison = idLivraison;
    }

    public Date getDatePrevu() {
        return datePrevu;
    }

    public void setDatePrevu(Date datePrevu) {
        this.datePrevu = datePrevu;
    }

    public String getEtatLivraison() {
        return etatLivraison;
    }

    public void setEtatLivraison(String etatLivraison) {
        this.etatLivraison = etatLivraison;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    public Adresse getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Adresse idAdresse) {
        this.idAdresse = idAdresse;
    }

    public TypeLivraison getIdType() {
        return idType;
    }

    public void setIdType(TypeLivraison idType) {
        this.idType = idType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivraison != null ? idLivraison.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.idLivraison == null && other.idLivraison != null) || (this.idLivraison != null && !this.idLivraison.equals(other.idLivraison))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Livraison[ idLivraison=" + idLivraison + " ]";
    }
    
}
