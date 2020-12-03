
package mycompany.trabalhoweb.dao;

import mycompany.trabalhoweb.model.Tbprova;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mycompany.trabalhoweb.util.PersistenceUtil;

public class ProvaDAO {

    public static ProvaDAO provaDAO;

    public static ProvaDAO getInstance() {
        if (provaDAO == null) {
            provaDAO = new ProvaDAO();
        }
        return provaDAO;
    }

    public Tbprova buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TipoFuncionario a where a.nomeTipoFuncionario =:nome ");
        query.setParameter("nome", nome);

        List<Tbprova> prova = query.getResultList();
        if (prova != null && prova.size() > 0) {
            return prova.get(0);
        }

        return null;
    }
    
    
    
    public Tbprova buscarPorId(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select q from tbprova q where q.idprova =:id ");
        query.setParameter("id", id);

        List<Tbprova> prova = query.getResultList();
        if (prova != null && prova.size() > 0) {
            return prova.get(0);
        }

        return null;
    }

    public List<Tbprova> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from tbprova As p");
        return query.getResultList();
    }

    public void remover(Tbprova prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(prova)) {
            prova = em.merge(prova);
        }
        em.remove(prova);
        em.getTransaction().commit();
    }

    public Tbprova persistir(Tbprova prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            prova = em.merge(prova);
            em.getTransaction().commit();
            System.out.println("Registro Prova gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prova;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from tbprova ");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
