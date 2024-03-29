/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Guru;
import models.JadwalPelajaran;
import models.Kelas;
import models.MataPelajaran;
import services.GuruService;
import services.JadwalPelajaranService;
import services.KelasService;
import services.MataPelajaranService;
import utils.AuthHelper;

/**
 *
 * @author User
 */
public class FormJadwalPelajaran extends javax.swing.JFrame {

    /**
     * Creates new form JadwalPelajaran
     */
    private GuruService gs = new GuruService();
    private KelasService ks = new KelasService();
    private JadwalPelajaranService jps = new JadwalPelajaranService();
    private MataPelajaranService mps = new MataPelajaranService();

    public FormJadwalPelajaran() {
        initComponents();
        setComboMapel();
        setComboTingkat();
        setComboHari();
        setComboJam();
        setLocationRelativeTo(this);
        kosongkanForm();
        tampilkanData(jps.getAll());
    }

    public void kosongkanForm() {
        txtKodeJadwal.setText("");
        txtNipGuru.setText("");
        lblGuru.setText("Pengajar");
        lblJamMulai.setText("00:00");
        lblJamSelesai.setText("00:00");
        cmbTingkat.setSelectedIndex(0);
        cmbKelas.setSelectedIndex(0);
        cmbHari.setSelectedIndex(0);
        cmbJamMulai.setSelectedIndex(0);
        cmbJamSelesai.setSelectedIndex(0);
        cmbMapel.setSelectedIndex(0);
    }

    public void setComboMapel() {
        ArrayList<MataPelajaran> results = (ArrayList<MataPelajaran>) mps.getAll();
        ArrayList<String> listMapel = new ArrayList<>();
        listMapel.add("Pilih Mata Pelajaran");
        for (MataPelajaran mapel : results) {
            listMapel.add(String.format("%s - %s", mapel.getKodeMataPelajaran(), mapel.getNama()));
        }
        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(listMapel.toArray());
        cmbMapel.setModel(cmbModel);
    }

    public void setComboTingkat() {
        String[] tingkat = {"Pilih Tingkat", "7", "8", "9"};
        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(tingkat);
        cmbTingkat.setModel(cmbModel);
    }

    public void setComboHari() {
        String[] hari = {"Pilih Hari", "senin", "selasa", "rabu", "kamis", "jumat", "sabtu", "minggu"};
        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(hari);
        cmbHari.setModel(cmbModel);
    }

    public void setComboJam() {
        String[] jamPelajaran = {"Pilih Jam Pelajaran", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(jamPelajaran);
        DefaultComboBoxModel cmbModel2 = new DefaultComboBoxModel(jamPelajaran);
        cmbJamMulai.setModel(cmbModel);
        cmbJamSelesai.setModel(cmbModel2);
    }

    public void setComboKelas(int tingkat) {
        ArrayList<Kelas> results = (ArrayList<Kelas>) ks.getByTingkat(tingkat);
        ArrayList<String> listKelas = new ArrayList<>();
        listKelas.add("Pilih Kelas");
        for (Kelas kelas : results) {
            listKelas.add(String.format("%s - %s", kelas.getKodeKelas(), kelas.getNama()));
        }
        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel(listKelas.toArray());
        cmbKelas.setModel(cmbModel);
    }

    public String getWaktu(int jam) {
        jam += 6;
        String waktu = jam > 9 ? String.format("%d:00", jam) : String.format("0%d:00", jam);

        return waktu;
    }

    public void tampilkanData(List<JadwalPelajaran> listJadwal) {
        String[] kolom = {"Kode Jadwal", "Guru", "Kelas", "Mata Pelajaran", "Hari", "Waktu Mulai", "Waktu Selesai"};
        Object rowData[] = new Object[7];
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, kolom);
        tblJadwalPelajaran.setModel(tableModel);
        for (JadwalPelajaran jadwal : listJadwal) {
            rowData[0] = jadwal.getKodeJadwal();
            rowData[1] = String.format("%s - %s", jadwal.getGuru().getNip(), jadwal.getGuru().getNama());
            rowData[2] = String.format("%s - %s", jadwal.getKelas().getKodeKelas(), jadwal.getKelas().getNama());
            rowData[3] = String.format("%s - %s", jadwal.getMapel().getKodeMataPelajaran(), jadwal.getMapel().getNama());
            rowData[4] = jadwal.getHari();
            rowData[5] = String.format("jam ke-%d, %s", jadwal.getWaktuMulai(), getWaktu(jadwal.getWaktuMulai()));
            rowData[6] = String.format("jam ke-%d, %s", jadwal.getWaktuSelesai(),
                    getWaktu(jadwal.getWaktuSelesai())
            );
            ((DefaultTableModel) tblJadwalPelajaran.getModel()).addRow(rowData);

        }
    }

