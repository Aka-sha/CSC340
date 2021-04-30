package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class loads city and location details based on user IP Address
 * May or may not need more depending on the scope of the project.
 * Last Updated 03/23/21
 * @author Andy Cruse
 */
public class City extends APIBaseClass{

    protected String address;
    protected String cityTitle;
    protected String latitude;
    protected String longitude;
    protected String zipCode;
    protected final String CITY_TITLE = "locality";
    protected final String LATITUDE = "lat";
    protected final String LONGITUDE = "lng";
    protected final String ZIP_CODE = "postal_code";



    public void City() {}

    /**
     * Static method creates a City object based on the given user ipAddress string.
     * Method connects to Geolocation API to return the name of a city given an IP Address.
     * @param _ipAddress
     * @return City city
     *
    public static City loadCityTitleByIP(String _ipAddress){
        City city = new City();
        city.setIpAddress(_ipAddress);
        String cityTitle = City.myLocationAPI.loadLocation(_ipAddress, city.CITY_TITLE).toString();
        if (cityTitle == null) {
            return null;
        }
        city.setCityTitle(cityTitle);
        return city;
    }*/


    /**
     * Static method creates a City object based on the given user ipAddress string.
     * Method connects to Geolocation API to return the latitude reading of a city given an IP Address.
     * @param _ipAddress
     * @return City city
     *
    public static City loadCityLatitudeByIP(String _ipAddress) {
        City city = new City();
        city.setIpAddress(_ipAddress);
        String cityLatitude = City.myLocationAPI.loadLocation(_ipAddress, city.LATITUDE).toString();
        if (cityLatitude == null) {
            return null;
        }
        city.setLatitude(cityLatitude);
        return city;
    }
    */

    /**
     * Static method creates a City object based on the given user ipAddress string.
     * Method connects to Geolocation API to return the longitude reading of a city given an IP Address.
     * @param _address
     * @return City city
     *
    public static City loadCityLongitudeByIP(String _address) {
        City city = new City();
        city.setIpAddress(_ipAddress);
        String cityLongitude = City.myLocationAPI.loadLocation(_address, city.LONGITUDE).toString();
        if (cityLongitude == null) {
            return null;
        }
        city.setLongitude(cityLongitude);
        return city;
    }
    */

    public static City loadCityResultsByAddress(String _address) {
        City city = new City();
        List<String> loadItem = new ArrayList<>();
        loadItem.add(city.CITY_TITLE);
        loadItem.add(city.ZIP_CODE);
        loadItem.add(city.LATITUDE);
        loadItem.add(city.LONGITUDE);
        try {
            List<Object> results = city.myLocationAPI.loadLocation(_address, loadItem);
            city.setCityTitle((String)results.get(0));
            city.setZipCode((String)results.get(1));
            city.setLatitude((String)results.get(2));
            city.setLongitude((String)results.get(3));
        }
        catch (NullPointerException ex) {
            city.setCityTitle(null);
            city.setZipCode(null);
            city.setLatitude(null);
            city.setLongitude(null);
        }
        return city;
    }

    //=============== GETTERS =============
    public String getAddress(){
        return this.address;
    }
    public String getCityTitle(){ return this.cityTitle; }
    public String getLatitude() { return this.latitude; }
    public String getLongitude() { return this.longitude; }
    public String getZipCode() { return this.zipCode; }

    //=============== SETTERS =============
    public void setIpAddress(String _address){
        this.address = _address;
    }
    public void setCityTitle(String _cityTitle){
        this.cityTitle = _cityTitle;
    }
    public void setLatitude(String _latitude) { this.latitude = _latitude; }
    public void setLongitude(String _longitude) { this.longitude = _longitude; }
    public void setZipCode(String _zipCode) { this.zipCode = _zipCode; }
}

