/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class TeamsFacade extends AbstractFacade<Teams> implements TeamsFacadeLocal {
    @EJB
    private GamesFacadeLocal gamesFacade;
    @PersistenceContext(unitName = "AdventureMaker_ProjSem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamsFacade() {
        super(Teams.class);
    }

    @Override
    public String newTeamID(){
        String gameID = "";
        javax.persistence.Query q = em.createNamedQuery("Teams.findAll");
        List<Teams> list = q.getResultList();
        int lastNumb = Integer.parseInt(list.get(list.size()-1).getTeamID().substring(1, 3));
        
        if (lastNumb<9) {
            gameID = "T0"+(lastNumb+1);
        }
        else if (lastNumb<98) {
            gameID = "T"+(lastNumb+1);
        }
        return gameID;
    }

    @Override
    public List<Teams> findByGameID(String gameID) {
        javax.persistence.Query q = em.createNamedQuery("Teams.findByGameID");
        q.setParameter("1", gamesFacade.find(gameID));
        return q.getResultList();
    }
    
    
}
