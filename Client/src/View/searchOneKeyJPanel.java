package View;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javalibrary.model.reponse.ListRelatedTopicReponse;
import javalibrary.model.reponse.RegionReponse;
import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.SearchOverTimeReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javax.swing.table.DefaultTableModel;

public class searchOneKeyJPanel extends javax.swing.JPanel {

    List<SearchRegionReponse> searchRegionReponses = new ArrayList<>();
    List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();
    List<SearchRelatedTopicReponse> searchRelatedTopicReponses = new ArrayList<>();
    SearchOverTimeReponse searchOverTimeReponse = new SearchOverTimeReponse();
    ListRelatedTopicReponse listRelatedTopicReponse = new ListRelatedTopicReponse();

    public searchOneKeyJPanel(ListRelatedTopicReponse listRelatedTopicReponse, SearchOverTimeReponse searchOverTimeReponse, List<SearchRegionReponse> searchRegionReponses, List<SearchRelatedReponse> searchRelatedReponses, List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
        initComponents();
        this.searchRegionReponses = searchRegionReponses;
        this.searchRelatedReponses = searchRelatedReponses;
        this.searchRelatedTopicReponses = searchRelatedTopicReponses;
        this.searchOverTimeReponse = searchOverTimeReponse;
        this.listRelatedTopicReponse = listRelatedTopicReponse;
        showData();
        showGraph();
        showRelatedTopic();
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
        graphPanel = new javax.swing.JPanel();
        relatedTopicPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(247, 247, 247));
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
        tbRelatedTopic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRelatedTopicMouseClicked(evt);
            }
        });
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

        graphPanel.setBackground(new java.awt.Color(247, 247, 247));

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout relatedTopicPanelLayout = new javax.swing.GroupLayout(relatedTopicPanel);
        relatedTopicPanel.setLayout(relatedTopicPanelLayout);
        relatedTopicPanelLayout.setHorizontalGroup(
            relatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        relatedTopicPanelLayout.setVerticalGroup(
            relatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(relatedTopicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graphPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(relatedTopicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbRelatedTopicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRelatedTopicMouseClicked
        int row = tbRelatedTopic.rowAtPoint(evt.getPoint());
        int col = tbRelatedTopic.columnAtPoint(evt.getPoint());
        String key = tbRelatedTopic.getValueAt(row, col).toString();
        searchJPanel.txSearch1.setText(key);
        searchJPanel.txSearch3.setText("");
        searchJPanel.txSearch4.setText("");
        searchJPanel.txSearch2.setText("");
        searchJPanel.txSearch5.setText("");
//        searchJPanel.BtnSearch();
    }//GEN-LAST:event_tbRelatedTopicMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel relatedTopicPanel;
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

    private void showGraph() {
        List<String> keySearchs = new ArrayList<>();
        for (int i = 0; i < searchRelatedReponses.size(); i++) {
            keySearchs.add(searchRelatedReponses.get(i).getColunm());

        }
        graphPanel.removeAll();
        graphPanel.setLayout(new BorderLayout());
        graphPanel.add(new lineGraph(keySearchs, searchOverTimeReponse));
        graphPanel.validate();
        graphPanel.repaint();
    }

    private void showRelatedTopic() {
        relatedTopicPanel.removeAll();
        relatedTopicPanel.setLayout(new BorderLayout());
        relatedTopicPanel.add(new listRelatedTopicJPanel(listRelatedTopicReponse.getRelatedTopicReponses(), listRelatedTopicReponse.getColumn()));
        relatedTopicPanel.validate();
        relatedTopicPanel.repaint();
    }
}
