
package mycompany.trabalhoweb.dao;

import mycompany.trabalhoweb.model.Tbresultado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mycompany.trabalhoweb.util.PersistenceUtil;

public class ResultadoDAO {

    public static ResultadoDAO resultadoDAO;

    public static ResultadoDAO getInstance() {
        if (resultadoDAO == null) {
            resultadoDAO = new ResultadoDAO();
        }
        return resultadoDAO;
    }

    public Tbresultado buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TipoFuncionario a where a.nomeTipoFuncionario =:nome ");
        query.setParameter("nome", nome);

        List<Tbresultado> resultado = query.getResultList();
        if (resultado != null && resultado.size() > 0) {
            return resultado.get(0);
        }

        return null;
    }
    
    
    
    public Tbresultado buscarPorId(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select q from tbresultado q where q.idresultado =:id ");
        query.setParameter("id", id);

        List<Tbresultado> resultado = query.getResultList();
        if (resultado != null && resultado.size() > 0) {
            return resultado.get(0);
        }

        return null;
    }

    public List<Tbresultado> buscarTodos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from tbresultado As q");
        return query.getResultList();
    }

    public void remover(Tbresultado resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(resultado)) {
            resultado = em.merge(resultado);
        }
        em.remove(resultado);
        em.getTransaction().commit();
    }

    public Tbresultado persistir(Tbresultado resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            resultado = em.merge(resultado);
            em.getTransaction().commit();
            System.out.println("Registro Resultado gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from tbresultado ");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
