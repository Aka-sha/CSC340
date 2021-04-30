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
    protected String type;
    protected List<String> tagsList = new ArrayList<>();
    protected List<String> addedToListList = new ArrayList<>();
    protected List<String> imageUrlList = new ArrayList<>();
    protected List<String> titleList = new ArrayList<>();
    protected List<String> synopsisList = new ArrayList<>();
    protected List<String> typeList = new ArrayList<>();
    protected List<String> ratingList = new ArrayList<>();
    protected List<Object> data;
    protected final String TYPE = "type";
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
    protected final String VIDEO_URL = "video_url";
    protected final String TAGS = "tags";
    protected final String ADDED_TO_LIST = "added_to_list";

    /** Static method creates a AnimeManga object based on the given user ID string.
     * Creates a loadItem String List to allow for user input search. User can input as many genre's as the want
     * up to maximum.
     * Currently returns a String. May update, but good enough for now.
     * @param _searchQuery
     * @return
     */
    public static AnimeManga loadAnimeMangaDataBySearch(List<String> _searchQuery) {
        AnimeManga animeManga = new AnimeManga();
        List<String> loadItem = new ArrayList<>();
        loadItem.add(animeManga.IMAGE_URL);
        loadItem.add(animeManga.TITLE);
        loadItem.add(animeManga.SYNOPSIS);
        loadItem.add(animeManga.TYPE);
        loadItem.add(animeManga.RATING);
        try {
            List<Object> data = AnimeManga.myAnimeMangaAPI.loadSeveralAnimeMangaItemBySearch(_searchQuery, loadItem); //.toString();
            for (int i = 0; i < data.size(); i++) {
                switch (i % loadItem.size()) {
                    case 0:
                        animeManga.imageUrlList.add((String) data.get(i));
                        break;
                    case 1:
                        animeManga.titleList.add((String) data.get(i));
                        break;
                    case 2:
                        animeManga.synopsisList.add((String) data.get(i));
                        break;
                    case 3:
                        animeManga.typeList.add((String) data.get(i));
                        break;
                    case 4:
                        animeManga.ratingList.add((String) data.get(i));
                        break;
                }
            }
        } catch (Exception e) {
            animeManga.imageUrlList.add("");
            animeManga.titleList.add("");
            animeManga.synopsisList.add("");
            animeManga.typeList.add("");
            animeManga.ratingList.add("");
        }

        return animeManga;
    }

    public static AnimeManga loadAnimeMangaUserData(String _userName) {
        AnimeManga animeManga = new AnimeManga();
        List<String> loadItem = new ArrayList<>();
        loadItem.add(animeManga.TITLE);
        loadItem.add(animeManga.IMAGE_URL);
        loadItem.add(animeManga.SYNOPSIS);
        loadItem.add(animeManga.TYPE);
        loadItem.add(animeManga.RATING);
        loadItem.add(animeManga.ADDED_TO_LIST);
        try {
            List<Object> data = AnimeManga.myAnimeMangaAPI.loadUserAnimeList(_userName, loadItem); //.toString();
            //there are 6 loaditems so 6 cases
            for (int i = 0; i < data.size(); i++) {
                switch (i % loadItem.size()) {
                    case 0:
                        animeManga.titleList.add((String) data.get(i));
                        break;
                    case 1:
                        animeManga.imageUrlList.add((String) data.get(i));
                        break;
                    case 2:
                        animeManga.synopsisList.add((String)data.get(i));
                        break;
                    case 3:
                        animeManga.typeList.add((String)data.get(i));
                        break;
                    case 4:
                        animeManga.ratingList.add((String)data.get(i));
                        break;
                    case 5:
                        animeManga.addedToListList.add((String)data.get(i));
                        break;
                }
            }

        } catch (NullPointerException ex) {
            animeManga.titleList.add("");
            animeManga.imageUrlList.add("");
            animeManga.synopsisList.add("");
            animeManga.typeList.add("");
            animeManga.ratingList.add("");
            animeManga.addedToListList.add("");
        }
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
    public List<String> getImageUrlList() { return this.imageUrlList; }
    public List<String> getTitleList() { return this.titleList; }
    public List<String> getSynopsisList() { return this.synopsisList; }
    public List<String> getTypeList() { return this.typeList; }
    public List<String> getRatingList() { return this.ratingList; }
    public List<String> getTagsList() { return this.tagsList; }
    public List<String> getAddedToListList() { return this.addedToListList; }

    //=============== SETTERS =============

    private void setID(String _id) {
        this.id = _id;
    }
    private void setURL(String _url) {
        this.url = _url;
    }
    private void setImageUrl(String _imageUrl) {
        this.imageUrl = _imageUrl;
    }
    private void setTitle(String _title) {
        this.title = _title;
    }
    private void setTitleEnglish(String _titleEnglish) {
        this.titleEnglish = _titleEnglish;
    }
    private void setSynopsis(String _synopsis) {
        this.synopsis = _synopsis;
    }
    private void setEpisodes(String _episodes) {
        this.episodes = _episodes;
    }
    private void setScore(String _score) {
        this.score = _score;
    }
    private void setRating(String _rating) {
        this.rating = _rating;
    }
    private void setData(List<Object> _data) {
        this.data = _data;
    }
    private void setImageUrlList(List<String> _list) { this.imageUrlList = _list; }
    private void setTitleList(List<String> _list) { this.titleList = _list; }
    private void setSynopsisList(List<String> _list) { this.synopsisList = _list; }
    private void setTypeList(List<String> _list) { this.typeList = _list; }
    private void setRatingList(List<String> _list) { this.ratingList = _list; }
    private void setTagsList(List<String> _list) { this.tagsList = _list; }
    private void setAddedToListList(List<String> _list) { this.addedToListList = _list; }
}
