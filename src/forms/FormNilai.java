/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.InternationalFormatter;
import models.MataPelajaran;
import models.Nilai;
import models.Siswa;
import services.MataPelajaranService;
import services.NilaiService;
import services.SiswaService;
import utils.AuthHelper;

/**
 *
 * @author User
 */
public class FormNilai extends javax.swing.JFrame {

    /**
     * Creates new form Nilai
     */
    private NilaiService ns = new NilaiService();
    private MataPelajaranService mps = new MataPelajaranService();
    private SiswaService ss = new SiswaService();

    private Siswa siswa;

    public FormNilai() {
        initComponents();
        setLocationRelativeTo(this);
        txtIdNilai.setVisible(false);
        setComboMapel();
        tampilkanData();
        kosongkanForm();
        setVerifier();
    }

    public void setComboMapel() {
        ArrayList<MataPelajaran> results = (ArrayList<MataPelajaran>) mps.getAll();
        ArrayList<String> listMapel = new ArrayList<>();
        listMapel.add("Pilih Mata Pelajaran");
        for (MataPelajaran mapel : results) {
            listMapel.add(mapel.getKodeMataPelajaran());
        }
        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(listMapel.toArray());
        cmbMapel.setModel(cmbModel);
    }

    public void kosongkanForm() {
        txtNis.setText("");
        kosongkanNilai();
        tampilkanData();
        siswa = null;
        cmbMapel.setSelectedIndex(0);

    }

    public void kosongkanNilai() {
        txtIdNilai.setText("");

        txtNilaiTugas.setText("");
        txtNilaiKuis.setText("");
        txtNilaiUTS.setText("");
        txtNilaiUAS.setText("");
        lblMapel.setText("Mata Pelajaran");
    }

    public void tampilkanData() {
        List<Nilai> list = new ArrayList<>();
        tampilkanData(list);
    }

