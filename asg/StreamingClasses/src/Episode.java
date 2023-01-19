public class Episode {
    private final String title;
    private final int season;
    private double runtime;

    public Episode(int season, String title, double runtime){
        this.title = title;
        this.runtime = runtime;
        this.season = season;
    }

    public void setRuntime(double runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public int getSeason() {
        return season;
    }

    public double getRuntime() {
        return runtime;
    }

    @Override
    public String toString() {
        return String.format("S%d - %s - %.2f", season, title, runtime);
    }
}
