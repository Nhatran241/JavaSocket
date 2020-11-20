package View;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javalibrary.model.reponse.RelatedTopicReponse;
import javax.swing.JPanel;

public class listRelatedTopicJPanel extends javax.swing.JPanel {

    List<RelatedTopicReponse> relatedTopicReponses = new ArrayList<>();
    String column;

    public listRelatedTopicJPanel(List<RelatedTopicReponse> relatedTopicReponses, String column) {
        initComponents();
        this.relatedTopicReponses = relatedTopicReponses;
        this.column = column;
        showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reladtedTopicJPanel = new javax.swing.JPanel();
        name = new javax.swing.JLabel();

        javax.swing.GroupLayout reladtedTopicJPanelLayout = new javax.swing.GroupLayout(reladtedTopicJPanel);
        reladtedTopicJPanel.setLayout(reladtedTopicJPanelLayout);
        reladtedTopicJPanelLayout.setHorizontalGroup(
            reladtedTopicJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        reladtedTopicJPanelLayout.setVerticalGroup(
            reladtedTopicJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        name.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reladtedTopicJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(name)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(reladtedTopicJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel name;
    private javax.swing.JPanel reladtedTopicJPanel;
    // End of variables declaration//GEN-END:variables

    private void showData() {
        name.setText("Related topic of " + column);
        int size = relatedTopicReponses.size();
        System.out.println("size: " + size);
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(size, 1));
        for (int i = 0; i < size; i++) {
            if (!relatedTopicReponses.get(i).getTitle().isEmpty() && !relatedTopicReponses.get(i).getUrl().isEmpty()) {
                jpanel.add(new RelatedTopicJPanel(relatedTopicReponses.get(i)));
            }
        }
        reladtedTopicJPanel.removeAll();
        reladtedTopicJPanel.setLayout(new GridLayout());
        reladtedTopicJPanel.add(jpanel);
        reladtedTopicJPanel.validate();
        reladtedTopicJPanel.repaint();
    }
}
