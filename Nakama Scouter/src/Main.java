import Models.AnimeManga;
import Models.City;
import Models.Restaurant;
import db.UserDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        //Black Box testing (comment out if it's to be skipped)
        blackBoxTest();
        //Testing The GUI
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Scene scene = new Scene(root, 1028, 579);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Welcome to Nakama Scouter");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method for testing every individual aspect of Nakama Scouter by comparing expected outputs with
     * the actual output.
     */
    public static void blackBoxTest() {

        //UserDatabase userDB = new UserDatabase();

        //Edge Case
//        //City city = City.loadCityResultsByAddress("1600PennsylvaniaAveNW,WashingtonDC");
//        //List<String> restSearchQuery = new ArrayList<>();
//        //restSearchQuery.add(city.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
//        //restSearchQuery.add(city.getLongitude()); //MUST STAY LONGITUDE
//        //restSearchQuery.add("30"); //MUST STAY DISTANCE
//        //restSearchQuery.add("Japanese"); //MUST STAY CUISINE
//        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
//        String nameExpected = "[Geisha Sushi Bar, Teaism Lafayette Park, Wasabi Sushi, Cafe Asia, Lotus, Tokyo In The City, Sushi Express, Kaz Sushi Bistro, Sushi Aoi, Sushi Express, Cha, Zentan, Suki Asia, Oh Fish, Asia Nine Bar & Lounge, Panda Cafe, Nagomi Izakaya, Oya, Sizzling Express, Teaism Penn Quarter, Tsunami Sushi & Lounge, Teak Wood Thai Restaurant & Sushi Bar, Sushi Go Round, Sei, Sushi Taro]";
//        blackBoxCompare(rest.getNameList(), nameExpected);
//        String priceExpected = "[, $$, , $$, , $$, $, , $$$, $, $$, $, , $, $, $$, $$, $$, $$$, $$, $$$, $$$, $$, $, $]";
//        blackBoxCompare(rest.getPriceRangeList(), priceExpected);
//        String phoneExpected = "[(202) 347-3887, (202) 667-3827, (202) 822-2005, (202) 659-2696, (202) 289-4222, , (202) 393-2292, (202) 530-5500, (202) 408-7770, (202) 659-1955, (202) 737-1200, (202) 379-4366, (202) 223-1337, (202) 223-1818, (202) 629-4355, (202) 337-9119, (202) 525-4016, (202) 393-1400, (202) 659-1234, (202) 638-6010, (202) 588-5889, (202) 290-1856, (202) 393-2825, (202) 783-7007, (202) 462-8999]";
//        blackBoxCompare(rest.getPhoneList(), phoneExpected);
//        String idExpected = "[3889924077033477, 3890046877038536, 3890143277039450, 3890100477040476, 3890225777032968, 3889784777029590, 3890301277033776, 3890154477044256, 3890025777027588, 3890188777044502, 3890461877031949, 3890502377031740, 3890588077039482, 3890463977043440, 3889659577024872, 3890165777048156, 3890543477044571, 3889951077023480, 3889637477050305, 3889515877023001, 3890803377032136, 3890798877031534, 3889851677021915, 3889573177022068, 3891007477038381]";
//        blackBoxCompare(rest.getIdList(), idExpected);

//        //Error Case
//        City city = City.loadCityResultsByAddress("NC, USA");
//        List<String> restSearchQuery = new ArrayList<>();
//        restSearchQuery.add(city.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
//        restSearchQuery.add(city.getLongitude()); //MUST STAY LONGITUDE
//        restSearchQuery.add("30"); //MUST STAY DISTANCE
//        restSearchQuery.add("Japanese"); //MUST STAY CUISINE
//        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
//        String nameExpected = "[Geisha Sushi Bar, Teaism Lafayette Park, Wasabi Sushi, Cafe Asia, Lotus, Tokyo In The City, Sushi Express, Kaz Sushi Bistro, Sushi Aoi, Sushi Express, Cha, Zentan, Suki Asia, Oh Fish, Asia Nine Bar & Lounge, Panda Cafe, Nagomi Izakaya, Oya, Sizzling Express, Teaism Penn Quarter, Tsunami Sushi & Lounge, Teak Wood Thai Restaurant & Sushi Bar, Sushi Go Round, Sei, Sushi Taro]";
//        blackBoxCompare(rest.getNameList(), nameExpected);
//        String priceExpected = "[, $$, , $$, , $$, $, , $$$, $, $$, $, , $, $, $$, $$, $$, $$$, $$, $$$, $$$, $$, $, $]";
//        blackBoxCompare(rest.getPriceRangeList(), priceExpected);
//        String phoneExpected = "[(202) 347-3887, (202) 667-3827, (202) 822-2005, (202) 659-2696, (202) 289-4222, , (202) 393-2292, (202) 530-5500, (202) 408-7770, (202) 659-1955, (202) 737-1200, (202) 379-4366, (202) 223-1337, (202) 223-1818, (202) 629-4355, (202) 337-9119, (202) 525-4016, (202) 393-1400, (202) 659-1234, (202) 638-6010, (202) 588-5889, (202) 290-1856, (202) 393-2825, (202) 783-7007, (202) 462-8999]";
//        blackBoxCompare(rest.getPhoneList(), phoneExpected);
//        String idExpected = "[3889924077033477, 3890046877038536, 3890143277039450, 3890100477040476, 3890225777032968, 3889784777029590, 3890301277033776, 3890154477044256, 3890025777027588, 3890188777044502, 3890461877031949, 3890502377031740, 3890588077039482, 3890463977043440, 3889659577024872, 3890165777048156, 3890543477044571, 3889951077023480, 3889637477050305, 3889515877023001, 3890803377032136, 3890798877031534, 3889851677021915, 3889573177022068, 3891007477038381]";
//        blackBoxCompare(rest.getIdList(), idExpected);

        //normal case
//        City city = City.loadCityResultsByAddress("1600 PennsylvaniaAve NW, Washington DC");
//        List<String> restSearchQuery = new ArrayList<>();
//        restSearchQuery.add(city.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
//        restSearchQuery.add(city.getLongitude()); //MUST STAY LONGITUDE
//        restSearchQuery.add("30"); //MUST STAY DISTANCE
//        restSearchQuery.add("Japanese"); //MUST STAY CUISINE
//        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
//        String nameExpected = "[Geisha Sushi Bar, Teaism Lafayette Park, Wasabi Sushi, Cafe Asia, Lotus, Tokyo In The City, Sushi Express, Kaz Sushi Bistro, Sushi Aoi, Sushi Express, Cha, Zentan, Suki Asia, Oh Fish, Asia Nine Bar & Lounge, Panda Cafe, Nagomi Izakaya, Oya, Sizzling Express, Teaism Penn Quarter, Tsunami Sushi & Lounge, Teak Wood Thai Restaurant & Sushi Bar, Sushi Go Round, Sei, Sushi Taro]";
//        blackBoxCompare(rest.getNameList(), nameExpected);
//        String priceExpected = "[, $$, , $$, , $$, $, , $$$, $, $$, $, , $, $, $$, $$, $$, $$$, $$, $$$, $$$, $$, $, $]";
//        blackBoxCompare(rest.getPriceRangeList(), priceExpected);
//        String phoneExpected = "[(202) 347-3887, (202) 667-3827, (202) 822-2005, (202) 659-2696, (202) 289-4222, , (202) 393-2292, (202) 530-5500, (202) 408-7770, (202) 659-1955, (202) 737-1200, (202) 379-4366, (202) 223-1337, (202) 223-1818, (202) 629-4355, (202) 337-9119, (202) 525-4016, (202) 393-1400, (202) 659-1234, (202) 638-6010, (202) 588-5889, (202) 290-1856, (202) 393-2825, (202) 783-7007, (202) 462-8999]";
//        blackBoxCompare(rest.getPhoneList(), phoneExpected);
//        String idExpected = "[3889924077033477, 3890046877038536, 3890143277039450, 3890100477040476, 3890225777032968, 3889784777029590, 3890301277033776, 3890154477044256, 3890025777027588, 3890188777044502, 3890461877031949, 3890502377031740, 3890588077039482, 3890463977043440, 3889659577024872, 3890165777048156, 3890543477044571, 3889951077023480, 3889637477050305, 3889515877023001, 3890803377032136, 3890798877031534, 3889851677021915, 3889573177022068, 3891007477038381]";
//        blackBoxCompare(rest.getIdList(), idExpected);

        //normal case
//        City city = City.loadCityResultsByAddress("938 Bugshop Rd, Princeton, NC");
//        List<String> restSearchQuery = new ArrayList<>();
//        restSearchQuery.add(city.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
//        restSearchQuery.add(city.getLongitude()); //MUST STAY LONGITUDE
//        restSearchQuery.add("30"); //MUST STAY DISTANCE
//        restSearchQuery.add("Japanese"); //MUST STAY CUISINE
//        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
//        System.out.println(rest.getNameList());
//        String nameExpected = "[Bonsai's, Yamato Japanese]";
//        blackBoxCompare(rest.getNameList(), nameExpected);
//        System.out.println(rest.getPriceRangeList());
//        String priceExpected = "[$$, $$]";
//        blackBoxCompare(rest.getPriceRangeList(), priceExpected);
//        System.out.println(rest.getPhoneList());
//        String phoneExpected = "[(919) 550-6030, (919) 266-5557]";
//        blackBoxCompare(rest.getPhoneList(), phoneExpected);
//        System.out.println(rest.getIdList());
//        String idExpected = "[3565400678474055, 3579830378491575]";
//        blackBoxCompare(rest.getIdList(), idExpected);

        //Edge case
//        City city = City.loadCityResultsByAddress("938 Bugshop Rd, Princeton, NC");
//        List<String> restSearchQuery = new ArrayList<>();
//        restSearchQuery.add(city.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
//        restSearchQuery.add(city.getLongitude()); //MUST STAY LONGITUDE
//        restSearchQuery.add("-30"); //MUST STAY DISTANCE //edge
//        restSearchQuery.add("Japanese"); //MUST STAY CUISINE
//        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
//        System.out.println(rest.getNameList());
//        String nameExpected = "[]";
//        blackBoxCompare(rest.getNameList(), nameExpected);
//        System.out.println(rest.getPriceRangeList());
//        String priceExpected = "[]";
//        blackBoxCompare(rest.getPriceRangeList(), priceExpected);
//        System.out.println(rest.getPhoneList());
//        String phoneExpected = "[]";
//        blackBoxCompare(rest.getPhoneList(), phoneExpected);
//        System.out.println(rest.getIdList());
//        String idExpected = "[]";
//        blackBoxCompare(rest.getIdList(), idExpected);
//

//
//        //Testing AnimeManga API
//        String type = "anime";
//        String genre1 = "1";
//        String genre2 = "10";
//        String genre3 = "4";
//        String orderBy = "start_date";
//        String sort = "desc";
//        //put this into a method for user preferences or search etc.
//        List<String> searchQuery = new ArrayList<>();
//        searchQuery.add(type); // TYPE MUST ALWAYS BE FIRST FOR URL TO WORK PROPERLY
//        searchQuery.add(genre1);
//        searchQuery.add(genre2);
//        searchQuery.add(genre3);
//        searchQuery.add(orderBy);
//        searchQuery.add(sort);
//        //AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch(type,  genre1, genre2, genre3,  orderBy, sort);
//        AnimeManga animeSearch = AnimeManga.loadAnimeMangaDataBySearch(searchQuery);
//        System.out.println(animeSearch.getTitleList().get(1));
//        //System.out.println(animeData);
//        //AnimeManga animeRatingByID = AnimeManga.loadAnimeMangaRatingByID(id);
//        //System.out.println("Anime Search Get Title: " + animeSearch.getTitle()); //Returns JSON File
//        //System.out.println(animeRatingByID.getRating());

        //edge
//        String type = "anime";
//        String genre1 = "-1"; //negative works fine
//        String genre2 = "10";
//        String genre3 = "4";
//        String orderBy = "start_date";
//        String sort = "desc";
//        //put this into a method for user preferences or search etc.
//        List<String> searchQuery = new ArrayList<>();
//        searchQuery.add(type); // TYPE MUST ALWAYS BE FIRST FOR URL TO WORK PROPERLY
//        searchQuery.add(genre1);
//        searchQuery.add(genre2);
//        searchQuery.add(genre3);
//        searchQuery.add(orderBy);
//        searchQuery.add(sort);
//        //AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch(type,  genre1, genre2, genre3,  orderBy, sort);
//        AnimeManga animeSearch = AnimeManga.loadAnimeMangaDataBySearch(searchQuery);
//        System.out.print(animeSearch.getImageUrlList());
//        String imageurlExpected = "[https://cdn.myanimelist.net/images/anime/1978/111973.jpg?s=611c7f900ef12f49707e02b5d7435bb4, https://cdn.myanimelist.net/images/anime/1407/111469.jpg?s=57f3024519667ef0d0fd15beeea628c1, https://cdn.myanimelist.net/images/anime/1449/112524.jpg?s=364294ec1a272f2a6a6bd39e6f55db92, https://cdn.myanimelist.net/images/anime/1436/106694.jpg?s=d395802efdb5b4a093f094f0090b7a07, https://cdn.myanimelist.net/images/anime/1193/113571.jpg?s=db662e014f9abdbe8ab0012970ba0a47, https://cdn.myanimelist.net/images/anime/1340/110088.jpg?s=ee67671d1f7730716efef5ba82681170, https://cdn.myanimelist.net/images/anime/1632/111141.jpg?s=2bdb023b6d20d6156ebd1fd6211fab2a, https://cdn.myanimelist.net/images/anime/1250/113680.jpg?s=32b77522dbf532c392bbac6857fa3adb, https://cdn.myanimelist.net/images/anime/1832/113529.jpg?s=a2f90d12986df45d9f33cb6cb03c515d, https://cdn.myanimelist.net/images/anime/1236/113727.jpg?s=83919aa2db778f788cb7b7664b802a59, https://cdn.myanimelist.net/images/anime/1482/110975.jpg?s=ee94ef31b46ea2f9578b288031110906, https://cdn.myanimelist.net/images/anime/1759/112402.jpg?s=a70bf4bfd28eac298b44689585a33178, https://cdn.myanimelist.net/images/anime/1243/106941.jpg?s=0d9ead9b55a8b462f5a4e692178527c3, https://cdn.myanimelist.net/images/anime/1559/110932.jpg?s=f254a22636b01e9fe625f7a5ba6bf5a2, https://cdn.myanimelist.net/images/anime/1767/110800.jpg?s=6db995d25948c48a6eeacfce26862794, https://cdn.myanimelist.net/images/anime/1527/113656.jpg?s=d48b6493a410e438c17fd8f6f838839b, https://cdn.myanimelist.net/images/anime/1011/111811.jpg?s=a598178907d1e1e578e91cdb2087abfb, https://cdn.myanimelist.net/images/anime/1827/107735.jpg?s=97c13a9106c18f1fb843e3e0183b5974, https://cdn.myanimelist.net/images/anime/1641/113723.jpg?s=dddf6ae4cfb0c654c188df83d63ed64c, https://cdn.myanimelist.net/images/anime/1011/113703.jpg?s=aa0805cfd63960669c770e08be9426d0, https://cdn.myanimelist.net/images/anime/1357/113277.jpg?s=e897e976e0f5ba1a43304bf56d977bcc, https://cdn.myanimelist.net/images/anime/1263/112268.jpg?s=c7dd5d1ef528ab602c1c70a4eb3f3c17, https://cdn.myanimelist.net/images/anime/1262/113705.jpg?s=d44cdbe0f8886f477cf83fe1e0510e15, https://cdn.myanimelist.net/images/anime/1876/114021.jpg?s=74962e6aeb030c39ed580d0ef5594749, https://cdn.myanimelist.net/images/anime/1378/113506.jpg?s=1fbc8e3379612b3493c94303a22715ec, https://cdn.myanimelist.net/images/anime/1298/113966.jpg?s=111b0344c5c28fe46692bf7fdd61fc61, https://cdn.myanimelist.net/images/anime/1655/111767.jpg?s=13665af0fc602b3dfd0ca6c27a823ac9, https://cdn.myanimelist.net/images/anime/1973/109541.jpg?s=f930103819566171a52ae1f687d5dd37, https://cdn.myanimelist.net/images/anime/1271/109841.jpg?s=8abec65944244475ed90db5cf43e3c7a, https://cdn.myanimelist.net/images/anime/1736/111113.jpg?s=e799d29f7869e9120fb10a1c87787df0, https://cdn.myanimelist.net/images/anime/1593/113724.jpg?s=d17599f12346e6f00964f443f33d02e2, https://cdn.myanimelist.net/images/anime/1816/109865.jpg?s=45984f42dfbe2801e75a28889dc5c3f5, https://cdn.myanimelist.net/images/anime/1670/111154.jpg?s=5ee70b6cdf99854cb689a32fb702ebde, https://cdn.myanimelist.net/images/anime/1738/111426.jpg?s=48be88e10a194a7d8dc204a89e66d0bb, https://cdn.myanimelist.net/images/anime/1553/110311.jpg?s=2d76ee9a2d41f7ecd35264f745039bc8, https://cdn.myanimelist.net/images/anime/1332/110305.jpg?s=d44e5d2c1db5590993fdd968f6522a76, https://cdn.myanimelist.net/images/anime/1063/113784.jpg?s=fab79880ff253f6eed509f1b54e3a821, https://cdn.myanimelist.net/images/anime/1029/106237.jpg?s=13a5f6bd3244d4e8ecb3ca422b4e15c3, https://cdn.myanimelist.net/images/anime/1633/111052.jpg?s=93aa4a4d8e0ddbed205a8edd4dbb15dd, https://cdn.myanimelist.net/images/anime/1955/107042.jpg?s=58e816de4e4f0d6a2fbb3a6e0701466f, https://cdn.myanimelist.net/images/anime/1385/110769.jpg?s=d07ef147026a1c39163877f4390322fd, https://cdn.myanimelist.net/images/anime/1634/109387.jpg?s=8120d5c3aeffc6f3d483781c0e081add, https://cdn.myanimelist.net/images/anime/1346/109452.jpg?s=41db88ac8b5d8b725125af308b2f97e4, https://cdn.myanimelist.net/images/anime/1413/110712.jpg?s=07755ebcee1a6049c87f1db02bfde0a7, https://cdn.myanimelist.net/images/anime/1448/108514.jpg?s=93f03b25d831d44652d8e2cc5241fcbb, https://cdn.myanimelist.net/images/anime/1984/110105.jpg?s=2a65f410c3780fc8677905351892a07a, https://cdn.myanimelist.net/images/anime/1523/108380.jpg?s=530c0ffde3d959e510749098851abca4, https://cdn.myanimelist.net/images/anime/1860/113887.jpg?s=80e276068cec724814f88d220a5d9505, https://cdn.myanimelist.net/images/anime/1774/104764.jpg?s=fea41f5ccc18e3f8c3aa047c5699debe, https://cdn.myanimelist.net/images/anime/1712/108161.jpg?s=16275c40cb01026ad7a012fbc45d6c12]";
//        blackBoxCompare(animeSearch.getImageUrlList(), imageurlExpected);

        //normal case
//        String type = "anime";
//        String genre1 = "6"; //negative works fine
//        String genre2 = "9";
//        String genre3 = "1";
//        String orderBy = "start_date";
//        String sort = "desc";
//        //put this into a method for user preferences or search etc.
//        List<String> searchQuery = new ArrayList<>();
//        searchQuery.add(type); // TYPE MUST ALWAYS BE FIRST FOR URL TO WORK PROPERLY
//        searchQuery.add(genre1);
//        searchQuery.add(genre2);
//        searchQuery.add(genre3);
//        searchQuery.add(orderBy);
//        searchQuery.add(sort);
//        //AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch(type,  genre1, genre2, genre3,  orderBy, sort);
//        AnimeManga animeSearch = AnimeManga.loadAnimeMangaDataBySearch(searchQuery);
//        System.out.print(animeSearch.getImageUrlList());
//        String imageurlExpected = "[https://cdn.myanimelist.net/images/anime/1189/93528.jpg?s=a8d4254bfdc3e8231abc1fc6e10590e1, https://cdn.myanimelist.net/images/anime/1879/91882.jpg?s=03ad258f2c777e40b76fd874dbac73f0, https://cdn.myanimelist.net/images/anime/1395/95778.jpg?s=6c028aa822eff33201f39e2ae3c22cb5, https://cdn.myanimelist.net/images/anime/1568/95614.jpg?s=f1f6a71d1f3a8e0f52cd60004f371294, https://cdn.myanimelist.net/images/anime/7/77358.jpg?s=943dba8af5380d5792ab4b882d2eff57, https://cdn.myanimelist.net/images/anime/1151/94750.jpg?s=de78217056b25e418cca3d80274b91e2, https://cdn.myanimelist.net/images/anime/12/69911.jpg?s=5907c38135abad012ceda04743f16691, https://cdn.myanimelist.net/images/anime/12/73642.jpg?s=4704d55494e8f155239877074efc4732, https://cdn.myanimelist.net/images/anime/1240/94749.jpg?s=468878a21cf99b30b7834dc8f2c0c146, https://cdn.myanimelist.net/images/anime/12/47729.jpg?s=7c377869a20132d9d2b591b699c70de4, https://cdn.myanimelist.net/images/anime/13/75838.jpg?s=0c921b311d78f408e77ab2e8e521c6e3, https://cdn.myanimelist.net/images/anime/13/15393.jpg?s=807834e20e03d7964697e0da6b40ba33, https://cdn.myanimelist.net/images/anime/6/16230.jpg?s=64f9f5a33e2d3887f9706455eff9e71e, https://cdn.myanimelist.net/images/anime/2/14047.jpg?s=aa6b5657b623c84be7eb5ad755901a55]";
//        blackBoxCompare(animeSearch.getImageUrlList(), imageurlExpected);

        //normal case
//        String type = "anime";
//        String genre1 = "4";
//        String genre2 = "10";
//        String genre3 = "1";
//        String orderBy = "start_date";
//        String sort = "desc";
//        //put this into a method for user preferences or search etc.
//        List<String> searchQuery = new ArrayList<>();
//        searchQuery.add(type); // TYPE MUST ALWAYS BE FIRST FOR URL TO WORK PROPERLY
//        searchQuery.add(genre1);
//        searchQuery.add(genre2);
//        searchQuery.add(genre3);
//        searchQuery.add(orderBy);
//        searchQuery.add(sort);
//        //AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch(type,  genre1, genre2, genre3,  orderBy, sort);
//        AnimeManga animeSearch = AnimeManga.loadAnimeMangaDataBySearch(searchQuery);
//        System.out.print(animeSearch.getImageUrlList());
//        String imageurlExpected = "[https://cdn.myanimelist.net/images/anime/1436/106694.jpg?s=d395802efdb5b4a093f094f0090b7a07, https://cdn.myanimelist.net/images/anime/1407/111469.jpg?s=57f3024519667ef0d0fd15beeea628c1, https://cdn.myanimelist.net/images/anime/1978/111973.jpg?s=611c7f900ef12f49707e02b5d7435bb4, https://cdn.myanimelist.net/images/anime/1193/113571.jpg?s=db662e014f9abdbe8ab0012970ba0a47, https://cdn.myanimelist.net/images/anime/1340/110088.jpg?s=ee67671d1f7730716efef5ba82681170, https://cdn.myanimelist.net/images/anime/1236/113727.jpg?s=83919aa2db778f788cb7b7664b802a59, https://cdn.myanimelist.net/images/anime/1632/111141.jpg?s=2bdb023b6d20d6156ebd1fd6211fab2a, https://cdn.myanimelist.net/images/anime/1559/110932.jpg?s=f254a22636b01e9fe625f7a5ba6bf5a2, https://cdn.myanimelist.net/images/anime/1011/111811.jpg?s=a598178907d1e1e578e91cdb2087abfb, https://cdn.myanimelist.net/images/anime/1357/113277.jpg?s=e897e976e0f5ba1a43304bf56d977bcc, https://cdn.myanimelist.net/images/anime/1262/113705.jpg?s=d44cdbe0f8886f477cf83fe1e0510e15, https://cdn.myanimelist.net/images/anime/1271/109841.jpg?s=8abec65944244475ed90db5cf43e3c7a, https://cdn.myanimelist.net/images/anime/1593/113724.jpg?s=d17599f12346e6f00964f443f33d02e2, https://cdn.myanimelist.net/images/anime/1670/111154.jpg?s=5ee70b6cdf99854cb689a32fb702ebde, https://cdn.myanimelist.net/images/anime/1029/106237.jpg?s=13a5f6bd3244d4e8ecb3ca422b4e15c3, https://cdn.myanimelist.net/images/anime/1385/110769.jpg?s=d07ef147026a1c39163877f4390322fd, https://cdn.myanimelist.net/images/anime/1523/108380.jpg?s=530c0ffde3d959e510749098851abca4, https://cdn.myanimelist.net/images/anime/1984/110105.jpg?s=2a65f410c3780fc8677905351892a07a, https://cdn.myanimelist.net/images/anime/1712/108161.jpg?s=16275c40cb01026ad7a012fbc45d6c12, https://cdn.myanimelist.net/images/anime/1297/108295.jpg?s=1d8738cf272335ccc9cd7a06dfca1638, https://cdn.myanimelist.net/images/anime/1722/107269.jpg?s=06aa2328ff29a9401217f3b9383ccbc9, https://cdn.myanimelist.net/images/anime/1611/105459.jpg?s=596fe59f8ef66718944737822e17c00f, https://cdn.myanimelist.net/images/anime/1395/111345.jpg?s=f532b529e81bd2f31c19afca6704b95d, https://cdn.myanimelist.net/images/anime/1090/108165.jpg?s=2932924482937656c82c81638095b62f, https://cdn.myanimelist.net/images/anime/1810/106070.jpg?s=458e00b593e32c2fdf3bd153fa371b86, https://cdn.myanimelist.net/images/anime/1745/105558.jpg?s=0d25d899ee9a94cd6b35cc1f8d68a36a, https://cdn.myanimelist.net/images/anime/1021/108530.jpg?s=cbf611d72014ddd1ca12b9d111b035c4, https://cdn.myanimelist.net/images/anime/1930/107868.jpg?s=c1a956cb32351da642ad2f50645cd1f2, https://cdn.myanimelist.net/images/anime/1174/103830.jpg?s=dd0a86918a30bbc30173e4902d862fbc, https://cdn.myanimelist.net/images/anime/1895/105493.jpg?s=e02e6086e74293b25efcacb13a30c4d8, https://cdn.myanimelist.net/images/anime/1399/104762.jpg?s=15622675b82572711e727e4d55970204, https://cdn.myanimelist.net/images/anime/1740/104786.jpg?s=09d26f1f93ec4a1f73e2f0734d63f442, https://cdn.myanimelist.net/images/anime/1438/105344.jpg?s=6ac37aec18b1b3d52845937f2087ea3e, https://cdn.myanimelist.net/images/anime/1384/111966.jpg?s=4f01148b08c87543051a3504c63b9501, https://cdn.myanimelist.net/images/anime/1689/105554.jpg?s=b14879445f9ad5921b25cc1a60852820, https://cdn.myanimelist.net/images/anime/1688/105773.jpg?s=a9f6288cef6b7a4b62eae922fdb19f0a, https://cdn.myanimelist.net/images/anime/1715/103419.jpg?s=e9b670d40bfd3d1f9074a382bcc7d781, https://cdn.myanimelist.net/images/anime/1486/107836.jpg?s=6de1000c1466057401316c1c25eae088, https://cdn.myanimelist.net/images/anime/1221/100550.jpg?s=0a8df0aea5d9091e628bab80b0dfae26, https://cdn.myanimelist.net/images/anime/1421/102040.jpg?s=c45522755106ab375fa18be986f7637b, https://cdn.myanimelist.net/images/anime/1759/102055.jpg?s=8e2235dbfdbb024a81532015d3ce1060, https://cdn.myanimelist.net/images/anime/1730/101329.jpg?s=a17145c4235b0a495710f5bd1a0d1a57, https://cdn.myanimelist.net/images/anime/1796/99496.jpg?s=61c746087878a4c94967323265b22e13, https://cdn.myanimelist.net/images/anime/1116/104615.jpg?s=d5b7b08a8bb81a5a6625654db3d224bf, https://cdn.myanimelist.net/images/anime/1986/101147.jpg?s=c4b25e448e1ad3f6498c3aaa38dd97ae, https://cdn.myanimelist.net/images/anime/1007/101921.jpg?s=d5db4619a7bd3fde00aba5cd73b1d7e5, https://cdn.myanimelist.net/images/anime/1261/100452.jpg?s=1dceac029530704562ad658c52511a16, https://cdn.myanimelist.net/images/anime/1072/113437.jpg?s=df64e2f4d4aae40927798792ed67f94e, https://cdn.myanimelist.net/images/anime/1215/100764.jpg?s=d9b3343d5724c0e3a9227cebd7c40ba0, https://cdn.myanimelist.net/images/anime/1239/96949.jpg?s=78996e899ca5f9e9b8a8492fbf4e523e]"
//        blackBoxCompare(animeSearch.getImageUrlList(), imageurlExpected);


        //error case
//        String type = "";
//        String genre1 = "4";
//        String genre2 = "10";
//        String genre3 = "1";
//        String orderBy = "start_date";
//        String sort = "desc";
//        //put this into a method for user preferences or search etc.
//        List<String> searchQuery = new ArrayList<>();
//        searchQuery.add(type); // TYPE MUST ALWAYS BE FIRST FOR URL TO WORK PROPERLY
//        searchQuery.add(genre1);
//        searchQuery.add(genre2);
//        searchQuery.add(genre3);
//        searchQuery.add(orderBy);
//        searchQuery.add(sort);
//        //AnimeManga animeSearch = AnimeManga.loadAnimeMangaTitleBySearch(type,  genre1, genre2, genre3,  orderBy, sort);
//        AnimeManga animeSearch = AnimeManga.loadAnimeMangaDataBySearch(searchQuery);
//        System.out.print(animeSearch.getImageUrlList());
//        String imageurlExpected = "[]";
//        blackBoxCompare(animeSearch.getImageUrlList(), imageurlExpected);
//
//        //testing MySQL Queries for Database established above
//        //for (int i = 0; i < userDB.getSize(); i++) {
//        //UserProfile userProfile = new UserProfile();
//        //userProfile.setUsername(userDB.getUsernameByIndex(i));
//        //userProfile.setEmail(userDB.getEmailByIndex(i));
//        //userProfile.setPassword(userDB.getPasswordByIndex(i));
//        //userProfile.setAge(userDB.getAgeByIndex(i));
//        //userProfile.setCity(cityTitle.getCityTitle());
////            userProfile.setIpAddress(ipAddress);
//        //userProfile.save();
//        // }


        //Use this address format. Surprisingly hard to fuck up for some reason...
//        City city = City.loadCityResultsByAddress("");//24 Sussex Drive Ottawa ON");
//        List<String> restSearchQuery = new ArrayList<>();
//        restSearchQuery.add(city.getLatitude()); //MUST STAY LATITUDE FOR TRANSLATOR (working on update!!!)
//        restSearchQuery.add(city.getLongitude()); //MUST STAY LONGITUDE
//        restSearchQuery.add("30"); //MUST STAY DISTANCE
//        restSearchQuery.add("Japanese"); //MUST STAY CUISINE
//        Restaurant rest = Restaurant.loadRestaurantResults(restSearchQuery);
//        System.out.println(rest.getNameList());
//        System.out.println(rest.getPriceRangeList());
//        System.out.println(rest.getPhoneList());

        //Testing the file loading, printing, and saving
        UserDatabase userDB = new UserDatabase();
        userDB.loadUserDatabaseDefault();
        System.out.println(userDB.printDatabase());
        userDB.saveUserDatabaseDefault();

        City cityTitle = City.loadCityResultsByAddress("1600 Pennsylvania Ave NW, Washington DC");
        //Creating an empty database for testing
        UserDatabase testDB = new UserDatabase();
        //Testing the UserDatabase
        testDB.addNewApplicationUser("eHicks", "eHicks@uncg.edu", "HicksPass1", 18, cityTitle.getCityTitle(), 12345);
        //Comparing
        blackBoxCompare(testDB.getUsernameByIndex(0), "eHicks");
        blackBoxCompare(testDB.getEmailByIndex(0), "eHicks@uncg.edu");
        blackBoxCompare(testDB.getPasswordByIndex(0), "HicksPass1");
        blackBoxCompare(testDB.getAgeByIndex(0), 18);
        blackBoxCompare(testDB.getCityByIndex(0), cityTitle.getCityTitle());
        blackBoxCompare(testDB.getZipCodeByIndex(0), 12345);
        //Add more users to the DB
        testDB.addNewApplicationUser("ACarver", "akasha_1@uncg.edu", "AkashPass2", 21, cityTitle.getCityTitle(), 12345);
        testDB.addNewApplicationUser("aCandy", "wacruse@uncg.edu", "ijustReallyfuckinglovegators3", 23, cityTitle.getCityTitle(), 12345);
        testDB.addNewApplicationUser("eHicks", "eHicksOtherEmail@uncg.edu", "sneakysumbitch", 22, cityTitle.getCityTitle(), 12345);
        testDB.addNewApplicationUser("EHicks", "eHicksOtherOtherEmail@uncg.edu", "Sneakier Sum Bitch", 1000, cityTitle.getCityTitle(), 12345);
        testDB.printDatabase();
        //Comparing
        blackBoxCompare(testDB.getIndexByUsername("eHicks"), 2);
        blackBoxCompare(testDB.getIndexByUsername("ACarver"), 1);
        blackBoxCompare(testDB.getIndexByUsername("aCandy"), 0);

        //Testing the quickAddNewApplication method
        UserDatabase mergeDB = new UserDatabase();
        mergeDB.quickAddNewApplicationUser("eHicks", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("ACarver", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("aCandy", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("TheMessiah", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("kev1nDu", "", "", 0, "", 0);
        mergeDB.quickAddNewApplicationUser("BigQuig", "", "", 0, "", 0);
        System.out.println("TESTING METHOD quickAddNewApplicationUser");
        //Comparing output
        blackBoxCompare(mergeDB.getUsernameByIndex(0), "eHicks");
        blackBoxCompare(mergeDB.getUsernameByIndex(1), "ACarver");
        blackBoxCompare(mergeDB.getUsernameByIndex(2), "aCandy");
        blackBoxCompare(mergeDB.getUsernameByIndex(3), "TheMessiah");
        blackBoxCompare(mergeDB.getUsernameByIndex(4), "kev1nDu");
        blackBoxCompare(mergeDB.getUsernameByIndex(5), "BigQuig");
        //Testing the merge-sort algorithm
        mergeDB.mergeSortList();
        //Comparing output
        blackBoxCompare(mergeDB.getUsernameByIndex(0), "aCandy");
        blackBoxCompare(mergeDB.getUsernameByIndex(1), "ACarver");
        blackBoxCompare(mergeDB.getUsernameByIndex(2), "BigQuig");
        blackBoxCompare(mergeDB.getUsernameByIndex(3), "eHicks");
        blackBoxCompare(mergeDB.getUsernameByIndex(4), "kev1nDu");
        blackBoxCompare(mergeDB.getUsernameByIndex(5), "TheMessiah");
    }

    /**
     * This method is to be used during black box testing to compare two strings to see if the expected and
     * received output match. Will not work well when used to compare objects that don't parse well into
     * String, like an image.
     * @param _actual
     * @param _expected
     */
    public static void blackBoxCompare(Object _actual, Object _expected) {
        String actual = _actual.toString();
        String expected = _expected.toString();
        System.out.println("EXPECTED OUTPUT: " + expected);
        System.out.println("RECEIVED OUTPUT: " + actual);
        if (actual.equals(expected))
            System.out.println("--------- SUCCESS ---------");
        else
            System.out.println("~~~ !ERROR! ~~~ !ERROR! ~~~");
    }
}