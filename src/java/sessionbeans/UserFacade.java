/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utils.Hasher;

/**
 *
 * @author ADMIN
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
        public User selectAccount(String email, String password) {        
        try {
            List<User> list = em.createQuery("select u FROM User u WHERE u.userID = :email AND u.password = :password")
                    .setParameter("email", email)
                    .setParameter("password", Hasher.hash(password))
                    .getResultList();
           
            if (!list.isEmpty()) {
                System.out.println("Login successfully");
                return list.get(0);
            } else {
                System.out.println("Login fails");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Login exception");
            ex.printStackTrace();
            return null;
        }
    }
}
