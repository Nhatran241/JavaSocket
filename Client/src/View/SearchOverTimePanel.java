package View;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import java.awt.BorderLayout;
import java.awt.Font;
import javalibrary.model.reponse.SearchOverTimeReponse;
import javalibrary.model.request.SearchOvertimeRequest;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SearchOverTimePanel extends javax.swing.JPanel {

    JLabel loading,error;
    public SearchOverTimePanel() {
        initComponents();
        initUI();
    }
    public void loadData(SearchOvertimeRequest searchOvertimeRequest){
        showLoading();
        MyClient.getInstance().getSearchOvertime(searchOvertimeRequest, new Interfaces.ISearchOvertimeListener() {
            @Override
            public void OnGetSearchOvertimeSuccess(SearchOverTimeReponse searchOverTimeReponse) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        initData(searchOvertimeRequest,searchOverTimeReponse);
                    }

                    
                }).start();
                
            }

            @Override
            public void OnGetSearchOvertimeFailed() {
                 new Thread(new Runnable() {
                    @Override
                    public void run() {
                        showError();
                    }
                }).start();
                
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphPanel = new javax.swing.JPanel();

        graphPanel.setPreferredSize(new java.awt.Dimension(1000, 500));

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphPanel;
    // End of variables declaration//GEN-END:variables

    private void initData(SearchOvertimeRequest searchOvertimeRequest, SearchOverTimeReponse searchOverTimeReponse) {
        if(searchOverTimeReponse.getOverTimeReponses()==null || searchOverTimeReponse.getOverTimeReponses().isEmpty()){
            showError();
            return;
        }else{
            dismisLoading();
            graphPanel.removeAll();
            graphPanel.setLayout(new BorderLayout());
            boolean isdayformat=true;
            boolean ishourformat=false;
            boolean ishourminuteformat=false;
            if(searchOvertimeRequest.getFromDate().contains("now1h")||searchOvertimeRequest.getFromDate().contains("now4h")
                    ||searchOvertimeRequest.getFromDate().contains("now1d")){
                ishourminuteformat=true;
                ishourformat=false;
                isdayformat =false;
            }
             if(searchOvertimeRequest.getFromDate().contains("now7d")){
                ishourminuteformat=false;
                ishourformat =true;
                isdayformat =false;
            }

            graphPanel.add(new SearchOverTimeGraph(searchOvertimeRequest.getSearchQuery(), searchOverTimeReponse,isdayformat,ishourformat,ishourminuteformat));
            graphPanel.validate();
            graphPanel.repaint();
        }

  }

    private void showLoading() {
         graphPanel.setVisible(false);
         loading.setVisible(true);
         error.setVisible(false);
    }
    private void showError() {
         graphPanel.setVisible(false);
         loading.setVisible(false);
         error.setVisible(true);
    }
    private void dismisLoading(){
         graphPanel.setVisible(true);
         loading.setVisible(false);
         error.setVisible(true);
    
    }
    
    private void onTryAgainClick(){
    
    }

    private void initUI() {
        Icon loadingImage = new ImageIcon(this.getClass().getResource("../image/goodLoading.gif"));
        loading = new JLabel(loadingImage);
        loading.setVisible(false);
        loading.setSize(200, 200);
        loading.setLocation(600, 150);
        add(loading,BorderLayout.CENTER);
        
        
        error = new JLabel("Graph No Data");
        error.setVisible(false);
        error.setSize(200, 200);
        error.setLocation(600, 150);
        error.setFont(new Font("Serif", Font.PLAIN, 30));
        add(error,BorderLayout.CENTER);
        
    }
}
