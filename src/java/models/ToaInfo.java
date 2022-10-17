/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author huytd
 */
public class ToaInfo {
    private int id;    
    private Date ngaytao;
    private String chandoan;
    private int idbenhnhan;
    private int idbacsi;
    private int idphatthuoc;
    private int tinhtrang;
    
   
    
    
    public ToaInfo(int id,Date ngaytao,String chandoan,int idbenhnhan,int idbacsi,int idphatthuoc,int tinhtrang) {
        this.id = id;        
        this.ngaytao=ngaytao;
        this.chandoan=chandoan;
        this.idbenhnhan=idbenhnhan;
        this.idbacsi=idbacsi;
        this.idphatthuoc=idphatthuoc;
        
    }
//    public String toJSON() {
//        return String.format("{\"id\":%d, \"ho\":\"%s\", \"ten\": \"%s\", \"ngaysinh\": \"%tF\", \"diachi\": \"%s\", \"sdt\": \"%s\", \"email\": \"%s\", \"gioitinh\": \"%s\"}", id, ho, ten,ngaysinh,diachi,sdt,email,gioitinh);                
//    }    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChanDoan() {
        return chandoan;
    }

    public void setChanDoan(String chandoan) {
        this.chandoan = chandoan;
    }
  
    public Date getNgayTao() {
        return ngaytao;
    }

    public void setNgayTao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }
    
    public int getIdBenhNhan() {
        return idbenhnhan;
    }

    public void setIdBenhNhan(int idbenhnhan) {
        this.idbenhnhan = idbenhnhan;
    }
    public int getIdBacSi() {
        return idbacsi;
    }

    public void setIdBacSi(int idbacsi) {
        this.idbacsi = idbacsi;
    }
    public int getIdPhatThuoc() {
        return idphatthuoc;
    }

    public void setIdPhatThuoc(int idphatthuoc) {
        this.idphatthuoc = idphatthuoc;
    }
    public int getTinhTrang() {
        return tinhtrang;
    }

    public void setTinhTrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
