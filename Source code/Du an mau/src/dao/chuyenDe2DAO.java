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
import entity.ChuyenDe2;

public class chuyenDe2DAO {
    private ChuyenDe2 readFromResultSet(ResultSet rs) throws SQLException{
	ChuyenDe2 model=new ChuyenDe2();
        model.setMACD(rs.getString("MACD"));
        model.setTENCD(rs.getString("TENCD"));
        model.setHOCPHI(rs.getDouble("HOCPHI"));     
        return model;
    }

    private List<ChuyenDe2> select(String sql, Object...args){
        List<ChuyenDe2> list=new ArrayList<>();
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
    public void insert(ChuyenDe2 entity) {
        String sql="INSERT INTO ChuyenDe2 (MACD,TENCD,HOCPHI) VALUES (?, ?, ?)";
        jdbcHelper.executeUpdate(sql,
                entity.getMACD(),
                entity.getTENCD(),
                entity.getHOCPHI());
    }

    /**
     * Cập nhật thực thể vào CSDL
     * @param entity là thực thể chứa thông tin bản ghi cần cập nhật
     */
    public void update(ChuyenDe2 entity) {
        String sql="UPDATE ChuyenDe2 SET TENCD = ? , HOCPHI = ? WHERE MACD=?";
        jdbcHelper.executeUpdate(sql,
                entity.getTENCD(),
                entity.getHOCPHI(),
                entity.getMACD());
    }

    /**
     * Xóa bản ghi khỏi CSDL
     * @param id là mã của bản ghi cần xóa
     */
    public void delete(String MACD) {
        String sql="DELETE FROM ChuyenDe2 WHERE MACD=?";
        jdbcHelper.executeUpdate(sql, MACD);
    }

    /**
     * Truy vấn tất cả các các thực thể
     * @return list danh sách các thực thể
     */
    public List<ChuyenDe2> select() {
        String sql="SELECT * FROM ChuyenDe2";
        return select(sql);
    }

    /**
     * Truy vấn thực thể theo mã id
     * @param id là mã của bản ghi được truy vấn
     * @return thực thể chứa thông tin của bản ghi
     */
    public ChuyenDe2 findById(String id) {
        String sql="SELECT * FROM ChuyenDe2 WHERE MACD=?";
        List<ChuyenDe2> list=select(sql,id);
        return list.size()>0?list.get(0):null;
    }    
        public List<ChuyenDe2> selectNotInCourse(String MACD, String keyword) {
        String sql="SELECT * FROM ChuyenDe2 "
                + " WHERE MACD LIKE ? AND "
                + " MACD NOT IN (SELECT MACD FROM ChuyenDe2 WHERE MACD =?)";
        return this.select(sql, "%"+keyword+"%", MACD);
    }

    public void delete(ChuyenDe2 cd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
