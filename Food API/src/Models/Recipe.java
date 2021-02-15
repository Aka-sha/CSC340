package Models;

/**
 * This class loads the recipe information from the Food API.
 * Last Updated 02/14/2021
 * @author Andy Cruse
 */
public class Recipe extends APIBaseClass{

    protected int id;
    protected String title;

    public void Recipe() {}

    /**
     * Static method creates a Recipe object based on a given ID number.
     * The method connects to the Food API to retrieve the Recipe Title.
     * @param _id
     * @return Recipe recipe
     */
    public static Recipe loadRecipeTitleById(int _id){
        Recipe recipe = new Recipe();
        recipe.setId(_id);
        String title = Recipe.myFoodAPI.loadRecipeTitleById(_id);
        if (title == null){
            return null;
        }
        recipe.setTitle(title);
        return recipe;
    }

    //=============== GETTERS =============
    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    //=============== SETTERS ==============
    public void setId(int _id) {
        this.id = _id;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }
}

