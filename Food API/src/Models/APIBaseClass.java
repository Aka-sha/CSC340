package Models;

import API.FoodApiInterface;
import API.FoodApiTranslator;
import API.GeolocationApiInterface;
import API.GeolocationApiTranslator;

/**
 * This class acts as a base for the API(s) that will be used through the application
 * We will be able to change API for the entire project by editing a line in this class
 * Currently only 2 API is in use, and API for food and an API for Geolocation.
 * Will add backups and additional API later.
 * Last Update: 03/23/2021
 * @author Andy Cruse
 */
public class APIBaseClass {

    protected final static FoodApiInterface myFoodAPI = new FoodApiTranslator();
    protected final static GeolocationApiInterface myLocationAPI = new GeolocationApiTranslator();

}