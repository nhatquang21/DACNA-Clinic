/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.BenhNhan;
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
public class BenhNhanFacade extends AbstractFacade<BenhNhan> {

    @PersistenceContext(unitName = "clinicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BenhNhanFacade() {
        super(BenhNhan.class);
    }

    public String getTodayPatient() {
        String sql = "Select Id_BenhNhan from ToaThuoc where NgayTao =  cast(getdate() as date)";
        Query q = getEntityManager().createNativeQuery(sql);
        List<String> listID = q.getResultList();
        System.out.println(listID.toString());
        return listID.toString();

    }

    public BenhNhan selectBenhNhanSDT(String info) {

        try {
            List<BenhNhan> list = em.createQuery("select u FROM BenhNhan u WHERE u.sdt = :info ")
                    .setParameter("info", info)
                    .getResultList();

            if (!list.isEmpty()) {
                System.out.println("Tìm thấy bệnh nhân");
                return list.get(0);
            } else {
                System.out.println("Không tìm thấy thấy bệnh nhân");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Login exception");
            ex.printStackTrace();
            return null;
        }

    }

    public BenhNhan selectBenhNhanEmail(String info) {

        try {
            List<BenhNhan> list = em.createQuery("select u FROM BenhNhan u WHERE u.email = :info ")
                    .setParameter("info", info)
                    .getResultList();

            if (!list.isEmpty()) {
                System.out.println("Tìm thấy bệnh nhân");
                return list.get(0);
            } else {
                System.out.println("Không tìm thấy thấy bệnh nhân");
                return null;
            }
        } catch (Exception ex) {
            System.out.println("Login exception");
            ex.printStackTrace();
            return null;
        }

    }

    public boolean checkDuplicatePatient(String email, String phone) {
        try {
            List<BenhNhan> list = em.createQuery("select b FROM BenhNhan b WHERE b.email = :email AND b.sdt = :phone")
                    .setParameter("email", email)
                    .setParameter("phone", phone)
                    .getResultList();

            if (!list.isEmpty()) {
                System.out.println("Duplicated");
                return true;
            } else {
                System.out.println("Email and phone number are not duplicated");
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Failed to check duplicate patient");
            ex.printStackTrace();
            return true;
        }
    }
        public boolean checkDuplicateEmailFromPatient(String email) {
        try {
            List<NhanVien> list = em.createQuery("select b FROM NhanVien b WHERE b.email = :email")
                    .setParameter("email", email)
                    .getResultList();

            if (!list.isEmpty()) {
                System.out.println("Duplicated from NhanVien");
                return true;
            } else {
                System.out.println("Email are not duplicated from nhanvien");
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Failed to check duplicate patient");
            ex.printStackTrace();
            return true;
        }
    }
      public boolean checkDuplicatePhone(String phone) {
        try {
            List<BenhNhan> list = em.createQuery("select b FROM BenhNhan b WHERE b.sdt = :phone")
                    .setParameter("phone", phone)
                    .getResultList();

            if (!list.isEmpty()) {
                System.out.println("Duplicated");
                return true;
            } else {
                System.out.println("phone number is not duplicated");
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Failed to check duplicate phone");
            ex.printStackTrace();
            return true;
        }
    }
       public boolean checkDuplicateEmail(String email) {
        try {
            List<BenhNhan> list = em.createQuery("select b FROM BenhNhan b WHERE b.email = :email")
                    .setParameter("email", email)
                    .getResultList();

            if (!list.isEmpty()) {
                System.out.println("Duplicated");
                return true;
            } else {
                System.out.println("Email is not duplicated");
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Failed to check duplicate email");
            ex.printStackTrace();
            return true;
        }
    }

    public List<BenhNhan> getNextPatient(int id) {

        String sql = "Select b FROM BenhNhan b";
        Query q = getEntityManager().createQuery(sql);
        return q.setMaxResults(1).setFirstResult(id).getResultList();
    }

}
