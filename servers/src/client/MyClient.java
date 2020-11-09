package client;


import javalibrary.*;
import javalibrary.model.request.*;
import javalibrary.securedata.SecureDataManager;

import javax.crypto.Cipher;
import javalibrary.model.Category;
import javalibrary.model.Geo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyClient {

    public static void main(String[] args) {
        TcpClient tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {
                System.out.println("Connected to"+transceiver.getInetAddress());
//                transceiver.send("Hello serrver việt nam");
                /**
                 * localhost:5000/search?q=Trump&geo=VN&cat=0&from=2019-10-6&to=2020-20-6
                 * */
                SearchRelatedTopicRequest searchRegionRequest = new SearchRelatedTopicRequest();
                List<String> list = new ArrayList<>();
                list.add("trump");
                searchRegionRequest.setSearchQuery(list);
//                searchRegionRequest.setCategory(new Category("na","45"));
//                searchRegionRequest.setGeo(new Geo("vn","VN"));
                Calendar c = Calendar.getInstance();
                Date dt = new Date();
                c.setTime(dt);
                c.add(Calendar.MONTH, -1);
                searchRegionRequest.setToDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                c.add(Calendar.MONTH, -2);
                searchRegionRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
                transceiver.sendWithEncrypt(searchRegionRequest);
                /**
                * localhost:5000/search?q=Trump&geo=VN&cat=19&from=2019-10-6&to=2020-20-6
                */
//                SearchRequest searchRequest = new SearchRequest();
//                searchRequest.setSearchQuery("Trump");
//                searchRequest.setGeo(new Geo("Viet Name","VN"));
//                searchRequest.setCategory(new Category("Pháp luật chính trị","19"));
//                Calendar c = Calendar.getInstance();
//                Date dt = new Date();
//                c.setTime(dt);
//                c.add(Calendar.YEAR, -1);
//                searchRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
//                transceiver.send(searchRequest);

                /**
                 * get Categories
                 */
//                transceiver.sendWithEncrypt(new CategoriesRequest());

                /**
                 * get Suggestions keyword
                 */
//                transceiver.send(new SuggestionsKeywordRequest("trump and biden"));
                /**
                 * get Geos
                 */
//                transceiver.sendWithEncrypt(new GeoRequestCountry());

//                RelatedTopicRequest relatedTopicRequest = new RelatedTopicRequest();
//                relatedTopicRequest.setRelatedTopicQuery("Lien minh");
//                transceiver.send(relatedTopicRequest);
            }


            @Override
            public void onConnectFailed() {
                System.out.println("connection failed");
            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String message) {
                System.out.println(message);
            }


            @Override
            public void onDisconnect(SocketTransceiver transceiver) {
                System.out.println("disconnected");

            }
        };
        tcpClient.connect("localhost",6060);

    }

}  