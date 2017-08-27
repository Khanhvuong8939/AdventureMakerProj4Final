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
public interface GameDetailsFacadeLocal {

    void create(GameDetails gameDetails);

    void edit(GameDetails gameDetails);

    void remove(GameDetails gameDetails);

    GameDetails find(Object id);

    List<GameDetails> findAll();

    List<GameDetails> findRange(int[] range);

    int count();
    
}
