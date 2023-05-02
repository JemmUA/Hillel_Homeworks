package lesson37.singleton;

public class Singleton {
    private static Singleton instance;
    private String configuration;

    private Singleton(final String configuration) {
        this.configuration = configuration;
    }

    public synchronized static Singleton instance(String configuration) {
        if (instance == null) {
            instance = new Singleton(configuration);
        }
        return instance;
    }

    public String getConfiguration() {
        return configuration;
    }
}
