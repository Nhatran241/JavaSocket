package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javalibrary.model.request.RelatedTopicRequest;
import javalibrary.model.request.SearchOvertimeRequest;
import javalibrary.model.request.SearchRegionRequest;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javalibrary.model.request.SearchRelatedTopicRequest;

public class searchReponsesJPanel extends javax.swing.JPanel {

    SearchOvertimeRequest searchOvertimeRequest = new SearchOvertimeRequest();
    SearchRegionRequest searchRegionRequest = new SearchRegionRequest();
    SearchRelatedQueryRequest searchRelatedQueryRequest = new SearchRelatedQueryRequest();
    SearchRelatedTopicRequest searchRelatedTopicRequest = new SearchRelatedTopicRequest();
    RelatedTopicRequest relatedTopicRequest = new RelatedTopicRequest();

    SearchOverTimePanel searchOverTimePanel = new SearchOverTimePanel();
    SearchRelatedPanel searchRelatedPanel = new SearchRelatedPanel();
    SearchRelatedTopicPanel searchRelatedTopicPanel = new SearchRelatedTopicPanel();
    SearchRegionPanel searchRegionPanel = new SearchRegionPanel();
    TopicPanel topicPanel = new TopicPanel();

    public searchReponsesJPanel(SearchOvertimeRequest searchOvertimeRequest, SearchRegionRequest searchRegionRequest, SearchRelatedQueryRequest searchRelatedQueryRequest, SearchRelatedTopicRequest searchRelatedTopicRequest, RelatedTopicRequest relatedTopicRequest) {
        this.searchOvertimeRequest = searchOvertimeRequest;
        this.searchRegionRequest = searchRegionRequest;
        this.searchRelatedQueryRequest = searchRelatedQueryRequest;
        this.searchRelatedTopicRequest = searchRelatedTopicRequest;
        this.relatedTopicRequest = relatedTopicRequest;
        initComponents();
        initContainer1();
        initData1();
    }

