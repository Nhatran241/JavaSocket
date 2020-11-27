package View;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javalibrary.model.reponse.SuggesstionKeywordResponse;
import javalibrary.model.request.SuggestionsKeywordRequest;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SuggestionKeywordPanel extends javax.swing.JPanel {

    JLabel loading;

    public SuggestionKeywordPanel() {
        initComponents();
        initUI();
    }

    public void loadData(SuggestionsKeywordRequest suggestionsKeywordRequest) {
        showLoading();
        MyClient.getInstance().getSuggestionKeyword(suggestionsKeywordRequest, new Interfaces.ISuggestionKeywordListener() {
            @Override
            public void OnGetSuggestionKeywordSuccess(SuggesstionKeywordResponse suggesstionKeywordResponse) {
               
                 new Thread(new Runnable() {
                    @Override
                    public void run() {
                            initData(suggesstionKeywordResponse);
                            dismisLoading();
                    }
                }).start();
            }

            @Override
            public void OnGetSuggestionKeywordFailed() {
                    
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

        suggestionKeywordPanel = new javax.swing.JPanel();

        suggestionKeywordPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout suggestionKeywordPanelLayout = new javax.swing.GroupLayout(suggestionKeywordPanel);
        suggestionKeywordPanel.setLayout(suggestionKeywordPanelLayout);
        suggestionKeywordPanelLayout.setHorizontalGroup(
            suggestionKeywordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );
        suggestionKeywordPanelLayout.setVerticalGroup(
            suggestionKeywordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(suggestionKeywordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(suggestionKeywordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel suggestionKeywordPanel;
    // End of variables declaration//GEN-END:variables
    private void initData(SuggesstionKeywordResponse suggesstionKeywordResponse) {
        suggestionKeywordPanel.removeAll();
        suggestionKeywordPanel.setLayout(new BorderLayout());
        suggestionKeywordPanel.add(new SuggestionKeywordTable(suggesstionKeywordResponse));
        suggestionKeywordPanel.validate();
        suggestionKeywordPanel.repaint();
    }

    private void showLoading() {

        suggestionKeywordPanel.setVisible(false);
        loading.setVisible(true);
        invalidate();
    }

    private void dismisLoading() {
        suggestionKeywordPanel.setVisible(true);
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
