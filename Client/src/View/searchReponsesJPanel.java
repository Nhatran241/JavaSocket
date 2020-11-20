package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javalibrary.model.reponse.SearchOverTimeReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;
import javax.swing.table.DefaultTableModel;

public class searchReponsesJPanel extends javax.swing.JPanel {

    List<SearchRegionReponse> searchRegionReponses = new ArrayList<>();
    List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();
    SearchOverTimeReponse searchOverTimeReponse = new SearchOverTimeReponse();

    public searchReponsesJPanel(SearchOverTimeReponse searchOverTimeReponse , List<SearchRegionReponse> searchRegionReponses, List<SearchRelatedReponse> searchRelatedReponses) {
        initComponents();
        this.searchRegionReponses = searchRegionReponses;
        this.searchRelatedReponses = searchRelatedReponses;
        this.searchOverTimeReponse = searchOverTimeReponse;
        showSearchRelated();
        showSearchRegion();
        showGraph();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegion = new javax.swing.JTable();
        graphJPanel = new javax.swing.JPanel();
        searchRelatedJPanel = new javax.swing.JPanel();

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));

        tbRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbRegion);

        graphJPanel.setBackground(new java.awt.Color(247, 247, 247));

        javax.swing.GroupLayout graphJPanelLayout = new javax.swing.GroupLayout(graphJPanel);
        graphJPanel.setLayout(graphJPanelLayout);
        graphJPanelLayout.setHorizontalGroup(
            graphJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graphJPanelLayout.setVerticalGroup(
            graphJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        searchRelatedJPanel.setBackground(new java.awt.Color(247, 247, 247));

        javax.swing.GroupLayout searchRelatedJPanelLayout = new javax.swing.GroupLayout(searchRelatedJPanel);
        searchRelatedJPanel.setLayout(searchRelatedJPanelLayout);
        searchRelatedJPanelLayout.setHorizontalGroup(
            searchRelatedJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        searchRelatedJPanelLayout.setVerticalGroup(
            searchRelatedJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchRelatedJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
                    .addComponent(graphJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(graphJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(searchRelatedJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        searchRelatedJPanel.removeAll();
        int column = 1;
        if (searchRelatedReponses.size() >= 3) {
            column = 2;
        }
        if (searchRelatedReponses.size() == 5) {
            column = 3;
        }
        searchRelatedJPanel.setLayout(new GridLayout(column, 2));
        for (int i = 0; i < searchRelatedReponses.size(); i++) {
            searchRelatedJPanel.add(new tbSearchRelatedJPanel(searchRelatedReponses.get(i)));
        }
        searchRelatedJPanel.validate();
        searchRelatedJPanel.repaint();
    }

    private void showSearchRegion() {
        DefaultTableModel regionModel = (DefaultTableModel) tbRegion.getModel();
        regionModel.addColumn("Region");
        for (int i = 0; i < searchRegionReponses.size(); i++) {
            regionModel.addColumn(searchRegionReponses.get(i).getColumn());
        }
        Object[] row = new Object[6];

        for (int i = 0; i < searchRegionReponses.get(0).getRegionReponses().size(); i++) {
            row[0] = searchRegionReponses.get(0).getRegionReponses().get(i).getName();
            row[1] = searchRegionReponses.get(0).getRegionReponses().get(i).getTotal();
            for (int j = 0; j < searchRegionReponses.get(1).getRegionReponses().size(); j++) {
                if (searchRegionReponses.get(0).getRegionReponses().get(i).getName().equalsIgnoreCase(searchRegionReponses.get(1).getRegionReponses().get(j).getName())) {
                    row[2] = searchRegionReponses.get(1).getRegionReponses().get(j).getTotal();
                }
            }
            if (searchRegionReponses.size() >= 3) {
                for (int j = 0; j < searchRegionReponses.get(2).getRegionReponses().size(); j++) {
                    if (searchRegionReponses.get(0).getRegionReponses().get(i).getName().equalsIgnoreCase(searchRegionReponses.get(2).getRegionReponses().get(j).getName())) {
                        row[3] = searchRegionReponses.get(2).getRegionReponses().get(j).getTotal();
                    }
                }
            }
            if (searchRegionReponses.size() >= 4) {
                for (int j = 0; j < searchRegionReponses.get(3).getRegionReponses().size(); j++) {
                    if (searchRegionReponses.get(0).getRegionReponses().get(i).getName().equalsIgnoreCase(searchRegionReponses.get(3).getRegionReponses().get(j).getName())) {
                        row[4] = searchRegionReponses.get(3).getRegionReponses().get(j).getTotal();
                    }
                }
            }
            if (searchRegionReponses.size() >= 5) {
                for (int j = 0; j < searchRegionReponses.get(4).getRegionReponses().size(); j++) {
                    if (searchRegionReponses.get(0).getRegionReponses().get(i).getName().equalsIgnoreCase(searchRegionReponses.get(4).getRegionReponses().get(j).getName())) {
                        row[5] = searchRegionReponses.get(4).getRegionReponses().get(j).getTotal();
                    }
                }
            }
            regionModel.addRow(row);
        }
    }
    
    private void showGraph() {
        List<String> keySearchs = new ArrayList<>();
        for (int i = 0; i < searchRelatedReponses.size(); i++) {
            keySearchs.add(searchRelatedReponses.get(i).getColunm());
        }
        graphJPanel.removeAll();
        graphJPanel.setLayout(new BorderLayout());
        graphJPanel.add(new lineGraph(keySearchs,searchOverTimeReponse));
        graphJPanel.validate();
        graphJPanel.repaint();
    }
}
