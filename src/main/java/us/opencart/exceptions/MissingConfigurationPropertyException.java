package us.opencart.exceptions;

public class MissingConfigurationPropertyException extends RuntimeException {

    public MissingConfigurationPropertyException(String propertyName) {
        super("The required configuration property '" + propertyName + "' was not found in serenity.conf.");
    }

    public MissingConfigurationPropertyException(String propertyName, Throwable cause) {
        super("The required configuration property '" + propertyName + "' was not found in serenity.conf.", cause);
    }
}

