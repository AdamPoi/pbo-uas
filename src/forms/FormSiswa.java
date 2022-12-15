/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Kelas;
import models.Siswa;
import services.KelasService;
import services.SiswaService;
import utils.AuthHelper;

public class FormSiswa extends javax.swing.JFrame {

    private SiswaService siswaService = new SiswaService();
    private KelasService kelasService = new KelasService();

    public FormSiswa() {
        initComponents();
        jkGroup.add(radioPria);
        jkGroup.add(radioWanita);
        setComboTingkat();
        cmbKelas.removeAllItems();
        cmbKelas.addItem("Pilih Kelas");

        setLocationRelativeTo(this);
        kosongkanForm();
        tampilkanData((ArrayList<Siswa>) siswaService.getAll());
    }

    public void kosongkanForm() {
        txtNIS.setText("");
        txtNamaSiswa.setText("");
        txtAlamatSiswa.setText("");
        txtNomorTelepon.setText("");
        jkGroup.clearSelection();
        cmbTingkat.setSelectedIndex(0);
        cmbKelas.setSelectedIndex(0);

    }

    public void setComboTingkat() {
        String[] tingkat = {"Pilih Tingkat", "7", "8", "9"};
        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(tingkat);
        cmbTingkat.setModel(cmbModel);
    }

    public void setComboKelas(int tingkat) {
        ArrayList<Kelas> results = (ArrayList<Kelas>) kelasService.getByTingkat(tingkat);
        ArrayList<String> listKelas = new ArrayList<>();
        listKelas.add("Pilih Kelas");
        for (Kelas kelas : results) {
            listKelas.add(kelas.getKodeKelas());
        }
        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(listKelas.toArray());
        cmbKelas.setModel(cmbModel);
    }

