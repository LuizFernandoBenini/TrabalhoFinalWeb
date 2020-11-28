
package mycompany.trabalhoweb.dao;

import mycompany.trabalhoweb.model.Tbtipoquestao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mycompany.trabalhoweb.util.PersistenceUtil;

public class TipoQuestaoDAO {

    public static TipoQuestaoDAO tipoQuestaoDAO;

    public static TipoQuestaoDAO getInstance() {
        if (tipoQuestaoDAO == null) {
            tipoQuestaoDAO = new TipoQuestaoDAO();
        }
        return tipoQuestaoDAO;
    }

    public Tbtipoquestao buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TipoFuncionario a where a.nomeTipoFuncionario =:nome ");
        query.setParameter("nome", nome);

        List<Tbtipoquestao> tipoQuestao = query.getResultList();
        if (tipoQuestao != null && tipoQuestao.size() > 0) {
            return tipoQuestao.get(0);
        }

        return null;
    }
    
    
    
    public Tbtipoquestao buscarPorId(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select tq from tbtipoquestao tq where tq.idtipoQuestao =:id ");
        query.setParameter("id", id);

        List<Tbtipoquestao> tipoQuestao = query.getResultList();
        if (tipoQuestao != null && tipoQuestao.size() > 0) {
            return tipoQuestao.get(0);
        }

        return null;
    }

    public List<Tbtipoquestao> buscarTodos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from tbtipoquestao As tq");
        return query.getResultList();
    }

    public void remover(Tbtipoquestao tipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tipoQuestao)) {
            tipoQuestao = em.merge(tipoQuestao);
        }
        em.remove(tipoQuestao);
        em.getTransaction().commit();
    }

    public Tbtipoquestao persistir(Tbtipoquestao tipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tipoQuestao = em.merge(tipoQuestao);
            em.getTransaction().commit();
            System.out.println("Registro Tipo de Questão gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoQuestao;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from tbtipoquestao ");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
