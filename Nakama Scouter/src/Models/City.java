package Models;

/**
 * This class loads city and location details based on user IP Address
 * May or may not need more depending on the scope of the project.
 * Last Updated 03/23/21
 * @author Andy Cruse
 */
public class City extends APIBaseClass{

    protected String ipAddress;
    protected String cityTitle;
    protected String latitude;
    protected String longitude;
    protected final String CITY_TITLE = "city";
    protected final String LATITUDE = "lat";
    protected final String LONGITUDE = "lon";


    public void City() {}

    /**
     * Static method creates a City object based on the given user ipAddress string.
     * Method connects to Geolocation API to return the name of a city given an IP Address.
     * @param _ipAddress
     * @return City city
     */
    public static City loadCityTitleByIP(String _ipAddress){
        City city = new City();
        city.setIpAddress(_ipAddress);
        String cityTitle = City.myLocationAPI.loadLocation(_ipAddress, city.CITY_TITLE).toString();
        if (cityTitle == null) {
            return null;
        }
        city.setCityTitle(cityTitle);
        return city;
    }

    /**
     * Static method creates a City object based on the given user ipAddress string.
     * Method connects to Geolocation API to return the latitude reading of a city given an IP Address.
     * @param _ipAddress
     * @return City city
     */
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

    /**
     * Static method creates a City object based on the given user ipAddress string.
     * Method connects to Geolocation API to return the longitude reading of a city given an IP Address.
     * @param _ipAddress
     * @return City city
     */
    public static City loadCityLongitudeByIP(String _ipAddress) {
        City city = new City();
        city.setIpAddress(_ipAddress);
        String cityLongitude = City.myLocationAPI.loadLocation(_ipAddress, city.LONGITUDE).toString();
        if (cityLongitude == null) {
            return null;
        }
        city.setLongitude(cityLongitude);
        return city;
    }

    //=============== GETTERS =============
    public String getIpAddress(){
        return this.ipAddress;
    }
    public String getCityTitle(){
        return this.cityTitle;
    }
    public double getLatitude() { return Double.parseDouble(this.latitude); }
    public double getLongitude() { return Double.parseDouble(this.longitude); }

    //=============== SETTERS =============
    public void setIpAddress(String _ipAddress){
        this.ipAddress = _ipAddress;
    }
    public void setCityTitle(String _cityTitle){
        this.cityTitle = _cityTitle;
    }
    public void setLatitude(String _latitude) { this.latitude = _latitude; }
    public void setLongitude(String _longitude) { this.longitude = _longitude; }
}

