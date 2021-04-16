package Models;

/**
 * This class loads the recipe information from the Restaurant API, Documenu.
 * Needs to be updated for search cuisines address and menus by restaurant ID ASAP once Translator issue is fixed
 * Last Updated 04/16/2021
 * @author Andy Cruse
 */
public class Restaurant extends APIBaseClass {

    protected String ipAddress;
    protected String latitude;
    protected String longitude;
    protected String distance;
    protected String totalResults;
    protected String data;
    protected String restaurantName;
    protected String restaurantID;
    protected String restaurantPhone;
    protected String restaurantWebsite;
    protected String hours;
    protected String priceRange;
    protected String[] cuisines;
    protected String[] address;
    protected String[] menus;
    protected final String TOTAL_RESULTS = "totalResults";
    protected final String DATA = "data";
    protected final String RESTAURANT_NAME = "restaurant_name";
    protected final String RESTAURANT_ID = "restaurant_id";
    protected final String RESTAURANT_PHONE = "restaurant_phone";
    protected final String RESTAURANT_WEBSITE = "restaurant_website";
    protected final String HOURS = "hours";
    protected final String PRICE_RANGE = "price_range";
    protected final String CUISINE = "cuisines";
    protected final String ADDRESS = "formatted";

    public void Restaurant() {}

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
     * This method connects with the Restaurant API to return the Number of Results
     * @param _latitude, _longitude, _distance, _cuisine
     * @return Restaurant rest
     */
    public static Restaurant loadRestaurantResults(String _latitude, String _longitude, String _distance, String _cuisine) {
        Restaurant rest = new Restaurant();
        rest.setLatitude(_latitude);
        rest.setLongitude(_longitude);
        rest.setDistance(_distance);
        String title;
        try {
            title = rest.myRestaurantAPI.loadRestaurantItemBySearch(_latitude, _longitude, _distance, _cuisine, rest.TOTAL_RESULTS).toString();
            rest.setTotalResults(title.toString());
        }
        catch (NullPointerException ex) {
            rest.setTotalResults("!NA!");
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
    public String getTotalResults() {
        return this.totalResults;
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
    public String[] getCuisines() {
        return this.cuisines;
    }
    public String[] getAddress() {
        return this.address;
    }
    public String[] getMenus() {
        return this.menus;
    }

    //=============== SETTERS =============
    public void setIpAddress(String _ipAddress) {
        this.ipAddress = _ipAddress;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    public void setTotalResults(String _totalResults) {
        this.totalResults = _totalResults;
    }
    public void setData(String _data) {
        this.data = _data;
    }
    public void setRestaurantName(String _restaurantName) {
        this.restaurantName = _restaurantName;
    }
    public void setID(String _id) {
        this.restaurantID = _id;
    }
    public void setRestaurantPhone(String _restaurantPhone) {
        this.restaurantPhone = _restaurantPhone;
    }
    public void setRestaurantWebsite(String _restaurantWebsite) {
        this.restaurantWebsite = _restaurantWebsite;
    }
    public void setHours(String _hours) {
        this.hours = _hours;
    }
    public void setPriceRange(String _priceRange) {
        this.priceRange = _priceRange;
    }
    public void setCuisines(String[] _cuisines) {
        this.cuisines = _cuisines;
    }
    public void setAddress(String[] _address) {
        this.address = _address;
    }
    public void setMenus(String[] _menus) {
        this.menus = _menus;
    }
}
