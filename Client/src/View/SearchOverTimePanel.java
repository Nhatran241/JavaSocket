/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javalibrary.model.reponse.SearchOverTimeReponse;
import javalibrary.model.request.SearchOvertimeRequest;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author trann
 */
public class SearchOverTimePanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchOverTimePanel
     */
    JLabel loading;
    public SearchOverTimePanel() {
        initComponents();
        initUI();
    }
    public void loadData(SearchOvertimeRequest searchOvertimeRequest){
        showLoading();
        MyClient.getInstance().getSearchOvertime(searchOvertimeRequest, new Interfaces.ISearchOvertimeListener() {
            @Override
            public void OnGetSearchOvertimeSuccess(SearchOverTimeReponse searchOverTimeReponse) {
                initData(searchOvertimeRequest,searchOverTimeReponse);
                dismisLoading();


            }

            @Override
            public void OnGetSearchOvertimeFailed() {
                dismisLoading();
                showTryAgain();
                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 255, 51));

        graphPanel.setBackground(new java.awt.Color(153, 0, 153));
        graphPanel.setPreferredSize(new java.awt.Dimension(1000, 500));

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphPanel;
    // End of variables declaration//GEN-END:variables

    private void initData(SearchOvertimeRequest searchOvertimeRequest,SearchOverTimeReponse searchOverTimeReponse) {
        graphPanel.removeAll();
        graphPanel.setLayout(new BorderLayout());
        graphPanel.add(new lineGraph(searchOvertimeRequest.getSearchQuery(), searchOverTimeReponse));
        graphPanel.validate();
        graphPanel.repaint();

  }

    private void showLoading() {
        
         graphPanel.setVisible(false);
         loading.setVisible(true);
         invalidate();
    }
     
    private void dismisLoading(){
         graphPanel.setVisible(true);
         loading.setVisible(false);
         invalidate();
    
    }
    private void showTryAgain(){
    
    }
    private void onTryAgainClick(){
    
    }

    private void initUI() {
        Icon loadingImage = new ImageIcon(this.getClass().getResource("../image/goodLoading.gif"));
        loading = new JLabel(loadingImage);
        loading.setVisible(false);
        loading.setSize(200, 200);
        loading.setLocation(600, 200);
        add(loading,BorderLayout.CENTER);
    }
}