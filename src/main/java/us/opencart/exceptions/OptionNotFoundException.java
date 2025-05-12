package us.opencart.exceptions;

public class OptionNotFoundException extends RuntimeException{

    public static final String ASSERT_EXPECTED_MESSAGE = "The exception %s was not thrown because the option is: %s";

    public OptionNotFoundException() {
        super("The provided option does not exist.");
    }

    public OptionNotFoundException(String option) {
        super(String.format("The option '%s' does not exist.", option));
    }

    public OptionNotFoundException(String option, Throwable cause) {
        super(String.format("The option '%s' does not exist.", option), cause);
    }

}
