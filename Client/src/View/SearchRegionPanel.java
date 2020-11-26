package View;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import java.awt.BorderLayout;
import java.util.List;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.request.SearchRegionRequest;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SearchRegionPanel extends javax.swing.JPanel {

    JLabel loading;

    public SearchRegionPanel() {
        initComponents();
        initUI();
    }

    public void loadData(SearchRegionRequest searchRegionRequest) {
        showLoading();
        MyClient.getInstance().getSearchRegion(searchRegionRequest, new Interfaces.IGetSearchRegionListener() {
            @Override
            public void OnGetSearchRegionSuccess(List<SearchRegionReponse> searchRegionReponses) {
                dismisLoading();
                initData(searchRegionReponses);
            }

            @Override
            public void OnGetSearchRegionFailed() {
                dismisLoading();
                showTryAgain();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchRegionPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegion = new javax.swing.JTable();

        tbRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbRegion);

        javax.swing.GroupLayout searchRegionPanelLayout = new javax.swing.GroupLayout(searchRegionPanel);
        searchRegionPanel.setLayout(searchRegionPanelLayout);
        searchRegionPanelLayout.setHorizontalGroup(
            searchRegionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
        );
        searchRegionPanelLayout.setVerticalGroup(
            searchRegionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchRegionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchRegionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel searchRegionPanel;
    private javax.swing.JTable tbRegion;
    // End of variables declaration//GEN-END:variables

    private void initData(List<SearchRegionReponse> searchRegionReponses) {
        searchRegionPanel.removeAll();
        searchRegionPanel.setLayout(new BorderLayout());
        searchRegionPanel.add(new SearchRegionTable(searchRegionReponses));
        searchRegionPanel.validate();
        searchRegionPanel.repaint();

    }

    private void showLoading() {

        searchRegionPanel.setVisible(false);
        loading.setVisible(true);
        invalidate();
    }

    private void dismisLoading() {
        searchRegionPanel.setVisible(true);
        loading.setVisible(false);
        invalidate();

    }

    private void showTryAgain() {

    }

    private void onTryAgainClick() {

    }

    private void initUI() {
        Icon loadingImage = new ImageIcon(this.getClass().getResource("../image/goodLoading.gif"));
        loading = new JLabel(loadingImage);
        loading.setVisible(false);
        loading.setSize(200, 200);
        loading.setLocation(600, 90);
        add(loading, BorderLayout.CENTER);
    }

}
