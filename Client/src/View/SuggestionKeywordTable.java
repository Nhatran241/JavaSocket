package View;

import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javax.swing.table.DefaultTableModel;

public class SuggestionKeywordTable extends javax.swing.JPanel {

    SearchRelatedReponse searchRelatedReponse;
     DefaultTableModel relatedModel;

    public SuggestionKeywordTable(SearchRelatedReponse searchRelatedReponse) {
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

        setBackground(new java.awt.Color(247, 247, 247));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameJLabel.setText("jLabel1");

        tbRelated.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbRelated.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbRelated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Keyword"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
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
        nameJLabel.setText(searchRelatedReponse.getColunm());
        relatedModel = (DefaultTableModel) tbRelated.getModel();
        showTopData();
       
    }
    private void showTopData(){
        removeAllRow();
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
