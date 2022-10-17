/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.ToaThuocChiTiet;
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
public class ToaThuocChiTietFacade extends AbstractFacade<ToaThuocChiTiet> {

    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ToaThuocChiTietFacade() {
        super(ToaThuocChiTiet.class);
    }
    public List<ToaThuocChiTiet> getByIdBn(int id){
        Query q = em.createQuery("SELECT t FROM ToaThuocChiTiet t WHERE t.iDToaThuoc.idBenhNhan.id=:id");
        q.setParameter("id", id);
        return q.getResultList();       
    }
}
