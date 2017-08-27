/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class AccountsFacade extends AbstractFacade<Accounts> implements AccountsFacadeLocal {
    @PersistenceContext(unitName = "AdventureMaker_ProjSem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountsFacade() {
        super(Accounts.class);
    }
    
    @Override
    public boolean checkLogin(String username, String password) {
        javax.persistence.Query q = em.createQuery("SELECT a FROM Accounts a WHERE a.accID = :accID and a.password = :password");
        q.setParameter("accID", username);
        q.setParameter("password", password);
        return (q.getSingleResult() != null);
    }
    
    @Override
    public List<Accounts> findByGroupID(String groupID) {
        javax.persistence.Query q = em.createNamedQuery("Accounts.findByGroupID");
        q.setParameter(1, groupID);
        return q.getResultList();
    }

}
