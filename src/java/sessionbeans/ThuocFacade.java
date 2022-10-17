/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Thuoc;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ADMIN
 */
@Stateless
public class ThuocFacade extends AbstractFacade<Thuoc> {

    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ThuocFacade() {
        super(Thuoc.class);
    }

    public List<Thuoc> findByName(String searchTxt) {
        //String sql = "select * from Thuoc where TenThuoc LIKE ?";
        Query q = em.createQuery(
                "SELECT t FROM Thuoc t WHERE t.tenThuoc LIKE :searchTxt"
        );
        q.setParameter("searchTxt", "%" + searchTxt + "%");
        //q.setParameter(1, searchTxt);
        return q.getResultList();
    }
}
