package mycompany.trabalhoweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import mycompany.trabalhoweb.model.Tbprova;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mycompany.trabalhoweb.dao.ProvaDAO;

@Named
@ViewScoped
public class ProvaBean implements Serializable {

    Tbprova prova = new Tbprova();

    List provas = new ArrayList();
    
    
    public ProvaBean() {
        provas = new ProvaDAO().buscarTodas();
        prova = new Tbprova();
    }

    public void salvar(ActionEvent actionEvent) {
     
        new ProvaDAO().persistir(prova);
        provas = new ProvaDAO().buscarTodas();
        prova = new Tbprova();
    }

    public void remover(ActionEvent actionEvent) {
        new ProvaDAO().remover(prova);
        provas = new ProvaDAO().buscarTodas();
        prova = new Tbprova();
    }

    public Tbprova getProva() {
        return prova;
    }

    public void setProva(Tbprova prova) {
        this.prova = prova;
    }

    public List getProvas() {
        return provas;
    }

    public void setProvas(List provas) {
        this.provas = provas;
    }

    
    

}
