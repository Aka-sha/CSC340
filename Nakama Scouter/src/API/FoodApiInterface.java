package API;

/**
 * This interface will define methods that are needed for the Food API Translator
 * Last Updated 02/14/2021
 * @author Andy Cruse
 */
public interface FoodApiInterface {

<<<<<<< HEAD:Nakama Scouter/src/API/FoodApiInterface.java
    public Object loadRecipeItem(int _id, String loadItem);
=======
    public String loadRecipeTitleById(int _id);

    public String loadSummaryById(int _id);

    public Boolean loadIsVegetarianById(int _id);

    public Boolean loadIsVeganById(int _id);

    public Double loadPricePerServingById(int _id);

    public Integer loadReadyInMinutesById(int _id);

    public Integer loadServingsById(int _id);
>>>>>>> parent of 4cd4337 (Merge pull request #3 from Aka-sha/echicks):Food API/src/API/FoodApiInterface.java

}