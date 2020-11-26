package View;

import java.awt.GridLayout;
import java.util.List;
import javalibrary.model.request.RelatedTopicRequest;

public class ListTopicPanel extends javax.swing.JPanel {
    
    public ListTopicPanel(List<RelatedTopicRequest> relatedTopicRequests) {
        initComponents();
        initData(relatedTopicRequests);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void initData(List<RelatedTopicRequest> relatedTopicRequests) {
        jPanel1.setLayout(new GridLayout(relatedTopicRequests.size(), 1));
        for (int i = 0; i < relatedTopicRequests.size(); i++) {
            TopicPanel topicPanel = new TopicPanel();
            jPanel1.add(topicPanel);
            topicPanel.loadData(relatedTopicRequests.get(i));
        }
        jPanel1.validate();
        jPanel1.repaint();
    }
}
