/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Thuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thuoc.findAll", query = "SELECT t FROM Thuoc t")
    , @NamedQuery(name = "Thuoc.findById", query = "SELECT t FROM Thuoc t WHERE t.id = :id")
    , @NamedQuery(name = "Thuoc.findByTenThuoc", query = "SELECT t FROM Thuoc t WHERE t.tenThuoc = :tenThuoc")
    , @NamedQuery(name = "Thuoc.findByNsx", query = "SELECT t FROM Thuoc t WHERE t.nsx = :nsx")
    , @NamedQuery(name = "Thuoc.findByDonViTinh", query = "SELECT t FROM Thuoc t WHERE t.donViTinh = :donViTinh")
    , @NamedQuery(name = "Thuoc.findBySoLuong", query = "SELECT t FROM Thuoc t WHERE t.soLuong = :soLuong")
    , @NamedQuery(name = "Thuoc.findByDonGia", query = "SELECT t FROM Thuoc t WHERE t.donGia = :donGia")
    , @NamedQuery(name = "Thuoc.findByCongDung", query = "SELECT t FROM Thuoc t WHERE t.congDung = :congDung")})
public class Thuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "TenThuoc")
    private String tenThuoc;
    @Size(max = 50)
    @Column(name = "NSX")
    private String nsx;
    @Size(max = 50)
    @Column(name = "DonViTinh")
    private String donViTinh;
    @Column(name = "SoLuong")
    private Integer soLuong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DonGia")
    private Double donGia;
    @Size(max = 50)
    @Column(name = "CongDung")
    private String congDung;
    @OneToMany(mappedBy = "iDThuoc")
    private List<ToaThuocChiTiet> toaThuocChiTietList;

    public Thuoc() {
    }

    public Thuoc(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public String getCongDung() {
        return congDung;
    }

    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }

    @XmlTransient
    public List<ToaThuocChiTiet> getToaThuocChiTietList() {
        return toaThuocChiTietList;
    }

    public void setToaThuocChiTietList(List<ToaThuocChiTiet> toaThuocChiTietList) {
        this.toaThuocChiTietList = toaThuocChiTietList;
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
        if (!(object instanceof Thuoc)) {
            return false;
        }
        Thuoc other = (Thuoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Thuoc[ id=" + id + " ]";
    }
    
}
