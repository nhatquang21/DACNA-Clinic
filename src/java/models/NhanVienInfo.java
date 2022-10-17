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
public class NhanVienInfo {
    private int id;
    private String ho;
    private String ten;
    private Date ngaysinh;
    private String diachi;
    private String sdt;
    private String email;
    private int iduser;
    
    public NhanVienInfo(int id,String ho,String ten,Date ngaysinh,String diachi,String sdt,String email,int iduser) {
        this.id = id;
        this.ho=ho;
        this.ten=ten;
        this.ngaysinh=ngaysinh;
        this.diachi=diachi;
        this.sdt=sdt;
        this.email=email;        
        this.iduser=iduser;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return ngaysinh;
    }

    public void setNgaySinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    public String getDiaChi() {
        return diachi;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }
    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    public int getIdUser() {
        return iduser;
    }

    public void setIdUser(int iduser) {
        this.iduser = iduser;
    }
    
}
