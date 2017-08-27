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
public class StationsFacade extends AbstractFacade<Stations> implements StationsFacadeLocal {
    @EJB
    private GamesFacadeLocal gamesFacade;
    @PersistenceContext(unitName = "AdventureMaker_ProjSem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StationsFacade() {
        super(Stations.class);
    }

    @Override
    public List<Stations> findByGameID(String gameID) {
        javax.persistence.Query q = em.createNamedQuery("Stations.findByGameID");
        q.setParameter(1, gamesFacade.find(gameID));
        return q.getResultList();
    }
    
    @Override
    public String newStationID(){
        String gameID = "";
        javax.persistence.Query q = em.createNamedQuery("Stations.findAll");
        List<Stations> list = q.getResultList();
        int lastNumb = Integer.parseInt(list.get(list.size()-1).getStationID().substring(2, 5));
        
        if (lastNumb<9) {
            gameID = "ST00"+(lastNumb+1);
        }
        else if (lastNumb<99) {
            gameID = "ST0"+(lastNumb+1);
        }
        else {
            gameID = "ST"+(lastNumb+1);
        }
        return gameID;
    }
}
