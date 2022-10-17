package entities;

import entities.BenhNhan;
import entities.HoaDon;
import entities.NhanVien;
import entities.ToaThuocChiTiet;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-25T19:34:40")
@StaticMetamodel(ToaThuoc.class)
public class ToaThuoc_ { 

    public static volatile ListAttribute<ToaThuoc, HoaDon> hoaDonList;
    public static volatile ListAttribute<ToaThuoc, ToaThuocChiTiet> toaThuocChiTietList;
    public static volatile SingularAttribute<ToaThuoc, Integer> tinhTrang;
    public static volatile SingularAttribute<ToaThuoc, NhanVien> idPhatThuoc;
    public static volatile SingularAttribute<ToaThuoc, Integer> id;
    public static volatile SingularAttribute<ToaThuoc, String> chanDoan;
    public static volatile SingularAttribute<ToaThuoc, NhanVien> idBacSi;
    public static volatile SingularAttribute<ToaThuoc, Date> ngayTao;
    public static volatile SingularAttribute<ToaThuoc, BenhNhan> idBenhNhan;

}