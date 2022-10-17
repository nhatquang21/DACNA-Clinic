package entities;

import entities.BenhNhan;
import entities.NhanVien;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-25T19:34:40")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, BenhNhan> benhNhanList;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> role;
    public static volatile ListAttribute<User, NhanVien> nhanVienList;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userID;

}