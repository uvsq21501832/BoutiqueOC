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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByIdArticle", query = "SELECT a FROM Article a WHERE a.idArticle = :idArticle"),
    @NamedQuery(name = "Article.findByDescription", query = "SELECT a FROM Article a WHERE a.description = :description"),
    @NamedQuery(name = "Article.findByPrix", query = "SELECT a FROM Article a WHERE a.prix = :prix"),
    @NamedQuery(name = "Article.findByDisponibilite", query = "SELECT a FROM Article a WHERE a.disponibilite = :disponibilite")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdArticle")
    private Integer idArticle;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Description")
    private String description;
    @Column(name = "Prix")
    private Long prix;
    @Column(name = "Disponibilite")
    private Short disponibilite;
    
    @Column(name = "NomPhoto")
    private String nomPhoto;
    @Lob
    private byte[] photo;
    
    @JoinTable(name = "LignePanier", joinColumns = {
        @JoinColumn(name = "IdArticle", referencedColumnName = "IdArticle")}, inverseJoinColumns = {
        @JoinColumn(name = "IdPanier", referencedColumnName = "IdPanier")})
    @ManyToMany
    private Collection<Panier> panierCollection;
    @JoinTable(name = "LigneCommande", joinColumns = {
        @JoinColumn(name = "IdArticle", referencedColumnName = "IdArticle")}, inverseJoinColumns = {
        @JoinColumn(name = "IdCommande", referencedColumnName = "IdCommande")})
    @ManyToMany
    private Collection<Commande> commandeCollection;
    @JoinColumn(name = "IdCategorie", referencedColumnName = "IdCategorie")
    @ManyToOne(optional = false)
    private CategorieArticle idCategorie;
    @JoinColumn(name = "IdPromotion", referencedColumnName = "IdPromotion")
    @ManyToOne
    private Promotion idPromotion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticle")
    private Collection<AvisClient> avisClientCollection;

    public Article() {
    }
    

    public Article(String description/*, Long prix, Short disponibilite*/) {
		super();
		this.description = description;
		/*this.prix = prix;
		this.disponibilite = disponibilite;*/
	}
    
	public Article(String nom, String description, Long prix, Short disponibilite) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.disponibilite = disponibilite;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Article(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public Short getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Short disponibilite) {
        this.disponibilite = disponibilite;
    }
    
    
    
    public String getNomPhoto() {
		return nomPhoto;
	}


	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	@XmlTransient
    public Collection<Panier> getPanierCollection() {
        return panierCollection;
    }

    public void setPanierCollection(Collection<Panier> panierCollection) {
        this.panierCollection = panierCollection;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    public CategorieArticle getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(CategorieArticle idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Promotion getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Promotion idPromotion) {
        this.idPromotion = idPromotion;
    }

    @XmlTransient
    public Collection<AvisClient> getAvisClientCollection() {
        return avisClientCollection;
    }

    public void setAvisClientCollection(Collection<AvisClient> avisClientCollection) {
        this.avisClientCollection = avisClientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.Article[ idArticle=" + idArticle + " ]";
    }
    
}
