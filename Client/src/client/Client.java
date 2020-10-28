package client;

import Services.Interfaces.Interfaces;
import Services.Interfaces.Interfaces.IConnectListener;
import Services.MyClient;
import View.HomeJFrame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javalibrary.model.Category;
import javalibrary.model.Geo;
import javalibrary.model.reponse.RelatedTopicReponse;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.reponse.SearchRelatedTopicReponse;
import javalibrary.model.request.RelatedTopicRequest;
import javalibrary.model.request.SearchRegionRequest;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javalibrary.model.request.SearchRelatedTopicRequest;

public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeJFrame().setVisible(true);
                MyClient myClient = MyClient.getInstance();
                myClient.connect(new IConnectListener() {
                    @Override
                    public void onConnectSuccess() {
                        SearchRegionRequest searchRegionRequest = new SearchRegionRequest();
                        List<String> list = new ArrayList<>();
//                        list.add("covid-19");
//                        list.add("trump");
                        searchRegionRequest.setSearchQuery(list);
                        searchRegionRequest.setCategory(new Category("All catagories", "0"));
                        Calendar c = Calendar.getInstance();
                        Date dt = new Date();
                        c.setTime(dt);
                        c.add(Calendar.YEAR, -1);
                        searchRegionRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                        
                        SearchRelatedQueryRequest searchRelatedQueryRequest = new SearchRelatedQueryRequest();
                        searchRelatedQueryRequest.setSearchQuery(list);
                        searchRelatedQueryRequest.setCategory(new Category("All catagories", "0"));
                        searchRelatedQueryRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                        
                        SearchRelatedTopicRequest searchRelatedTopicRequest = new SearchRelatedTopicRequest();
                        searchRelatedTopicRequest.setSearchQuery(list);
                        searchRelatedTopicRequest.setCategory(new Category("All catagories", "0"));
                        searchRelatedTopicRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                        
                        RelatedTopicRequest relatedTopicRequest = new RelatedTopicRequest("trump");
                        
                        myClient.getRelatedTopic(relatedTopicRequest, new Interfaces.IRelatedTopicListener() {
                            @Override
                            public void OnGetRelatedTopicSuccess(List<RelatedTopicReponse> relatedTopicReponses) {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void OnGetRelatedTopicFailed() {
                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });
                        
//                        myClient.getSearchRelatedTopic(searchRelatedTopicRequest, new Interfaces.ISearchRelatedTopicListener() {
//                            @Override
//                            public void OnGetSearchRelatedTopicSuccess(List<SearchRelatedTopicReponse> searchRelatedTopicReponses) {
//                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                            }
//
//                            @Override
//                            public void OnGetSearchRelatedTopicFailed() {
//                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                            }
//                        });
//                        
//                        myClient.getSearchRegion(searchRegionRequest, new Interfaces.IGetSearchRegionListener() {
//                            @Override
//                            public void OnGetSearchRegionSuccess(List<SearchRegionReponse> searchRegionReponses) {
//                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                            }
//
//                            @Override
//                            public void OnGetSearchRegionFailed() {
//                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                            }
//                        });

//                        myClient.getGeo(new Interfaces.IGetGeoListener() {
//                            @Override
//                            public void onGetGeoSuccess(List<Geo> geo) {
//                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                            }
//
//                            @Override
//                            public void onGetGeoFailed() {
//                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                            }
//                        });

//                        myClient.getCategory(new Interfaces.IGetCategoryListener() {
//                            @Override
//                            public void onGetCategorySuccess(List<Category> categorys) {
//                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                            }
//
//                            @Override
//                            public void onGetCategoryFailed() {
//                                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                            }
//                        });
                    }

                    @Override
                    public void onConnectFailed() {
                    }

                    @Override
                    public void onDisconnect() {
                    }
                });
            }
        });
    }
}
