package View;

import java.util.List;
import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.RelatedTopicRising;
import javalibrary.model.reponse.RelatedTopicTop;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javax.swing.table.DefaultTableModel;

public class SearchRelatedTopicTable extends javax.swing.JPanel {

    SearchRelatedTopicReponse searchRelatedTopicReponse;
    DefaultTableModel regionTopicModel;

    public SearchRelatedTopicTable(String keyString, SearchRelatedTopicReponse searchRelatedTopicReponse) {
        initComponents();
        this.searchRelatedTopicReponse = searchRelatedTopicReponse;
        regionTopicModel = (DefaultTableModel) relatedTopicTable.getModel();
        showData(keyString, searchRelatedTopicReponse);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchRelatedTopicPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        relatedTopicTable = new javax.swing.JTable();
        nameJLabel = new javax.swing.JLabel();
        btn_top = new javax.swing.JButton();
        btn_raising = new javax.swing.JButton();

        searchRelatedTopicPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchRelatedTopicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        relatedTopicTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        relatedTopicTable.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        relatedTopicTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Related topic", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        relatedTopicTable.setRowSelectionAllowed(false);
        relatedTopicTable.setShowHorizontalLines(false);
        relatedTopicTable.setShowVerticalLines(false);
        relatedTopicTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relatedTopicTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(relatedTopicTable);

        searchRelatedTopicPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 40, 640, 340));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameJLabel.setText("jLabel1");
        searchRelatedTopicPanel.add(nameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, -1, -1));

        btn_top.setText("Top");
        btn_top.setPreferredSize(new java.awt.Dimension(67, 23));
        btn_top.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_topActionPerformed(evt);
            }
        });
        searchRelatedTopicPanel.add(btn_top, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        btn_raising.setText("Raising");
        btn_raising.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_raisingActionPerformed(evt);
            }
        });
        searchRelatedTopicPanel.add(btn_raising, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchRelatedTopicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchRelatedTopicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void relatedTopicTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relatedTopicTableMouseClicked
        int row = relatedTopicTable.rowAtPoint(evt.getPoint());
        int col = relatedTopicTable.columnAtPoint(evt.getPoint());
        String key = relatedTopicTable.getValueAt(row, col).toString();
        searchJPanel.txSearch1.setText(key);
        searchJPanel.txSearch3.setText("");
        searchJPanel.txSearch4.setText("");
        searchJPanel.txSearch2.setText("");
        searchJPanel.txSearch5.setText("");
        searchJPanel.btnSearch.doClick();
    }//GEN-LAST:event_relatedTopicTableMouseClicked

    private void btn_topActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_topActionPerformed
        // TODO add your handling code here:
        showTopData();
    }//GEN-LAST:event_btn_topActionPerformed

    private void btn_raisingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_raisingActionPerformed
        // TODO add your handling code here:
        showRaisingData();
    }//GEN-LAST:event_btn_raisingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_raising;
    private javax.swing.JButton btn_top;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTable relatedTopicTable;
    private javax.swing.JPanel searchRelatedTopicPanel;
    // End of variables declaration//GEN-END:variables

    private void showData(String keyString, SearchRelatedTopicReponse searchRelatedTopicReponse) {
        nameJLabel.setText(keyString);
        showTopData();
    }

    private void showTopData() {
        removeAllRow();
        btn_top.setEnabled(false);
        btn_raising.setEnabled(true);
        Object[] row = new Object[2];
        for (RelatedTopicTop relatedReponse : searchRelatedTopicReponse.getRelatedTopicTops()) {
            row[0] = relatedReponse.getName();
            row[1] = relatedReponse.getTop();
            regionTopicModel.addRow(row);
        }
    }

    private void showRaisingData() {
        removeAllRow();
        btn_top.setEnabled(true);
        btn_raising.setEnabled(false);
        Object[] row = new Object[2];
        for (RelatedTopicRising relatedReponse : searchRelatedTopicReponse.getRelatedTopicRisings()) {
            row[0] = relatedReponse.getName();
            row[1] = relatedReponse.getRising();
            regionTopicModel.addRow(row);
        }
    }

    private void removeAllRow() {
        for (int i = regionTopicModel.getRowCount() - 1; i >= 0; i--) {
            regionTopicModel.removeRow(i);
        }
    }
}
