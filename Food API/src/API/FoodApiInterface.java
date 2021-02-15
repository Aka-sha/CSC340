package API;

/**
 * This interface will define methods that are needed for the Food API Translator
 * or any relevant API that is to be implemented.
 * Last Updated 02/14/2021
 * @author Andy Cruse, modified by Edward Hicks
 */
public interface FoodApiInterface {

    public Object loadRecipeItem(int _id, String loadItem);
}