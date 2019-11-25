package tests;

public class Config {
    public static final String baseUrl = System.getProperty("baseUrl",
            "https://en.wikipedia.org/wiki/Metis_(mythology)");
    public static final String browser = System.getProperty("browser", "firefox");
}
