/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "HoaDonChiTiet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDonChiTiet.findAll", query = "SELECT h FROM HoaDonChiTiet h")
    , @NamedQuery(name = "HoaDonChiTiet.findById", query = "SELECT h FROM HoaDonChiTiet h WHERE h.id = :id")
    , @NamedQuery(name = "HoaDonChiTiet.findByDichVu", query = "SELECT h FROM HoaDonChiTiet h WHERE h.dichVu = :dichVu")
    , @NamedQuery(name = "HoaDonChiTiet.findByDonGia", query = "SELECT h FROM HoaDonChiTiet h WHERE h.donGia = :donGia")})
public class HoaDonChiTiet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "DichVu")
    private String dichVu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DonGia")
    private Double donGia;
    @JoinColumn(name = "ID_HoaDon", referencedColumnName = "ID")
    @ManyToOne
    private HoaDon iDHoaDon;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public HoaDon getIDHoaDon() {
        return iDHoaDon;
    }

    public void setIDHoaDon(HoaDon iDHoaDon) {
        this.iDHoaDon = iDHoaDon;
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
        if (!(object instanceof HoaDonChiTiet)) {
            return false;
        }
        HoaDonChiTiet other = (HoaDonChiTiet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HoaDonChiTiet[ id=" + id + " ]";
    }
    
}
