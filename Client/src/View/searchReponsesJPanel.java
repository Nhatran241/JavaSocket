package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javalibrary.model.reponse.RegionReponse;
import javalibrary.model.reponse.RelatedReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class searchReponsesJPanel extends javax.swing.JPanel {

    List<SearchRegionReponse> searchRegionReponses = new ArrayList<>();
    List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();

    public searchReponsesJPanel(List<SearchRegionReponse> searchRegionReponses, List<SearchRelatedReponse> searchRelatedReponses) {
        initComponents();
        this.searchRegionReponses = searchRegionReponses;
        this.searchRelatedReponses = searchRelatedReponses;
        showSearchRelated();
        showSearchRegion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegion = new javax.swing.JTable();
        graphJPanel = new javax.swing.JPanel();
        searchRelatedJPanel = new javax.swing.JPanel();

        tbRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbRegion);

        javax.swing.GroupLayout graphJPanelLayout = new javax.swing.GroupLayout(graphJPanel);
        graphJPanel.setLayout(graphJPanelLayout);
        graphJPanelLayout.setHorizontalGroup(
            graphJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graphJPanelLayout.setVerticalGroup(
            graphJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout searchRelatedJPanelLayout = new javax.swing.GroupLayout(searchRelatedJPanel);
        searchRelatedJPanel.setLayout(searchRelatedJPanelLayout);
        searchRelatedJPanelLayout.setHorizontalGroup(
            searchRelatedJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        searchRelatedJPanelLayout.setVerticalGroup(
            searchRelatedJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchRelatedJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graphJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(graphJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(searchRelatedJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphJPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel searchRelatedJPanel;
    private javax.swing.JTable tbRegion;
    // End of variables declaration//GEN-END:variables

    private void showSearchRelated() {

//        for (int i = 0; i < searchRelatedReponses.size(); i++) {
//            SearchRelatedReponse searchRelatedReponse = searchRelatedReponses.get(i);
//            JTable jtable = new JTable();
//            DefaultTableModel relatedModel = (DefaultTableModel) jtable.getModel();
//            relatedModel.addColumn("Related search");
//            relatedModel.addColumn("Rising");
//            relatedModel.addColumn("Top");
//            Object[] row = new Object[3];
//            for (int j = 0; j < searchRelatedReponse.getRelatedReponses().size(); j++) {
//                RelatedReponse relatedReponse = searchRelatedReponse.getRelatedReponses().get(j);
//                row[0] = relatedReponse.getName();
//                row[1] = relatedReponse.getRising();
//                row[2] = relatedReponse.getTop();
//                relatedModel.addRow(row);
//            }
//            searchRelatedJPanel.add(new JScrollPane(jtable));
//        }
    }

    private void showSearchRegion() {
        DefaultTableModel regionModel = (DefaultTableModel) tbRegion.getModel();
        regionModel.addColumn("Region");
        for (int i = 0; i < searchRegionReponses.size(); i++) {
            regionModel.addColumn(searchRegionReponses.get(i).getColumn());
        }
        Object[] row = new Object[5];

        for (int i = 0; i < (searchRegionReponses.size() - 1); i++) {
            for (int j = 0; j < searchRegionReponses.get(i).getRegionReponses().size(); j++) {
                row[0] = searchRegionReponses.get(i).getRegionReponses().get(j).getName();
                row[1] = searchRegionReponses.get(i).getRegionReponses().get(j).getTotal();
                for (int k = (i + 1); k < searchRegionReponses.size(); k++) {
                    for (int l = 0; l < searchRegionReponses.get(k).getRegionReponses().size(); l++) {
                        if (searchRegionReponses.get(k).getRegionReponses().get(l).getName() == searchRegionReponses.get(i).getRegionReponses().get(j).getName()) {
                            row[2] = searchRegionReponses.get(k).getRegionReponses().get(l).getTotal();
                        }
                    }
                }
                regionModel.addRow(row);
            }
        }
    }
}
