package View;

import java.util.List;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javax.swing.table.DefaultTableModel;

public class SearchRelatedTopicTable extends javax.swing.JPanel {

    public SearchRelatedTopicTable(String keyString, List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
        initComponents();
        showData(keyString, searchRelatedTopicReponses);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchRelatedTopicPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        relatedTopicTable = new javax.swing.JTable();
        nameJLabel = new javax.swing.JLabel();

        searchRelatedTopicPanel.setBackground(new java.awt.Color(255, 255, 255));

        relatedTopicTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        relatedTopicTable.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        relatedTopicTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Related topic", "Rising", "Top"
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
        relatedTopicTable.setRowSelectionAllowed(false);
        relatedTopicTable.setShowHorizontalLines(false);
        relatedTopicTable.setShowVerticalLines(false);
        relatedTopicTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relatedTopicTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(relatedTopicTable);
        if (relatedTopicTable.getColumnModel().getColumnCount() > 0) {
            relatedTopicTable.getColumnModel().getColumn(1).setMinWidth(80);
            relatedTopicTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            relatedTopicTable.getColumnModel().getColumn(1).setMaxWidth(120);
            relatedTopicTable.getColumnModel().getColumn(2).setMinWidth(80);
            relatedTopicTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            relatedTopicTable.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        nameJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nameJLabel.setText("jLabel1");

        javax.swing.GroupLayout searchRelatedTopicPanelLayout = new javax.swing.GroupLayout(searchRelatedTopicPanel);
        searchRelatedTopicPanel.setLayout(searchRelatedTopicPanelLayout);
        searchRelatedTopicPanelLayout.setHorizontalGroup(
            searchRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchRelatedTopicPanelLayout.createSequentialGroup()
                .addGroup(searchRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchRelatedTopicPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchRelatedTopicPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nameJLabel)))
                .addGap(15, 15, 15))
        );
        searchRelatedTopicPanelLayout.setVerticalGroup(
            searchRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchRelatedTopicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchRelatedTopicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchRelatedTopicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTable relatedTopicTable;
    private javax.swing.JPanel searchRelatedTopicPanel;
    // End of variables declaration//GEN-END:variables

    private void showData(String keyString, List<SearchRelatedTopicReponse> searchRelatedTopicReponses)
    {
        nameJLabel.setText(keyString);
        DefaultTableModel regionTopicModel = (DefaultTableModel) relatedTopicTable.getModel();
        Object[] row = new Object[3];
        for (SearchRelatedTopicReponse object : searchRelatedTopicReponses) {
            row[0] = object.getName();
            row[1] = object.getRising();
            row[2] = object.getTop();
            regionTopicModel.addRow(row);
        }
    }
}
