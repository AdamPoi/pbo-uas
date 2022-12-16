/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import models.Admin;
import utils.AuthHelper;

/**
 *
 * @author User
 */
public class ProfilAdmin extends javax.swing.JFrame {

    /**
     * Creates new form ProfilAdmin
     */
    public ProfilAdmin() {
        initComponents();
        setLocationRelativeTo(this);
        setData();
    }

    private void setData() {
        Admin admin = (Admin) AuthHelper.getCurrentUser();
        lblTitle.setText(String.format("Selamat Datang Admin %s Tersayang", admin.getNama()));
        lblIdAdmin.setText("ID Admin : " + String.valueOf(admin.getIdAdmin()));
        lblNama.setText("Nama : " + admin.getNama());
        lblUsername.setText("Username : " + admin.getUsername());
        lblKelamin.setText("Jenis Kelamin : " + admin.getJenisKelamin());
        lblAlamat.setText("Alamat : " + admin.getAlamat());
        lblNomorTelepon.setText("No. Telepon : " + admin.getAlamat());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        lblIdAdmin = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblAlamat = new javax.swing.JLabel();
        lblNomorTelepon = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblKelamin = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        btnSiswa3 = new javax.swing.JButton();
        btnMataPelajaran3 = new javax.swing.JButton();
        btnGuru3 = new javax.swing.JButton();
        btnJadwalPelajaran3 = new javax.swing.JButton();
        btnLogOut3 = new javax.swing.JButton();
        btnKelas8 = new javax.swing.JButton();
        btnAdmin8 = new javax.swing.JButton();
        btnProfil8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        lblNama.setBackground(new java.awt.Color(255, 255, 255));
        lblNama.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("DIGANTI NAMA");

        lblIdAdmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIdAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblIdAdmin.setText("DIGANTI ID ADMIN");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Selamat Datang Admin Tersayang");

        lblAlamat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAlamat.setForeground(new java.awt.Color(255, 255, 255));
        lblAlamat.setText("DIGANTI ALAMAT");

        lblNomorTelepon.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNomorTelepon.setForeground(new java.awt.Color(255, 255, 255));
        lblNomorTelepon.setText("DIGANTI NOMOR TELEPON");

        lblUsername.setBackground(new java.awt.Color(255, 255, 255));
        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setText("DIGANTI Username");

        lblKelamin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblKelamin.setForeground(new java.awt.Color(255, 255, 255));
        lblKelamin.setText("DIGANTI Kelamin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomorTelepon)
                    .addComponent(lblIdAdmin)
                    .addComponent(lblNama)
                    .addComponent(lblAlamat)
                    .addComponent(lblUsername)
                    .addComponent(lblKelamin))
                .addGap(0, 303, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(lblNama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername)
                .addGap(16, 16, 16)
                .addComponent(lblIdAdmin)
                .addGap(16, 16, 16)
                .addComponent(lblKelamin)
                .addGap(16, 16, 16)
                .addComponent(lblAlamat)
                .addGap(16, 16, 16)
                .addComponent(lblNomorTelepon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(lblTitle)
                    .addContainerGap(459, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SMK NEGERI 1");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("GRYFFINDOR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 102, 102));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 102)));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("MAIN MENU");

        btnSiswa3.setText("SISWA");
        btnSiswa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiswa3ActionPerformed(evt);
            }
        });

        btnMataPelajaran3.setText("MATA PELAJARAN");
        btnMataPelajaran3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMataPelajaran3ActionPerformed(evt);
            }
        });

        btnGuru3.setText("GURU");
        btnGuru3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuru3ActionPerformed(evt);
            }
        });

        btnJadwalPelajaran3.setText("JADWAL PELAJARAN");
        btnJadwalPelajaran3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalPelajaran3ActionPerformed(evt);
            }
        });

        btnLogOut3.setText("LOG OUT");
        btnLogOut3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOut3ActionPerformed(evt);
            }
        });

        btnKelas8.setText("KELAS");
        btnKelas8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKelas8ActionPerformed(evt);
            }
        });

        btnAdmin8.setText("ADMIN");
        btnAdmin8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmin8ActionPerformed(evt);
            }
        });

        btnProfil8.setBackground(new java.awt.Color(250, 70, 70));
        btnProfil8.setText("PROFIL");
        btnProfil8.setBorderPainted(false);
        btnProfil8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfil8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSiswa3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdmin8, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfil8, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnMataPelajaran3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnJadwalPelajaran3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuru3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKelas8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel33)
                .addGap(32, 32, 32)
                .addComponent(btnProfil8)
                .addGap(24, 24, 24)
                .addComponent(btnAdmin8)
                .addGap(24, 24, 24)
                .addComponent(btnSiswa3)
                .addGap(24, 24, 24)
                .addComponent(btnGuru3)
                .addGap(24, 24, 24)
                .addComponent(btnKelas8)
                .addGap(24, 24, 24)
                .addComponent(btnJadwalPelajaran3)
                .addGap(24, 24, 24)
                .addComponent(btnMataPelajaran3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnLogOut3)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiswa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiswa3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiswa3ActionPerformed

    private void btnMataPelajaran3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMataPelajaran3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMataPelajaran3ActionPerformed

    private void btnGuru3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuru3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuru3ActionPerformed

    private void btnJadwalPelajaran3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJadwalPelajaran3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnJadwalPelajaran3ActionPerformed

    private void btnLogOut3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOut3ActionPerformed
        AuthHelper.setCurrentUSer(null);
        FormLogin fl = new FormLogin();
        this.dispose();
        fl.show();
    }//GEN-LAST:event_btnLogOut3ActionPerformed

    private void btnKelas8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelas8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKelas8ActionPerformed

    private void btnAdmin8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmin8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdmin8ActionPerformed

    private void btnProfil8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfil8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProfil8ActionPerformed

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
            java.util.logging.Logger.getLogger(ProfilAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin8;
    private javax.swing.JButton btnGuru3;
    private javax.swing.JButton btnJadwalPelajaran3;
    private javax.swing.JButton btnKelas8;
    private javax.swing.JButton btnLogOut3;
    private javax.swing.JButton btnMataPelajaran3;
    private javax.swing.JButton btnProfil8;
    private javax.swing.JButton btnSiswa3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblIdAdmin;
    private javax.swing.JLabel lblKelamin;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNomorTelepon;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
