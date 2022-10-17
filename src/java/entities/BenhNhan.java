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
@Table(name = "BenhNhan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BenhNhan.findAll", query = "SELECT b FROM BenhNhan b")
    , @NamedQuery(name = "BenhNhan.findById", query = "SELECT b FROM BenhNhan b WHERE b.id = :id")
    , @NamedQuery(name = "BenhNhan.findByHo", query = "SELECT b FROM BenhNhan b WHERE b.ho = :ho")
    , @NamedQuery(name = "BenhNhan.findByTen", query = "SELECT b FROM BenhNhan b WHERE b.ten = :ten")
    , @NamedQuery(name = "BenhNhan.findByNgaySinh", query = "SELECT b FROM BenhNhan b WHERE b.ngaySinh = :ngaySinh")
    , @NamedQuery(name = "BenhNhan.findByDiaChi", query = "SELECT b FROM BenhNhan b WHERE b.diaChi = :diaChi")
    , @NamedQuery(name = "BenhNhan.findBySdt", query = "SELECT b FROM BenhNhan b WHERE b.sdt = :sdt")
    , @NamedQuery(name = "BenhNhan.findByEmail", query = "SELECT b FROM BenhNhan b WHERE b.email = :email")
    , @NamedQuery(name = "BenhNhan.findByGioiTinh", query = "SELECT b FROM BenhNhan b WHERE b.gioiTinh = :gioiTinh")})
public class BenhNhan implements Serializable {

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
    @Size(max = 5)
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @JoinColumn(name = "Id_User", referencedColumnName = "ID")
    @ManyToOne
    private User idUser;
    @OneToMany(mappedBy = "idBenhNhan")
    private List<ToaThuoc> toaThuocList;

    public BenhNhan() {
    }

    public BenhNhan(Integer id) {
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<ToaThuoc> getToaThuocList() {
        return toaThuocList;
    }

    public void setToaThuocList(List<ToaThuoc> toaThuocList) {
        this.toaThuocList = toaThuocList;
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
        if (!(object instanceof BenhNhan)) {
            return false;
        }
        BenhNhan other = (BenhNhan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BenhNhan[ id=" + id + " ]";
    }
    
}
