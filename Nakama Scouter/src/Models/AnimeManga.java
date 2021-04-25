package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * This class loads the Anime/Manga information under a number of various parameters
 * Last Updated 04/16/21
 * @author Andy Cruse
 */
public class AnimeManga extends APIBaseClass {

    protected String results;
    protected String id;
    protected String url;
    protected String imageUrl;
    protected String title;
    protected String titleEnglish;
    protected String synopsis;
    protected String episodes;
    protected String score;
    protected String rating;
    protected List<Object> data;
    protected final String RESULTS = "results";
    protected final String ID = "mal_id";
    protected final String URL = "url";
    protected final String IMAGE_URL = "image_url";
    protected final String TITLE = "title";
    protected final String TITLE_ENGLISH = "title_english";
    protected final String SYNOPSIS = "synopsis";
    protected final String EPISODES = "episodes";
    protected final String SCORE = "score";
    protected final String RATING = "rated";

    /** Static method creates a AnimeManga object based on the given user ID string.
     * Creates a loadItem String List to allow for user input search. User can input as many genre's as the want
     * up to maximum.
     * Currently returns a String. May update, but good enough for now.
     * @param _searchQuery
     * @return
     */
    public static AnimeManga loadAnimeMangaDataBySearch(List<String> _searchQuery) {
        AnimeManga animeManga = new AnimeManga();
        List<String> loadItem = new ArrayList<String>();
        loadItem.add(animeManga.IMAGE_URL);
        loadItem.add(animeManga.TITLE);
        loadItem.add(animeManga.SYNOPSIS);
        List<Object> data = AnimeManga.myAnimeMangaAPI.loadSeveralAnimeMangaItemBySearch(_searchQuery, loadItem); //.toString();
        if (data == null) {
            return null;
        }
        animeManga.setImageUrl((String)data.get(0));
        animeManga.setTitle((String)data.get(1));
        animeManga.setSynopsis((String)data.get(2));
        return animeManga;
    }

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to returns the MyAnimeList url for the Anime/Manga
     * (NEEDS WORK/TESTING)
     * @param _id
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaURLByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String url = AnimeManga.myLocationAPI.loadLocation(_id, animemanga.URL).toString();
        if (url == null) {
            return null;
        }
        animemanga.setURL(url);
        return animemanga;
    }
    */

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the Image URL for the Anime/Manga
     * (NEEDS WORK/TESTING)
     * @param _id
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaImageUrlByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String imageUrl = AnimeManga.myLocationAPI.loadLocation(_id, animemanga.IMAGE_URL).toString();
        if (imageUrl == null) {
            return null;
        }
        animemanga.setImageUrl(imageUrl);
        return animemanga;
    }
    */

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the Title of an Anime/Manga.
     * (NEEDS WORK/TESTING)
     * @param _id
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaTitleByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String title = AnimeManga.myAnimeMangaAPI.loadAnimeMangaItemByID(_id, animemanga.TITLE).toString();
        if (title == null) {
            return null;
        }
        animemanga.setTitle(title);
        return animemanga;
    }
    */

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the English Title of an Anime/Manga.
     * (NEEDS WORK/TESTING)
     * @param _id
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaTitleEnglishByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String titleEnglish = AnimeManga.myAnimeMangaAPI.loadAnimeMangaItemByID(_id, animemanga.TITLE_ENGLISH).toString();
        if (titleEnglish == null) {
            return null;
        }
        animemanga.setTitleEnglish(titleEnglish);
        return animemanga;
    }
    */

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the Synopsis of an Anime/Manga.
     * (NEEDS WORK/TESTING)
     * @param _id
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaSynopsisByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String synopsis = AnimeManga.myAnimeMangaAPI.loadAnimeMangaItemByID(_id, animemanga.SYNOPSIS).toString();
        if (synopsis == null) {
            return null;
        }
        animemanga.setSynopsis(synopsis);
        return animemanga;
    }
    */

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the Episodes of an Anime or Manga
     * (NEEDS WORK/TESTING)
     * @param _id
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaEpisodesByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String episodes = AnimeManga.myAnimeMangaAPI.loadAnimeMangaItemByID(_id, animemanga.EPISODES).toString();
        if (episodes == null) {
            return null;
        }
        animemanga.setEpisodes(episodes);
        return animemanga;
    }
    */

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the rating score of an Anime/Manga
     * (NEEDS WORK/TESTING)
     * @param _id
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaScoreByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String score = AnimeManga.myAnimeMangaAPI.loadAnimeMangaItemByID(_id, animemanga.SCORE).toString();
        if (score == null) {
            return null;
        }
        animemanga.setScore(score);
        return animemanga;
    }
    */

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the Title of an Anime/Manga.
     * (NEEDS WORK/TESTING)
     * @param _id
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaRatingByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String rating = AnimeManga.myAnimeMangaAPI.loadAnimeMangaItemByID(_id, animemanga.RATING).toString();
        if (rating == null) {
            return null;
        }
        animemanga.setRating(rating);
        return animemanga;
    }
    */

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the Title of an anime or manga
     * by the user inputted type, 3 genres, sort order genre, and the method of sorting
     *
     * @return AnimeManga animemanga
     *
    public static AnimeManga loadAnimeMangaTitleBySearch(String _type, String _genre1, String _genre2, String _genre3, String _orderBy, String _sort) {
        AnimeManga animemanga = new AnimeManga();
        String title = AnimeManga.myAnimeMangaAPI.loadAnimeMangaItemSearch(_type, _genre1, _genre2, _genre3, _orderBy, _sort, animemanga.TITLE).toString();
        if (title == null) {
            return null;
        }
        animemanga.setTitle(title);
        return animemanga;
    }
    */


    //=============== GETTERS =============
    public String getID() {
        return this.id;
    }
    public String getUrl() {
        return this.url;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public String getTitle() {
        return this.title;
    }
    public String getTitleEnglish() {
        return this.titleEnglish;
    }
    public String getSynopsis() {
        return this.synopsis;
    }
    public String getEpisodes() {
        return this.episodes;
    }
    public String getScore() {
        return this.score;
    }
    public String getRating() {
        return this.rating;
    }
    public List<Object> getData() {
        return this.data;
    }

    //=============== SETTERS =============

    public void setID(String _id) {
        this.id = _id;
    }
    public void setURL(String _url) {
        this.url = _url;
    }
    public void setImageUrl(String _imageUrl) {
        this.imageUrl = _imageUrl;
    }
    public void setTitle(String _title) {
        this.title = _title;
    }
    public void setTitleEnglish(String _titleEnglish) {
        this.titleEnglish = _titleEnglish;
    }
    public void setSynopsis(String _synopsis) {
        this.synopsis = _synopsis;
    }
    public void setEpisodes(String _episodes) {
        this.episodes = _episodes;
    }
    public void setScore(String _score) {
        this.score = _score;
    }
    public void setRating(String _rating) {
        this.rating = _rating;
    }
    public void setData(List<Object> _data) {
        this.data = _data;
    }
}
