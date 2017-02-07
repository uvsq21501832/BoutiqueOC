/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.datascale.boutiqueoc.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yarbanga
 */
@Entity
@Table(name = "AvisClient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvisClient.findAll", query = "SELECT a FROM AvisClient a"),
    @NamedQuery(name = "AvisClient.findByIdAvis", query = "SELECT a FROM AvisClient a WHERE a.idAvis = :idAvis"),
    @NamedQuery(name = "AvisClient.findByDate", query = "SELECT a FROM AvisClient a WHERE a.date = :date"),
    @NamedQuery(name = "AvisClient.findByCommentaire", query = "SELECT a FROM AvisClient a WHERE a.commentaire = :commentaire")})
public class AvisClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdAvis")
    private Integer idAvis;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "Commentaire")
    private String commentaire;
    @JoinColumn(name = "IdArticle", referencedColumnName = "IdArticle")
    @ManyToOne(optional = false)
    private Article idArticle;
    @JoinColumn(name = "IdClient", referencedColumnName = "IdClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public AvisClient() {
    }

    public AvisClient(Integer idAvis) {
        this.idAvis = idAvis;
    }

    public Integer getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Integer idAvis) {
        this.idAvis = idAvis;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvis != null ? idAvis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvisClient)) {
            return false;
        }
        AvisClient other = (AvisClient) object;
        if ((this.idAvis == null && other.idAvis != null) || (this.idAvis != null && !this.idAvis.equals(other.idAvis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.AvisClient[ idAvis=" + idAvis + " ]";
    }
    
}
