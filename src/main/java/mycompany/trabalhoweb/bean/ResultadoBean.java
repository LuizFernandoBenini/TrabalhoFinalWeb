package mycompany.trabalhoweb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.event.ActionEvent;
import mycompany.trabalhoweb.model.Tbquestao;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mycompany.trabalhoweb.dao.ProvaDAO;
import mycompany.trabalhoweb.dao.QuestaoDAO;
import mycompany.trabalhoweb.dao.ResultadoDAO;
import mycompany.trabalhoweb.dao.TipoQuestaoDAO;
import mycompany.trabalhoweb.model.Tbprova;
import mycompany.trabalhoweb.model.Tbresultado;
import mycompany.trabalhoweb.model.Tbtipoquestao;
import mycompany.trabalhoweb.model.Tbusuario;

@Named
@ViewScoped
public class ResultadoBean implements Serializable {

    Tbresultado resultado = new Tbresultado();

    List resultados = new ArrayList();
    
    Tbprova prova = new Tbprova();
    
    Tbusuario aluno = new Tbusuario();
    
    public ResultadoBean() {
        resultados = new ResultadoDAO().buscarTodos();
        resultado = new Tbresultado();
        prova = new Tbprova();
        aluno = new Tbusuario();
    }
  

    public void salvar(ActionEvent actionEvent) {
     
        new ResultadoDAO().persistir(resultado);
        resultados = new ResultadoDAO().buscarTodos();
        resultado = new Tbresultado();
        prova = new Tbprova();
        aluno = new Tbusuario();
    }
    
    public Tbresultado getResultado() {
        return resultado;
    }

    public void setResultado(Tbresultado resultado) {
        this.resultado = resultado;
    }

    public List getResultados() {
        return resultados;
    }

    public void setResultados(List resultados) {
        this.resultados = resultados;
    }
    
    

}
