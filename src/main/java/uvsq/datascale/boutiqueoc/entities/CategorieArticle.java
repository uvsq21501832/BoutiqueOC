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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CategorieArticle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategorieArticle.findAll", query = "SELECT c FROM CategorieArticle c"),
    @NamedQuery(name = "CategorieArticle.findByIdCategorie", query = "SELECT c FROM CategorieArticle c WHERE c.idCategorie = :idCategorie"),
    @NamedQuery(name = "CategorieArticle.findByNom", query = "SELECT c FROM CategorieArticle c WHERE c.nom = :nom"),
    @NamedQuery(name = "CategorieArticle.findByDescription", query = "SELECT c FROM CategorieArticle c WHERE c.description = :description")})
public class CategorieArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCategorie")
    private Integer idCategorie;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategorie")
    private Collection<Article> articleCollection;

    public CategorieArticle() {
    }

    public CategorieArticle(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    
    
    public CategorieArticle(/*Integer idCategorie,*/ String nom, String description) {
		super();
		//this.idCategorie = idCategorie;
		this.nom = nom;
		this.description = description;
	}

	public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (idCategorie != null ? idCategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategorieArticle)) {
            return false;
        }
        CategorieArticle other = (CategorieArticle) object;
        if ((this.idCategorie == null && other.idCategorie != null) || (this.idCategorie != null && !this.idCategorie.equals(other.idCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.CategorieArticle[ idCategorie=" + idCategorie + " ]";
    }
    
}
