/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polypro;

import dao.TaiKhoanDAO;
import dao.nhanVienDAO;
import entity.nhanVien;
import helper.dialogHelper;
import helper.shareHelper;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quang
 */
public class TaiKhoan extends javax.swing.JFrame {
    TaiKhoanDAO dao = new TaiKhoanDAO();
    nhanVien nv = new nhanVien();
    public TaiKhoan() {
        initComponents();
    }
    void load(){
                DefaultTableModel model = (DefaultTableModel) tblTaikhoan.getModel();
            model.setRowCount(0);
        
        try {
            List<entity.TaiKhoan> list = dao.select();
            for (entity.TaiKhoan taikhoan : list) {
                Object[] row = {
                    taikhoan.getUsername(),
                    taikhoan.getPassword(),            
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTaikhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDangnhap = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaikhoan = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtMatkhau = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tài khoản:");

        jLabel2.setText("Mật khẩu:");

        btnDangnhap.setText("Đăng nhập");
        btnDangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangnhapActionPerformed(evt);
            }
        });

        tblTaikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tài khoản", "Mật khẩu"
            }
        ));
        tblTaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaikhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaikhoan);

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTaikhoan)
                                    .addComponent(txtMatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btnDangnhap))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnDangnhap)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangnhapActionPerformed
         login();
    }//GEN-LAST:event_btnDangnhapActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insert();
        load();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();  
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed
    int row = -1;
    private void tblTaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaikhoanMouseClicked
          if(evt.getClickCount()==1){   
            row = tblTaikhoan.getSelectedRow();
            edit();
        }     
    }//GEN-LAST:event_tblTaikhoanMouseClicked
     
     void edit(){
     
        String username = (String) tblTaikhoan.getValueAt(row, 0);
        entity.TaiKhoan tk2 = dao.findById(username);
        setForm(tk2);
     
     };
    
    
    
    
    
    nhanVienDAO nvdao = new nhanVienDAO();
    void login() {
        String manv = txtTaikhoan.getText();
        String matKhau = new String(txtMatkhau.getPassword());
        try {
            nhanVien nv = nvdao.findById(manv); 
            /*
            manv là tên đăng nhập
            nhanVien findbyId(String manv)
            */
            if(nv != null){    //nếu manv đúng
                String matKhau2 = nv.getMatKhau();
                if(matKhau.equals(matKhau2)){  //nếu mật khẩu đúng
                    shareHelper.USER = nv;
                    dialogHelper.alert(this, "Đăng nhập thành công!");
                    load();
    
                }
                else{
                    dialogHelper.alert(this, "Sai mật khẩu!");
                }
            }
            else{
                dialogHelper.alert(this, "Sai tên đăng nhập!");
            }
        }
        catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
 }
    void setForm( entity.TaiKhoan taikhoan){
         txtTaikhoan.setText(taikhoan.getUsername());
        txtMatkhau.setText(taikhoan.getPassword());;
    }
    
        entity.TaiKhoan getForm(){
        entity.TaiKhoan taikhoan = new entity.TaiKhoan();
        taikhoan.setUsername(txtTaikhoan.getText());
        taikhoan.setPassword(txtMatkhau.getText());;
        return taikhoan;
        
    }
     void insert(){
         entity.TaiKhoan taikhoan = getForm();
        try {        
        dao.insert(taikhoan);
        load();
        dialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {    
            e.printStackTrace();
        }  
     }
       
    void findbyName(){      
        try {
            DefaultTableModel model = (DefaultTableModel) tblTaikhoan.getModel();
            model.setRowCount(0);
            entity.ChuyenDe2 cd = new entity.ChuyenDe2();
            String keyword = txtTaikhoan.getText();
            List<entity.TaiKhoan> list = dao.selectNotInCourse(cd.getMACD(), keyword);
            for (entity.TaiKhoan taikhoan2 : list) {
                model.addRow(new Object[]{
                taikhoan2.getUsername(),
                    taikhoan2.getPassword(),
                    
                });
                setForm(taikhoan2);
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void delete(){
        String u = txtTaikhoan.getText();
        try {
            dao.delete(u);
            load();
            dialogHelper.alert(this, "Xoá thành công");
            
        } catch (Exception e) {
            dialogHelper.alert(this, "Xoá thất bại");
        }
    }
    
     void update(){
        entity.TaiKhoan model = getmodel();
        try {
            dao.update(model);
            dialogHelper.alert(this, "Cập nhật thành công");
            load();
        } catch (Exception e) {
            dialogHelper.alert(this, "Cập nhật thất bại");
        }
    }
    entity.TaiKhoan getmodel(){
        entity.TaiKhoan model = new entity.TaiKhoan();
        model.setUsername(txtTaikhoan.getText());
        model.setPassword(txtMatkhau.getText());  
        return model;
    }
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangnhap;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTaikhoan;
    private javax.swing.JPasswordField txtMatkhau;
    private javax.swing.JTextField txtTaikhoan;
    // End of variables declaration//GEN-END:variables
}
