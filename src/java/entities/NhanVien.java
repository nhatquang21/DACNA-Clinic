/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "NhanVien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n")
    , @NamedQuery(name = "NhanVien.findById", query = "SELECT n FROM NhanVien n WHERE n.id = :id")
    , @NamedQuery(name = "NhanVien.findByHo", query = "SELECT n FROM NhanVien n WHERE n.ho = :ho")
    , @NamedQuery(name = "NhanVien.findByTen", query = "SELECT n FROM NhanVien n WHERE n.ten = :ten")
    , @NamedQuery(name = "NhanVien.findByNgaySinh", query = "SELECT n FROM NhanVien n WHERE n.ngaySinh = :ngaySinh")
    , @NamedQuery(name = "NhanVien.findByDiaChi", query = "SELECT n FROM NhanVien n WHERE n.diaChi = :diaChi")
    , @NamedQuery(name = "NhanVien.findBySdt", query = "SELECT n FROM NhanVien n WHERE n.sdt = :sdt")
    , @NamedQuery(name = "NhanVien.findByEmail", query = "SELECT n FROM NhanVien n WHERE n.email = :email")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "Ho")
    private String ho;
    @Size(max = 50)
    @Column(name = "Ten")
    private String ten;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Size(max = 50)
    @Column(name = "DiaChi")
    private String diaChi;
    @Size(max = 50)
    @Column(name = "SDT")
    private String sdt;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @OneToMany(mappedBy = "idBacSi")
    private List<ToaThuoc> toaThuocList;
    @OneToMany(mappedBy = "idPhatThuoc")
    private List<ToaThuoc> toaThuocList1;
    @JoinColumn(name = "Id_User", referencedColumnName = "ID")
    @ManyToOne
    private User idUser;

    public NhanVien() {
    }

    public NhanVien(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<ToaThuoc> getToaThuocList() {
        return toaThuocList;
    }

    public void setToaThuocList(List<ToaThuoc> toaThuocList) {
        this.toaThuocList = toaThuocList;
    }

    @XmlTransient
    public List<ToaThuoc> getToaThuocList1() {
        return toaThuocList1;
    }

    public void setToaThuocList1(List<ToaThuoc> toaThuocList1) {
        this.toaThuocList1 = toaThuocList1;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NhanVien[ id=" + id + " ]";
    }
    
}
