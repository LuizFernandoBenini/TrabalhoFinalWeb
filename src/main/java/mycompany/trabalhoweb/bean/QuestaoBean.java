package mycompany.trabalhoweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import mycompany.trabalhoweb.model.Tbquestao;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mycompany.trabalhoweb.dao.QuestaoDAO;
import mycompany.trabalhoweb.dao.TipoQuestaoDAO;
import mycompany.trabalhoweb.model.Tbtipoquestao;

@Named
@ViewScoped
public class QuestaoBean implements Serializable {

    Tbquestao questao = new Tbquestao();

    List questoes = new ArrayList();
    
    Tbtipoquestao tipoQuestao = new Tbtipoquestao();

    List tiposQuestao = new ArrayList();
    
    public QuestaoBean() {
        questoes = new QuestaoDAO().buscarTodos();
        questao = new Tbquestao();
        tiposQuestao = new TipoQuestaoDAO().buscarTodos();
        tipoQuestao = new Tbtipoquestao();
    }
  

    public void salvar(ActionEvent actionEvent) {
     
        new QuestaoDAO().persistir(questao);
        questoes = new QuestaoDAO().buscarTodos();
        questao = new Tbquestao();
    }

    public void trocaStatus(ActionEvent actionEvent) {
        new QuestaoDAO().trocaStatus(questao);
        questoes = new QuestaoDAO().buscarTodos();
        questao = new Tbquestao();
    }

    public Tbquestao getQuestao() {
        return questao;
    }

    public void setQuestao(Tbquestao questao) {
        this.questao = questao;
    }

    public List getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List questoes) {
        this.questoes = questoes;
    }
    
    

}
