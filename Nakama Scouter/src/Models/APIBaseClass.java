package Models;

import API.*;

/**
 * This class acts as a base for the API(s) that will be used through the application
 * We will be able to change API for the entire project by editing a line in this class
 * Will add backups and additional API later.
 * Last Update: 03/26/2021
 * @author Andy Cruse
 */
public class APIBaseClass {

    protected final static FoodApiInterface myFoodAPI = new FoodApiTranslator();
    protected final static GeolocationApiInterface myLocationAPI = new GeolocationApiTranslator();
    protected final static RestaurantApiInterface myRestaurantAPI = new RestaurantApiTranslator();
    protected final static AnimeApiInterface myAnimeMangaAPI = new AnimeApiTranslator();

}