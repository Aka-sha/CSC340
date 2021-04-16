package API;
import java.util.ArrayList;
import java.util.List;

/**
 * This interface will define methods that are needed for the Anime/Manga API Translator
 * Last Updated 03/26/2021
 * @author Andy Cruse
 */
public interface AnimeApiInterface {

    public Object loadAnimeMangaItemByID(String _id, String _loadItem);

    public List<Object> loadSeveralAnimeMangaItemByID(String _id, List<String> _loadItem);

    public Object loadAnimeMangaItemSearch(String _type, String _genre1, String _genre2, String _genre3, String _orderBy, String _sort, String _loadItem);

    public List<Object> loadSeveralAnimeMangaItemBySearch(List<String> _searchQuery, List<String> _loadItem);
}
