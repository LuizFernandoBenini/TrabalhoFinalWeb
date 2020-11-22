/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author luizf
 */
@Entity
@Table(name = "tbprova")
@NamedQueries({
    @NamedQuery(name = "Tbprova.findAll", query = "SELECT t FROM Tbprova t"),
    @NamedQuery(name = "Tbprova.findByIdProva", query = "SELECT t FROM Tbprova t WHERE t.idProva = :idProva"),
    @NamedQuery(name = "Tbprova.findByDataProva", query = "SELECT t FROM Tbprova t WHERE t.dataProva = :dataProva")})
public class Tbprova implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProva")
    private Integer idProva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataProva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProva;
    @JoinTable(name = "tbprova_has_tbquestao", joinColumns = {
        @JoinColumn(name = "tbProva_idProva", referencedColumnName = "idProva")}, inverseJoinColumns = {
        @JoinColumn(name = "tbQuestao_idQuestao", referencedColumnName = "idQuestao")})
    @ManyToMany
    private List<Tbquestao> tbquestaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProvaidProva")
    private List<Tbresultado> tbresultadoList;

    public Tbprova() {
    }

    public Tbprova(Integer idProva) {
        this.idProva = idProva;
    }

    public Tbprova(Integer idProva, Date dataProva) {
        this.idProva = idProva;
        this.dataProva = dataProva;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Date getDataProva() {
        return dataProva;
    }

    public void setDataProva(Date dataProva) {
        this.dataProva = dataProva;
    }

    public List<Tbquestao> getTbquestaoList() {
        return tbquestaoList;
    }

    public void setTbquestaoList(List<Tbquestao> tbquestaoList) {
        this.tbquestaoList = tbquestaoList;
    }

    public List<Tbresultado> getTbresultadoList() {
        return tbresultadoList;
    }

    public void setTbresultadoList(List<Tbresultado> tbresultadoList) {
        this.tbresultadoList = tbresultadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbprova)) {
            return false;
        }
        Tbprova other = (Tbprova) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tbprova[ idProva=" + idProva + " ]";
    }
    
}
