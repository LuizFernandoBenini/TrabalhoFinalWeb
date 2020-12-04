/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.trabalhoweb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luizf
 */
@Entity
@Table(name = "tbquestao")
@NamedQueries({
    @NamedQuery(name = "Tbquestao.findAll", query = "SELECT t FROM Tbquestao t"),
    @NamedQuery(name = "Tbquestao.findByIdQuestao", query = "SELECT t FROM Tbquestao t WHERE t.idQuestao = :idQuestao"),
    @NamedQuery(name = "Tbquestao.findByDescricaoQuestao", query = "SELECT t FROM Tbquestao t WHERE t.descricaoQuestao = :descricaoQuestao"),
    @NamedQuery(name = "Tbquestao.findByAlternativaA", query = "SELECT t FROM Tbquestao t WHERE t.alternativaA = :alternativaA"),
    @NamedQuery(name = "Tbquestao.findByAlternativaB", query = "SELECT t FROM Tbquestao t WHERE t.alternativaB = :alternativaB"),
    @NamedQuery(name = "Tbquestao.findByAlternativaC", query = "SELECT t FROM Tbquestao t WHERE t.alternativaC = :alternativaC"),
    @NamedQuery(name = "Tbquestao.findByAlternativaD", query = "SELECT t FROM Tbquestao t WHERE t.alternativaD = :alternativaD"),
    @NamedQuery(name = "Tbquestao.findByAlternativaE", query = "SELECT t FROM Tbquestao t WHERE t.alternativaE = :alternativaE"),
    @NamedQuery(name = "Tbquestao.findByQuestaoCorreta", query = "SELECT t FROM Tbquestao t WHERE t.questaoCorreta = :questaoCorreta"),
    @NamedQuery(name = "Tbquestao.findByEstadoQuestao", query = "SELECT t FROM Tbquestao t WHERE t.estadoQuestao = :estadoQuestao")})
public class Tbquestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idQuestao")
    private Integer idQuestao;
    @Size(max = 45)
    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;
    @Size(max = 45)
    @Column(name = "alternativaA")
    private String alternativaA;
    @Size(max = 45)
    @Column(name = "alternativaB")
    private String alternativaB;
    @Size(max = 45)
    @Column(name = "alternativaC")
    private String alternativaC;
    @Size(max = 45)
    @Column(name = "alternativaD")
    private String alternativaD;
    @Size(max = 45)
    @Column(name = "alternativaE")
    private String alternativaE;
    @Column(name = "questaoCorreta")
    private Character questaoCorreta;
    @Column(name = "estadoQuestao")
    private short estadoQuestao;
    @ManyToMany(mappedBy = "tbquestaoList")
    private List<Tbprova> tbprovaList;
    @JoinColumn(name = "tbTipoQuestao_idTipoQuestao", referencedColumnName = "idTipoQuestao")
    @ManyToOne(optional = false)
    private Tbtipoquestao tbTipoQuestaoidTipoQuestao;

    public Tbquestao() {
    }

    public Tbquestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Tbquestao(Integer idQuestao, String descricaoQuestao, short estadoQuestao) {
        this.idQuestao = idQuestao;
        this.descricaoQuestao = descricaoQuestao;
        this.estadoQuestao = estadoQuestao;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public Character getQuestaoCorreta() {
        return questaoCorreta;
    }

    public void setQuestaoCorreta(Character questaoCorreta) {
        this.questaoCorreta = questaoCorreta;
    }

    public short getEstadoQuestao() {
        return estadoQuestao;
    }

    public void setEstadoQuestao(short estadoQuestao) {
        this.estadoQuestao = estadoQuestao;
    }

    public List<Tbprova> getTbprovaList() {
        return tbprovaList;
    }

    public void setTbprovaList(List<Tbprova> tbprovaList) {
        this.tbprovaList = tbprovaList;
    }

    public Tbtipoquestao getTbTipoQuestaoidTipoQuestao() {
        return tbTipoQuestaoidTipoQuestao;
    }

    public void setTbTipoQuestaoidTipoQuestao(Tbtipoquestao tbTipoQuestaoidTipoQuestao) {
        this.tbTipoQuestaoidTipoQuestao = tbTipoQuestaoidTipoQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbquestao)) {
            return false;
        }
        Tbquestao other = (Tbquestao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tbquestao[ idQuestao=" + idQuestao + " ]";
    }
    
}
