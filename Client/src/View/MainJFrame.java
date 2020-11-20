package View;

import View.bean.MenuBean;
import View.controller.TransferView;
import java.util.ArrayList;
import java.util.List;

public class MainJFrame extends javax.swing.JFrame {
    
    public MainJFrame() {
        initComponents();
        setTitle("Google Trends");
        
        TransferView transferView = new TransferView(viewjPanel);
        transferView.setView(searchjPanel, searchjLabel);
        
        List<MenuBean> listItem = new ArrayList<>();
        listItem.add(new MenuBean("search", searchjPanel, searchjLabel));
        transferView.setEvent(listItem);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainjPanel = new javax.swing.JPanel();
        menujPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        searchjPanel = new javax.swing.JPanel();
        searchjLabel = new javax.swing.JLabel();
        viewjPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menujPanel.setBackground(new java.awt.Color(66, 133, 244));

        jPanel11.setBackground(new java.awt.Color(255, 102, 102));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_ratings_50px.png"))); // NOI18N
        jLabel9.setText("Google Trends");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        searchjPanel.setBackground(new java.awt.Color(66, 133, 244));
        searchjPanel.setForeground(new java.awt.Color(255, 255, 255));

        searchjLabel.setBackground(new java.awt.Color(66, 133, 244));
        searchjLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchjLabel.setForeground(new java.awt.Color(255, 255, 255));
        searchjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_25px.png"))); // NOI18N
        searchjLabel.setText("Search ");

        javax.swing.GroupLayout searchjPanelLayout = new javax.swing.GroupLayout(searchjPanel);
        searchjPanel.setLayout(searchjPanelLayout);
        searchjPanelLayout.setHorizontalGroup(
            searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchjPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(searchjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        searchjPanelLayout.setVerticalGroup(
            searchjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchjPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(searchjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout menujPanelLayout = new javax.swing.GroupLayout(menujPanel);
        menujPanel.setLayout(menujPanelLayout);
        menujPanelLayout.setHorizontalGroup(
            menujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menujPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        menujPanelLayout.setVerticalGroup(
            menujPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menujPanelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(searchjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 759, Short.MAX_VALUE))
        );

        viewjPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout viewjPanelLayout = new javax.swing.GroupLayout(viewjPanel);
        viewjPanel.setLayout(viewjPanelLayout);
        viewjPanelLayout.setHorizontalGroup(
            viewjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1415, Short.MAX_VALUE)
        );
        viewjPanelLayout.setVerticalGroup(
            viewjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainjPanelLayout = new javax.swing.GroupLayout(mainjPanel);
        mainjPanel.setLayout(mainjPanelLayout);
        mainjPanelLayout.setHorizontalGroup(
            mainjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainjPanelLayout.createSequentialGroup()
                .addComponent(menujPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainjPanelLayout.setVerticalGroup(
            mainjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menujPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel mainjPanel;
    private javax.swing.JPanel menujPanel;
    private javax.swing.JLabel searchjLabel;
    private javax.swing.JPanel searchjPanel;
    private javax.swing.JPanel viewjPanel;
    // End of variables declaration//GEN-END:variables
}
