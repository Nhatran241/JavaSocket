package View;

import static View.searchJPanel.fromDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ChooseDatePanel extends javax.swing.JPanel {

    public ChooseDatePanel() {
        initComponents();
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseDatePanel = new javax.swing.JPanel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fromtoRadioButton = new javax.swing.JRadioButton();
        yearRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();

        chooseDatePanel.setBackground(new java.awt.Color(255, 255, 255));

        fromDateChooser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fromDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromDateChooserPropertyChange(evt);
            }
        });

        toDateChooser.setEnabled(false);
        toDateChooser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        toDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toDateChooserPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("From");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("To");

        fromtoRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        fromtoRadioButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fromtoRadioButton.setSelected(true);
        fromtoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromtoRadioButtonActionPerformed(evt);
            }
        });

        yearRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        yearRadioButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        yearRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearRadioButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setText("Custom time");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Cả năm");

        yearComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020" }));
        yearComboBox.setEnabled(false);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chooseDatePanelLayout = new javax.swing.GroupLayout(chooseDatePanel);
        chooseDatePanel.setLayout(chooseDatePanelLayout);
        chooseDatePanelLayout.setHorizontalGroup(
            chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseDatePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chooseDatePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(chooseDatePanelLayout.createSequentialGroup()
                        .addGroup(chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chooseDatePanelLayout.createSequentialGroup()
                                .addComponent(yearRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(chooseDatePanelLayout.createSequentialGroup()
                                .addComponent(fromtoRadioButton)
                                .addGap(22, 22, 22)
                                .addGroup(chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fromDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseDatePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(31, 31, 31))
        );
        chooseDatePanelLayout.setVerticalGroup(
            chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseDatePanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(chooseDatePanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(yearRadioButton))
                    .addGroup(chooseDatePanelLayout.createSequentialGroup()
                        .addGroup(chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(chooseDatePanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel2))
                                .addGroup(chooseDatePanelLayout.createSequentialGroup()
                                    .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(chooseDatePanelLayout.createSequentialGroup()
                                .addComponent(fromtoRadioButton)
                                .addGap(50, 50, 50)))
                        .addGap(25, 25, 25)
                        .addGroup(chooseDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooseDatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chooseDatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fromtoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromtoRadioButtonActionPerformed
        if (fromtoRadioButton.isSelected()) {
            fromDateChooser.setEnabled(true);
            yearRadioButton.setSelected(false);
            yearComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_fromtoRadioButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (fromtoRadioButton.isSelected()) {
            if (fromDateChooser.getDate() != null && toDateChooser.getDate() != null) {
                searchJPanel.fromDate = fromDateChooser.getDate();
                searchJPanel.toDate = toDateChooser.getDate();
                searchJPanel.jDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(chooseDatePanel, "Is not allowed to be empty");
            }
        } else {
            String year = yearComboBox.getSelectedItem().toString();
            SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = year + "-01-01";
            try {
                searchJPanel.fromDate = sdt.parse(dateString);
            } catch (ParseException ex) {
                Logger.getLogger(ChooseDatePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            Date date = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
            if (year == sdf1.format(date)) {
                searchJPanel.toDate = date;
            } else {
                dateString = year + "-12-31";
                try {
                    searchJPanel.toDate = sdt.parse(dateString);
                } catch (ParseException ex) {
                    Logger.getLogger(ChooseDatePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            searchJPanel.jDialog.dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void yearRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearRadioButtonActionPerformed
        if (yearRadioButton.isSelected()) {
            yearComboBox.setEnabled(true);
            fromDateChooser.setEnabled(false);
            toDateChooser.setEnabled(false);
            fromtoRadioButton.setSelected(false);
        }
    }//GEN-LAST:event_yearRadioButtonActionPerformed

    private void fromDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromDateChooserPropertyChange
        if (fromDateChooser.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String fromDate = sdf.format(fromDateChooser.getDate());
            String dateNow = sdf.format(date);
            try {
                if (sdf.parse(fromDate).before(sdf.parse(dateNow))) {
                    toDateChooser.setEnabled(true);
                } else {
                    fromDateChooser.setDate(null);
                    toDateChooser.setEnabled(false);
                    JOptionPane.showMessageDialog(chooseDatePanel, "Cannot be greater than the current date");
                }
            } catch (ParseException ex) {
                toDateChooser.setEnabled(false);
                JOptionPane.showMessageDialog(chooseDatePanel, "Invalid date");
            }

        }
    }//GEN-LAST:event_fromDateChooserPropertyChange

    private void toDateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toDateChooserPropertyChange

        if (toDateChooser.getDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String fromDate = sdf.format(fromDateChooser.getDate());
            String toDate = sdf.format(toDateChooser.getDate());
            String dateNow = sdf.format(date);
            try {
                if (sdf.parse(toDate).before(sdf.parse(dateNow))) {
                    if (sdf.parse(fromDate).after(sdf.parse(toDate))) {
                        toDateChooser.setDate(null);
                        JOptionPane.showMessageDialog(chooseDatePanel, "FromDate cannot be greater than ToDate");
                    }
                } else {
                    toDateChooser.setDate(null);
                    JOptionPane.showMessageDialog(chooseDatePanel, "Invalid date");
                }

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(chooseDatePanel, "Invalid date");
            }
        }
    }//GEN-LAST:event_toDateChooserPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chooseDatePanel;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JRadioButton fromtoRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton okButton;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JComboBox<String> yearComboBox;
    private javax.swing.JRadioButton yearRadioButton;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int start = Integer.parseInt(sdf.format(date));
        for (int i = 0; i < 20; i++) {
             yearComboBox.addItem(Integer.toString(start - i));
        }
        yearComboBox.setSelectedIndex(0);
    }
}
