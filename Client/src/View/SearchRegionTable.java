package View;

import java.util.List;
import javalibrary.model.reponse.SearchRegionReponse;
import javax.swing.table.DefaultTableModel;

public class SearchRegionTable extends javax.swing.JPanel {

    public SearchRegionTable(List<SearchRegionReponse> searchRegionReponses) {
        initComponents();
        showSearchRegion(searchRegionReponses);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbRegion);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Region");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1212, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRegion;
    // End of variables declaration//GEN-END:variables

    private void showSearchRegion(List<SearchRegionReponse> searchRegionReponses) {
        DefaultTableModel regionModel = (DefaultTableModel) tbRegion.getModel();
        regionModel.addColumn("Region");
        for (int i = 0; i < searchRegionReponses.size(); i++) {
            regionModel.addColumn(searchRegionReponses.get(i).getColumn());
        }
        Object[] row = new Object[6];
        
        for (int i = 0; i < searchRegionReponses.get(0).getRegionReponses().size(); i++) {
            row[0] = searchRegionReponses.get(0).getRegionReponses().get(i).getName();
            row[1] = searchRegionReponses.get(0).getRegionReponses().get(i).getTotal();
            if (searchRegionReponses.size() >= 2) {
                for (int j = 0; j < searchRegionReponses.get(1).getRegionReponses().size(); j++) {
                    if (searchRegionReponses.get(0).getRegionReponses().get(i).getName().equalsIgnoreCase(searchRegionReponses.get(1).getRegionReponses().get(j).getName())) {
                        row[2] = searchRegionReponses.get(1).getRegionReponses().get(j).getTotal();
                    }
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
}
