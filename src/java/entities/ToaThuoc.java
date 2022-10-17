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
@Table(name = "ToaThuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToaThuoc.findAll", query = "SELECT t FROM ToaThuoc t")
    , @NamedQuery(name = "ToaThuoc.findById", query = "SELECT t FROM ToaThuoc t WHERE t.id = :id")
    , @NamedQuery(name = "ToaThuoc.findByNgayTao", query = "SELECT t FROM ToaThuoc t WHERE t.ngayTao = :ngayTao")
    , @NamedQuery(name = "ToaThuoc.findByChanDoan", query = "SELECT t FROM ToaThuoc t WHERE t.chanDoan = :chanDoan")})
public class ToaThuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    @Size(max = 50)
    @Column(name = "ChanDoan")
    private String chanDoan;
    @JoinColumn(name = "Id_BenhNhan", referencedColumnName = "ID")
    @ManyToOne
    private BenhNhan idBenhNhan;
    @JoinColumn(name = "Id_BacSi", referencedColumnName = "ID")
    @ManyToOne
    private NhanVien idBacSi;
    @JoinColumn(name = "Id_PhatThuoc", referencedColumnName = "ID")
    @ManyToOne
    private NhanVien idPhatThuoc;
    @Column(name = "TinhTrang")
    private Integer tinhTrang;
    @OneToMany(mappedBy = "iDToaThuoc")
    private List<ToaThuocChiTiet> toaThuocChiTietList;
    @OneToMany(mappedBy = "iDToaThuoc")
    private List<HoaDon> hoaDonList;

    public ToaThuoc() {
    }

    public ToaThuoc(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
      public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getChanDoan() {
        return chanDoan;
    }

    public void setChanDoan(String chanDoan) {
        this.chanDoan = chanDoan;
    }

    public BenhNhan getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(BenhNhan idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public NhanVien getIdBacSi() {
        return idBacSi;
    }

    public void setIdBacSi(NhanVien idBacSi) {
        this.idBacSi = idBacSi;
    }

    public NhanVien getIdPhatThuoc() {
        return idPhatThuoc;
    }

    public void setIdPhatThuoc(NhanVien idPhatThuoc) {
        this.idPhatThuoc = idPhatThuoc;
    }

    @XmlTransient
    public List<ToaThuocChiTiet> getToaThuocChiTietList() {
        return toaThuocChiTietList;
    }

    public void setToaThuocChiTietList(List<ToaThuocChiTiet> toaThuocChiTietList) {
        this.toaThuocChiTietList = toaThuocChiTietList;
    }

    @XmlTransient
    public List<HoaDon> getHoaDonList() {
        return hoaDonList;
    }

    public void setHoaDonList(List<HoaDon> hoaDonList) {
        this.hoaDonList = hoaDonList;
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
        if (!(object instanceof ToaThuoc)) {
            return false;
        }
        ToaThuoc other = (ToaThuoc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ToaThuoc[ id=" + id + " ]";
    }
    
}
