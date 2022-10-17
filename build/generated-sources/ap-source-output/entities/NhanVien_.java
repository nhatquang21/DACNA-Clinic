package entities;

import entities.ToaThuoc;
import entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-25T19:34:40")
@StaticMetamodel(NhanVien.class)
public class NhanVien_ { 

    public static volatile SingularAttribute<NhanVien, User> idUser;
    public static volatile SingularAttribute<NhanVien, String> diaChi;
    public static volatile SingularAttribute<NhanVien, String> sdt;
    public static volatile ListAttribute<NhanVien, ToaThuoc> toaThuocList1;
    public static volatile SingularAttribute<NhanVien, String> ho;
    public static volatile SingularAttribute<NhanVien, Date> ngaySinh;
    public static volatile ListAttribute<NhanVien, ToaThuoc> toaThuocList;
    public static volatile SingularAttribute<NhanVien, Integer> id;
    public static volatile SingularAttribute<NhanVien, String> ten;
    public static volatile SingularAttribute<NhanVien, String> email;

}