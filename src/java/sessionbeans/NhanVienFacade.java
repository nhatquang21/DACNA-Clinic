/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.NhanVien;
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
public class NhanVienFacade extends AbstractFacade<NhanVien> {

    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NhanVienFacade() {
        super(NhanVien.class);
    }
    public List<NhanVien> getByRole(String role){
        Query q = em.createQuery("SELECT n FROM NhanVien n WHERE n.idUser.role =:role");
        q.setParameter("role", role);       
        return q.getResultList();
    }
}