    public void tampilkanData(List<Nilai> list) {
        String[] kolom = {"ID", "NIS", "Nama", "Mata Pelajaran", "Tugas", "Kuis", "UTS", "UAS"};
        Object rowData[] = new Object[8];
        tblNilai.setModel(new DefaultTableModel(new Object[][]{}, kolom));
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getIdNilai();
            rowData[1] = list.get(i).getSiswa().getNis();
            rowData[2] = list.get(i).getSiswa().getNama();
            rowData[3] = list.get(i).getMataPelajaran().getKodeMataPelajaran();
            rowData[4] = list.get(i).getNilaiTugas();
            rowData[5] = list.get(i).getNilaiKuis();
            rowData[6] = list.get(i).getNilaiUTS();
            rowData[7] = list.get(i).getNilaiUAS();

            ((DefaultTableModel) tblNilai.getModel()).addRow(rowData);
        }
        tblNilai.removeColumn(tblNilai.getColumnModel().getColumn(0));
    }

    public boolean validateForm() {
        if (txtNis.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nis Siswa belum diisi !");
            txtNis.requestFocus();
            return false;
        } else if (cmbMapel.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Mata Pelajaran belum diisi !");
            cmbMapel.requestFocus();
            return false;
        }
//        else if (txtIdNilai.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Data Nilai Masih Kosong!");
//            return false;
//        }
//        else if (txtNilaiTugas.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Nilai Tugas belum diisi !");
//            txtNilaiTugas.requestFocus();
//            return false;
//        } else if (txtNilaiKuis.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Nilai Kuis belum diisi !");
//            txtNilaiKuis.requestFocus();
//            return false;
//        } else if (txtNilaiUTS.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Nilai UTS belum diisi !");
//            txtNilaiUTS.requestFocus();
//            return false;
//        } else if (txtNilaiUAS.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(null, "Nilai UAS belum diisi !");
//            txtNilaiUAS.requestFocus();
//            return false;
//        }
        return true;
    }

    public void setVerifier() {
        txtNilaiTugas.setFormatterFactory(new AbstractFormatterFactory() {
            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat format = DecimalFormat.getInstance();
                format.setMinimumFractionDigits(1);
                format.setMaximumFractionDigits(1);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0.0);
                formatter.setMaximum(100.0);
                return formatter;
            }
        });
        txtNilaiKuis.setFormatterFactory(new AbstractFormatterFactory() {
            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat format = DecimalFormat.getInstance();
                format.setMinimumFractionDigits(1);
                format.setMaximumFractionDigits(1);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0.0);
                formatter.setMaximum(100.0);
                return formatter;
            }
        });
        txtNilaiUTS.setFormatterFactory(new AbstractFormatterFactory() {
            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat format = DecimalFormat.getInstance();
                format.setMinimumFractionDigits(1);
                format.setMaximumFractionDigits(1);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0.0);
                formatter.setMaximum(100.0);
                return formatter;
            }
        });

        txtNilaiUAS.setFormatterFactory(new AbstractFormatterFactory() {
            @Override
            public AbstractFormatter getFormatter(JFormattedTextField tf) {
                NumberFormat format = DecimalFormat.getInstance();
                format.setMinimumFractionDigits(1);
                format.setMaximumFractionDigits(1);
                format.setRoundingMode(RoundingMode.HALF_UP);
                InternationalFormatter formatter = new InternationalFormatter(format);
                formatter.setAllowsInvalid(false);
                formatter.setMinimum(0.0);
                formatter.setMaximum(100.0);
                return formatter;
            }
        });
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNilai = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnTambahBaru = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNis = new javax.swing.JTextField();
        btnCariSiswa = new javax.swing.JButton();
        lblNamaSiswa = new javax.swing.JLabel();
        txtIdNilai = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNilaiTugas = new javax.swing.JFormattedTextField();
        txtNilaiKuis = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNilaiUTS = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNilaiUAS = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbMapel = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();
        lblMapel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnProfil = new javax.swing.JButton();
        btnLihatJadwalPelajaran = new javax.swing.JButton();
        btnPenilaian = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        tblNilai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNilaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNilai);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NIS Siswa");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mata Pelajaran");

        btnTambahBaru.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });

        btnSimpan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("FORM PENILAIAN SISWA");

        txtNis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNisActionPerformed(evt);
            }
        });

        btnCariSiswa.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCariSiswa.setText("CARI Siswa");
        btnCariSiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariSiswaActionPerformed(evt);
            }
        });

        lblNamaSiswa.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaSiswa.setText("Nama Siswa");

        txtIdNilai.setEnabled(false);
        txtIdNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdNilaiMouseClicked(evt);
            }
        });
        txtIdNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdNilaiActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nilai Tugas");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nilai Kuis");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nilai UTS");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nilai UAS");

        cmbMapel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMapel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMapelItemStateChanged(evt);
            }
        });

        jLabel5.setText("Nilai Siswa");

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        lblMapel.setText("Mata Pelajaran");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(txtNilaiTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(txtNilaiKuis, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNilaiUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtNilaiUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnCetak))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(lblNamaSiswa)
                                                    .addGap(158, 158, 158))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtNis)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(btnCariSiswa))
                                                .addComponent(txtIdNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cmbMapel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblMapel)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnTambahBaru, javax.swing.GroupLayout.Alignment.TRAILING))))))
                        .addGap(31, 31, 31))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(txtIdNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCariSiswa))
                        .addGap(16, 16, 16)
                        .addComponent(lblNamaSiswa)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMapel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNilaiTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNilaiUTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNilaiKuis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNilaiUAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCetak)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambahBaru)
                        .addGap(21, 21, 21)
                        .addComponent(btnSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus)))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jLabel10)
                    .addContainerGap(458, Short.MAX_VALUE)))
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
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(61, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addGap(3, 3, 3)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 102)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("MAIN MENU");

        btnProfil.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnProfil.setText("PROFIL");
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });

        btnLihatJadwalPelajaran.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLihatJadwalPelajaran.setText("LIHAT JADWAL PELAJARAN");
        btnLihatJadwalPelajaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatJadwalPelajaranActionPerformed(evt);
            }
        });

        btnPenilaian.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnPenilaian.setText("PENILAIAN");
        btnPenilaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenilaianActionPerformed(evt);
            }
        });

        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLogOut.setText("LOG OUT");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLihatJadwalPelajaran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPenilaian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addGap(32, 32, 32)
                .addComponent(btnProfil)
                .addGap(18, 18, 18)
                .addComponent(btnLihatJadwalPelajaran)
                .addGap(18, 18, 18)
                .addComponent(btnPenilaian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNilaiMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblNilai.getModel();
        int row = tblNilai.getSelectedRow();
        txtIdNilai.setText(model.getValueAt(row, 0).toString());
        txtNis.setText(model.getValueAt(row, 1).toString());
        cmbMapel.setSelectedItem((model.getValueAt(row, 3).toString()));
        txtNilaiTugas.setText(model.getValueAt(row, 4).toString());
        txtNilaiKuis.setText(model.getValueAt(row, 5).toString());
        txtNilaiUTS.setText(model.getValueAt(row, 6).toString());
        txtNilaiUAS.setText(model.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tblNilaiMouseClicked

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        kosongkanForm();
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (!validateForm()) {
            return;
        }
        Nilai nilai = new Nilai();

        nilai.setSiswa(ss.getByNis(txtNis.getText()));
        nilai.setMataPelajaran(mps.getByKode(cmbMapel.getSelectedItem().toString()));
        if (!txtNilaiTugas.getText().isEmpty()) {
            nilai.setNilaiTugas(Double.parseDouble(txtNilaiTugas.getText()));
        }
        if (!txtNilaiKuis.getText().isEmpty()) {
            nilai.setNilaiKuis(Double.parseDouble(txtNilaiKuis.getText()));
        }
        if (!txtNilaiUTS.getText().isEmpty()) {
            nilai.setNilaiUTS(Double.parseDouble(txtNilaiUTS.getText()));
        }
        if (!txtNilaiUAS.getText().isEmpty()) {
            nilai.setNilaiUAS(Double.parseDouble(txtNilaiUAS.getText()));
        }

        if (txtIdNilai.getText().isEmpty()) {
            ns.insert(nilai);
        } else {
            nilai.setIdNilai(Integer.parseInt(txtIdNilai.getText()));
            ns.update(nilai);
        }
        cmbMapel.setSelectedIndex(0);

        kosongkanNilai();
        tampilkanData(ns.getBySiswa(siswa.getNis()));
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        ns.delete(Integer.parseInt(txtIdNilai.getText()));
        kosongkanNilai();
        cmbMapel.setSelectedIndex(0);
        tampilkanData(ns.getBySiswa(siswa.getNis()));
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtNisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNisActionPerformed

    private void btnCariSiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariSiswaActionPerformed
        if (!txtNis.getText().isEmpty()) {
            siswa = ss.getByNis(txtNis.getText());
            if (siswa == null) {
                kosongkanForm();
                kosongkanNilai();

                lblNamaSiswa.setText("Siswa tidak ditemukan!");
                return;
            }
            lblNamaSiswa.setText(siswa.getNama());
            cmbMapel.setSelectedIndex(0);
            kosongkanNilai();
            tampilkanData(ns.getBySiswa(siswa.getNis()));
        }
    }//GEN-LAST:event_btnCariSiswaActionPerformed

    private void txtIdNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdNilaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNilaiActionPerformed

    private void txtIdNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdNilaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdNilaiMouseClicked

    private void cmbMapelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMapelItemStateChanged

        if (cmbMapel.getSelectedIndex() == 0) {
            kosongkanNilai();
        }
        MataPelajaran mapel = mps.getByKode(cmbMapel.getSelectedItem().toString());
        if (mapel != null) {
            lblMapel.setText(mapel.getNama());
        }
        Nilai nilai = ns.getBySiswaMataPelajaran(txtNis.getText(), cmbMapel.getSelectedItem().toString());
        if (nilai == null) {
            kosongkanNilai();
            return;
        }
        txtIdNilai.setText(String.valueOf(nilai.getIdNilai()));
        txtNilaiTugas.setText(String.valueOf(nilai.getNilaiTugas()));
        txtNilaiKuis.setText(String.valueOf(nilai.getNilaiKuis()));
        txtNilaiUTS.setText(String.valueOf(nilai.getNilaiUTS()));
        txtNilaiUAS.setText(String.valueOf(nilai.getNilaiUAS()));

    }//GEN-LAST:event_cmbMapelItemStateChanged

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        if (txtIdNilai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nilai Belum Dipilih!", "Pilih Nilai", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PrintRaport form = new PrintRaport(ns.getById(Integer.parseInt(txtIdNilai.getText())));
        form.show();
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
        if (!(this.getClass().getSimpleName().equals("ProfilGuru"))) {
            ProfilGuru nf = new ProfilGuru();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnProfilActionPerformed

    private void btnLihatJadwalPelajaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatJadwalPelajaranActionPerformed
        if (!(this.getClass().getSimpleName().equals("LihatJadwalPelajaran"))) {
            FormNilai nf = new FormNilai();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnLihatJadwalPelajaranActionPerformed

    private void btnPenilaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenilaianActionPerformed
        if (!(this.getClass().getSimpleName().equals("FormNilai"))) {
            FormNilai nf = new FormNilai();
            this.dispose();
            nf.show();
        }
    }//GEN-LAST:event_btnPenilaianActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        AuthHelper.setCurrentUSer(null);
        FormLogin fl = new FormLogin();
        this.dispose();
        fl.show();
    }//GEN-LAST:event_btnLogOutActionPerformed

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
            java.util.logging.Logger.getLogger(FormNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariSiswa;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLihatJadwalPelajaran;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPenilaian;
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JComboBox<String> cmbMapel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMapel;
    private javax.swing.JLabel lblNamaSiswa;
    private javax.swing.JTable tblNilai;
    private javax.swing.JTextField txtIdNilai;
    private javax.swing.JFormattedTextField txtNilaiKuis;
    private javax.swing.JFormattedTextField txtNilaiTugas;
    private javax.swing.JFormattedTextField txtNilaiUAS;
    private javax.swing.JFormattedTextField txtNilaiUTS;
    private javax.swing.JTextField txtNis;
    // End of variables declaration//GEN-END:variables
}
