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
import javax.persistence.Query;


@Stateless
public class GamesFacade extends AbstractFacade<Games> implements GamesFacadeLocal {
    @PersistenceContext(unitName = "AdventureMaker_ProjSem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GamesFacade() {
        super(Games.class);
    }

    @Override
    public List<Games> getGames(String user) {
        Query q = em.createNamedQuery("Games.findByAccID");
        q.setParameter("accID", user);
        return q.getResultList();
    }
    
    @Override
    public String newGameID(){
        String gameID = "";
        javax.persistence.Query q = em.createNamedQuery("Games.findAll");
        List<Games> list = q.getResultList();
        int lastNumb = Integer.parseInt(list.get(list.size()-1).getGameID().substring(2, 5));
        
        if (lastNumb<9) {
            gameID = "GA00"+(lastNumb+1);
        }
        else if (lastNumb<98) {
            gameID = "GA0"+(lastNumb+1);
        }
        else {
            gameID = "GA" + (lastNumb+1);
        }
        return gameID;
    }
    
}
