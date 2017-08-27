/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nth15
 */
@Local
public interface TeamTrackingsFacadeLocal {

    void create(TeamTrackings teamTrackings);

    void edit(TeamTrackings teamTrackings);

    void remove(TeamTrackings teamTrackings);

    TeamTrackings find(Object id);

    List<TeamTrackings> findAll();

    List<TeamTrackings> findRange(int[] range);

    int count();
    
}
