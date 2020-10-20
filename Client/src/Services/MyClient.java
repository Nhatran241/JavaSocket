package Services;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import library.SocketTransceiver;
import library.model.Category;
import library.model.Geo;
import library.model.request.CategoriesRequest;
import library.model.request.GeoRequestCountry;
import library.model.request.SearchRequest;

public class MyClient {

    public void getGeo(IGetGeoListener i) {
        TcpClient tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {

                transceiver.send(new GeoRequestCountry());
            }

            @Override
            public void onConnectFailed() {
                System.out.println("connection failed");
            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String message) {

                System.out.println(message);
                List<Geo> geos = new ArrayList<>();

                GsonBuilder builder = new GsonBuilder();
                builder.setPrettyPrinting();

                Gson gson = builder.create();
                Type collectionType = new TypeToken<List<Geo>>() {
                }.getType();
                geos = gson.fromJson(message, collectionType);

                i.onGetGeoSuccess(geos);

            }

            @Override
            public void onDisconnect(SocketTransceiver transceiver) {
                System.out.println("disconnected");
            }

        };
        tcpClient.connect("gettrend.tk", 6060);
    }

    public void getCategory(IGetCategoryListener i) {
        TcpClient tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {

                transceiver.send(new CategoriesRequest());
            }

            @Override
            public void onConnectFailed() {
                System.out.println("connection failed");
            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String message) {

                List<Category> categorys = new ArrayList<>();
                
                String json = "[{\"id\":184,\"name\":\"Celebrities & Entertainment News\"},{\"children\":[{\"id\":1104,\"name\":\"Animated Films\"},{\"id\":317,\"name\":\"Anime & Manga\"},{\"id\":319,\"name\":\"Cartoons\"},{\"id\":318,\"name\":\"Comics\"}],\"id\":316,\"name\":\"Comics & Animation\"},{\"children\":[{\"children\":[{\"id\":1108,\"name\":\"Film & TV Awards\"},{\"id\":1117,\"name\":\"Film & TV Production\"}],\"id\":1116,\"name\":\"Film & TV Industry\"},{\"children\":[{\"id\":1113,\"name\":\"Music Awards\"},{\"id\":1114,\"name\":\"Record Labels\"}],\"id\":1115,\"name\":\"Recording Industry\"}],\"id\":612,\"name\":\"Entertainment Industry\"},{\"children\":[{\"id\":188,\"name\":\"Clubs & Nightlife\"},{\"id\":891,\"name\":\"Concerts & Music Festivals\"},{\"id\":1086,\"name\":\"Film Festivals\"},{\"id\":1273,\"name\":\"Live Sporting Events\"},{\"id\":1085,\"name\":\"Movie Listings & Theater Showtimes\"},{\"id\":614,\"name\":\"Ticket Sales\"}],\"id\":569,\"name\":\"Events & Listings\"},{\"children\":[{\"id\":1173,\"name\":\"Dress-Up & Fashion Games\"},{\"id\":447,\"name\":\"Flash-Based Entertainment\"},{\"id\":1174,\"name\":\"Fun Tests & Silly Surveys\"}],\"id\":539,\"name\":\"Fun & Trivia\"},{\"children\":[{\"id\":1095,\"name\":\"Comedy Films\"},{\"id\":895,\"name\":\"Live Comedy\"},{\"id\":1180,\"name\":\"Political Humor\"},{\"id\":1244,\"name\":\"Spoofs & Satire\"},{\"id\":1047,\"name\":\"TV Comedies\"}],\"id\":182,\"name\":\"Humor\"},{\"children\":[{\"children\":[{\"id\":1101,\"name\":\"Martial Arts Films\"},{\"id\":1100,\"name\":\"Superhero Films\"},{\"id\":1099,\"name\":\"Western Films\"}],\"id\":1097,\"name\":\"Action & Adventure Films\"},{\"id\":1104,\"name\":\"Animated Films\"},{\"id\":360,\"name\":\"Bollywood & South Asian Film\"},{\"children\":[{\"id\":1098,\"name\":\"Silent Films\"}],\"id\":1102,\"name\":\"Classic Films\"},{\"id\":1095,\"name\":\"Comedy Films\"},{\"id\":1103,\"name\":\"Cult & Indie Films\"},{\"id\":1072,\"name\":\"Documentary Films\"},{\"id\":1094,\"name\":\"Drama Films\"},{\"children\":[{\"id\":1145,\"name\":\"DVD & Video Rentals\"}],\"id\":210,\"name\":\"DVD & Video Shopping\"},{\"id\":1291,\"name\":\"Family Films\"},{\"id\":1108,\"name\":\"Film & TV Awards\"},{\"id\":1086,\"name\":\"Film Festivals\"},{\"id\":615,\"name\":\"Horror Films\"},{\"id\":213,\"name\":\"Movie Memorabilia\"},{\"children\":[{\"id\":1107,\"name\":\"Movie Reviews & Previews\"}],\"id\":1106,\"name\":\"Movie Reference\"},{\"id\":1105,\"name\":\"Musical Films\"},{\"id\":1310,\"name\":\"Romance Films\"},{\"id\":616,\"name\":\"Science Fiction & Fantasy Films\"},{\"id\":1096,\"name\":\"Thriller, Crime & Mystery Films\"}],\"id\":34,\"name\":\"Movies\"},{\"children\":[{\"id\":217,\"name\":\"CD & Audio Shopping\"},{\"children\":[{\"id\":1185,\"name\":\"Opera\"}],\"id\":586,\"name\":\"Classical Music\"},{\"id\":587,\"name\":\"Country Music\"},{\"id\":588,\"name\":\"Dance & Electronic Music\"},{\"id\":1022,\"name\":\"Experimental & Industrial Music\"},{\"id\":1023,\"name\":\"Folk & Traditional Music\"},{\"children\":[{\"id\":1040,\"name\":\"Blues\"},{\"id\":42,\"name\":\"Jazz\"}],\"id\":589,\"name\":\"Jazz & Blues\"},{\"id\":1285,\"name\":\"Latin Pop\"},{\"id\":218,\"name\":\"Music Art & Memorabilia\"},{\"id\":1087,\"name\":\"Music Education & Instruction\"},{\"children\":[{\"id\":1025,\"name\":\"DJ Resources & Equipment\"},{\"id\":1026,\"name\":\"Music Recording Technology\"},{\"children\":[{\"id\":1327,\"name\":\"Drums & Percussion\"},{\"id\":1325,\"name\":\"Guitars\"},{\"id\":1326,\"name\":\"Pianos & Keyboards\"}],\"id\":216,\"name\":\"Musical Instruments\"},{\"id\":1091,\"name\":\"Samples & Sound Libraries\"}],\"id\":1024,\"name\":\"Music Equipment & Technology\"},{\"children\":[{\"id\":1028,\"name\":\"Music Composition & Theory\"},{\"id\":892,\"name\":\"Sheet Music\"},{\"id\":617,\"name\":\"Song Lyrics & Tabs\"}],\"id\":1027,\"name\":\"Music Reference\"},{\"id\":220,\"name\":\"Music Streams & Downloads\"},{\"id\":1021,\"name\":\"Pop Music\"},{\"children\":[{\"id\":809,\"name\":\"Podcasting\"},{\"id\":1186,\"name\":\"Talk Radio\"}],\"id\":215,\"name\":\"Radio\"},{\"children\":[{\"id\":585,\"name\":\"Christian & Gospel Music\"}],\"id\":1020,\"name\":\"Religious Music\"},{\"children\":[{\"id\":1037,\"name\":\"Classic Rock & Oldies\"},{\"id\":1035,\"name\":\"Hard Rock & Progressive\"},{\"id\":1038,\"name\":\"Indie & Alternative Music\"},{\"id\":1036,\"name\":\"Metal (Music)\"},{\"id\":1041,\"name\":\"Punk (Music)\"}],\"id\":590,\"name\":\"Rock Music\"},{\"id\":893,\"name\":\"Soundtracks\"},{\"children\":[{\"id\":1030,\"name\":\"Rap & Hip-Hop\"},{\"id\":1242,\"name\":\"Reggaeton\"},{\"id\":1039,\"name\":\"Soul & R&B\"}],\"id\":592,\"name\":\"Urban & Hip-Hop\"},{\"id\":618,\"name\":\"Vocals & Show Tunes\"},{\"children\":[{\"id\":1208,\"name\":\"African Music\"},{\"id\":1034,\"name\":\"Arab & Middle Eastern Music\"},{\"id\":1033,\"name\":\"East Asian Music\"},{\"children\":[{\"id\":1287,\"name\":\"Brazilian Music\"},{\"id\":1285,\"name\":\"Latin Pop\"},{\"id\":1242,\"name\":\"Reggaeton\"},{\"id\":1286,\"name\":\"Salsa & Tropical Music\"}],\"id\":591,\"name\":\"Latin American Music\"},{\"children\":[{\"id\":1242,\"name\":\"Reggaeton\"}],\"id\":1031,\"name\":\"Reggae & Caribbean Music\"},{\"id\":1032,\"name\":\"South Asian Music\"}],\"id\":593,\"name\":\"World Music\"}],\"id\":35,\"name\":\"Music & Audio\"},{\"children\":[{\"id\":538,\"name\":\"Edgy & Bizarre\"},{\"id\":449,\"name\":\"Occult & Paranormal\"}],\"id\":33,\"name\":\"Offbeat\"},{\"children\":[{\"id\":447,\"name\":\"Flash-Based Entertainment\"},{\"id\":220,\"name\":\"Music Streams & Downloads\"},{\"children\":[{\"id\":935,\"name\":\"Massive Multiplayer\"}],\"id\":105,\"name\":\"Online Games\"},{\"children\":[{\"id\":978,\"name\":\"Photo & Image Sharing\"},{\"id\":320,\"name\":\"Photo Rating Sites\"},{\"id\":574,\"name\":\"Stock Photography\"}],\"id\":1222,\"name\":\"Online Image Galleries\"},{\"children\":[{\"id\":979,\"name\":\"Video Sharing\"}],\"id\":211,\"name\":\"Online Video\"},{\"id\":301,\"name\":\"Web Portals\"},{\"id\":575,\"name\":\"Webcams & Virtual Tours\"}],\"id\":613,\"name\":\"Online Media\"},{\"children\":[{\"id\":894,\"name\":\"Acting & Theater\"},{\"id\":1243,\"name\":\"Broadway & Musical Theater\"},{\"id\":581,\"name\":\"Dance\"},{\"id\":1185,\"name\":\"Opera\"}],\"id\":23,\"name\":\"Performing Arts\"},{\"children\":[{\"children\":[{\"id\":979,\"name\":\"Video Sharing\"}],\"id\":211,\"name\":\"Online Video\"},{\"id\":1055,\"name\":\"TV Commercials\"},{\"id\":1187,\"name\":\"TV Guides & Reference\"},{\"id\":359,\"name\":\"TV Networks & Stations\"},{\"children\":[{\"id\":1047,\"name\":\"TV Comedies\"},{\"children\":[{\"id\":1111,\"name\":\"TV Crime & Legal Shows\"},{\"id\":1194,\"name\":\"TV Medical Shows\"},{\"id\":357,\"name\":\"TV Soap Operas\"}],\"id\":1193,\"name\":\"TV Dramas\"},{\"id\":1110,\"name\":\"TV Family-Oriented Shows\"},{\"id\":1050,\"name\":\"TV Game Shows\"},{\"id\":1049,\"name\":\"TV Reality Shows\"},{\"id\":1112,\"name\":\"TV Sci-Fi & Fantasy Shows\"},{\"id\":1048,\"name\":\"TV Talk Shows\"}],\"id\":358,\"name\":\"TV Shows & Programs\"}],\"id\":36,\"name\":\"TV & Video\"},{\"children\":[{\"id\":477,\"name\":\"Architecture\"},{\"id\":1361,\"name\":\"Art & Craft Supplies\"},{\"id\":1195,\"name\":\"Arts Education\"},{\"children\":[{\"id\":1300,\"name\":\"CAD & CAM\"},{\"id\":654,\"name\":\"Graphic Design\"},{\"id\":655,\"name\":\"Industrial & Product Design\"},{\"id\":656,\"name\":\"Interior Design\"}],\"id\":653,\"name\":\"Design\"},{\"id\":1167,\"name\":\"Painting\"},{\"children\":[{\"children\":[{\"id\":1384,\"name\":\"Binoculars, Telescopes & Optical Devices\"},{\"children\":[{\"id\":308,\"name\":\"Camcorders\"},{\"id\":1383,\"name\":\"Camera Lenses\"},{\"id\":307,\"name\":\"Cameras\"}],\"id\":306,\"name\":\"Cameras & Camcorders\"}],\"id\":573,\"name\":\"Camera & Photo Equipment\"},{\"children\":[{\"id\":1315,\"name\":\"Video File Formats & Codecs\"}],\"id\":577,\"name\":\"Photo & Video Software\"}],\"id\":439,\"name\":\"Photographic & Digital Arts\"}],\"id\":24,\"name\":\"Visual Art & Design\"}]";
                JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
                String jsonArray = jsonObject.get("children").toString();
                categorys.addAll(GetGeorecursive(jsonArray));
                System.out.println(categorys);
                
//                i.onGetCategorySuccess(categorys);
            }

            @Override
            public void onDisconnect(SocketTransceiver transceiver) {
                System.out.println("disconnected");

            }

        };
        tcpClient.connect("gettrend.tk", 6060);
    }
    
    public void getSearch(IGetSearchListenner i) {
        TcpClient tcpClient = new TcpClient() {
            @Override
            public void onConnect(SocketTransceiver transceiver) {
                SearchRequest searchRequests = new SearchRequest();
                
            }

            @Override
            public void onConnectFailed() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onReceive(SocketTransceiver transceiver, String message) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onDisconnect(SocketTransceiver transceiver) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        tcpClient.connect("gettrend.tk", 6060);
    }

    public interface IGetGeoListener {

        void onGetGeoSuccess(List<Geo> geo);

        void onGetGeoFailed();
    }

    public interface IGetCategoryListener {

        void onGetCategorySuccess(List<Category> categorys);

        void onGetCategoryFailed();
    }
    
    public interface IGetSearchListenner {
        void OnGetSearchSuccess();
        void OnGetSearchFailed();
    }

    public List<Category> GetGeorecursive(String inputString) {
        List<Category> categorys = new ArrayList<>();
        JsonArray jsonArray = new JsonParser().parse(inputString).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {

            String id = jsonArray.get(i).getAsJsonObject().get("id").toString();
            String name = jsonArray.get(i).getAsJsonObject().get("name").toString();

            if (jsonArray.get(i).getAsJsonObject().get("children") != null) {
                String children = jsonArray.get(i).getAsJsonObject().get("children").toString();
                Category category = new Category(name, id, GetGeorecursive(children));
                categorys.add(category);
            } else {
                Category category = new Category(name, id);
                categorys.add(category);
            }
        }
        return categorys;
    }

}
