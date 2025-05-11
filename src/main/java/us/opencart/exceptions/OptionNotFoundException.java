package us.opencart.exceptions;

public class OptionNotFoundException extends RuntimeException{

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
