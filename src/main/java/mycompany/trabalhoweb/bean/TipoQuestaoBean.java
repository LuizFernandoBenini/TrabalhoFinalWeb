package mycompany.trabalhoweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import mycompany.trabalhoweb.model.Tbtipoquestao;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mycompany.trabalhoweb.dao.TipoQuestaoDAO;

@Named
@ViewScoped
public class TipoQuestaoBean implements Serializable {

    Tbtipoquestao tipoQuestao = new Tbtipoquestao();

    List tiposQuestao = new ArrayList();
    
    
    public TipoQuestaoBean() {
        tiposQuestao = new TipoQuestaoDAO().buscarTodos();
        tipoQuestao = new Tbtipoquestao();
    }

    public void salvar(ActionEvent actionEvent) {
     
        new TipoQuestaoDAO().persistir(tipoQuestao);
        tiposQuestao = new TipoQuestaoDAO().buscarTodos();
        tipoQuestao = new Tbtipoquestao();
    }

    public void remover(ActionEvent actionEvent) {
        new TipoQuestaoDAO().remover(tipoQuestao);
        tiposQuestao = new TipoQuestaoDAO().buscarTodos();
        tipoQuestao = new Tbtipoquestao();
    }

    public Tbtipoquestao getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(Tbtipoquestao tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    public List getTiposQuestao() {
        return tiposQuestao;
    }

    public void setTiposQuestao(List tiposQuestao) {
        this.tiposQuestao = tiposQuestao;
    }
    
    

}
