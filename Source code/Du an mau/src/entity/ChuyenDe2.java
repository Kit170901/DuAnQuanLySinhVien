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
public class ChuyenDe2 {
    public String MACD;
    public String TENCD;
    public Double HOCPHI;

    public ChuyenDe2(String MACD, String TENCD, Double HOCPHI) {
        this.MACD = MACD;
        this.TENCD = TENCD;
        this.HOCPHI = HOCPHI;
    }

    public String getMACD() {
        return MACD;
    }

    public void setMACD(String MACD) {
        this.MACD = MACD;
    }

    public String getTENCD() {
        return TENCD;
    }

    public ChuyenDe2() {
    }

    public void setTENCD(String TENCD) {
        this.TENCD = TENCD;
    }

    public Double getHOCPHI() {
        return HOCPHI;
    }

    public void setHOCPHI(Double HOCPHI) {
        this.HOCPHI = HOCPHI;
    }
    
            
}