    public void cari(String keyword) {
        tampilkanData(jps.search(keyword));
    }

    public boolean validateForm() {
        if (txtKodeJadwal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Jadwal Pelajaran belum diisi !");
            txtKodeJadwal.requestFocus();
            return false;
        } else if (txtNipGuru.getText().isEmpty() && lblGuru.equals("Pengajar")) {
            JOptionPane.showMessageDialog(null, "NIP guru belum diisi !");
            txtNipGuru.requestFocus();
            return false;
        } else if (cmbKelas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Kelas belum diisi !");
            cmbKelas.requestFocus();
            return false;
        } else if (cmbMapel.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Mata Pelajaran belum diisi !");
            cmbMapel.requestFocus();
            return false;
        } else if (cmbHari.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Hari belum diisi !");
            cmbHari.requestFocus();
            return false;
        } else if (cmbJamMulai.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Jam Mulai belum diisi !");
            cmbJamMulai.requestFocus();
            return false;
        } else if (cmbJamSelesai.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Jam Selesai belum diisi !");
            cmbJamSelesai.requestFocus();
            return false;
        }
        return true;
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
        tblJadwalPelajaran = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtKodeJadwal = new javax.swing.JTextField();
        btnTambahBaru = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbKelas = new javax.swing.JComboBox<>();
        cmbHari = new javax.swing.JComboBox<>();
        cmbTingkat = new javax.swing.JComboBox<>();
        cmbJamMulai = new javax.swing.JComboBox<>();
        lblJamSelesai = new javax.swing.JLabel();
        cmbJamSelesai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblJamMulai = new javax.swing.JLabel();
        txtNipGuru = new javax.swing.JTextField();
        btnCariGuru = new javax.swing.JButton();
        lblGuru = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbMapel = new javax.swing.JComboBox<>();
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

        tblJadwalPelajaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tblJadwalPelajaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJadwalPelajaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblJadwalPelajaran);

        btnCari.setText("Cari Jadwal Pelajaran");
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

        jLabel5.setText("Kode Jadwal");

        jLabel6.setText("NIP Pengajar");

        jLabel7.setText("Kode Kelas");

        jLabel8.setText("Waktu Pembelajaran");

        txtKodeJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeJadwalActionPerformed(evt);
            }
        });

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
        jLabel10.setText("FORM JADWAL PELAJARAN");

        jLabel13.setText("Hari");

        jLabel1.setText("Mata Pelajaran");

        cmbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKelasActionPerformed(evt);
            }
        });

        cmbHari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTingkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTingkat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTingkatItemStateChanged(evt);
            }
        });

        cmbJamMulai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblJamSelesai.setText("00:00");

        cmbJamSelesai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbJamSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJamSelesaiActionPerformed(evt);
            }
        });

        jLabel3.setText("sampai");

        lblJamMulai.setText("00:00");

        btnCariGuru.setText("Cari");
        btnCariGuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariGuruActionPerformed(evt);
            }
        });

        lblGuru.setText("Pengajar");

        jLabel2.setText("Tingkat");

        cmbMapel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMapel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMapelItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbHari, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbJamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblJamMulai)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbJamSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblJamSelesai)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(330, 330, 330))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNipGuru, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCariGuru)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblGuru))
                                    .addComponent(txtKodeJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTambahBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMapel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTingkat, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtKodeJadwal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNipGuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCariGuru)
                            .addComponent(lblGuru))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTambahBaru)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHapus)
                            .addComponent(cmbMapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cmbTingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbJamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJamSelesai)
                    .addComponent(cmbJamSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lblJamMulai))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
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
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblJadwalPelajaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJadwalPelajaranMouseClicked
        kosongkanForm();
        DefaultTableModel model = (DefaultTableModel) tblJadwalPelajaran.getModel();
        int row = tblJadwalPelajaran.getSelectedRow();
        String nipGuru = model.getValueAt(row, 1).toString().split("\\-")[0].trim();
        String kodeKelas = model.getValueAt(row, 2).toString().split("\\-")[0].trim();
        String kodeMapel = model.getValueAt(row, 3).toString().split("\\-")[0].trim();

        String jamMulai = model.getValueAt(row, 5).toString().split("\\-")[1].split("\\,")[0].trim();
        String jamSelesai = model.getValueAt(row, 6).toString().split("\\-")[1].split("\\,")[0].trim();

        txtKodeJadwal.setText(model.getValueAt(row, 0).toString());
        Guru guru = gs.getByNip(nipGuru);
        txtNipGuru.setText(nipGuru);
        lblGuru.setText(String.format("%s - %s", guru.getNip(), guru.getNama()));
        MataPelajaran mapel = mps.getByKode(kodeMapel);

        cmbMapel.setSelectedItem(String.format("%s - %s", mapel.getKodeMataPelajaran(), mapel.getNama()));
        Kelas kelas = ks.getByKode(kodeKelas);
        cmbTingkat.setSelectedItem(String.valueOf(kelas.getTingkat()));
        cmbKelas.setSelectedItem(String.format("%s - %s", kelas.getKodeKelas(), kelas.getNama()));
        cmbHari.setSelectedItem(model.getValueAt(row, 4));
        cmbJamMulai.setSelectedItem(jamMulai);
        cmbJamSelesai.setSelectedItem(jamSelesai);
        lblJamMulai.setText(getWaktu(Integer.parseInt(jamMulai)));
        lblJamSelesai.setText(getWaktu(Integer.parseInt(jamSelesai)));

    }//GEN-LAST:event_tblJadwalPelajaranMouseClicked

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtKodeJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeJadwalActionPerformed

    }//GEN-LAST:event_txtKodeJadwalActionPerformed

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        kosongkanForm();
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if (!validateForm()) {
            return;
        }

        JadwalPelajaran jadwal = new JadwalPelajaran();
        jadwal.setKodeJadwal(txtKodeJadwal.getText());
        Guru guru = gs.getByNip(txtNipGuru.getText());
        Kelas kelas = ks.getByKode(cmbKelas.getSelectedItem().toString().split("\\-")[0].trim());
        MataPelajaran mapel = mps.getByKode(cmbMapel.getSelectedItem().toString().split("\\-")[0].trim());

        jadwal.setGuru(guru);
        jadwal.setKelas(kelas);
        jadwal.setMapel(mapel);
        jadwal.setHari(cmbHari.getSelectedItem().toString());
        jadwal.setWaktuMulai(Integer.parseInt(cmbJamMulai.getSelectedItem().toString()));
        jadwal.setWaktuSelesai(Integer.parseInt(cmbJamSelesai.getSelectedItem().toString()));
        if (jps.getByKode(txtKodeJadwal.getText()) == null) {
            jps.insert(jadwal);
        } else {
            jps.update(jadwal);
        }
        kosongkanForm();
        tampilkanData(jps.getAll());
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed

        jps.delete(txtKodeJadwal.getText());
        kosongkanForm();
        tampilkanData(jps.getAll());
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cmbKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKelasActionPerformed

    private void cmbJamSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJamSelesaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJamSelesaiActionPerformed

    private void btnCariGuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariGuruActionPerformed
        if (!txtNipGuru.getText().isEmpty()) {
            Guru guru = gs.getByNip(txtNipGuru.getText());
            if (guru != null) {
                lblGuru.setText(String.format("%s - %s", guru.getNip(), guru.getNama()));
            } else {
                lblGuru.setText("Guru Tidak Ditemukan");
            }
        }
    }//GEN-LAST:event_btnCariGuruActionPerformed

    private void cmbTingkatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTingkatItemStateChanged
        if (cmbTingkat.getSelectedIndex() != 0) {
            int tingkat = Integer.parseInt(cmbTingkat.getSelectedItem().toString());
            setComboKelas(tingkat);
        }
    }//GEN-LAST:event_cmbTingkatItemStateChanged

    private void cmbMapelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMapelItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMapelItemStateChanged

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
            java.util.logging.Logger.getLogger(FormJadwalPelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormJadwalPelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormJadwalPelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormJadwalPelajaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJadwalPelajaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin1;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCariGuru;
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
    private javax.swing.JComboBox<String> cmbHari;
    private javax.swing.JComboBox<String> cmbJamMulai;
    private javax.swing.JComboBox<String> cmbJamSelesai;
    private javax.swing.JComboBox<String> cmbKelas;
    private javax.swing.JComboBox<String> cmbMapel;
    private javax.swing.JComboBox<String> cmbTingkat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGuru;
    private javax.swing.JLabel lblJamMulai;
    private javax.swing.JLabel lblJamSelesai;
    private javax.swing.JTable tblJadwalPelajaran;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtKodeJadwal;
    private javax.swing.JTextField txtNipGuru;
    // End of variables declaration//GEN-END:variables
}
