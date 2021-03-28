package Models;

/**
 * This class loads the recipe information from the Food API.
 * Last Updated 02/14/2021
 * @author Andy Cruse
 */
public class Recipe extends APIBaseClass {

    protected int id;
    protected String title;
    protected String summary;
    protected Boolean isVegetarian;
    protected Boolean isVegan;
    protected Double pricePerServing;
    protected Integer readyInMinutes;
    protected Integer servings;

    public void Recipe() {}

    /**
     * Static method creates a Recipe object based on a given ID number.
     * The method connects to the Food API to retrieve the Recipe Title.
     * @param _id
     * @return Recipe recipe
     */
    public static Recipe loadRecipeTitleById(int _id) {
        Recipe recipe = new Recipe();
        recipe.setId(_id);
        String title = Recipe.myFoodAPI.loadRecipeTitleById(_id);
        if (title == null) {
            return null;
        }
        recipe.setTitle(title);
        return recipe;
    }

    /**
     * Static method creates a Recipe object based on a given ID number.
     * The method connects to the Food API to retrieve the Recipe Summary
     * @param _id
     * @return Recipe recipe
     */
    public static Recipe loadSummaryById(int _id) {
        Recipe recipe = new Recipe();
        recipe.setId(_id);
        String summary = Recipe.myFoodAPI.loadSummaryById(_id);
        if (summary == null) {
            return null;
        }
        recipe.setSummary(summary);
        return recipe;
    }

    /**
     * Static method creates a Recipe object based on a given ID number.
     * The method connects to the Food API to determine if Recipe is Vegetarian.
     * @param _id
     * @return Recipe recipe
     */
    public static Recipe loadIsVegetarianById(int _id) {
        Recipe recipe = new Recipe();
        recipe.setId(_id);
        Boolean isVegetarian = Recipe.myFoodAPI.loadIsVegetarianById(_id);
        if (isVegetarian == null) {
            return null;
        }
        recipe.setIsVegetarian(isVegetarian);
        return recipe;
    }

    /**
     * Static method creates a Recipe object based on a given ID number.
     * The method connects to the Food API to determine if Recipe is Vegan.
     * @param _id
     * @return Recipe recipe
     */
    public static Recipe loadIsVeganById(int _id) {
        Recipe recipe = new Recipe();
        recipe.setId(_id);
        Boolean isVegan = Recipe.myFoodAPI.loadIsVeganById(_id);
        if (isVegan == null) {
            return null;
        }
        recipe.setIsVegan(isVegan);
        return recipe;
    }

    /**
     * Static method creates a Recipe object based on a given ID number.
     * The method connects to the Food API to retrieve the Recipe Price per Serving
     * @param _id
     * @return Recipe recipe
     */
    public static Recipe loadPricePerServingById(int _id) {
        Recipe recipe = new Recipe();
        recipe.setId(_id);
        Double pricePerServing = Recipe.myFoodAPI.loadPricePerServingById(_id);
        if (pricePerServing == null){
            return null;
        }
        recipe.setPricePerServing(pricePerServing);
        return recipe;
    }

    /**
     * Static method creates a Recipe object based on a given ID number.
     * The method connects to the Food API to retrieve the Recipe Cook time in Minutes
     * @param _id
     * @return Recipe recipe
     */
    public static Recipe loadReadyInMinutesById(int _id) {
        Recipe recipe = new Recipe();
        recipe.setId(_id);
        Integer minutes = Recipe.myFoodAPI.loadReadyInMinutesById(_id);
        if (minutes == null){
            return null;
        }
        recipe.setReadyInMinutes(minutes);
        return recipe;
    }

    /**
     * Static method creates a Recipe object based on a given ID number.
     * The method connects to the Food API to retrieve the Recipe number of Servings
     * @param _id
     * @return Recipe recipe
     */
    public static Recipe loadServingsById(int _id) {
        Recipe recipe = new Recipe();
        recipe.setId(_id);
        Integer servings = Recipe.myFoodAPI.loadServingsById(_id);
        if (servings == null){
            return null;
        }
        recipe.setServings(servings);
        return recipe;
    }

    //=============== GETTERS =============
    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSummary() {
        return this.summary;
    }

    public Boolean getIsVegetarian() {
        return this.isVegetarian;
    }

    public Boolean getIsVegan() {
        return this.isVegan;
    }

    public Double getPricePerServing() {
        return this.pricePerServing;
    }

    public Integer getReadyInMinutes() {
        return this.readyInMinutes;
    }

    public Integer getServings() {
        return this.servings;
    }

    //=============== SETTERS ==============
    public void setId(int _id) {
        this.id = _id;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public void setSummary(String _summary) {
        this.summary = _summary;
    }

    public void setIsVegetarian(Boolean _isVegetarian) {
        this.isVegetarian = _isVegetarian;
    }

    public void setIsVegan(Boolean _isVegan) {
        this.isVegan = _isVegan;
    }

    public void setPricePerServing(Double _pricePerServing) {
        this.pricePerServing = _pricePerServing;
    }

    public void setReadyInMinutes(Integer _readyInMinutes) {
        this.readyInMinutes = _readyInMinutes;
    }

    public void setServings(Integer _servings) {
        this.servings = _servings;
    }
}