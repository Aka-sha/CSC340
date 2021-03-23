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
    protected final String CITY_TITLE = "city";

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
        city.setCity(cityTitle);
        return city;
    }
    //=============== GETTERS =============
    public String getIpAddress(){
        return this.ipAddress;
    }
    public String getCityTitle(){
        return this.cityTitle;
    }

    //=============== SETTERS =============
    public void setIpAddress(String _ipAddress){
        this.ipAddress = _ipAddress;
    }
    public void setCity(String _cityTitle){
        this.cityTitle = _cityTitle;
    }
}

