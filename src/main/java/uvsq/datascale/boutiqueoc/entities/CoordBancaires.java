/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uvsq.datascale.boutiqueoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yarbanga
 */
@Entity
@Table(name = "CoordBancaires")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoordBancaires.findAll", query = "SELECT c FROM CoordBancaires c"),
    @NamedQuery(name = "CoordBancaires.findByNumeroCarte", query = "SELECT c FROM CoordBancaires c WHERE c.numeroCarte = :numeroCarte"),
    @NamedQuery(name = "CoordBancaires.findByCryptogramme", query = "SELECT c FROM CoordBancaires c WHERE c.cryptogramme = :cryptogramme")})
public class CoordBancaires implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NumeroCarte")
    private String numeroCarte;
    @Column(name = "Cryptogramme")
    private String cryptogramme;
    @JoinColumn(name = "IdClient", referencedColumnName = "IdClient")
    @ManyToOne(optional = false)
    private Client idClient;

    public CoordBancaires() {
    }

    public CoordBancaires(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public String getCryptogramme() {
        return cryptogramme;
    }

    public void setCryptogramme(String cryptogramme) {
        this.cryptogramme = cryptogramme;
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
        hash += (numeroCarte != null ? numeroCarte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoordBancaires)) {
            return false;
        }
        CoordBancaires other = (CoordBancaires) object;
        if ((this.numeroCarte == null && other.numeroCarte != null) || (this.numeroCarte != null && !this.numeroCarte.equals(other.numeroCarte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "test.CoordBancaires[ numeroCarte=" + numeroCarte + " ]";
    }
    
}
