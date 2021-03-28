package API;

/**
 * This interface will define methods that are needed for the Food API Translator
 * or any relevant API that is to be implemented.
 * Last Updated 02/14/2021
 * @author Andy Cruse
 */
public interface FoodApiInterface {

    public String loadRecipeTitleById(int _id);

    public String loadSummaryById(int _id);

    public Boolean loadIsVegetarianById(int _id);

    public Boolean loadIsVeganById(int _id);

    public Double loadPricePerServingById(int _id);

    public Integer loadReadyInMinutesById(int _id);

    public Integer loadServingsById(int _id);

}