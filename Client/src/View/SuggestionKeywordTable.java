package View;

import javalibrary.model.reponse.SuggesstionKeywordResponse;
import javalibrary.model.reponse.SuggesstionResponse;
import javax.swing.table.DefaultTableModel;

public class SuggestionKeywordTable extends javax.swing.JPanel {

    SuggesstionKeywordResponse suggesstionKeywordResponse;
    DefaultTableModel relatedModel;

    public SuggestionKeywordTable(SuggesstionKeywordResponse suggesstionKeywordResponse) {
        initComponents();
        this.suggesstionKeywordResponse = suggesstionKeywordResponse;
        relatedModel = (DefaultTableModel) tbRelated.getModel();
        showdata();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameJLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRelated = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameJLabel.setText("Suggestions Keyword");

        tbRelated.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbRelated.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbRelated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Keyword", "Type"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJLabel))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(nameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTable tbRelated;
    // End of variables declaration//GEN-END:variables

    private void showdata() {
        removeAllRow();
        Object[] row = new Object[2];
        for (SuggesstionResponse suggesstionResponse : suggesstionKeywordResponse.getResponse()) {
            row[0] = suggesstionResponse.getTitle();
            row[1] = suggesstionResponse.getType();
            relatedModel.addRow(row);
        }
       
    }
   

    private void removeAllRow() {
       for (int i = relatedModel.getRowCount() - 1; i >= 0; i--) {
            relatedModel.removeRow(i);
        }
    }
}
