/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Polypro.SanPham;
import entity.Students;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.TaiKhoan;
import entity.sanpham;

public class StudentsDAO {
    private Students readFromResultSet(ResultSet rs) throws SQLException{
	      Students model=new Students();
        model.setMaSV(rs.getString("MaSV"));
        model.setHoTen(rs.getString("HoTen"));
     
        return model;
    }

    private List<Students> select(String sql, Object...args){
        List<Students> list=new ArrayList<>();
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
    public void insert(Students entity) {
        String sql="INSERT INTO Students (MaSV,HoTen) VALUES (?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMaSV(),
                entity.getHoTen());
    }
        public void update(Students entity) {
        String sql="UPDATE Students SET HoTen = ? WHERE MaSV=?";
        jdbcHelper.executeUpdate(sql,
                entity.getHoTen(),
                entity.getMaSV());      
    }
      public void delete(String MaSV) {
        String sql="DELETE FROM Students WHERE MaSV=?";
        jdbcHelper.executeUpdate(sql, MaSV);
    }


    /**
     * Truy vấn tất cả các các thực thể
     * @return list danh sách các thực thể
     */
    public List<Students> select() {
        String sql="SELECT * FROM Students";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public Students findById(String id) {
        String sql="SELECT * FROM Students WHERE MaSV=?";
        List<Students> list=select(sql,id);
        return list.size()>0?list.get(0):null;
    }    
}
