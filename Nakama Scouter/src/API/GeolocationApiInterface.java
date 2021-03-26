package API;

/**
 * This interface will define methods that are needed for the Geolocation API Translator
 * or any relevant API that is to be implemented.
 * Last Updated 03/23/2021
 * @author Andy Cruse
 */
public interface GeolocationApiInterface {

    public Object loadLocation(String _ipAddress, String _loadItem);

}
