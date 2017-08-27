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
public interface GamesFacadeLocal {

    void create(Games games);

    void edit(Games games);

    void remove(Games games);

    Games find(Object id);

    List<Games> findAll();

    List<Games> findRange(int[] range);

    int count();
    
    List<Games> getGames(String user);
    
    String newGameID();
    
}
