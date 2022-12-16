/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Guru;
import services.GuruService;
import utils.AuthHelper;

public class FormGuru extends javax.swing.JFrame {

    GuruService guruService = new GuruService();
    Guru guru = new Guru();

    public FormGuru() {
        initComponents();
        jkGroup.add(radioPria);
        jkGroup.add(radioWanita);

        setLocationRelativeTo(this);
        tampilkanData();
        kosongkanForm();
    }

    public void kosongkanForm() {
        txtNIP.setText("");
        txtNamaPengajar.setText("");
        txtAlamatPengajar.setText("");
        jkGroup.clearSelection();
        txtNomorTelepon.setText("");
        txtPassword.setText("");
    }

    public void tampilkanData() {
        String[] kolom = {"NIP", "Nama", "Jenis Kelamin", "Alamat", "Telepon"};
        ArrayList<Guru> list = (ArrayList<Guru>) guruService.getAll();
        Object rowData[] = new Object[5];
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, kolom);
        tblPengajar.setModel(tableModel);
        for (Guru guru : list) {
            rowData[0] = guru.getNip();
            rowData[1] = guru.getNama();
            rowData[2] = guru.getJenisKelamin();
            rowData[3] = guru.getAlamat();
            rowData[4] = guru.getTelepon();
            ((DefaultTableModel) tblPengajar.getModel()).addRow(rowData);
        }
    }

    public boolean validateForm() {
        if (txtNIP.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "NIP Guru belum diisi !");
            txtNIP.requestFocus();
            return false;
        } else if (txtNamaPengajar.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Guru belum diisi !");
            txtNamaPengajar.requestFocus();
            return false;
        } else if (jkGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Jenis Kelamin Guru belum diisi !");
            return false;
        } else if (txtAlamatPengajar.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Guru belum diisi !");
            txtAlamatPengajar.requestFocus();
            return false;
        } else if (txtNomorTelepon.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Telepon Guru belum diisi !");
            txtNomorTelepon.requestFocus();
            return false;
        }

        return true;
    }

    public void cari(String keyword) {
        String[] kolom = {"NIP", "Nama", "Jenis Kelamin", "Alamat", "Telepon"};
        ArrayList<Guru> list = (ArrayList<Guru>) guruService.search(keyword);
        Object rowData[] = new Object[5];
        tblPengajar.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (Guru guru : list) {
            rowData[0] = guru.getNip();
            rowData[1] = guru.getNama();
            rowData[2] = guru.getJenisKelamin();
            rowData[3] = guru.getAlamat();
            rowData[4] = guru.getTelepon();
            ((DefaultTableModel) tblPengajar.getModel()).addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jkGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPengajar = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNomorTelepon = new javax.swing.JTextField();
        txtAlamatPengajar = new javax.swing.JTextField();
        txtNamaPengajar = new javax.swing.JTextField();
        txtNIP = new javax.swing.JTextField();
        btnTambahBaru = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        radioPria = new javax.swing.JRadioButton();
        radioWanita = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        tblPengajar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPengajar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPengajarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPengajar);

        btnCari.setText("Cari Pengajar");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel13.setText("NIP");

        jLabel14.setText("Nama Pengajar");

        jLabel15.setText("Alamat Pengajar");

        jLabel16.setText("Nomor Telepon");

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

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("FORM DATA DIRI PENGAJAR");

        jLabel26.setText("Jenis Kelamin");

        radioPria.setText("Laki-laki");

        radioWanita.setText("Perempuan");

        jLabel20.setText("Password");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel20))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(radioPria)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioWanita))
                                    .addComponent(txtNIP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaPengajar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlamatPengajar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomorTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnTambahBaru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(34, 34, 34))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel17)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnTambahBaru))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNamaPengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlamatPengajar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(radioPria)
                    .addComponent(radioWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomorTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("SMK NEGERI 1");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("GRYFFINDOR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(12, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPengajarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPengajarMouseClicked
        kosongkanForm();
        DefaultTableModel model = (DefaultTableModel) tblPengajar.getModel();
        int row = tblPengajar.getSelectedRow();
        String nip = model.getValueAt(row, 0).toString();
        guru = guruService.getByNip(nip);
        txtNIP.setText(guru.getNip());
        txtNamaPengajar.setText(guru.getNama());
        String kelamin = guru.getJenisKelamin();

        if (kelamin.equals("laki-laki")) {
            radioPria.setSelected(true);
        } else if (kelamin.equals("perempuan")) {
            radioWanita.setSelected(true);
        }
        txtAlamatPengajar.setText(guru.getAlamat());
        txtNomorTelepon.setText(guru.getTelepon());
    }//GEN-LAST:event_tblPengajarMouseClicked

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

        guru.setNip(txtNIP.getText());
        guru.setNama(txtNamaPengajar.getText());
        String kelamin = "";
        if (radioPria.isSelected()) {
            kelamin = "laki-laki";
        } else if (radioWanita.isSelected()) {
            kelamin = "perempuan";
        }

        guru.setJenisKelamin(kelamin);
        guru.setAlamat(txtAlamatPengajar.getText());
        guru.setTelepon(txtNomorTelepon.getText());
        if (!txtPassword.getText().trim().equals("")) {
            guru.setPassword(AuthHelper.getMd5(txtPassword.getText()));
        } else {
            guru.setPassword(null);
        }

        if (guruService.getByNip(txtNIP.getText()) == null) {
            if (txtPassword.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Password Guru belum diisi !");
                txtPassword.requestFocus();
                return;
            }
            guruService.insert(guru);
        } else {
            if (!txtPassword.getText().isEmpty()) {
                int result = JOptionPane.showConfirmDialog(null, "Yakin ingin mengganti password guru?", "Ganti Password Guru", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    guruService.update(guru);
                } else {
                    return;
                }
            } else {
                guruService.update(guru);

            }

        }
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblPengajar.getModel();
        int row = tblPengajar.getSelectedRow();
        guruService.delete(model.getValueAt(row, 0).toString());

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
            java.util.logging.Logger.getLogger(FormGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGuru().setVisible(true);
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.ButtonGroup jkGroup;
    private javax.swing.JRadioButton radioPria;
    private javax.swing.JRadioButton radioWanita;
    private javax.swing.JTable tblPengajar;
    private javax.swing.JTextField txtAlamatPengajar;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNIP;
    private javax.swing.JTextField txtNamaPengajar;
    private javax.swing.JTextField txtNomorTelepon;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
