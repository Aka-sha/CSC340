package API;

import java.util.List;

/**
 * This interface will define methods that are needed for the Geolocation API Translator
 * or any relevant API that is to be implemented.
 * Last Updated 03/23/2021
 * @author Andy Cruse
 */
public interface GeolocationApiInterface {

    public List<Object> loadLocation(String _address, List<String> _loadItem);

}
