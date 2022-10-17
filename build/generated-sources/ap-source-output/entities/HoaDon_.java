package entities;

import entities.HoaDonChiTiet;
import entities.ToaThuoc;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-25T19:34:40")
@StaticMetamodel(HoaDon.class)
public class HoaDon_ { 

    public static volatile SingularAttribute<HoaDon, ToaThuoc> iDToaThuoc;
    public static volatile SingularAttribute<HoaDon, Integer> id;
    public static volatile ListAttribute<HoaDon, HoaDonChiTiet> hoaDonChiTietList;
    public static volatile SingularAttribute<HoaDon, Date> ngayTao;

}