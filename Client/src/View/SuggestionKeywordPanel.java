package View;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javalibrary.model.reponse.SearchRelatedReponse;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SuggestionKeywordPanel extends javax.swing.JPanel {

    JLabel loading;

    public SuggestionKeywordPanel() {
        initComponents();
        initUI();
    }

    public void loadData(SearchRelatedQueryRequest searchRelatedQueryRequest) {
        
        showLoading();
        MyClient.getInstance().getSearchRelated(searchRelatedQueryRequest, new Interfaces.ISearchRelatedListener() {
            @Override
            public void OnGetSearchRelatedSuccess(List<SearchRelatedReponse> searchRelatedReponses) {
                System.out.println("asdasdasdasd: " + searchRelatedReponses);
                initData(searchRelatedReponses);
                dismisLoading();
            }

            @Override
            public void OnGetSearchRelatedFailed() {
                dismisLoading();
                showTryAgain();
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
            .addGap(0, 791, Short.MAX_VALUE)
        );
        searchRelatedTopicPanelLayout.setVerticalGroup(
            searchRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
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
    private void initData(List<SearchRelatedReponse> searchRelatedReponses) {
        searchRelatedTopicPanel.removeAll();
        int column = 1;
        int row = 1;
        if (searchRelatedReponses.size() >= 3) {
            column = 2;
        }
        if (searchRelatedReponses.size() == 5) {
            column = 3;
        }
        if (searchRelatedReponses.size() >= 2) {
            row = 2;
        }
        searchRelatedTopicPanel.setLayout(new GridLayout(column, row));
        for (int i = 0; i < searchRelatedReponses.size(); i++) {
            searchRelatedTopicPanel.add(new SearchRelatedTable(searchRelatedReponses.get(i)));
        }
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
        loading.setLocation(600, 100);
        add(loading, BorderLayout.CENTER);
    }
}
