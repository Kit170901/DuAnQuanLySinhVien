/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Polypro.SanPham;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.TaiKhoan;
import entity.sanpham;

public class SanPhamDAO {
    private sanpham readFromResultSet(ResultSet rs) throws SQLException{
	      sanpham model=new sanpham();
        model.setMasp(rs.getString("masp"));
        model.setTensp(rs.getString("tensp"));
        model.setDongia(Double.parseDouble(rs.getString("dongia")));
        return model;
    }

    private List<sanpham> select(String sql, Object...args){
        List<sanpham> list=new ArrayList<>();
        try {
            ResultSet rs=null;
            try{
                rs=jdbcHelper.executeQuery(sql, args);
                while(rs.next()){
                    list.add(readFromResultSet(rs));
                }
            }finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException();
        }
        return list;
    }
    /**
     * Thêm mới thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi mới
     */
    public void insert(sanpham entity) {
        String sql="INSERT INTO sanpham (masp,tensp,dongia) VALUES (?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMasp(),
                entity.getTensp(),
                entity.getDongia());
    }

    /**
     * Cập nhật thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(sanpham entity) {
        String sql="UPDATE sanpham SET tensp = ?, dongia = ? WHERE masp=?";
        jdbcHelper.executeUpdate(sql,
                entity.getTensp(),
                entity.getDongia(),
                entity.getMasp());      
    }

    /**
     * Xóa bản ghi khỏi CSDL
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String masp) {
        String sql="DELETE FROM sanpham WHERE masp=?";
        jdbcHelper.executeUpdate(sql, masp);
    }

    /**
     * Truy vấn tất cả các các thực thể
     * @return list danh sách các thực thể
     */
    public List<sanpham> select() {
        String sql="SELECT * FROM sanpham";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public sanpham findById(String id) {
        String sql="SELECT * FROM sanpham WHERE masp=?";
        List<sanpham> list=select(sql,id);
        return list.size()>0?list.get(0):null;
    }    
        public List<sanpham> selectNotInCourse(String masp, String keyword) {
        String sql="SELECT * FROM sanpham "
                + " WHERE masp LIKE ? AND "
                + " masp NOT IN (SELECT masp FROM sanpham WHERE masp =?)";
        return this.select(sql, "%"+keyword+"%", masp);
    }
            public void delete(TaiKhoan tk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
