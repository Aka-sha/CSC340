package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class loads the recipe information from the Restaurant API, Documenu.
 * Needs to be updated for search cuisines address and menus by restaurant ID ASAP once Translator issue is fixed
 * Last Updated 04/30/2021
 * @author Andy Cruse
 */
public class Restaurant extends APIBaseClass {

    protected String ipAddress;
    protected String latitude;
    protected String longitude;
    protected String distance;
    protected String data;
    protected String restaurantName;
    protected String restaurantID;
    protected String restaurantPhone;
    protected String restaurantWebsite;
    protected String hours;
    protected String priceRange;
    protected List<Object> results;
    protected List<String> nameList = new ArrayList<>();
    protected List<String> phoneList = new ArrayList<>();
    protected List<String> websiteList = new ArrayList<>();
    protected List<String> hoursList = new ArrayList<>();
    protected List<String> priceRangeList = new ArrayList<>();
    protected List<String> idList = new ArrayList<>();
    protected final String TOTAL_RESULTS = "totalResults";
    protected final String DATA = "data";
    protected final String RESTAURANT_NAME = "restaurant_name";
    protected final String RESTAURANT_ID = "restaurant_id";
    protected final String RESTAURANT_PHONE = "restaurant_phone";
    protected final String RESTAURANT_WEBSITE = "restaurant_website";
    protected final String HOURS = "hours";
    protected final String PRICE_RANGE = "price_range";

    public void Restaurant() {}

