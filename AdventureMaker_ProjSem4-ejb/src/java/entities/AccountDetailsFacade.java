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
public class AccountDetailsFacade extends AbstractFacade<AccountDetails> implements AccountDetailsFacadeLocal {
    @PersistenceContext(unitName = "AdventureMaker_ProjSem4-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountDetailsFacade() {
        super(AccountDetails.class);
    }

}
