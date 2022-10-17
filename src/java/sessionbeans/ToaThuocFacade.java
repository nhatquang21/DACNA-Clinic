/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.BenhNhan;
import entities.ToaThuoc;
import java.util.Date;
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
public class ToaThuocFacade extends AbstractFacade<ToaThuoc> {

    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ToaThuocFacade() {
        super(ToaThuoc.class);
    }

    public List<ToaThuoc> getTodayToaThuoc() {
        String sql = "Select t from ToaThuoc t where t.ngayTao =  :currentDate";
        Query q = getEntityManager().createQuery(sql).setParameter("currentDate", new Date());
        return q.getResultList();
    }

    public List<ToaThuoc> getToa(int tinhTrang) {
        Query q = em.createQuery("SELECT t FROM ToaThuoc t WHERE t.tinhTrang =:tinhtrang");
        q.setParameter("tinhtrang", tinhTrang);
        return q.getResultList();
    }

    public List<Integer> getByIdBn(int id) {
        String sql = "Select ID from ToaThuoc where Id_BenhNhan = ?1";
        Query q = getEntityManager().createNativeQuery(sql).setParameter(1, id);
        return q.getResultList();
    }

    public List<ToaThuoc> getByIdBnPT(int id) {
        Query q = em.createQuery("SELECT t FROM ToaThuoc t WHERE t.idBenhNhan.id=:id");
        q.setParameter("id", id);
        return q.getResultList();
    }
    
    public List<ToaThuoc> getByIdUser(int id){
        Query q = em.createQuery("SELECT t FROM ToaThuoc t WHERE t.idBenhNhan.idUser.id=:id");
        q.setParameter("id", id);
        return q.getResultList();       
    }
    
}
