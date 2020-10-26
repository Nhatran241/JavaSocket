package client;


import javalibrary.*;
import javalibrary.securedata.SecureDataManager;

import javax.crypto.Cipher;

public class MyClient {

    public static void main(String[] args) {
        TcpClient tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {
                System.out.println("Connected to"+transceiver.getInetAddress());
                transceiver.send(new String(SecureDataManager.getInstance().EncrpytMessage("Hello",transceiver.secretKey)));
                /**
                 * localhost:5000/search?q=Trump&geo=VN&cat=0&from=2019-10-6&to=2020-20-6
                 * */
//                SearchRequest searchRequest = new SearchRequest();
//                List<String> list = new ArrayList<>();
//                list.add("Trump");
//                list.add("Biden");
//                list.add("John Cena");
//                list.add("Son Tung");
//                searchRequest.setSearchQuery(list);
//                searchRequest.setGeo(new Geo("Viet Name","VN"));
//                searchRequest.setCategory(new Category("Doanh nghiep","12"));
//                Calendar c = Calendar.getInstance();
//                Date dt = new Date();
//                c.setTime(dt);
//                c.add(Calendar.YEAR, -1);
//                searchRequest.setFromDate(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
//                transceiver.send(searchRequest);
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
//                transceiver.send(new CategoriesRequest());

                /**
                 * get Suggestions keyword
                 */
//                transceiver.send(new SuggestionsKeywordRequest("trump and biden"));
                /**
                 * get Geos
                 */
//                transceiver.send(new GeoRequestCountry());
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