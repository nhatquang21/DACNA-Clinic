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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "HoaDon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h")
    , @NamedQuery(name = "HoaDon.findById", query = "SELECT h FROM HoaDon h WHERE h.id = :id")
    , @NamedQuery(name = "HoaDon.findByNgayTao", query = "SELECT h FROM HoaDon h WHERE h.ngayTao = :ngayTao")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    @JoinColumn(name = "ID_ToaThuoc", referencedColumnName = "ID")
    @ManyToOne
    private ToaThuoc iDToaThuoc;
    @OneToMany(mappedBy = "iDHoaDon")
    private List<HoaDonChiTiet> hoaDonChiTietList;

    public HoaDon() {
    }

    public HoaDon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public ToaThuoc getIDToaThuoc() {
        return iDToaThuoc;
    }

    public void setIDToaThuoc(ToaThuoc iDToaThuoc) {
        this.iDToaThuoc = iDToaThuoc;
    }

    @XmlTransient
    public List<HoaDonChiTiet> getHoaDonChiTietList() {
        return hoaDonChiTietList;
    }

    public void setHoaDonChiTietList(List<HoaDonChiTiet> hoaDonChiTietList) {
        this.hoaDonChiTietList = hoaDonChiTietList;
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
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HoaDon[ id=" + id + " ]";
    }
    
}
