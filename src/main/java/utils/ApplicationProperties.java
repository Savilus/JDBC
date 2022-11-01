package utils;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {

    private static final Properties applicationProperties;

    static {
        applicationProperties = new Properties();

        try(final var propertiesInputStream = ApplicationProperties.class.getResourceAsStream("/application.properties")) {
            applicationProperties.load(propertiesInputStream);
        }
        catch(IOException ioe) {
            throw new ExceptionInInitializerError(ioe);
        }
    }

    private ApplicationProperties() {
        throw new UnsupportedOperationException();
    }

    public static Properties getApplicationProperties() {
        return applicationProperties;
    }
}


