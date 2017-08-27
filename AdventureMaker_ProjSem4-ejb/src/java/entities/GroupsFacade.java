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
public class GroupsFacade extends AbstractFacade<Groups> implements GroupsFacadeLocal {
    @PersistenceContext(unitName = "AdventureMaker_ProjSem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupsFacade() {
        super(Groups.class);
    }

    @Override
    public String newGroupID(){
        javax.persistence.Query q = em.createNamedQuery("Groups.findAll");
        List<Groups> listG = q.getResultList();
        String groupID = "";
        int lastNumb = Integer.parseInt(listG.get(listG.size()-1).getGroupID().substring(2, 5));
        
        if (lastNumb<9) {
            groupID = "GP00"+(lastNumb+1);
        }
        else if (lastNumb<98) {
            groupID = "GP0"+(lastNumb+1);
        }
        else {
            groupID = "GP"+(lastNumb+1);
        }
        return groupID;
    }
}
