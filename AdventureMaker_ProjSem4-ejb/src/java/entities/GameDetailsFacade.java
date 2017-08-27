/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class GameDetailsFacade extends AbstractFacade<GameDetails> implements GameDetailsFacadeLocal {
    @PersistenceContext(unitName = "AdventureMaker_ProjSem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GameDetailsFacade() {
        super(GameDetails.class);
    }

}
