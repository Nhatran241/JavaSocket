package View;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import java.awt.BorderLayout;
import java.util.List;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javalibrary.model.request.SearchRelatedTopicRequest;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SearchRelatedTopicPanel extends javax.swing.JPanel {

    JLabel loading;

    public SearchRelatedTopicPanel() {
        initComponents();
        initUI();
    }

    public void loadData(SearchRelatedTopicRequest searchRelatedTopicRequest) {
        showLoading();
        MyClient.getInstance().getSearchRelatedTopic(searchRelatedTopicRequest, new Interfaces.ISearchRelatedTopicListener() {
            @Override
            public void OnGetSearchRelatedTopicSuccess(List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
                 new Thread(new Runnable() {
                    @Override
                    public void run() {
                        initData(searchRelatedTopicRequest.getSearchQuery().get(0), searchRelatedTopicReponses);
                        dismisLoading();
                    }
                }).start();
                
            }

            @Override
            public void OnGetSearchRelatedTopicFailed() {
                 new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dismisLoading();
                        showTryAgain();
                    }
                }).start();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchRelatedTopicPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout searchRelatedTopicPanelLayout = new javax.swing.GroupLayout(searchRelatedTopicPanel);
        searchRelatedTopicPanel.setLayout(searchRelatedTopicPanelLayout);
        searchRelatedTopicPanelLayout.setHorizontalGroup(
            searchRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        searchRelatedTopicPanelLayout.setVerticalGroup(
            searchRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel searchRelatedTopicPanel;
    // End of variables declaration//GEN-END:variables

    private void initData(String keyString, List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
        searchRelatedTopicPanel.removeAll();
        searchRelatedTopicPanel.setLayout(new BorderLayout());
        searchRelatedTopicPanel.add(new SearchRelatedTopicTable(keyString, searchRelatedTopicReponses));
        searchRelatedTopicPanel.validate();
        searchRelatedTopicPanel.repaint();

    }

    private void showLoading() {

        searchRelatedTopicPanel.setVisible(false);
        loading.setVisible(true);
        invalidate();
    }

    private void dismisLoading() {
        searchRelatedTopicPanel.setVisible(true);
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
        loading.setLocation(250, 150);
        add(loading, BorderLayout.CENTER);
    }
}
