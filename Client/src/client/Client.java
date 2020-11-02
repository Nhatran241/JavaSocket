package client;

import Services.Interfaces.Interfaces;
import Services.MyClient;
import View.MainJFrame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javalibrary.model.Category;
import javalibrary.model.reponse.SearchRegionReponse;
import javalibrary.model.request.SearchRegionRequest;
import javalibrary.model.request.SearchRelatedQueryRequest;
import javalibrary.model.request.SearchRelatedTopicRequest;
import javax.swing.UIManager;

public class Client {

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
                MyClient myClient = MyClient.getInstance();
                myClient.connect(new Interfaces.IConnectListener() {
                    @Override
                    public void onConnectSuccess() {
                        SearchRegionRequest searchRegionRequest = new SearchRegionRequest();
                        List<String> list = new ArrayList<>();
                        list.add("trump");
                        list.add("covid19");
                        searchRegionRequest.setSearchQuery(list);
                        searchRegionRequest.setCategory(new Category("0"));
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

                        myClient.getSearchRegion(searchRegionRequest, new Interfaces.IGetSearchRegionListener() {
                            @Override
                            public void OnGetSearchRegionSuccess(List<SearchRegionReponse> searchRegionReponses) {
                            }

                            @Override
                            public void OnGetSearchRegionFailed() {
                            }
                        });
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
