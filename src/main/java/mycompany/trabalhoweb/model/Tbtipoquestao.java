/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.trabalhoweb.model;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luizf
 */
@Entity
@Table(name = "tbtipoquestao")
@NamedQueries({
    @NamedQuery(name = "Tbtipoquestao.findAll", query = "SELECT t FROM Tbtipoquestao t"),
    @NamedQuery(name = "Tbtipoquestao.findByIdTipoQuestao", query = "SELECT t FROM Tbtipoquestao t WHERE t.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "Tbtipoquestao.findByNomeTipoQuestaocol", query = "SELECT t FROM Tbtipoquestao t WHERE t.nomeTipoQuestaocol = :nomeTipoQuestaocol")})
public class Tbtipoquestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoQuestao")
    private Integer idTipoQuestao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeTipoQuestaocol")
    private String nomeTipoQuestaocol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbTipoQuestaoidTipoQuestao")
    private List<Tbquestao> tbquestaoList;

    public Tbtipoquestao() {
    }

    public Tbtipoquestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public Tbtipoquestao(Integer idTipoQuestao, String nomeTipoQuestaocol) {
        this.idTipoQuestao = idTipoQuestao;
        this.nomeTipoQuestaocol = nomeTipoQuestaocol;
    }

    public Integer getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public String getNomeTipoQuestaocol() {
        return nomeTipoQuestaocol;
    }

    public void setNomeTipoQuestaocol(String nomeTipoQuestaocol) {
        this.nomeTipoQuestaocol = nomeTipoQuestaocol;
    }

    public List<Tbquestao> getTbquestaoList() {
        return tbquestaoList;
    }

    public void setTbquestaoList(List<Tbquestao> tbquestaoList) {
        this.tbquestaoList = tbquestaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoQuestao != null ? idTipoQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbtipoquestao)) {
            return false;
        }
        Tbtipoquestao other = (Tbtipoquestao) object;
        if ((this.idTipoQuestao == null && other.idTipoQuestao != null) || (this.idTipoQuestao != null && !this.idTipoQuestao.equals(other.idTipoQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tbtipoquestao[ idTipoQuestao=" + idTipoQuestao + " ]";
    }
    
}