    /**
     * Static method creates a Restaurant object based on latitude, longtitude, a distance radius in miles, and a specified cuisine
     * This method connects with the Restaurant API to return the Number of Results
     * @param _searchQuery
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantResults(List<String> _searchQuery) {
        Restaurant rest = new Restaurant();
        List<String> loadItems = new ArrayList<String>();
        loadItems.add(rest.RESTAURANT_NAME);
        loadItems.add(rest.RESTAURANT_PHONE);
        loadItems.add(rest.RESTAURANT_WEBSITE);
        loadItems.add(rest.RESTAURANT_ID);
        loadItems.add(rest.PRICE_RANGE);
        try {
            List<Object> results = rest.myRestaurantAPI.loadRestaurantItemBySearch(_searchQuery, loadItems);
            for (int i = 0; i < results.size(); i++) {
                int mod = i % loadItems.size();
                switch (mod) {
                    case 0:
                        rest.nameList.add((String)results.get(i));
                        break;
                    case 1:
                        rest.phoneList.add((String)results.get(i));
                        break;
                    case 2:
                        rest.websiteList.add((String)results.get(i));
                        break;
                    case 3:
                        rest.idList.add((String)results.get(i));
                        break;
                    case 4:
                        rest.priceRangeList.add((String)results.get(i));
                        break;
                }
            }
        }
        catch (NullPointerException ex) {
            rest.nameList.add("");
            rest.phoneList.add("");
            rest.websiteList.add("");
            rest.idList.add("");
            rest.priceRangeList.add("");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on a Restaurant ID
     * This method connects with the Restaurant API to return Restaurant Name
     * @param _id
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantNameByID(String _id) {
        Restaurant rest = new Restaurant();
        rest.setID(_id);
        String title;
        try {
            title = rest.myRestaurantAPI.loadRestaurantItemByID(_id, rest.RESTAURANT_NAME).toString();
            rest.setRestaurantName(title.toString());
        }
        catch (NullPointerException ex) {
            rest.setRestaurantName("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on a Restaurant ID
     * This method connects with the Restaurant API to return Restaurant phone
     * @param _id
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantPhoneByID(String _id) {
        Restaurant rest = new Restaurant();
        rest.setID(_id);
        String phoneNum;
        try {
            phoneNum = rest.myRestaurantAPI.loadRestaurantItemByID(_id, rest.RESTAURANT_PHONE).toString();
            rest.setRestaurantPhone(phoneNum.toString());
        }
        catch (NullPointerException ex) {
            rest.setRestaurantPhone("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on a Restaurant ID
     * This method connects with the Restaurant API to return Restaurant Website
     * @param _id
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantWebsiteByID(String _id) {
        Restaurant rest = new Restaurant();
        rest.setID(_id);
        String website;
        try {
            website = rest.myRestaurantAPI.loadRestaurantItemByID(_id, rest.RESTAURANT_WEBSITE).toString();
            rest.setRestaurantWebsite(website.toString());
        }
        catch (NullPointerException ex) {
            rest.setRestaurantWebsite("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on a Restaurant ID
     * This method connects with the Restaurant API to return Restaurant Hours
     * @param _id
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantHoursByID(String _id) {
        Restaurant rest = new Restaurant();
        rest.setID(_id);
        String hours;
        try {
            hours = rest.myRestaurantAPI.loadRestaurantItemByID(_id, rest.HOURS).toString();
            rest.setHours(hours.toString());
        }
        catch (NullPointerException ex) {
            rest.setHours("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on a Restaurant ID
     * This method connects with the Restaurant API to return Restaurant Price Range
     * @param _id
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantPriceByID(String _id) {
        Restaurant rest = new Restaurant();
        rest.setID(_id);
        String price;
        try {
            price = rest.myRestaurantAPI.loadRestaurantItemByID(_id, rest.PRICE_RANGE).toString();
            rest.setPriceRange(price.toString());
        }
        catch (NullPointerException ex) {
            rest.setPriceRange("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on latitude, longtitude, a distance radius in miles, and a specified cuisine
     * This method connects with the Restaurant API to return the Restaurant Data Set
     * @param _latitude, _longitude, _distance, _cuisine
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantData(String _latitude, String _longitude, String _distance, String _cuisine) {
        Restaurant rest = new Restaurant();
        rest.setLatitude(_latitude);
        rest.setLongitude(_longitude);
        rest.setDistance(_distance);
        String title;
        try {
            title = rest.myRestaurantAPI.loadRestaurantItemBySearch(_latitude, _longitude, _distance, _cuisine, rest.DATA).toString();
            rest.setData(title.toString());
        }
        catch (NullPointerException ex) {
            rest.setData("!NA!");
        }
        return rest;
    }
    /**
     * Static method creates a Restaurant object based on latitude, longtitude, a distance radius in miles, and a specified cuisine
     * This method connects with the Restaurant API to return Restaurant Name
     * @param _latitude, _longitude, _distance, _cuisine
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantName(String _latitude, String _longitude, String _distance, String _cuisine) {
        Restaurant rest = new Restaurant();
        rest.setLatitude(_latitude);
        rest.setLongitude(_longitude);
        rest.setDistance(_distance);
        String title;
        try {
            title = rest.myRestaurantAPI.loadRestaurantItemBySearch(_latitude, _longitude, _distance, _cuisine, rest.RESTAURANT_NAME).toString();
            rest.setRestaurantName(title.toString());
        }
        catch (NullPointerException ex) {
            rest.setRestaurantName("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on latitude, longtitude, a distance radius in miles, and a specified cuisine
     * This method connects with the Restaurant API to return Restaurant Phone Number
     * @param _latitude, _longitude, _distance, _cuisine
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantPhone(String _latitude, String _longitude, String _distance, String _cuisine) {
        Restaurant rest = new Restaurant();
        rest.setLatitude(_latitude);
        rest.setLongitude(_longitude);
        rest.setDistance(_distance);
        String title;
        try {
            title = rest.myRestaurantAPI.loadRestaurantItemBySearch(_latitude, _longitude, _distance, _cuisine, rest.RESTAURANT_PHONE).toString();
            rest.setRestaurantPhone(title.toString());
        }
        catch (NullPointerException ex) {
            rest.setRestaurantPhone("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on latitude, longtitude, a distance radius in miles, and a specified cuisine
     * This method connects with the Restaurant API to return Restaurant Website
     * @param _latitude, _longitude, _distance, _cuisine
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantWebsite(String _latitude, String _longitude, String _distance, String _cuisine) {
        Restaurant rest = new Restaurant();
        rest.setLatitude(_latitude);
        rest.setLongitude(_longitude);
        rest.setDistance(_distance);
        String title;
        try {
            title = rest.myRestaurantAPI.loadRestaurantItemBySearch(_latitude, _longitude, _distance, _cuisine, rest.RESTAURANT_WEBSITE).toString();
            rest.setRestaurantWebsite(title.toString());
        }
        catch (NullPointerException ex) {
            rest.setRestaurantWebsite("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on latitude, longtitude, a distance radius in miles, and a specified cuisine
     * This method connects with the Restaurant API to return Restaurant Hours
     * @param _latitude, _longitude, _distance, _cuisine
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantHours(String _latitude, String _longitude, String _distance, String _cuisine) {
        Restaurant rest = new Restaurant();
        rest.setLatitude(_latitude);
        rest.setLongitude(_longitude);
        rest.setDistance(_distance);
        String title;
        try {
            title = rest.myRestaurantAPI.loadRestaurantItemBySearch(_latitude, _longitude, _distance, _cuisine, rest.HOURS).toString();
            rest.setHours(title.toString());
        }
        catch (NullPointerException ex) {
            rest.setHours("!NA!");
        }
        return rest;
    }

    /**
     * Static method creates a Restaurant object based on latitude, longtitude, a distance radius in miles, and a specified cuisine
     * This method connects with the Restaurant API to return Restaurant Price Range
     * @param _latitude, _longitude, _distance, _cuisine
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantPriceRange(String _latitude, String _longitude, String _distance, String _cuisine) {
        Restaurant rest = new Restaurant();
        rest.setLatitude(_latitude);
        rest.setLongitude(_longitude);
        rest.setDistance(_distance);
        String title;
        try {
            title = rest.myRestaurantAPI.loadRestaurantItemBySearch(_latitude, _longitude, _distance, _cuisine, rest.PRICE_RANGE).toString();
            rest.setPriceRange(title.toString());
        }
        catch (NullPointerException ex) {
            rest.setPriceRange("!NA!");
        }
        return rest;
    }


    //=============== GETTERS =============
    public String getIpAddress() {
        return this.ipAddress;
    }
    public String getLatitude() {
        return this.latitude;
    }
    public String getLongitude() {
        return this.longitude;
    }
    public String getDistance() {
        return this.distance;
    }
    public String getData() {
        return this.data;
    }
    public String getRestaurantName() {
        return this.restaurantName;
    }
    public String getRestaurantID() {
        return this.restaurantID;
    }
    public String getRestaurantPhone() {
        return this.restaurantPhone;
    }
    public String getRestaurantWebsite() {
        return this.restaurantWebsite;
    }
    public String getHours() {
        return this.hours;
    }
    public String getPriceRange() {
        return this.priceRange;
    }
    public List<Object> getResults() {
        return this.results;
    }

    public List<String> getNameList() {
        return this.nameList;
    }

    public List<String> getPhoneList() {
        return this.phoneList;
    }

    public List<String> getWebsiteList() {
        return this.websiteList;
    }

    public List<String> getHoursList() {
        return this.hoursList;
    }

    public List<String> getPriceRangeList() {
        return this.priceRangeList;
    }
    public List<String> getIdList() { return this.idList; }
    //=============== SETTERS =============
    private void setIpAddress(String _ipAddress) {
        this.ipAddress = _ipAddress;
    }
    private void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    private void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    private void setDistance(String distance) {
        this.distance = distance;
    }
    private void setData(String _data) {
        this.data = _data;
    }
    private void setRestaurantName(String _restaurantName) {
        this.restaurantName = _restaurantName;
    }
    private void setID(String _id) {
        this.restaurantID = _id;
    }
    private void setRestaurantPhone(String _restaurantPhone) {
        this.restaurantPhone = _restaurantPhone;
    }
    private void setRestaurantWebsite(String _restaurantWebsite) {
        this.restaurantWebsite = _restaurantWebsite;
    }
    private void setHours(String _hours) {
        this.hours = _hours;
    }
    private void setPriceRange(String _priceRange) {
        this.priceRange = _priceRange;
    }
    private void setNameList(List<String> _list) { this.nameList = _list; }
    private void setPhoneList(List<String> _list) { this.phoneList = _list; }
    private void setWebsiteList(List<String> _list) { this.websiteList = _list; }
    private void setHoursList(List<String> _list) { this.hoursList = _list; }
    private void setPriceRangeList(List<String> _list) { this.priceRangeList = _list; }
    private void setIdList(List<String> _list) { this.idList = _list; }
}
