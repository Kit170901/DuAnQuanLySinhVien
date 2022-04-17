/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Polypro;

import dao.chuyenDe2DAO;
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
public class ChuyenDe2 extends javax.swing.JFrame {

    /**
     * Creates new form ChuyenDe2
     */
    public ChuyenDe2() {
        initComponents();
       
    }
    chuyenDe2DAO dao = new chuyenDe2DAO();
    nhanVien nv = new nhanVien();
    
void load(){
                DefaultTableModel model = (DefaultTableModel) tblChuyenDe.getModel();
            model.setRowCount(0);
        
        try {
            List<entity.ChuyenDe2> list = dao.select();
            for (entity.ChuyenDe2 cd : list) {
                Object[] row = {
                    cd.getMACD(),
                    cd.getTENCD(),
                    cd.getHOCPHI(),
                    
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            dialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
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


    



@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTaikhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDangnhap = new javax.swing.JButton();
        btnDangxuat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMachuyende = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenchuyende = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHocphi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChuyenDe = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtMatkhau = new javax.swing.JPasswordField();

        jButton1.setText("jButton1");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tài khoản:");

        jLabel2.setText("Mật khẩu");

        btnDangnhap.setText("Đăng nhập");
        btnDangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangnhapActionPerformed(evt);
            }
        });

        btnDangxuat.setText("Đăng xuất");

        jLabel3.setText("Mã chuyên đề:");

        txtMachuyende.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMachuyendeActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên chuyên đề:");

        jLabel5.setText("Học phí:");

        tblChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã chuyên đề", "Tên chuyên đề", "Học phí"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChuyenDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChuyenDeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChuyenDe);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMachuyende)
                    .addComponent(txtTenchuyende)
                    .addComponent(txtHocphi, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTaikhoan)
                            .addComponent(txtMatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnDangnhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(btnDangxuat)))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMachuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtTenchuyende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHocphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDangnhap)
                            .addComponent(btnDangxuat))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangnhapActionPerformed
        login();
    }//GEN-LAST:event_btnDangnhapActionPerformed
    int row = -1;
    private void tblChuyenDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMouseClicked
        if(evt.getClickCount()==1){   
            row = tblChuyenDe.getSelectedRow();
            edit();
        }
     
        
    
    }//GEN-LAST:event_tblChuyenDeMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        findbyName();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtMachuyendeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMachuyendeActionPerformed
        findbyName();   
     // TODO add your handling code here:
    }//GEN-LAST:event_txtMachuyendeActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed
    void edit(){
        String MACD = (String) tblChuyenDe.getValueAt(row, 0);
        entity.ChuyenDe2 cd2 = dao.findById(MACD);
        setForm(cd2);
    }
    void setForm( entity.ChuyenDe2 cd){
         txtMachuyende.setText(cd.getMACD());
        txtTenchuyende.setText(cd.getTENCD());
        txtHocphi.setText(String.valueOf(cd.getHOCPHI()));
    }
    entity.ChuyenDe2 getForm(){
        entity.ChuyenDe2 cd = new entity.ChuyenDe2();
        cd.setMACD(txtMachuyende.getText());
        cd.setTENCD(txtTenchuyende.getText());
        cd.setHOCPHI(Double.parseDouble((txtHocphi.getText())));
        return cd;
        
    }
    void insert(){
          entity.ChuyenDe2 cd = getForm();
        try {        
        dao.insert(cd);
        load();
        dialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {    
            e.printStackTrace();
        }  
    }
    void delete(){
        String macd = txtMachuyende.getText();
        try {
            dao.delete(macd);
            load();
            dialogHelper.alert(this, "Xoá thành công");
            
        } catch (Exception e) {
            dialogHelper.alert(this, "Xoá thất bại");
        }
    }
    void update(){
        entity.ChuyenDe2 model = getmodel();
        try {
            dao.update(model);
            dialogHelper.alert(this, "Cập nhật thành công");
            load();
        } catch (Exception e) {
            dialogHelper.alert(this, "Cập nhật thất bại");
        }
    }
    entity.ChuyenDe2 getmodel(){
        entity.ChuyenDe2 model = new entity.ChuyenDe2();
        model.setMACD(txtMachuyende.getText());
        model.setTENCD(txtTenchuyende.getText());
        model.setHOCPHI(Double.parseDouble(txtHocphi.getText()));
        return model;
    }
    void findbyName(){
    
        try {
            DefaultTableModel model = (DefaultTableModel)tblChuyenDe.getModel();
            model.setRowCount(0);
            entity.ChuyenDe2 cd = new entity.ChuyenDe2();
            String kewword = txtMachuyende.getText();
            List<entity.ChuyenDe2> list = dao.selectNotInCourse(cd.getMACD(), kewword);
            for (entity.ChuyenDe2 cd2 : list) {
                model.addRow(new Object[]{
                cd2.getMACD(),
                    cd2.getTENCD(),
                    cd2.getHOCPHI()
                });
                setForm(cd2);
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ChuyenDe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChuyenDe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChuyenDe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChuyenDe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChuyenDe2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangnhap;
    private javax.swing.JButton btnDangxuat;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblChuyenDe;
    private javax.swing.JTextField txtHocphi;
    private javax.swing.JTextField txtMachuyende;
    private javax.swing.JPasswordField txtMatkhau;
    private javax.swing.JTextField txtTaikhoan;
    private javax.swing.JTextField txtTenchuyende;
    // End of variables declaration//GEN-END:variables
}
