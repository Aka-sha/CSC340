package Models;

/**
 * This class loads the recipe information from the Food API.
 * Last Updated 03/24/2021
 * @author Andy Cruse, modified by Edward Hicks
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
    protected final String itemTitle = "title";
    protected final String itemSummary = "summary";
    protected final String itemVegetarian = "vegetarian";
    protected final String itemVegan = "vegan";
    protected final String itemPricePerServing = "pricePerServing";
    protected final String itemReadyInMinutes = "readyInMinutes";
    protected final String itemServings = "servings";

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
        String title;
        try {
            title = Recipe.myFoodAPI.loadRecipeItem(_id, recipe.itemTitle).toString();
            recipe.setTitle(title.toString());
        }
        catch (NullPointerException ex) {
            recipe.setTitle("!NA!");
        }
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
        String summary;
        try {
            summary = Recipe.myFoodAPI.loadRecipeItem(_id, recipe.itemSummary).toString();
            recipe.setSummary(summary);
        }
        catch (NullPointerException ex) {
            recipe.setSummary("!NA!");
        }
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
        Boolean isVegetarian;
        try {
            isVegetarian = Boolean.parseBoolean(myFoodAPI.loadRecipeItem(_id, recipe.itemVegetarian).toString());
            recipe.setIsVegetarian(isVegetarian);
        }
        catch (NullPointerException ex) {
            recipe.setIsVegetarian(false);
        }
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
        Boolean isVegan;
        try {
            isVegan = Boolean.parseBoolean(Recipe.myFoodAPI.loadRecipeItem(_id, recipe.itemVegan).toString());
            recipe.setIsVegan(isVegan);
        }
        catch (NullPointerException ex) {
            recipe.setIsVegan(false);
        }
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
        Double pricePerServing;
        try {
            pricePerServing = Double.parseDouble(Recipe.myFoodAPI.loadRecipeItem(_id, recipe.itemPricePerServing).toString());
            recipe.setPricePerServing(pricePerServing);
        }
        catch (NullPointerException ex) {
            recipe.setPricePerServing(0d);
        }
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
        Integer minutes;
        try {
            minutes = Integer.parseInt(Recipe.myFoodAPI.loadRecipeItem(_id, recipe.itemReadyInMinutes).toString());
            recipe.setReadyInMinutes(minutes);
        }
        catch (NullPointerException ex) {
            recipe.setReadyInMinutes(0);
        }
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
        Integer servings;
        try {
            servings = Integer.parseInt(Recipe.myFoodAPI.loadRecipeItem(_id, recipe.itemServings).toString());
            recipe.setServings(servings);
        }
        catch (NullPointerException ex) {
            recipe.setServings(0);
        }
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