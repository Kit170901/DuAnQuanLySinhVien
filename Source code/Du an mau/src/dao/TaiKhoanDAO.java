/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.TaiKhoan;

public class TaiKhoanDAO {
    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException{
	TaiKhoan model=new TaiKhoan();
        model.setUsername(rs.getString("username"));
        model.setPassword(rs.getString("password"));
        return model;
    }

    private List<TaiKhoan> select(String sql, Object...args){
        List<TaiKhoan> list=new ArrayList<>();
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
    public void insert(TaiKhoan entity) {
        String sql="INSERT INTO TaiKhoan (username,password) VALUES ( ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getUsername(),
                entity.getPassword());           
    }

    /**
     * Cập nhật thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(TaiKhoan entity) {
        String sql="UPDATE TaiKhoan SET password = ? WHERE username=?";
        jdbcHelper.executeUpdate(sql,
                entity.getPassword(),
                entity.getUsername());      
    }

    /**
     * Xóa bản ghi khỏi CSDL
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String username) {
        String sql="DELETE FROM TaiKhoan WHERE username=?";
        jdbcHelper.executeUpdate(sql, username);
    }

    /**
     * Truy vấn tất cả các các thực thể
     * @return list danh sách các thực thể
     */
    public List<TaiKhoan> select() {
        String sql="SELECT * FROM TaiKhoan";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public TaiKhoan findById(String id) {
        String sql="SELECT * FROM TaiKhoan WHERE username=?";
        List<TaiKhoan> list=select(sql,id);
        return list.size()>0?list.get(0):null;
    }    
        public List<TaiKhoan> selectNotInCourse(String username, String keyword) {
        String sql="SELECT * FROM TaiKhoan "
                + " WHERE username LIKE ? AND "
                + " username NOT IN (SELECT username FROM TaiKhoan WHERE username =?)";
        return this.select(sql, "%"+keyword+"%", username);
    }
            public void delete(TaiKhoan tk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
