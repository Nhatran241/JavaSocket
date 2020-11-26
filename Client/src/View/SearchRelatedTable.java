package View;

import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javax.swing.table.DefaultTableModel;

public class SearchRelatedTable extends javax.swing.JPanel {

    SearchRelatedReponse searchRelatedReponse;
     DefaultTableModel relatedModel;

    public SearchRelatedTable(SearchRelatedReponse searchRelatedReponse) {
        initComponents();
        this.searchRelatedReponse = searchRelatedReponse;
        showdata();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameJLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRelated = new javax.swing.JTable();
        btn_raising = new javax.swing.JButton();
        btn_top = new javax.swing.JButton();

        setBackground(new java.awt.Color(247, 247, 247));
        setLayout(null);

        nameJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameJLabel.setText("jLabel1");
        add(nameJLabel);
        nameJLabel.setBounds(10, 10, 66, 22);

        tbRelated.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbRelated.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbRelated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Related search", "Value"
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
        tbRelated.setRowSelectionAllowed(false);
        tbRelated.setShowHorizontalLines(false);
        tbRelated.setShowVerticalLines(false);
        tbRelated.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRelatedMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbRelated);

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 42, 648, 341);

        btn_raising.setText("Raising");
        btn_raising.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_raisingActionPerformed(evt);
            }
        });
        add(btn_raising);
        btn_raising.setBounds(585, 13, 67, 23);

        btn_top.setText("Top");
        btn_top.setPreferredSize(new java.awt.Dimension(67, 23));
        btn_top.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_topActionPerformed(evt);
            }
        });
        add(btn_top);
        btn_top.setBounds(500, 13, 67, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void tbRelatedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRelatedMouseClicked
        int row = tbRelated.rowAtPoint(evt.getPoint());
        int col = tbRelated.columnAtPoint(evt.getPoint());
        String key = tbRelated.getValueAt(row, col).toString();
        searchJPanel.txSearch1.setText(key);
        searchJPanel.txSearch3.setText("");
        searchJPanel.txSearch4.setText("");
        searchJPanel.txSearch2.setText("");
        searchJPanel.txSearch5.setText("");
        searchJPanel.btnSearch.doClick();
    }//GEN-LAST:event_tbRelatedMouseClicked

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
    private javax.swing.JTable tbRelated;
    // End of variables declaration//GEN-END:variables

    private void showdata() {
        nameJLabel.setText(searchRelatedReponse.getColunm());
        relatedModel = (DefaultTableModel) tbRelated.getModel();
        showTopData();
       
    }
    private void showTopData(){
        removeAllRow();
        btn_top.setEnabled(false);
        btn_raising.setEnabled(true);
        Object[] row = new Object[2];
        for (RelatedReponse relatedReponse : searchRelatedReponse.getRelatedReponses()) {
            row[0] = relatedReponse.getName();
            row[1] = relatedReponse.getTop();
            System.out.println(""+relatedReponse.getTop() +" / "+relatedReponse.getRising());
            relatedModel.addRow(row);
        }
    }
    private void showRaisingData(){
        removeAllRow();
        btn_top.setEnabled(true);
        btn_raising.setEnabled(false);
        Object[] row = new Object[2];
        for (RelatedReponse relatedReponse : searchRelatedReponse.getRelatedReponses()) {
            row[0] = relatedReponse.getName();
            row[1] = relatedReponse.getRising();
            relatedModel.addRow(row);
        }
    }

    private void removeAllRow() {
       for (int i = relatedModel.getRowCount() - 1; i >= 0; i--) {
            relatedModel.removeRow(i);
        }
    }
}
