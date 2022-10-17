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
@Table(name = "ToaThuocChiTiet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToaThuocChiTiet.findAll", query = "SELECT t FROM ToaThuocChiTiet t")
    , @NamedQuery(name = "ToaThuocChiTiet.findById", query = "SELECT t FROM ToaThuocChiTiet t WHERE t.id = :id")
    , @NamedQuery(name = "ToaThuocChiTiet.findBySoLuong", query = "SELECT t FROM ToaThuocChiTiet t WHERE t.soLuong = :soLuong")
    , @NamedQuery(name = "ToaThuocChiTiet.findByDonGia", query = "SELECT t FROM ToaThuocChiTiet t WHERE t.donGia = :donGia")
    , @NamedQuery(name = "ToaThuocChiTiet.findBySang", query = "SELECT t FROM ToaThuocChiTiet t WHERE t.sang = :sang")
    , @NamedQuery(name = "ToaThuocChiTiet.findByChieu", query = "SELECT t FROM ToaThuocChiTiet t WHERE t.chieu = :chieu")
    , @NamedQuery(name = "ToaThuocChiTiet.findByToi", query = "SELECT t FROM ToaThuocChiTiet t WHERE t.toi = :toi")
    , @NamedQuery(name = "ToaThuocChiTiet.findByCachDung", query = "SELECT t FROM ToaThuocChiTiet t WHERE t.cachDung = :cachDung")})
public class ToaThuocChiTiet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SoLuong")
    private Integer soLuong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DonGia")
    private Double donGia;
    @Size(max = 50)
    @Column(name = "Sang")
    private String sang;
    @Size(max = 50)
    @Column(name = "Chieu")
    private String chieu;
    @Size(max = 50)
    @Column(name = "Toi")
    private String toi;
    @Size(max = 50)
    @Column(name = "CachDung")
    private String cachDung;
    @JoinColumn(name = "ID_Thuoc", referencedColumnName = "ID")
    @ManyToOne
    private Thuoc iDThuoc;
    @JoinColumn(name = "ID_ToaThuoc", referencedColumnName = "ID")
    @ManyToOne
    private ToaThuoc iDToaThuoc;

    public ToaThuocChiTiet() {
    }

    public ToaThuocChiTiet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSang() {
        return sang;
    }

    public void setSang(String sang) {
        this.sang = sang;
    }

    public String getChieu() {
        return chieu;
    }

    public void setChieu(String chieu) {
        this.chieu = chieu;
    }

    public String getToi() {
        return toi;
    }

    public void setToi(String toi) {
        this.toi = toi;
    }

    public String getCachDung() {
        return cachDung;
    }

    public void setCachDung(String cachDung) {
        this.cachDung = cachDung;
    }

    public Thuoc getIDThuoc() {
        return iDThuoc;
    }

    public void setIDThuoc(Thuoc iDThuoc) {
        this.iDThuoc = iDThuoc;
    }

    public ToaThuoc getIDToaThuoc() {
        return iDToaThuoc;
    }

    public void setIDToaThuoc(ToaThuoc iDToaThuoc) {
        this.iDToaThuoc = iDToaThuoc;
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
        if (!(object instanceof ToaThuocChiTiet)) {
            return false;
        }
        ToaThuocChiTiet other = (ToaThuocChiTiet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ToaThuocChiTiet[ id=" + id + " ]";
    }
    
}
