import java.time.Year;
import java.util.ArrayList;

public class Series {
    enum GENRE {
        HORROR,
        SCIFI,
        DRAMA,
        ROMANCE,
        TRUECRIME
    }
    private final ArrayList<Episode> episodes;
    private final StreamingPlatform platform;
    private final String name;
    private final GENRE genre;
    private final Year startYear;

    public Series(String name, Year startYear, GENRE genre, ArrayList<Episode> episode, StreamingPlatform platform){
        validateSeries(episode);

        this.name = name;
        this.startYear = startYear;
        this.episodes = episode;
        this.platform = platform;
        this.genre = genre;
    }

    public Series(String name, GENRE genre, StreamingPlatform platform){
        this.name = name;
        this.platform = platform;
        this.genre = genre;
        this.startYear = Year.now();
        this.episodes = new ArrayList<>();
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public StreamingPlatform getPlatform() {
        return platform;
    }

    public String getName() {
        return name;
    }

    public GENRE getGenre() {
        return genre;
    }

    public Year getStartYear() {
        return startYear;
    }

    private static void validateSeries(ArrayList<Episode> episodes){
        int lastnum = -1;

        for (Episode e : episodes){
            if (e.getSeason() < lastnum){
                throw new IllegalArgumentException("Season numbers must be in ascending order");
            }
        }
    }

    public int numSeasons(){
        return episodes.get(episodes.size() - 1).getSeason();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Title: %s %s, seasons: %d\nGenre: %s\nPlatform: %s\n",
                name, startYear, numSeasons(), genre, platform));

        for (Episode e : episodes){
            s.append(e.toString()).append("\n");
        }

        return s.toString();
    }
}
