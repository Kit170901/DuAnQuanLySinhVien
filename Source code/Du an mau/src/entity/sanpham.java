/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author quang
 */
public class sanpham {
    public String masp;
    public String tensp;
    public Double dongia;

    public sanpham() {
    }

    public sanpham(String masp, String tensp, Double dongia) {
        this.masp = masp;
        this.tensp = tensp;
        this.dongia = dongia;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public Double getDongia() {
        return dongia;
    }

    public void setDongia(Double dongia) {
        this.dongia = dongia;
    }
    
}
