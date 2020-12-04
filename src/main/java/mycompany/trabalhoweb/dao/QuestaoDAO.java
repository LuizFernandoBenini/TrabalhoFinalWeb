
package mycompany.trabalhoweb.dao;

import mycompany.trabalhoweb.model.Tbquestao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mycompany.trabalhoweb.util.PersistenceUtil;

public class QuestaoDAO {

    public static QuestaoDAO questaoDAO;

    public static QuestaoDAO getInstance() {
        if (questaoDAO == null) {
            questaoDAO = new QuestaoDAO();
        }
        return questaoDAO;
    }

   
    public Tbquestao buscarPorId(long id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select q from Tbquestao q where q.idQuestao =:id ");
        query.setParameter("id", id);

        List<Tbquestao> questao = query.getResultList();
        if (questao != null && questao.size() > 0) {
            return questao.get(0);
        }

        return null;
    }

    public List<Tbquestao> buscarTodos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Tbquestao As q");
        return query.getResultList();
    }

    public void trocaStatus(Tbquestao questao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        if (questao.getEstadoQuestao() == 0) 
        {
            questao.setEstadoQuestao((short)1);
        }else{
            questao.setEstadoQuestao((short)0);
        }
        
        em.getTransaction().begin();
        try {
            questao = em.merge(questao);
            em.getTransaction().commit();
            System.out.println("Registro Questão anulado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Tbquestao persistir(Tbquestao questao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            questao = em.merge(questao);
            em.getTransaction().commit();
            System.out.println("Registro Questão gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questao;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from tbquestao ");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
