package Models;

import API.FoodApiInterface;
import API.FoodApiTranslator;

/**
 * This class acts as a base for the API(s) that will be used through the application
 * We will be able to change API for the entire project by editing a line in this class
 * Currently only 1 API is in use. Will add backups and additional API later.
 * Last Update: 02/14/2021
 * @author Andy Cruse
 */
public class APIBaseClass {

    protected final static FoodApiInterface myFoodAPI = new FoodApiTranslator();
}