    public void tampilkanData(ArrayList<Siswa> listSiswa) {
        String[] kolom = {"NIS", "Nama", "Jenis Kelamin", "Alamat", "Telepon"};
        Object rowData[] = new Object[5];
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, kolom);
        tblSiswa.setModel(tableModel);
        for (Siswa siswa : listSiswa) {
            rowData[0] = siswa.getNis();
            rowData[1] = siswa.getNama();
            rowData[2] = siswa.getJenisKelamin();
            rowData[3] = siswa.getAlamat();
            rowData[4] = siswa.getTelepon();
            ((DefaultTableModel) tblSiswa.getModel()).addRow(rowData);
        }

//        tableModel.addTableModelListener(new TableModelListener() {
//            public void tableChanged(TableModelEvent e) {
//                System.out.println("Column: " + e.getColumn() + " Row: " + e.getFirstRow());
//                DefaultTableModel model = (DefaultTableModel) e.getSource();
//                System.out.println(model.getColumnName(e.getColumn()));
//                System.out.println(model.getValueAt(e.getFirstRow(), 0).toString());
//
//                System.out.println(model.getValueAt(e.getFirstRow(), e.getColumn()).toString());
//            }
//        });
    }

    public boolean validateForm() {
        if (txtNIS.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "NIS Siswa belum diisi !");
            txtNIS.requestFocus();
            return false;
        } else if (txtNamaSiswa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Siswa belum diisi !");
            txtNamaSiswa.requestFocus();
            return false;

        } else if (jkGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Jenis Kelamin Siswa belum diisi !");
            return false;

        } else if (txtAlamatSiswa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Siswa belum diisi !");
            txtAlamatSiswa.requestFocus();
            return false;

        } else if (txtNomorTelepon.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Telepon Siswa belum diisi !");
            txtNomorTelepon.requestFocus();
            return false;
        }
        return true;
    }

    public void cari(String keyword) {
        tampilkanData((ArrayList<Siswa>) siswaService.search(keyword));
    }

    public void simpanKelasSiswa() {
        String nis = txtNIS.getText();
        String kodeKelas = String.valueOf(cmbKelas.getSelectedItem());
        if (siswaService.getKelas(nis) == null) {
            kelasService.insertSiswaKelas(nis, kodeKelas);
        } else {
            kelasService.updateSiswaKelas(nis, kodeKelas);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jkGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSiswa = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNomorTelepon = new javax.swing.JTextField();
        txtAlamatSiswa = new javax.swing.JTextField();
        txtNamaSiswa = new javax.swing.JTextField();
        txtNIS = new javax.swing.JTextField();
        btnTambahBaru = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        radioPria = new javax.swing.JRadioButton();
        radioWanita = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbTingkat = new javax.swing.JComboBox<>();
        cmbKelas = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        btnSiswa = new javax.swing.JButton();
        btnMataPelajaran = new javax.swing.JButton();
        btnGuru = new javax.swing.JButton();
        btnJadwalPelajaran = new javax.swing.JButton();
        btnPenilaian = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        tblSiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSiswaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSiswa);

        btnCari.setText("Cari Siswa");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel13.setText("NIS");

        jLabel14.setText("Nama Siswa");

        jLabel15.setText("Alamat Siswa");

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
        jLabel17.setText("FORM DATA DIRI SISWA");

        jLabel26.setText("Jenis Kelamin");

        radioPria.setText("Laki-laki");

        radioWanita.setText("Perempuan");

        jLabel20.setText("Tingkat");

        jLabel21.setText("Kelas");

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel1.setText("Kelas");

        cmbTingkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTingkat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTingkatItemStateChanged(evt);
            }
        });

        cmbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKelasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel26)
                            .addComponent(jLabel16)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(radioPria)
                                .addGap(18, 18, 18)
                                .addComponent(radioWanita))
                            .addComponent(txtNIS, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaSiswa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlamatSiswa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomorTelepon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTingkat, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTambahBaru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(34, 34, 34))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnTambahBaru))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlamatSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cmbTingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel17)
                    .addContainerGap(538, Short.MAX_VALUE)))
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
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 102)));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("MAIN MENU");

        btnSiswa.setText("SISWA");
        btnSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiswaActionPerformed(evt);
            }
        });

        btnMataPelajaran.setText("MATA PELAJARAN");
        btnMataPelajaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMataPelajaranActionPerformed(evt);
            }
        });

        btnGuru.setText("GURU");
        btnGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuruActionPerformed(evt);
            }
        });

        btnJadwalPelajaran.setText("JADWAL PELAJARAN");
        btnJadwalPelajaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalPelajaranActionPerformed(evt);
            }
        });

        btnPenilaian.setText("PENILAIAN");
        btnPenilaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenilaianActionPerformed(evt);
            }
        });

        btnLogOut.setText("LOG OUT");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnMataPelajaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnJadwalPelajaran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPenilaian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnGuru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel25)
                .addGap(44, 44, 44)
                .addComponent(btnSiswa)
                .addGap(83, 83, 83)
                .addComponent(btnJadwalPelajaran)
                .addGap(30, 30, 30)
                .addComponent(btnMataPelajaran)
                .addGap(32, 32, 32)
                .addComponent(btnPenilaian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(32, 32, 32))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addComponent(btnGuru)
                    .addContainerGap(424, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSiswaMouseClicked

        kosongkanForm();
        DefaultTableModel model = (DefaultTableModel) tblSiswa.getModel();
        int row = tblSiswa.getSelectedRow();

        txtNIS.setText(model.getValueAt(row, 0).toString());
        txtNamaSiswa.setText(model.getValueAt(row, 1).toString());
        String kelamin = model.getValueAt(row, 2).toString();

        if (kelamin.equals("laki-laki")) {
            radioPria.setSelected(true);
        } else if (kelamin.equals("perempuan")) {
            radioWanita.setSelected(true);
        }

        txtAlamatSiswa.setText(model.getValueAt(row, 3).toString());
        txtNomorTelepon.setText(model.getValueAt(row, 4).toString());

        Kelas kelas = siswaService.getKelas(model.getValueAt(row, 0).toString());
        cmbTingkat.setSelectedItem(String.valueOf(kelas.getTingkat()));

        cmbKelas.setSelectedItem(kelas.getKodeKelas());
    }//GEN-LAST:event_tblSiswaMouseClicked

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

        Siswa siswa = new Siswa();
        siswa.setNis(txtNIS.getText());
        siswa.setNama(txtNamaSiswa.getText());
        String kelamin = "";
        if (radioPria.isSelected()) {
            kelamin = "laki-laki";
        } else if (radioWanita.isSelected()) {
            kelamin = "perempuan";
        }

        siswa.setJenisKelamin(kelamin);
        siswa.setAlamat(txtAlamatSiswa.getText());
        siswa.setTelepon(txtNomorTelepon.getText());

        if (siswaService.getByNis(txtNIS.getText()) == null) {
            siswaService.insert(siswa);
        } else {
            siswaService.update(siswa);
        }
        if (cmbKelas.getSelectedIndex() != 0) {
            simpanKelasSiswa();
        }
        kosongkanForm();
        tampilkanData((ArrayList<Siswa>) siswaService.getAll());
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblSiswa.getModel();
        int row = tblSiswa.getSelectedRow();
        siswaService.delete(model.getValueAt(row, 0).toString());
        kosongkanForm();
        tampilkanData((ArrayList<Siswa>) siswaService.getAll());
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiswaActionPerformed

    private void btnMataPelajaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMataPelajaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMataPelajaranActionPerformed

    private void btnGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuruActionPerformed

    private void btnJadwalPelajaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJadwalPelajaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnJadwalPelajaranActionPerformed

    private void btnPenilaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenilaianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPenilaianActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        AuthHelper.setCurrentUSer(null);
        FormLogin fl = new FormLogin();
        this.dispose();
        fl.show();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void cmbKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKelasActionPerformed

    private void cmbTingkatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTingkatItemStateChanged
        if (cmbTingkat.getSelectedIndex() != 0) {
            int tingkat = Integer.parseInt(cmbTingkat.getSelectedItem().toString());
            setComboKelas(tingkat);
        }
    }//GEN-LAST:event_cmbTingkatItemStateChanged

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
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FormSiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnGuru;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnJadwalPelajaran;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMataPelajaran;
    private javax.swing.JButton btnPenilaian;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSiswa;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JComboBox<String> cmbKelas;
    private javax.swing.JComboBox<String> cmbTingkat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.ButtonGroup jkGroup;
    private javax.swing.JRadioButton radioPria;
    private javax.swing.JRadioButton radioWanita;
    private javax.swing.JTable tblSiswa;
    private javax.swing.JTextField txtAlamatSiswa;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNIS;
    private javax.swing.JTextField txtNamaSiswa;
    private javax.swing.JTextField txtNomorTelepon;
    // End of variables declaration//GEN-END:variables
}
