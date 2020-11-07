package View;

import java.util.ArrayList;
import java.util.List;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedReponse;

public class searchReponsesJPanel extends javax.swing.JPanel {

    List<SearchRegionReponse> searchRegionReponses = new ArrayList<>();
    List<SearchRelatedReponse> searchRelatedReponses = new ArrayList<>();

    public searchReponsesJPanel(List<SearchRegionReponse> searchRegionReponses, List<SearchRelatedReponse> searchRelatedReponses) {
        initComponents();
        this.searchRegionReponses = searchRegionReponses;
        this.searchRelatedReponses = searchRelatedReponses;
        showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegion = new javax.swing.JTable();

        tbRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Region", "Care"
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
        jScrollPane1.setViewportView(tbRegion);
        if (tbRegion.getColumnModel().getColumnCount() > 0) {
            tbRegion.getColumnModel().getColumn(1).setMinWidth(90);
            tbRegion.getColumnModel().getColumn(1).setPreferredWidth(120);
            tbRegion.getColumnModel().getColumn(1).setMaxWidth(140);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                .addGap(244, 244, 244))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(432, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRegion;
    // End of variables declaration//GEN-END:variables

    private void showData() {

    }
}