    public searchReponsesJPanel(SearchOvertimeRequest searchOvertimeRequest, SearchRegionRequest searchRegionRequest, SearchRelatedQueryRequest searchRelatedQueryRequest, List<RelatedTopicRequest> relatedTopicRequests) {
        System.out.println("searchRelatedQueryRequest: " + searchRelatedQueryRequest);
        this.searchOvertimeRequest = searchOvertimeRequest;
        this.searchRegionRequest = searchRegionRequest;
        this.searchRelatedQueryRequest = searchRelatedQueryRequest;
        initComponents();
        initContainer2();
        initData2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        containerSearchOverTimePanel = new javax.swing.JPanel();
        containerSearchRelatedJPanel = new javax.swing.JPanel();
        containerSearchRelatedTopicPanel = new javax.swing.JPanel();
        containerRelatedTopicPanel = new javax.swing.JPanel();
        containerSearchRegionPanel = new javax.swing.JPanel();

        containerSearchOverTimePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout containerSearchOverTimePanelLayout = new javax.swing.GroupLayout(containerSearchOverTimePanel);
        containerSearchOverTimePanel.setLayout(containerSearchOverTimePanelLayout);
        containerSearchOverTimePanelLayout.setHorizontalGroup(
            containerSearchOverTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        containerSearchOverTimePanelLayout.setVerticalGroup(
            containerSearchOverTimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        containerSearchRelatedJPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout containerSearchRelatedJPanelLayout = new javax.swing.GroupLayout(containerSearchRelatedJPanel);
        containerSearchRelatedJPanel.setLayout(containerSearchRelatedJPanelLayout);
        containerSearchRelatedJPanelLayout.setHorizontalGroup(
            containerSearchRelatedJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
        );
        containerSearchRelatedJPanelLayout.setVerticalGroup(
            containerSearchRelatedJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerSearchRelatedTopicPanelLayout = new javax.swing.GroupLayout(containerSearchRelatedTopicPanel);
        containerSearchRelatedTopicPanel.setLayout(containerSearchRelatedTopicPanelLayout);
        containerSearchRelatedTopicPanelLayout.setHorizontalGroup(
            containerSearchRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        containerSearchRelatedTopicPanelLayout.setVerticalGroup(
            containerSearchRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        containerRelatedTopicPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout containerRelatedTopicPanelLayout = new javax.swing.GroupLayout(containerRelatedTopicPanel);
        containerRelatedTopicPanel.setLayout(containerRelatedTopicPanelLayout);
        containerRelatedTopicPanelLayout.setHorizontalGroup(
            containerRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        containerRelatedTopicPanelLayout.setVerticalGroup(
            containerRelatedTopicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        containerSearchRegionPanel.setBackground(new java.awt.Color(255, 255, 255));
        containerSearchRegionPanel.setPreferredSize(new java.awt.Dimension(786, 396));

        javax.swing.GroupLayout containerSearchRegionPanelLayout = new javax.swing.GroupLayout(containerSearchRegionPanel);
        containerSearchRegionPanel.setLayout(containerSearchRegionPanelLayout);
        containerSearchRegionPanelLayout.setHorizontalGroup(
            containerSearchRegionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        containerSearchRegionPanelLayout.setVerticalGroup(
            containerSearchRegionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(containerRelatedTopicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(containerSearchRelatedJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(containerSearchOverTimePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(containerSearchRegionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(containerSearchRelatedTopicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(containerSearchOverTimePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(containerSearchRegionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(containerSearchRelatedTopicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(containerSearchRelatedJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(containerRelatedTopicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );

        containerSearchRelatedJPanel.setMinimumSize(new Dimension(1236, 397));
        containerRelatedTopicPanel.setMinimumSize(new Dimension(1236, 397));

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
    private javax.swing.JPanel containerRelatedTopicPanel;
    private javax.swing.JPanel containerSearchOverTimePanel;
    private javax.swing.JPanel containerSearchRegionPanel;
    private javax.swing.JPanel containerSearchRelatedJPanel;
    private javax.swing.JPanel containerSearchRelatedTopicPanel;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public void initData1() {
        searchOverTimePanel.loadData(searchOvertimeRequest);
        searchRegionPanel.loadData(searchRegionRequest);
        searchRelatedPanel.loadData(searchRelatedQueryRequest);
        searchRelatedTopicPanel.loadData(searchRelatedTopicRequest);
        topicPanel.loadData(relatedTopicRequest);
    }

    private void initContainer1() {
        containerSearchOverTimePanel.setLayout(new BorderLayout());
        containerSearchOverTimePanel.add(searchOverTimePanel);
        containerSearchOverTimePanel.invalidate();

        containerSearchRegionPanel.setLayout(new BorderLayout());
        containerSearchRegionPanel.add(searchRegionPanel);
        containerSearchRegionPanel.invalidate();

        containerSearchRelatedJPanel.setLayout(new BorderLayout());
        containerSearchRelatedJPanel.add(searchRelatedPanel);
        containerSearchRelatedJPanel.invalidate();

        containerSearchRelatedTopicPanel.setLayout(new BorderLayout());
        containerSearchRelatedTopicPanel.add(searchRelatedTopicPanel);
        containerSearchRelatedTopicPanel.invalidate();
        
        containerRelatedTopicPanel.setLayout(new BorderLayout());
        containerRelatedTopicPanel.add(topicPanel);
        containerRelatedTopicPanel.invalidate();
    }

    public void initData2() {
        searchOverTimePanel.loadData(searchOvertimeRequest);
        searchRegionPanel.loadData(searchRegionRequest);
        searchRelatedPanel.loadData(searchRelatedQueryRequest);
    }

    private void initContainer2() {
        containerSearchOverTimePanel.setLayout(new BorderLayout());
        containerSearchOverTimePanel.add(searchOverTimePanel);
        containerSearchOverTimePanel.invalidate();

        containerSearchRegionPanel.setLayout(new BorderLayout());
        containerSearchRegionPanel.add(searchRegionPanel);
        containerSearchRegionPanel.invalidate();

        containerSearchRelatedJPanel.setLayout(new BorderLayout());
        containerSearchRelatedJPanel.add(searchRelatedPanel);
        containerSearchRelatedJPanel.invalidate();
    }
}
