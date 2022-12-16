package forms;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.MataPelajaran;
import services.MataPelajaranService;
import utils.AuthHelper;

public class FormMataPelajaran extends javax.swing.JFrame {

    private MataPelajaranService mps = new MataPelajaranService();

    public FormMataPelajaran() {
        initComponents();
        setLocationRelativeTo(this);
        tampilkanData();
        kosongkanForm();
    }

    public void kosongkanForm() {
        txtKodeMataPelajaran.setText("");
        txtNamaMataPelajaran.setText("");
    }

    public void tampilkanData() {
        String[] kolom = {"Kode Mata Pelajaran", "Mata Pelajaran"};
        List<MataPelajaran> list = mps.getAll();
        Object rowData[] = new Object[2];
        tblMataPelajaran.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getKodeMataPelajaran();
            rowData[1] = list.get(i).getNama();
            ((DefaultTableModel) tblMataPelajaran.getModel()).addRow(rowData);
        }
    }

    public void cari(String keyword) {
        kosongkanForm();
        String[] kolom = {"Kode Mata Pelajaran", "Mata Pelajaran"};
        List<MataPelajaran> list = mps.search(keyword);
        Object rowData[] = new Object[2];
        tblMataPelajaran.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (MataPelajaran mataPelajaran : list) {
            rowData[0] = mataPelajaran.getKodeMataPelajaran();
            rowData[1] = mataPelajaran.getNama();
            ((DefaultTableModel) tblMataPelajaran.getModel()).addRow(rowData);
        }
    }

    public boolean validateForm() {
        if (txtKodeMataPelajaran.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Mata Pelajaran belum diisi !");
            txtKodeMataPelajaran.requestFocus();
            return false;
        } else if (txtNamaMataPelajaran.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Mata Pelajaran belum diisi !");
            txtNamaMataPelajaran.requestFocus();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMataPelajaran = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKodeMataPelajaran = new javax.swing.JTextField();
        btnTambahBaru = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNamaMataPelajaran = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        btnSiswa1 = new javax.swing.JButton();
        btnMataPelajaran1 = new javax.swing.JButton();
        btnGuru1 = new javax.swing.JButton();
        btnJadwalPelajaran1 = new javax.swing.JButton();
        btnLogOut1 = new javax.swing.JButton();
        btnKelas1 = new javax.swing.JButton();
        btnAdmin1 = new javax.swing.JButton();
        btnProfil1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        tblMataPelajaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMataPelajaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMataPelajaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMataPelajaran);

        btnCari.setText("Cari Mata Pelajaran");
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariMouseClicked(evt);
            }
        });
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel5.setText("Kode Mata Pelajaran");

        jLabel6.setText("Nama Mata Pelajaran");

        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("FORM MATA PELAJARAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKodeMataPelajaran)
                            .addComponent(txtNamaMataPelajaran, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTambahBaru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeMataPelajaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnTambahBaru))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnSimpan)
                    .addComponent(txtNamaMataPelajaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnHapus)
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel10)
                    .addContainerGap(484, Short.MAX_VALUE)))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SMK NEGERI 1");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
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

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 102)));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("MAIN MENU");

        btnSiswa1.setText("SISWA");
        btnSiswa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiswa1ActionPerformed(evt);
            }
        });

        btnMataPelajaran1.setText("MATA PELAJARAN");
        btnMataPelajaran1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMataPelajaran1ActionPerformed(evt);
            }
        });

        btnGuru1.setText("GURU");
        btnGuru1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuru1ActionPerformed(evt);
            }
        });

        btnJadwalPelajaran1.setText("JADWAL PELAJARAN");
        btnJadwalPelajaran1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalPelajaran1ActionPerformed(evt);
            }
        });

        btnLogOut1.setText("LOG OUT");
        btnLogOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOut1ActionPerformed(evt);
            }
        });

        btnKelas1.setText("KELAS");
        btnKelas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKelas1ActionPerformed(evt);
            }
        });

        btnAdmin1.setText("ADMIN");
        btnAdmin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmin1ActionPerformed(evt);
            }
        });

        btnProfil1.setBackground(new java.awt.Color(250, 70, 70));
        btnProfil1.setText("PROFIL");
        btnProfil1.setBorderPainted(false);
        btnProfil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfil1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSiswa1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdmin1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnMataPelajaran1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnJadwalPelajaran1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuru1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKelas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel32)
                .addGap(32, 32, 32)
                .addComponent(btnProfil1)
                .addGap(24, 24, 24)
                .addComponent(btnAdmin1)
                .addGap(24, 24, 24)
                .addComponent(btnSiswa1)
                .addGap(24, 24, 24)
                .addComponent(btnGuru1)
                .addGap(24, 24, 24)
                .addComponent(btnKelas1)
                .addGap(24, 24, 24)
                .addComponent(btnJadwalPelajaran1)
                .addGap(32, 32, 32)
                .addComponent(btnMataPelajaran1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogOut1)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMataPelajaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMataPelajaranMouseClicked
        kosongkanForm();
        DefaultTableModel model = (DefaultTableModel) tblMataPelajaran.getModel();
        int row = tblMataPelajaran.getSelectedRow();

        txtKodeMataPelajaran.setText(model.getValueAt(row, 0).toString());
        txtNamaMataPelajaran.setText(model.getValueAt(row, 1).toString());

    }//GEN-LAST:event_tblMataPelajaranMouseClicked

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        kosongkanForm();
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (!validateForm()) {
            return;
        }

        MataPelajaran mataPelajaran = new MataPelajaran();
        mataPelajaran.setKodeMataPelajaran(txtKodeMataPelajaran.getText());
        mataPelajaran.setNama(txtNamaMataPelajaran.getText());

        if (mps.getByKode(txtKodeMataPelajaran.getText()) == null) {
            mps.insert(mataPelajaran);
        } else {
            mps.update(mataPelajaran);
        }
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblMataPelajaran.getModel();
        int row = tblMataPelajaran.getSelectedRow();
        mps.delete(model.getValueAt(row, 0).toString());
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSiswa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiswa1ActionPerformed
        if (!(this.getClass().getSimpleName().equals("FormSiswa"))) {
            FormSiswa nf = new FormSiswa();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnSiswa1ActionPerformed

    private void btnMataPelajaran1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMataPelajaran1ActionPerformed
        if (!(this.getClass().getSimpleName().equals("FormMataPelajaran"))) {
            FormMataPelajaran nf = new FormMataPelajaran();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnMataPelajaran1ActionPerformed

    private void btnGuru1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuru1ActionPerformed
        if (!(this.getClass().getSimpleName().equals("FormGuru"))) {
            FormGuru nf = new FormGuru();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnGuru1ActionPerformed

    private void btnJadwalPelajaran1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJadwalPelajaran1ActionPerformed
        if (!(this.getClass().getSimpleName().equals("FormJadwalPelajaran"))) {
            FormJadwalPelajaran nf = new FormJadwalPelajaran();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnJadwalPelajaran1ActionPerformed

    private void btnLogOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOut1ActionPerformed
        AuthHelper.setCurrentUSer(null);
        FormLogin fl = new FormLogin();
        this.dispose();
        fl.show();
    }//GEN-LAST:event_btnLogOut1ActionPerformed

    private void btnKelas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelas1ActionPerformed
        if (!(this.getClass().getSimpleName().equals("FormKelas"))) {
            FormKelas nf = new FormKelas();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnKelas1ActionPerformed

    private void btnAdmin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmin1ActionPerformed
        if (!(this.getClass().getSimpleName().equals("FormAdmin"))) {
            FormAdmin nf = new FormAdmin();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnAdmin1ActionPerformed

    private void btnProfil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfil1ActionPerformed
        if (!(this.getClass().getSimpleName().equals("ProfilAdmin"))) {
            ProfilAdmin nf = new ProfilAdmin();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnProfil1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMataPelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMataPelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMataPelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMataPelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMataPelajaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin1;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnGuru1;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnJadwalPelajaran1;
    private javax.swing.JButton btnKelas1;
    private javax.swing.JButton btnLogOut1;
    private javax.swing.JButton btnMataPelajaran1;
    private javax.swing.JButton btnProfil1;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSiswa1;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMataPelajaran;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtKodeMataPelajaran;
    private javax.swing.JTextField txtNamaMataPelajaran;
    // End of variables declaration//GEN-END:variables
}
