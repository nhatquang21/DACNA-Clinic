package entities;

import entities.ToaThuocChiTiet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-07-25T19:34:40")
@StaticMetamodel(Thuoc.class)
public class Thuoc_ { 

    public static volatile SingularAttribute<Thuoc, String> nsx;
    public static volatile ListAttribute<Thuoc, ToaThuocChiTiet> toaThuocChiTietList;
    public static volatile SingularAttribute<Thuoc, String> congDung;
    public static volatile SingularAttribute<Thuoc, Integer> id;
    public static volatile SingularAttribute<Thuoc, String> tenThuoc;
    public static volatile SingularAttribute<Thuoc, String> donViTinh;
    public static volatile SingularAttribute<Thuoc, Integer> soLuong;
    public static volatile SingularAttribute<Thuoc, Double> donGia;

}