package entities;

import entities.ToaThuoc;
import entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-25T19:34:40")
@StaticMetamodel(BenhNhan.class)
public class BenhNhan_ { 

    public static volatile SingularAttribute<BenhNhan, User> idUser;
    public static volatile SingularAttribute<BenhNhan, String> diaChi;
    public static volatile SingularAttribute<BenhNhan, String> sdt;
    public static volatile SingularAttribute<BenhNhan, String> ho;
    public static volatile SingularAttribute<BenhNhan, Date> ngaySinh;
    public static volatile ListAttribute<BenhNhan, ToaThuoc> toaThuocList;
    public static volatile SingularAttribute<BenhNhan, Integer> id;
    public static volatile SingularAttribute<BenhNhan, String> gioiTinh;
    public static volatile SingularAttribute<BenhNhan, String> ten;
    public static volatile SingularAttribute<BenhNhan, String> email;

}