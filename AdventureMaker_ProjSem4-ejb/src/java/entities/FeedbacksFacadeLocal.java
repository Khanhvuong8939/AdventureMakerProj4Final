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
public interface FeedbacksFacadeLocal {

    void create(Feedbacks feedbacks);

    void edit(Feedbacks feedbacks);

    void remove(Feedbacks feedbacks);

    Feedbacks find(Object id);

    List<Feedbacks> findAll();

    List<Feedbacks> findRange(int[] range);

    int count();
    
}
