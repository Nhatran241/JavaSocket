package View;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javalibrary.model.Category;
import javalibrary.model.Geo;
import javalibrary.model.request.RelatedTopicRequest;
import javalibrary.model.request.SearchOvertimeRequest;
import javalibrary.model.request.SearchRegionRequest;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javalibrary.model.request.SearchRelatedTopicRequest;
import javalibrary.model.request.SuggestionsKeywordRequest;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class searchJPanel extends javax.swing.JPanel {

    MyClient myClient = MyClient.getInstance();
    String[] dateStrings = {"The past 12 months", "Hours passed", "Last 4 hours", "Last day", "Last 7 days", "30 days", "90 days", "The past 5 years", "Custom time"};
    JLabel loading;
    public static JDialog jDialog;
    public static Date fromDate;
    public static Date toDate;
    

    public searchJPanel() {
        initComponents();
        initUI();
        showLoading();
        txSearch2.setEditable(false);
        txSearch3.setEditable(false);
        txSearch4.setEditable(false);
        txSearch5.setEditable(false);
        myClient.init(new Interfaces.IConnectListener() {
            @Override
            public void onConnectSuccess() {
                searchReponseJPanel.removeAll();
                searchReponseJPanel.validate();
                myClient.getCategory(new Interfaces.IGetCategoryListener() {
                    @Override
                    public void onGetCategorySuccess(List<Category> categorys) {

                        showcbCatetegoryData(categorys);
                        myClient.getGeo(new Interfaces.IGetGeoListener() {
                            @Override
                            public void onGetGeoSuccess(List<Geo> geo) {
                                showcbGeoData(geo);
                                dismisLoading();
                            }

                            @Override
                            public void onGetGeoFailed() {
                                dismisLoading();
                            }
                        });
                    }

                    @Override
                    public void onGetCategoryFailed() {
                        dismisLoading();
                    }
                });
            }

            @Override
            public void onConnectFailed() {
                JOptionPane.showMessageDialog(jPanel1, "Failed to connect, try to reconnect");
                showLoading();
                myClient.connect();
            }

            @Override
            public void onDisconnect() {
                JOptionPane.showMessageDialog(jPanel1, "Disconnect to server, try to reconnect");
                showLoading();
                myClient.connect();
            }
        });
        myClient.connect();
        showcbDateData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txSearch1 = new javax.swing.JTextField();
        txSearch2 = new javax.swing.JTextField();
        txSearch3 = new javax.swing.JTextField();
        txSearch4 = new javax.swing.JTextField();
        txSearch5 = new javax.swing.JTextField();
        cbCategory = new javax.swing.JComboBox<>();
        cbGeo = new javax.swing.JComboBox<>();
        searchReponseJPanel = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        cbDate = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Search:");

        txSearch1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearch1ActionPerformed(evt);
            }
        });
        txSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSearch1KeyPressed(evt);
            }
        });

        txSearch2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearch2ActionPerformed(evt);
            }
        });
        txSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSearch2KeyPressed(evt);
            }
        });

        txSearch3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txSearch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearch3ActionPerformed(evt);
            }
        });
        txSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSearch3KeyPressed(evt);
            }
        });

        txSearch4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txSearch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearch4ActionPerformed(evt);
            }
        });
        txSearch4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSearch4KeyPressed(evt);
            }
        });

        txSearch5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txSearch5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearch5ActionPerformed(evt);
            }
        });

        cbCategory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cbGeo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        searchReponseJPanel.setBackground(new java.awt.Color(247, 247, 247));

        javax.swing.GroupLayout searchReponseJPanelLayout = new javax.swing.GroupLayout(searchReponseJPanel);
        searchReponseJPanel.setLayout(searchReponseJPanelLayout);
        searchReponseJPanelLayout.setHorizontalGroup(
            searchReponseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1613, Short.MAX_VALUE)
        );
        searchReponseJPanelLayout.setVerticalGroup(
            searchReponseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSearch.setText("Enter search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cbDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchReponseJPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(txSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(cbGeo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSearch5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(searchReponseJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        searchReponseJPanel.getAccessibleContext().setAccessibleDescription("");

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

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        BtnSearch();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void txSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearch1ActionPerformed
        BtnSearch();
    }//GEN-LAST:event_txSearch1ActionPerformed

    private void txSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearch2ActionPerformed
        BtnSearch();
    }//GEN-LAST:event_txSearch2ActionPerformed

    private void txSearch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearch3ActionPerformed
        BtnSearch();
    }//GEN-LAST:event_txSearch3ActionPerformed

    private void txSearch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearch4ActionPerformed
        BtnSearch();
    }//GEN-LAST:event_txSearch4ActionPerformed

    private void txSearch5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearch5ActionPerformed
        BtnSearch();
    }//GEN-LAST:event_txSearch5ActionPerformed

    private void txSearch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearch1KeyPressed
        if (!txSearch1.getText().isEmpty()) {
            txSearch2.setEditable(true);
        } else {
            txSearch2.setText("");
            txSearch2.setEditable(false);
        }
    }//GEN-LAST:event_txSearch1KeyPressed

    private void txSearch3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearch3KeyPressed
        if (!txSearch3.getText().isEmpty()) {
            txSearch4.setEditable(true);
        } else {
            txSearch4.setText("");
            txSearch4.setEditable(false);
        }
    }//GEN-LAST:event_txSearch3KeyPressed

    private void txSearch4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearch4KeyPressed
        if (!txSearch4.getText().isEmpty()) {
            txSearch5.setEditable(true);
        } else {
            txSearch5.setText("");
            txSearch5.setEditable(false);
        }
    }//GEN-LAST:event_txSearch4KeyPressed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        BtnSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txSearch2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSearch2KeyPressed
        if (!txSearch2.getText().isEmpty()) {
            txSearch3.setEditable(true);
        } else {
            txSearch3.setText("");
            txSearch3.setEditable(false);
        }
    }//GEN-LAST:event_txSearch2KeyPressed

    private void cbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDateActionPerformed
        String cbdate = cbDate.getSelectedItem().toString();
        if (cbdate.contains("Custom time")) {
            jDialog = new JDialog();
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            panel.add(new ChooseDatePanel());
            jDialog.add(panel);
            jDialog.setSize(340, 297);
            jDialog.setLocationRelativeTo(null);
            jDialog.setVisible(true);
        }
    }//GEN-LAST:event_cbDateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbDate;
    private javax.swing.JComboBox<String> cbGeo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel searchReponseJPanel;
    public static javax.swing.JTextField txSearch1;
    public static javax.swing.JTextField txSearch2;
    public static javax.swing.JTextField txSearch3;
    public static javax.swing.JTextField txSearch4;
    public static javax.swing.JTextField txSearch5;
    // End of variables declaration//GEN-END:variables

    private void showcbGeoData(List<Geo> geos) {
        geos.forEach((geo) -> {
            cbGeo.addItem(geo.toString());
        });
        cbGeo.setSelectedItem(geos.get(0));
    }

    private void showcbCatetegoryData(List<Category> categorys) {
        categorys.forEach((category) -> {
            cbCategory.addItem(category.toString());
        });
        cbCategory.setSelectedItem(categorys.get(0));
    }

    private void showcbDateData() {
        for (String dateString : dateStrings) {
            cbDate.addItem(dateString);
        }
        cbDate.setSelectedIndex(0);
    }

    public void BtnSearch() {

        String txsearch1 = this.txSearch1.getText();
        String txsearch2 = this.txSearch2.getText();
        String txsearch3 = this.txSearch3.getText();
        String txsearch4 = this.txSearch4.getText();
        String txsearch5 = this.txSearch5.getText();

        String cbgeo = cbGeo.getSelectedItem().toString();
        cbgeo = cbgeo.split(" ")[0];
        String cbcategoty = cbCategory.getSelectedItem().toString();
        cbcategoty = cbcategoty.split(" ")[0];
        String cbdate = cbDate.getSelectedItem().toString();

        SearchRegionRequest searchRegionRequest = new SearchRegionRequest();
        SearchRelatedQueryRequest searchRelatedQueryRequest = new SearchRelatedQueryRequest();
        SearchRelatedTopicRequest searchRelatedTopicRequest = new SearchRelatedTopicRequest();
        SearchOvertimeRequest searchOvertimeRequest = new SearchOvertimeRequest();
        RelatedTopicRequest relatedTopicRequest = new RelatedTopicRequest();
        SuggestionsKeywordRequest suggestionsKeywordRequest = new SuggestionsKeywordRequest();

        List<String> listSearchs = new ArrayList<>();
        if (!txsearch1.isEmpty()) {
            listSearchs.add(txsearch1);
        }
        if (!txsearch2.isEmpty()) {
            listSearchs.add(txsearch2);
        }
        if (!txsearch3.isEmpty()) {
            listSearchs.add(txsearch3);
        }
        if (!txsearch4.isEmpty()) {
            listSearchs.add(txsearch4);
        }
        if (!txsearch5.isEmpty()) {
            listSearchs.add(txsearch5);
        }

//        Calendar c2 = Calendar.getInstance();
//        Date dt2 = new Date();
//        c2.setTime(dt2);
//        
//        searchRegionRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(c2.getTime()));
//        searchRelatedQueryRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(c2.getTime()));
//        searchRelatedTopicRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(c2.getTime()));
//        searchOvertimeRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(c2.getTime()));
        if (!txsearch1.isEmpty()) {
            searchRegionRequest.setSearchQuery(listSearchs);
            searchRelatedQueryRequest.setSearchQuery(listSearchs);
            searchRelatedTopicRequest.setSearchQuery(listSearchs);
            searchOvertimeRequest.setSearchQuery(listSearchs);
            relatedTopicRequest.setRelatedTopicQuery(listSearchs.get(0));
            relatedTopicRequest.setPageNumber(1);

            searchRegionRequest.setCategory(new Category(cbcategoty));
            searchRelatedQueryRequest.setCategory(new Category(cbcategoty));
            searchRelatedTopicRequest.setCategory(new Category(cbcategoty));
            searchOvertimeRequest.setCategory(new Category(cbcategoty));

            if (!cbgeo.equalsIgnoreCase("GLOBAL")) {
                searchRegionRequest.setGeo(new Geo(cbgeo));
                searchRelatedQueryRequest.setGeo(new Geo(cbgeo));
                searchRelatedTopicRequest.setGeo(new Geo(cbgeo));
                searchOvertimeRequest.setGeo(new Geo(cbgeo));
            }

            Calendar c = Calendar.getInstance();
            Date dt = new Date();
            c.setTime(dt);
            if (cbdate.contains("The past 12 months")) {
                c.add(Calendar.YEAR, -1);
            } else if (cbdate.contains("Hours passed")) {
                c.add(Calendar.HOUR, -1);
            } else if (cbdate.contains("Last 4 hours")) {
                c.add(Calendar.HOUR, -4);
            } else if (cbdate.contains("Last day")) {
                c.add(Calendar.HOUR, -24);
            } else if (cbdate.contains("Last 7 days")) {
                c.add(Calendar.DATE, -7);
            } else if (cbdate.contains("30 days")) {
                c.add(Calendar.DATE, -30);
            } else if (cbdate.contains("90 days")) {
                c.add(Calendar.DATE, -90);
            } else if (cbdate.contains("The past 5 years")) {
                c.add(Calendar.YEAR, -5);
            }
            
            if (cbdate.contains("Custom time")) {
                if (fromDate != null && toDate != null) {
                    
                    searchRegionRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(fromDate));
                    searchRelatedQueryRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(fromDate));
                    searchRelatedTopicRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(fromDate));
                    searchOvertimeRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(fromDate));
                    
                    searchRegionRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(toDate));
                    searchRelatedQueryRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(toDate));
                    searchRelatedTopicRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(toDate));
                    searchOvertimeRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(toDate));
                    System.out.println("fromDate + toDate: " + fromDate + "/" + toDate);
                } else {
                    cbDate.setSelectedIndex(0);
                    c.add(Calendar.YEAR, -1);
                    searchRegionRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                    searchRelatedQueryRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                    searchRelatedTopicRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                    searchOvertimeRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                }
            }

            
            if (cbdate.contains("Hours passed")) {
                searchRegionRequest.setFromDate("now1h");
                searchRelatedQueryRequest.setFromDate("now1h");
                searchRelatedTopicRequest.setFromDate("now1h");
                searchOvertimeRequest.setFromDate("now1h");
                searchRegionRequest.setToDate("");
                searchRelatedQueryRequest.setToDate("");
                searchRelatedTopicRequest.setToDate("");
                searchOvertimeRequest.setToDate("");
            } else if (cbdate.contains("Last 4 hours")) {
                searchRegionRequest.setFromDate("now4h");
                searchRelatedQueryRequest.setFromDate("now4h");
                searchRelatedTopicRequest.setFromDate("now4h");
                searchOvertimeRequest.setFromDate("now4h");
                searchRegionRequest.setToDate("");
                searchRelatedQueryRequest.setToDate("");
                searchRelatedTopicRequest.setToDate("");
                searchOvertimeRequest.setToDate("");
            } else if (cbdate.contains("Last day")) {
                searchRegionRequest.setFromDate("now1d");
                searchRelatedQueryRequest.setFromDate("now1d");
                searchRelatedTopicRequest.setFromDate("now1d");
                searchOvertimeRequest.setFromDate("now1d");
                searchRegionRequest.setToDate("");
                searchRelatedQueryRequest.setToDate("");
                searchRelatedTopicRequest.setToDate("");
                searchOvertimeRequest.setToDate("");
            } else if (cbdate.contains("Last 7 days")) {
                searchRegionRequest.setFromDate("now7d");
                searchRelatedQueryRequest.setFromDate("now7d");
                searchRelatedTopicRequest.setFromDate("now7d");
                searchOvertimeRequest.setFromDate("now7d");
                searchRegionRequest.setToDate("");
                searchRelatedQueryRequest.setToDate("");
                searchRelatedTopicRequest.setToDate("");
                searchOvertimeRequest.setToDate("");
            } else if (cbdate.contains("30 days")) {
                searchRegionRequest.setFromDate("now1m");
                searchRelatedQueryRequest.setFromDate("now1m");
                searchRelatedTopicRequest.setFromDate("now1m");
                searchOvertimeRequest.setFromDate("now1m");
                searchRegionRequest.setToDate("");
                searchRelatedQueryRequest.setToDate("");
                searchRelatedTopicRequest.setToDate("");
                searchOvertimeRequest.setToDate("");
            } else if (cbdate.contains("90 days")) {
                searchRegionRequest.setFromDate("now3m");
                searchRelatedQueryRequest.setFromDate("now3m");
                searchRelatedTopicRequest.setFromDate("now3m");
                searchOvertimeRequest.setFromDate("now3m");
                searchRegionRequest.setToDate("");
                searchRelatedQueryRequest.setToDate("");
                searchRelatedTopicRequest.setToDate("");
                searchOvertimeRequest.setToDate("");
            }
            if (txsearch2.isEmpty() && txsearch3.isEmpty() && txsearch4.isEmpty() && txsearch5.isEmpty()) {
                suggestionsKeywordRequest.setKeyword(txsearch1.toString());
                JScrollPane jScrollPane = new JScrollPane(new searchReponsesJPanel(searchOvertimeRequest, searchRegionRequest, searchRelatedQueryRequest, searchRelatedTopicRequest, relatedTopicRequest, suggestionsKeywordRequest), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                searchReponseJPanel.removeAll();
                searchReponseJPanel.setLayout(new BorderLayout());
                searchReponseJPanel.add(jScrollPane);
                searchReponseJPanel.validate();
            } else {
                JScrollPane jScrollPane = new JScrollPane(new searchReponsesJPanel(searchOvertimeRequest, searchRegionRequest, searchRelatedQueryRequest, relatedTopicRequest), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                searchReponseJPanel.removeAll();
                searchReponseJPanel.setLayout(new BorderLayout());
                searchReponseJPanel.add(jScrollPane);
                searchReponseJPanel.validate();
                searchReponseJPanel.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(jPanel1, "You have not entered keywords");
        }

    }

    private void showLoading() {

        jPanel1.setVisible(false);
        loading.setVisible(true);
        invalidate();
    }

    private void dismisLoading() {
        jPanel1.setVisible(true);
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
        loading.setLocation(600, 400);
        add(loading, BorderLayout.CENTER);

    }

}
