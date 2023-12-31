package Views;

import ConnectDB.ConnectionUtils;
import Processes.ClockThread;
import Processes.Room;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nguyen Bao Anh
 */
public class RoomManagement extends javax.swing.JFrame {

    DefaultTableModel modelRoom = null;
    String maPhongTap;

    /**
     * Creates new form CustomerForm
     *
     * @throws java.lang.ClassNotFoundException
     */
    public RoomManagement() throws ClassNotFoundException {
        initComponents();
        init();
    }

    private void init() throws ClassNotFoundException {
        setResizable(false);
        this.setLocationRelativeTo(null);
        modelRoom = (DefaultTableModel) tableRoom.getModel();
        setTableRoom();
        resetClass();
        initClock();
    }

    private void initClock() {
        ClockThread ct = new ClockThread(lbClock, lbTime);
        ct.start();
    }

    private void setTableRoom() throws ClassNotFoundException {
        try {
            Connection conn = ConnectionUtils.getOracleConnection();
            String sql = "SELECT * FROM room ORDER BY room_id";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maPhongTap = rs.getString("room_id");
                String sucChua = rs.getString("room_capacity");
                modelRoom.addRow(new Object[]{maPhongTap, sucChua});
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel1 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoom = new javax.swing.JTable();
        lbTime = new javax.swing.JLabel();
        lbClock = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lvMinimize = new javax.swing.JLabel();
        lbExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("#9Slide03 Roboto Condensed", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(134, 1, 4));
        jLabel1.setText("Sức chứa");

        txtCapacity.setBackground(new java.awt.Color(255, 255, 255));
        txtCapacity.setFont(new java.awt.Font("#9Slide03 Roboto Condensed Bold", 0, 14)); // NOI18N
        txtCapacity.setForeground(new java.awt.Color(134, 1, 4));
        txtCapacity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnReset.setBackground(new java.awt.Color(255, 255, 255));
        btnReset.setForeground(new java.awt.Color(134, 1, 4));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-refresh-30.png"))); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setFont(new java.awt.Font("#9Slide03 Roboto Condensed Bold", 0, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(134, 1, 4));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-room-30.png"))); // NOI18N
        btnThem.setText("NEW");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("#9Slide03 Montserrat Bold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(134, 1, 4));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PHÒNG TẬP");

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setForeground(new java.awt.Color(134, 1, 4));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-delete-32.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate1.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate1.setForeground(new java.awt.Color(134, 1, 4));
        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons8-edit-30.png"))); // NOI18N
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(134, 1, 4));
        jSeparator2.setForeground(new java.awt.Color(134, 1, 4));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCapacity)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(134, 1, 4));

        tableRoom.setBackground(new java.awt.Color(134, 1, 4));
        tableRoom.setFont(new java.awt.Font("#9Slide03 Roboto Condensed", 0, 14)); // NOI18N
        tableRoom.setForeground(new java.awt.Color(255, 255, 255));
        tableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng tập", "Sức chứa"
            }
        ));
        tableRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRoom);

        lbTime.setBackground(new java.awt.Color(134, 1, 4));
        lbTime.setFont(new java.awt.Font("#9Slide03 HelvetIns", 0, 14)); // NOI18N
        lbTime.setForeground(new java.awt.Color(255, 255, 255));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTime.setText("Ngày");

        lbClock.setBackground(new java.awt.Color(134, 1, 4));
        lbClock.setFont(new java.awt.Font("#9Slide03 HelvetIns", 0, 14)); // NOI18N
        lbClock.setForeground(new java.awt.Color(255, 255, 255));
        lbClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClock.setText("giờ");

        txtSearch.setBackground(new java.awt.Color(134, 1, 4));
        txtSearch.setFont(new java.awt.Font("#9Slide03 Roboto Condensed Bold", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setText("SEARCH");
        txtSearch.setBorder(null);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ic_search_white_18dp_1.png"))); // NOI18N

        jSeparator4.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        lvMinimize.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lvMinimize.setForeground(new java.awt.Color(221, 229, 232));
        lvMinimize.setText("-");
        lvMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lvMinimizeMouseClicked(evt);
            }
        });

        lbExit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbExit.setForeground(new java.awt.Color(221, 229, 232));
        lbExit.setText("X");
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbClock)
                            .addComponent(lbTime))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(lvMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbExit)))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(lvMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbClock, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTime)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tableRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRoomMouseClicked
        int Click = tableRoom.getSelectedRow();
        maPhongTap = (String) tableRoom.getValueAt(Click, 0);
        txtCapacity.setText((String) tableRoom.getValueAt(Click, 1));
    }//GEN-LAST:event_tableRoomMouseClicked

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        try {
            String sucChua = txtCapacity.getText();
            int i = Room.updateRoom(maPhongTap, sucChua);
            if (i > 0) {
                modelRoom.setRowCount(0);
                setTableRoom();
                JOptionPane.showMessageDialog(this, "Cập nhật Phòng tập THÀNH CÔNG!");
                resetClass();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật Phòng tập THẤT BẠI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                resetClass();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomManagement.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Cập nhật Phòng tập THẤT BẠI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            resetClass();
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            Object[] options = {"Có", "Không", "Hủy"};
            int result = JOptionPane.showOptionDialog(rootPane,
                    "Bạn có chắc muốn xóa phòng tập số" + maPhongTap + " hay không?",
                    "Xóa phòng tập", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (result == JOptionPane.YES_OPTION) {
                int i = Room.deleteRoom(maPhongTap);
                if (i > 0) {
                    modelRoom.setRowCount(0);
                    setTableRoom();
                    JOptionPane.showMessageDialog(this, "Xóa phòng tập THÀNH CÔNG!");
                    resetClass();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa phòng tập THẤT BẠI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    resetClass();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hủy thao tác thêm phòng tập!");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomManagement.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Xóa phòng tập THẤT BẠI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            resetClass();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            String sucChua = txtCapacity.getText();
            Object[] options = {"Có", "Không", "Hủy"};
            int result = JOptionPane.showOptionDialog(rootPane,
                    "Bạn có chắc muốn thêm phòng tập có sỉ số " + sucChua + " hay không?",
                    "Thêm phòng tập", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (result == JOptionPane.YES_OPTION) {
                int i = Room.addRoom(sucChua);
                if (i > 0) {
                    modelRoom.setRowCount(0);
                    setTableRoom();
                    JOptionPane.showMessageDialog(this, "Thêm Phòng tập THÀNH CÔNG!");
                    resetClass();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm Phòng tập THẤT BẠI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    resetClass();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hủy thao tác thêm phòng tập!");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RoomManagement.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Thêm Phòng tập THẤT BẠI!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetClass();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        DefaultTableModel SearchTable = (DefaultTableModel) tableRoom.getModel();
        String timkiemKH = txtSearch.getText();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(SearchTable);
        tableRoom.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(timkiemKH));
    }//GEN-LAST:event_txtSearchKeyPressed

    private void lvMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lvMinimizeMouseClicked
        // TODO add your handling code here:
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lvMinimizeMouseClicked

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lbExitMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new RoomManagement().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RoomManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbClock;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lvMinimize;
    private javax.swing.JTable tableRoom;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void resetClass() {
        txtSearch.setText("SEARCH");
        txtCapacity.setText("");
    }
}
