/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.datascale.boutiqueoc.entities;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yarbanga
 */
@Entity
@Table(name = "TypeLivraison")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeLivraison.findAll", query = "SELECT t FROM TypeLivraison t"),
    @NamedQuery(name = "TypeLivraison.findByIdType", query = "SELECT t FROM TypeLivraison t WHERE t.idType = :idType"),
    @NamedQuery(name = "TypeLivraison.findByNom", query = "SELECT t FROM TypeLivraison t WHERE t.nom = :nom"),
    @NamedQuery(name = "TypeLivraison.findByFrais", query = "SELECT t FROM TypeLivraison t WHERE t.frais = :frais")})
public class TypeLivraison implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdType")
    private Integer idType;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Frais")
    private Integer frais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idType")
    private Collection<Livraison> livraisonCollection;

    public TypeLivraison() {
    }

    public TypeLivraison(Integer idType) {
        this.idType = idType;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getFrais() {
        return frais;
    }

    public void setFrais(Integer frais) {
        this.frais = frais;
    }

    @XmlTransient
    public Collection<Livraison> getLivraisonCollection() {
        return livraisonCollection;
    }

    public void setLivraisonCollection(Collection<Livraison> livraisonCollection) {
        this.livraisonCollection = livraisonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idType != null ? idType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeLivraison)) {
            return false;
        }
        TypeLivraison other = (TypeLivraison) object;
        if ((this.idType == null && other.idType != null) || (this.idType != null && !this.idType.equals(other.idType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.TypeLivraison[ idType=" + idType + " ]";
    }
    
}
