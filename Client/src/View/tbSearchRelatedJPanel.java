package View;

import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javax.swing.table.DefaultTableModel;

public class tbSearchRelatedJPanel extends javax.swing.JPanel {

    SearchRelatedReponse searchRelatedReponse;

    public tbSearchRelatedJPanel(SearchRelatedReponse searchRelatedReponse) {
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

        setBackground(new java.awt.Color(204, 255, 255));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameJLabel.setText("jLabel1");

        tbRelated.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbRelated.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbRelated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Related search", "Rising", "Top"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane2.setViewportView(tbRelated);
        if (tbRelated.getColumnModel().getColumnCount() > 0) {
            tbRelated.getColumnModel().getColumn(1).setMinWidth(100);
            tbRelated.getColumnModel().getColumn(1).setPreferredWidth(120);
            tbRelated.getColumnModel().getColumn(1).setMaxWidth(140);
            tbRelated.getColumnModel().getColumn(2).setMinWidth(100);
            tbRelated.getColumnModel().getColumn(2).setPreferredWidth(120);
            tbRelated.getColumnModel().getColumn(2).setMaxWidth(140);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJLabel))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTable tbRelated;
    // End of variables declaration//GEN-END:variables

    private void showdata() {
        nameJLabel.setText(searchRelatedReponse.getColunm());
        
        DefaultTableModel relatedModel = (DefaultTableModel) tbRelated.getModel();
        Object[] row = new Object[3];
        for (RelatedReponse relatedReponse : searchRelatedReponse.getRelatedReponses()) {
            row[0] = relatedReponse.getName();
            row[1] = relatedReponse.getRising();
            row[2] = relatedReponse.getTop();
            relatedModel.addRow(row);
        }
    }
}
