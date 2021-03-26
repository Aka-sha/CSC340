package Models;

public class AnimeManga extends APIBaseClass {

    protected String results;
    protected String type;
    protected String genre;
    protected String genre1; //genre1, 2 ,3, order, and sort are used for search and recommendations
    protected String genre2;
    protected String genre3;
    protected String order;
    protected String sort;
    protected String id;
    protected String url;
    protected String imageUrl;
    protected String title;
    protected String synopsis;
    protected String episodes;
    protected String score;
    protected String rating;
    protected final String RESULTS = "results";
    protected final String TYPE = "type";
    protected final String GENRE = "genre";
    protected final String ORDER = "order_by";
    protected final String SORT = "sort_by";
    protected final String ID = "mal_id";
    protected final String URL = "url";
    protected final String IMAGE_URL = "image_url";
    protected final String TITLE = "title";
    protected final String SYNOPSIS = "synopsis";
    protected final String EPISODES = "episodes";
    protected final String SCORE = "score";
    protected final String RATING = "rated";

    /**
     * Static method creates a City object based on the given user ipAddress string.
     * Method connects to Geolocation API to return the latitude reading of a city given an IP Address.
     * @param _id
     * @return AnimeManga animemanga
     */
    public static AnimeManga loadAnimeMangaTypeByID(String _id) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setID(_id);
        String type = AnimeManga.myLocationAPI.loadLocation(_id, animemanga.TYPE).toString();
        if (type == null) {
            return null;
        }
        animemanga.setType(type);
        return animemanga;
    }

    /**
     * Static method creates a AnimeManga object based on the given user ID string.
     * Method connects to AnimeManga API to return the Genre given an IP Address.
     *
     * CURRENTLY DOES NOT WORK!!!
     *
     * @param _id
     * @return AnimeManga animemanga
     */
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

    public static AnimeManga loadAnimeMangaTitleBySearch(String _type, String _genre1, String _genre2, String _genre3, String _orderBy, String _sort) {
        AnimeManga animemanga = new AnimeManga();
        animemanga.setType(_type);
        animemanga.setGenre1(_genre1);
        animemanga.setGenre2(_genre2);
        animemanga.setGenre3(_genre3);
        animemanga.setOrder(_orderBy);
        animemanga.setSort(_sort);
        String title = AnimeManga.myAnimeMangaAPI.loadAnimeMangaItemSearch(_type, _genre1, _genre2, _genre3, _orderBy, _sort, animemanga.RESULTS).toString();
        if (title == null) {
            return null;
        }
        animemanga.setTitle(title);
        return animemanga;
    }

    //=============== GETTERS =============
    public String getType() {
        return this.type;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getGenre1() {
        return this.genre1;
    }
    public String getGenre2() {
        return this.genre2;
    }
    public String getGenre3() {
        return this.genre3;
    }
    public String getOrder() {
        return this.order;
    }
    public String getSort() {
        return this.sort;
    }
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

    //=============== SETTERS =============

    public void setType(String _type) {
        this.type = _type;
    }
    public void setGenre(String _genre) {
        this.genre = _genre;
    }
    public void setGenre1(String _genre1) {
        this.genre1 = _genre1;
    }
    public void setGenre2(String _genre2) {
        this.genre2 = _genre2;
    }
    public void setGenre3(String _genre3) {
        this.genre3 = _genre3;
    }
    public void setOrder(String _order) {
        this.order = _order;
    }
    public void setSort(String _sort) {
        this.sort = _sort;
    }
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
}
