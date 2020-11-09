package View;

import java.util.ArrayList;
import java.util.List;
import javalibrary.model.reponse.RegionReponse;
import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javax.swing.table.DefaultTableModel;

public class searchOneKeyJPanel extends javax.swing.JPanel {

    List<SearchRegionReponse> searchRegionReponses = new ArrayList<>();
    List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();
    List<SearchRelatedTopicReponse> searchRelatedTopicReponses = new ArrayList<>();

    public searchOneKeyJPanel(List<SearchRegionReponse> searchRegionReponses, List<SearchRelatedReponse> searchRelatedReponses, List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
        initComponents();
        this.searchRegionReponses = searchRegionReponses;
        this.searchRelatedReponses = searchRelatedReponses;
        this.searchRelatedTopicReponses = searchRelatedTopicReponses;
        showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRelatedTopic = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRelated = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbRegion = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbRelatedTopic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbRelatedTopic.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbRelatedTopic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject search", "Rising", "Top"
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
        tbRelatedTopic.setRowSelectionAllowed(false);
        tbRelatedTopic.setShowHorizontalLines(false);
        tbRelatedTopic.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tbRelatedTopic);
        if (tbRelatedTopic.getColumnModel().getColumnCount() > 0) {
            tbRelatedTopic.getColumnModel().getColumn(1).setMinWidth(80);
            tbRelatedTopic.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbRelatedTopic.getColumnModel().getColumn(1).setMaxWidth(100);
            tbRelatedTopic.getColumnModel().getColumn(2).setMinWidth(80);
            tbRelatedTopic.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbRelatedTopic.getColumnModel().getColumn(2).setMaxWidth(100);
        }

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
            tbRelated.getColumnModel().getColumn(1).setMinWidth(80);
            tbRelated.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbRelated.getColumnModel().getColumn(1).setMaxWidth(100);
            tbRelated.getColumnModel().getColumn(2).setMinWidth(100);
            tbRelated.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbRelated.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        tbRegion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbRegion.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Region search", "Care"
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
        tbRegion.setRowSelectionAllowed(false);
        tbRegion.setShowHorizontalLines(false);
        tbRegion.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tbRegion);
        if (tbRegion.getColumnModel().getColumnCount() > 0) {
            tbRegion.getColumnModel().getColumn(1).setMinWidth(80);
            tbRegion.getColumnModel().getColumn(1).setPreferredWidth(120);
            tbRegion.getColumnModel().getColumn(1).setMaxWidth(140);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jScrollPane2)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                .addGap(350, 350, 350))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbRegion;
    private javax.swing.JTable tbRelated;
    private javax.swing.JTable tbRelatedTopic;
    // End of variables declaration//GEN-END:variables

    private void showData() {
        DefaultTableModel regionModel = (DefaultTableModel) tbRegion.getModel();
        DefaultTableModel relatedModel = (DefaultTableModel) tbRelated.getModel();
        DefaultTableModel regionTopicModel = (DefaultTableModel) tbRelatedTopic.getModel();
        Object[] row = new Object[3];
        for (RegionReponse regionReponse : searchRegionReponses.get(0).getRegionReponses()) {
            row[0] = regionReponse.getName();
            row[1] = regionReponse.getTotal();
            regionModel.addRow(row);
        }

        for (RelatedReponse relatedReponse : searchRelatedReponses.get(0).getRelatedReponses()) {
            row[0] = relatedReponse.getName();
            row[1] = relatedReponse.getRising();
            row[2] = relatedReponse.getTop();
            relatedModel.addRow(row);
        }

        for (SearchRelatedTopicReponse object : searchRelatedTopicReponses) {
            row[0] = object.getName();
            row[1] = object.getRising();
            row[2] = object.getTop();
            regionTopicModel.addRow(row);
        }
    }
}
